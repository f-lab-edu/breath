package kr.co.changh0.breath.controller;

import kr.co.changh0.breath.dto.DonationDto;
import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.dto.UserPointDto;
import kr.co.changh0.breath.service.DonationService;
import kr.co.changh0.breath.service.PostService;
import kr.co.changh0.breath.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private final UserService userService;
    private final PostService postService;
    private final DonationService donationService;

    @PostMapping("/{postSeq}") // 내가 누군가의 어느 게시물에 후원을 함
    public ResponseEntity doDonation(@PathVariable final Integer postSeq,
                                        @RequestBody final UserPointDto userPointDto) {
        // 1. 해당 포스트의 글쓴이 정보를 가져옴
        PostDto postDto = postService.selectPost(postSeq);
        UserDto userDto = userService.selectUser(postDto.getUserSeq());

        // 2. 내가 사용하고자 하는 포인트와 현재 가지고 있는 포인트 확인
        UserPointDto getUserPointDto = donationService.selectUserPoint(userDto.getUserSeq());
        Integer userPoint = userPointDto.getUsePoint();

        if(userPoint > getUserPointDto.getCurrentPoint()) {
            throw new RuntimeException("포인트가 부족합니다.");
        }

        // 3. 나의 포인트를 그 포스트에 후원을 함
        DonationDto donationDto = DonationDto.builder()
                .userSeq(6) // 추후 세션을 통해 유저의 고유넘버를 가져올 예정
                .masterUserSeq(userDto.getUserSeq())
                .postSeq(postSeq)
                .donationPointDetail(userPointDto.getUsePoint())
                .build();
        donationService.doDonation(donationDto);

        return ResponseEntity.ok(userPointDto);
    }
}
