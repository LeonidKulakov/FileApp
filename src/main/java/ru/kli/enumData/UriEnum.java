package ru.kli.enumData;

public enum UriEnum {

    BASE_URI("my_data_for_testing");

    private String uri;

    UriEnum(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
