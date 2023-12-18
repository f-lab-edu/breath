package kr.co.changh0.breath.service;

import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    public void save(PostDto postDto) {

        postMapper.insertPost(postDto);

    }

    public List<PostDto> selectPosts(String type) {
        return postMapper.selectPosts(type);
    }

    public List<PostDto> selectUserPosts(int seq) {
        return postMapper.selectUserPosts(seq);
    }
}
