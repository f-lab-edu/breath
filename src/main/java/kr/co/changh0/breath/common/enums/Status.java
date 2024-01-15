package kr.co.changh0.breath.common.enums;

public enum Status {
    REQUEST(1), APPROVE(2), RETURN(3), CLOSE(4);

    private final Integer statusId;

    Status(Integer statusId) {
        this.statusId = statusId;
    }
    public Integer getStatusId() {
        return statusId;
    }
}
