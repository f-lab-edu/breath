package kr.co.changh0.breath.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.co.changh0.breath.common.enums.BoolType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class PostDto {
    public PostDto() {}

    private Integer postSeq;

    private Integer parentPostSeq;

    private Integer userSeq;

    private Integer postNo;

    private String title;

    private String contents;

    private Integer targetAmount;

    private Date donationStartDt;

    private Date donationEndDt;

    private Integer reviewerSeq;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date reviewDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date createDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date updateDt;

    private BoolType mainYn;

    private BoolType adultYn;

    private BoolType secretYn;

    private BoolType deleteYn;

    private Integer qnaTypeId;

    private String qnaType;

    private Integer categoryId;

    private Integer downCategoryId;

    private String category;

    private Integer statusId;

    private String status;

    private Integer postTypeId;

    private String postType;

    private String searchVal;

    private String searchType;
}
