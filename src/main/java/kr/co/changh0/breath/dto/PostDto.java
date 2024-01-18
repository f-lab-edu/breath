package kr.co.changh0.breath.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.co.changh0.breath.common.enums.BoolType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime donationStartDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime donationEndDt;

    private Integer reviewerSeq;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime reviewDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime createDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime updateDt;

    private BoolType mainYn;

    private BoolType adultYn;

    private BoolType secretYn;

    private BoolType deleteYn;

    private Integer qnaTypeId;

    private String qnaType;

    private Integer categoryId;

    private String category;

    private Integer statusId;

    private String status;

    private Integer postTypeId;

    private String postType;

    private String searchVal;

    private String searchType;

    private String type;

    private Integer typeId;
}
