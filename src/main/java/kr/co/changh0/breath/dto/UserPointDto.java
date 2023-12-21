package kr.co.changh0.breath.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserPointDto {
    public UserPointDto() {}

    private Integer userPointSeq;

    private Integer userSeq;

    private Integer chargeAmount;

    private Integer receivePoint;

    private Integer usePoint;

    private Integer currentPoint;

    private String createDt;

    private String updateDt;

    @Builder
    public UserPointDto(Integer userSeq, Integer receivePoint, Integer usePoint) {
        this.userSeq = userSeq;
        this.receivePoint = receivePoint;
        this.usePoint = usePoint;
    }
}
