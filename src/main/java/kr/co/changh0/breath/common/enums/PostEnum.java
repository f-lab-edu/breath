package kr.co.changh0.breath.common.enums;

public enum PostEnum {
    SPONSOR("001"), COMMUNICATION("002"), QNA("003");

    private final String postTypeId;

    PostEnum(String postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getPostTypeId() {
        return postTypeId;
    }

}
