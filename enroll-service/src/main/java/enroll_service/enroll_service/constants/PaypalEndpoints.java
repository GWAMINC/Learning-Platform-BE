package enroll_service.enroll_service.constants;

public enum PaypalEndpoints {
    GET_ACCESS_TOKEN("/v1/oauth2/token"),
    CREATE_ORDER("/v2/checkout/orders");

    private final String path;

    PaypalEndpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static String createUrl(String baseUrl, PaypalEndpoints endpoint) {
        return baseUrl + endpoint.getPath();
    }
}
