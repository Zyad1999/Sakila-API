package com.sakilaAPI.database.enums;

public enum SpecialFeatures {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    DeletedScenes("Deleted Scenes"),
    BehindTheScenes("Behind the Scenes");

    private final String value;

    public String getValue() {
        return value;
    }

    public static SpecialFeatures fromValue(String value) {
        for (SpecialFeatures feature : SpecialFeatures.values()) {
            if (feature.value.equalsIgnoreCase(value)) {
                return feature;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

    SpecialFeatures(String value) {
        this.value = value;
    }
}
