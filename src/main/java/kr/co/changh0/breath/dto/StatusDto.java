package kr.co.changh0.breath.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StatusDto {

    public StatusDto() {}

    private String statusId;

    private String status;

    private String useYn;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

}
