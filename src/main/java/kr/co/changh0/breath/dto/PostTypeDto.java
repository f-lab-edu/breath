package kr.co.changh0.breath.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostTypeDto {

    public PostTypeDto() {}

    private String typeId;

    private String type;

    private String useYn;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

}
