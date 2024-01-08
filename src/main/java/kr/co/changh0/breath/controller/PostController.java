package kr.co.changh0.breath.controller;

import jakarta.validation.Valid;
import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    // 삭제여부가 N 일 때
    // 1. 후원, 문의 등 게시글 종류에 따라 전체 게시글 목록 또는 검색(게시글 이름, 게시자)결과 목록(소통은 유저의 데이터가 필요함)
    // 2. 게시글 종류에 따라 포스팅(후원일 경우 요청상태로 변경) -> 생성된 게시글로 이동
    // 3. 유저가 작성한 게시글 목록
    // 조건 :
    // 4. 후원 게시글 : 승인만 리턴, 카테고리별 리턴
    // 5. 문의 게시글 : 문의종류에 따라서 리턴
    // 6. 소통 게시글 : 부모게시글, 부모게시글 유저의 게시글 목록

    private final PostService postService;

    @GetMapping("/{type}")
    public List<PostDto> selectPosts(@PathVariable final String type) {
        return postService.selectPosts(type, null, null, null);
    }

    @PostMapping("/{type}")
    public ResponseEntity<PostDto> savePost(@Valid @RequestBody final PostDto postDto, @PathVariable final String type) {
        // 추후 세션을 활용하여 로그인 된 회원만 포스팅 할 수 있도록 추가 예정
        // 후원글 게시 일 경우 요청 상태로 세팅
        postService.save(postDto,type);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{type}")
                .buildAndExpand(postDto.getPostSeq())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{type}/{postSeq}")
    public ResponseEntity<PostDto> viewPost(@PathVariable final String type, @PathVariable final Integer postSeq) {
        PostDto postDto = postService.viewPost(type, postSeq);

        return ResponseEntity.ok(postDto);

    }

    @GetMapping("/{type}/search")
    public ResponseEntity<List<PostDto>> searchPosts(@PathVariable("type") final String postType,
                                                     @RequestParam final String searchVal,
                                                     @RequestParam final String searchType,
                                                     @RequestParam final String type) {
        List<PostDto> posts = postService.selectPosts(postType, searchVal, searchType, type);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{type}/{postSeq}/{parentPostSeq}")
    public ResponseEntity<PostDto> viewChildPost(@PathVariable("type") final String type,
                                                 @PathVariable("postSeq") final Integer postSeq,
                                                 @PathVariable("parentPostSeq") final Integer parentPostSeq) {
        PostDto postDto = postService.viewPost(type, parentPostSeq);

        return ResponseEntity.ok(postDto);
    }
    
}
