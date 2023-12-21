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

    public List<PostDto> selectUserPosts(Integer userSeq) {
        return postMapper.selectUserPosts(userSeq);
    }

    public PostDto selectPost(Integer postSeq) {
        return postMapper.selectPost(postSeq);
    }


    public List<PostDto> selectPosts(String postTypeId, String searchVal, String searchType, String typeId) {
        return postMapper.selectPosts(postTypeId, searchVal, searchType, typeId);
    }
}
