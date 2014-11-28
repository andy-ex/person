package com.test.domain.enumeration;

public enum ColumnHeader {
    FULL_NAME("Full Name"), GENDER("Sex"), AGE("Age"), DATE_OF_BIRTH("D.O.B");

    private String name;

    private ColumnHeader(String name) {
        this.name = name;
    }

    public static ColumnHeader getColumnHeaderByName(String headerName) {
        for (ColumnHeader header : ColumnHeader.values()) {
            if (header.name.equalsIgnoreCase(headerName)) {
                return header;
            }
        }
        throw new IllegalArgumentException("Illegal column header value: " + headerName);
    }
}
