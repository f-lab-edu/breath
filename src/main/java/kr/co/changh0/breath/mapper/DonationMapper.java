package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.DonationDto;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationMapper {

    void doDonation(DonationDto donationDto);
}
