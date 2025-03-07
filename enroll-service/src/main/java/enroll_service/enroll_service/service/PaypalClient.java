package enroll_service.enroll_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import enroll_service.enroll_service.dto.PaypalRequest;
import enroll_service.enroll_service.dto.PaypalResponse;
import enroll_service.enroll_service.config.PaypalConfig;
import enroll_service.enroll_service.constants.PaypalEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class PaypalClient {

    private final PaypalConfig paypalConfig;
    private final ObjectMapper objectMapper;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    // 1️⃣ Lấy access token từ PayPal
    public String getPaypalAccessToken() throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(PaypalEndpoints.createUrl(paypalConfig.getBaseUrl(), PaypalEndpoints.GET_ACCESS_TOKEN)))
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic " + encodeCredentials())
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get PayPal access token: " + response.body());
        }

        var tokenResponse = objectMapper.readTree(response.body());
        return tokenResponse.get("access_token").asText();
    }

    // 2️⃣ Tạo giao dịch PayPal
    public PaypalResponse createPaypalTransaction(PaypalRequest paypalRequest) throws Exception {
        var accessToken = getPaypalAccessToken();
        var payload = objectMapper.writeValueAsString(paypalRequest);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(PaypalEndpoints.createUrl(paypalConfig.getBaseUrl(), PaypalEndpoints.CREATE_ORDER)))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .header("Prefer", "return=representation")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 201) {
            throw new RuntimeException("Failed to create PayPal transaction: " + response.body());
        }

        return objectMapper.readValue(response.body(), PaypalResponse.class);
    }

    // Encode clientId:secret thành base64
    private String encodeCredentials() {
        var credentials = paypalConfig.getClientId() + ":" + paypalConfig.getSecret();
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
