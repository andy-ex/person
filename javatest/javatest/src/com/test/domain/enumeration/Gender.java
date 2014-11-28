package com.test.domain.enumeration;

public enum Gender {
    MALE("male"), FEMALE("female");

    private String value;

    private Gender(String value) {
        this.value = value;
    }
}
