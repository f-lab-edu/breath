package kr.co.changh0.breath.common.enums;

public enum QnaEnum {

    ALL(null),
    ACCOUNT("001"), REFUND("002"), MASTER("003"), ETC("999");

    private final String QnaTypeId;

    QnaEnum(String qnaTypeId) {
        QnaTypeId = qnaTypeId;
    }

    public String getQnaTypeId() {
        return QnaTypeId;
    }
}
