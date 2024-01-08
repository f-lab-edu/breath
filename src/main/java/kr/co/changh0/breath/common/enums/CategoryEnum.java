package kr.co.changh0.breath.common.enums;

public enum CategoryEnum {
    ALL(null, null),
    ART(1,0), PAINTING(1,1), CRAFT(1,2),
    MEDIAART(2,0);

    private final Integer categoryId;
    private final Integer downCategoryId;

    CategoryEnum(Integer categoryId, Integer downCategoryId) {
        this.categoryId = categoryId;
        this.downCategoryId = downCategoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getDownCategoryId() {
        return downCategoryId;
    }
}
