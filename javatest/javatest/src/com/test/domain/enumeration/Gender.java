package com.test.domain.enumeration;

public enum Gender {
    MALE("male"), FEMALE("female");

    private String name;

    private Gender(String value) {
        this.name = value;
    }

    public static Gender getGenderByName(String genderName) {
        for (Gender gender : Gender.values()) {
            if (gender.name.equals(genderName)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Illegal gender value: " + genderName);
    }


}
