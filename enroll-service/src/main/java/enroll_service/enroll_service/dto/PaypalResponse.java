package enroll_service.enroll_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PaypalResponse {

    @JsonProperty("id")
    private String id;   // ID giao dịch PayPal

    @JsonProperty("status")
    private String status;   // Trạng thái đơn hàng (CREATED, APPROVED...)

    @JsonProperty("links")
    private List<Link> links;   // Các URL (checkout, capture...)

    @Data
    public static class Link {

        @JsonProperty("href")
        private String href;   // URL để redirect người dùng

        @JsonProperty("rel")
        private String rel;   // "approve" là link thanh toán

        @JsonProperty("method")
        private String method;   // GET, POST...
    }
}
