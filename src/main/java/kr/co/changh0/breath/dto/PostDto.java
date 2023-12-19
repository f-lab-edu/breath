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

    private boolType mainYn;

    private boolType adultYn;

    private boolType secretYn;

    private boolType deleteYn;

    private String qnaTypeId;

    private String qnaType;

    private String categoryId;

    private String downCategoryId;

    private String category;

    private String statusId;

    private String status;

    private String postTypeId;

    private String postType;

}
