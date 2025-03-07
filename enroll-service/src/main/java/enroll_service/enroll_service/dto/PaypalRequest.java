package enroll_service.enroll_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalRequest implements Serializable {

    @JsonProperty("intent")
    private String intent = "CAPTURE";   // Thanh toán luôn, không phải "AUTHORIZE"

    @JsonProperty("purchase_units")
    private List<PurchaseUnit> purchaseUnits;

    @JsonProperty("application_context")
    private PayPalAppContext applicationContext;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PurchaseUnit {

        @JsonProperty("amount")
        private Money amount;  // Đây là lớp lồng nhau

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Money {
            @JsonProperty("currency_code")
            private String currencyCode;

            @JsonProperty("value")
            private String value;
        }
    }

    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PayPalAppContext {

        @JsonProperty("brand_name")
        private String brandName;

        @JsonProperty("landing_page")
        private String landingPage = "BILLING";   // Chọn luôn phương thức thanh toán

        @JsonProperty("return_url")
        private String returnUrl;   // URL callback khi thanh toán thành công

        @JsonProperty("cancel_url")
        private String cancelUrl;   // URL callback khi người dùng hủy thanh toán
    }
}
