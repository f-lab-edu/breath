package kr.co.changh0.breath.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import kr.co.changh0.breath.common.boolType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.MapMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.mapstruct.control.MappingControl;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    public PostDto() {}

    private Integer id;

    private Integer parentId;

    private Integer userSeq;

    private Integer postNo;

    private String title;

    private Blob contents;

    private Integer targetAmount;

    private LocalDate donationStartDt;

    private LocalDate donationEndDt;

    private Integer reviewerSeq;

    private LocalDateTime reviewDt;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

    @Enumerated(EnumType.STRING)
    private boolType mainYn = boolType.N;

    @Enumerated(EnumType.STRING)
    private boolType adultYn = boolType.N;

    @Enumerated(EnumType.STRING)
    private boolType secretYn = boolType.N;

    @Enumerated(EnumType.STRING)
    private boolType deleteYn = boolType.N;

    private String qnaTypeId;

    private String categoryId;

    private String statusId;

    private String typeId;

}
