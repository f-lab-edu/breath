package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.UserPointDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointMapper {

    UserPointDto selectUserPoint(Integer userSeq);
    void insertDonationInfoToUserPoint(UserPointDto userPointDto);
}
