package kr.co.changh0.breath.controller;

import jakarta.validation.Valid;
import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.entity.Post;
import kr.co.changh0.breath.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/{type}")
    public ResponseEntity<Post> createPost(@Valid @RequestBody final PostDto postDto, @PathVariable final String type) {
        // 추후 세션을 활용하여 로그인 된 회원만 포스팅 할 수 있도록 추가 예정
        // 포스팅 후 게시글로 이동
        postDto.setTypeId(type);
        postService.save(postDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{type}")
                .buildAndExpand(postDto.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
