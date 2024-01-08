package kr.co.changh0.breath.common.enums;

public enum QnaEnum {

    ALL(null),
    ACCOUNT(1), REFUND(2), MASTER(3), ETC(99);

    private final Integer QnaTypeId;

    QnaEnum(Integer qnaTypeId) {
        QnaTypeId = qnaTypeId;
    }

    public Integer getQnaTypeId() {
        return QnaTypeId;
    }
}
