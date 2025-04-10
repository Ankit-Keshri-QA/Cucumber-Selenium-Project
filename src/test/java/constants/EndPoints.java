package constants;

public enum EndPoints {

    // Constants that hold a value
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");

    public final String url;

    EndPoints(String url) {
        this.url = url;
    }
}
