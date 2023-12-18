package kr.co.changh0.breath.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QnaTypeDto {
    public QnaTypeDto() {}

    private String qnaTypeId;

    private String qnaType;

    private String useYn;

    private String createDt;

    private String updateDt;

}
