package kr.co.changh0.breath.service;

import kr.co.changh0.breath.dto.DonationDto;
import kr.co.changh0.breath.dto.UserPointDto;
import kr.co.changh0.breath.mapper.DonationMapper;
import kr.co.changh0.breath.mapper.UserPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationMapper donationMapper;
    private final UserPointMapper userPointMapper;

    public UserPointDto selectUserPoint(final Integer userSeq) {
        return userPointMapper.selectUserPoint(userSeq);
    }

    public void doDonation(final DonationDto donationDto) {
        // 3-1. 내 포인트를 사용
        UserPointDto userPointDto;

        userPointDto = userPointMapper.selectUserPoint(donationDto.getUserSeq());
        UserPointDto userPoint = UserPointDto.builder()
                .userSeq(donationDto.getUserSeq())
                .usePoint(donationDto.getDonationPointDetail())
                .currentPoint(userPointDto.getCurrentPoint() - donationDto.getDonationPointDetail())
                .build();

        userPointMapper.insertDonationInfoToUserPoint(userPoint);

        // 3-2. 장인유저가 포인트를 얻음
        userPointDto = userPointMapper.selectUserPoint(donationDto.getMasterUserSeq());
        Integer currentPoint;
        if(userPointDto == null) {
            currentPoint = 0;
        }else {
            currentPoint = userPointDto.getCurrentPoint();
        }

        UserPointDto masterPoint = UserPointDto.builder()
                .userSeq(donationDto.getMasterUserSeq())
                .receivePoint(donationDto.getDonationPointDetail())
                .currentPoint(currentPoint + donationDto.getDonationPointDetail())
                .build();

        userPointMapper.insertDonationInfoToUserPoint(masterPoint);

        // 3-3. 후원 내역 저장
        donationMapper.doDonation(donationDto);
    }
}
