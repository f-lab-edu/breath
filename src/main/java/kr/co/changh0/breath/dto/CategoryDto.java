package kr.co.changh0.breath.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryDto {
    public CategoryDto() {}

    private String categoryId;

    private String downCategoryId;

    private String category;

    private String useYn;

    private String createDt;

    private String updateDt;
}
