package constants;

public enum EndPoints {

    // Constants that hold a value
    STORE("/store"),
    ACCOUNT("/account");


    public final String url;

    EndPoints(String url) {
        this.url = url;
    }
}
