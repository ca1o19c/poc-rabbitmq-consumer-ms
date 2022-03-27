package com.ms.parkingcontrol.domain.parkingmanagement;

public enum SortType {
    ASC("asc"), DESC("desc");

    private final String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static SortType fromValue(String sortType) {
        for (SortType sortTypeEnum : SortType.values()) {
            if (sortTypeEnum.name().equalsIgnoreCase(sortType)) {
                return sortTypeEnum;
            }
        }
        return SortType.ASC;
    }
}
