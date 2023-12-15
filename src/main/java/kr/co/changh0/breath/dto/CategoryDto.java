package kr.co.changh0.breath.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryDto {
    public CategoryDto() {}

    private String categoryId;

    private String category;

    private String useYn;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;
}
