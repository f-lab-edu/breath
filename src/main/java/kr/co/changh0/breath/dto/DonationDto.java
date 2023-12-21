package kr.co.changh0.breath.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationDto {

    public DonationDto() {}

    private Integer donationSeq;

    private Integer userSeq;

    private Integer masterUserSeq;

    private Integer postSeq;

    private Integer donationPointDetail;

    private String createDt;

    private String updateDt;

    @Builder
    public DonationDto(Integer userSeq, Integer masterUserSeq, Integer postSeq, Integer donationPointDetail) {
        this.userSeq = userSeq;
        this.masterUserSeq = masterUserSeq;
        this.postSeq = postSeq;
        this.donationPointDetail = donationPointDetail;
    }
}
