package kr.co.changh0.breath.common.enums;

public enum CategoryEnum {
    ALL(null),
    ART("0100"), PAINTING("0101"), CRAFT("0102"),
    MEDIAART("0200");

    private final String categoryId;

    CategoryEnum(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
