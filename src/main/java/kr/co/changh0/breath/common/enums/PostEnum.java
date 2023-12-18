package kr.co.changh0.breath.common.enums;

public enum PostEnum {
    SPONSOR("001", "sponsor"), COMMUNICATION("002", "communication"), QNA("003", "qna");

    private final String postTypeId;
    private final String postType;

    PostEnum(String postTypeId, String postType) {
        this.postTypeId = postTypeId;
        this.postType = postType;
    }

    public String getPostTypeId() {
        return postTypeId;
    }

    public String getPostType() {
        return postType;
    }
}
