package kr.co.changh0.breath.dto;

import kr.co.changh0.breath.common.enums.BoolType;
import lombok.Getter;
import lombok.Setter;


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

    private BoolType mainYn;

    private BoolType adultYn;

    private BoolType secretYn;

    private BoolType deleteYn;

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
