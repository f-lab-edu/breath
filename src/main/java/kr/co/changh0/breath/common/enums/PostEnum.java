package kr.co.changh0.breath.common.enums;

public enum PostEnum {
    SPONSOR(1), COMMUNICATION(2), QNA(3);

    private final Integer postTypeId;

    PostEnum(Integer postTypeId) {
        this.postTypeId = postTypeId;
    }

    public Integer getPostTypeId() {
        return postTypeId;
    }

}
