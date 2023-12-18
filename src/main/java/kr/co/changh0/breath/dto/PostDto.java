package kr.co.changh0.breath.dto;

import kr.co.changh0.breath.common.enums.boolType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
public class PostDto {
    public PostDto() {}

    private Integer postSeq;

    private Integer parentPostId;

    private Integer userSeq;

    private Integer postNo;

    private String title;

    private String contents;

    private Integer targetAmount;

    private String donationStartDt;

    private String donationEndDt;

    private Integer reviewerSeq;

    private String reviewDt;

    private String createDt;

    private String updateDt;

    private boolType mainYn = boolType.N;

    private boolType adultYn = boolType.N;

    private boolType secretYn = boolType.N;

    private boolType deleteYn = boolType.N;

    private String qnaTypeId;

    private String categoryId;

    private String downCategoryId;

    private String statusId;

    private String postTypeId;

}
