package com.sakilaAPI.database.enums;

public enum Rating {
    NC17("NC-17"),
    PG13("PG-13"),
    PG("PG"),
    G("G"),
    R("R");
    private final String value;

    public String getValue() {
        return value;
    }

    public static Rating fromValue(String value) {
        for (Rating rating : Rating.values()) {
            if (rating.value.equalsIgnoreCase(value)) {
                return rating;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

    Rating(String value) {
        this.value = value;
    }
}
