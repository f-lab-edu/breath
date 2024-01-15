package kr.co.changh0.breath.service;

import java.util.List;

import kr.co.changh0.breath.common.enums.Status;
import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.dto.PostTypeDto;
import kr.co.changh0.breath.mapper.PostMapper;
import kr.co.changh0.breath.mapper.TypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private final TypeMapper typeMapper;

    @Transactional
    public void save(final PostDto postDto, final String postType) {
        Integer postTypeId = typeMapper.getPostTypeId(postType);
        List<PostTypeDto> postTypeIdList = typeMapper.getPostTypeList(true);
        for(PostTypeDto postTypeDto : postTypeIdList) {
            if(postTypeId == postTypeDto.getPostTypeId()) {
                postDto.setStatusId(Status.REQUEST.getStatusId());
                break;
            }
        }
        postDto.setPostTypeId(postTypeId);

        postMapper.insertPost(postDto);

    }

    public List<PostDto> selectUserPosts(Integer userSeq) {
        return postMapper.selectUserPosts(userSeq);
    }

    public PostDto viewPost(String postType, Integer postSeq) {
        PostDto postDto = PostDto.builder()
                .postType(postType)
                .postSeq(postSeq)
                .build();

        return postMapper.viewPost(postDto);
    }

    public List<PostDto> selectPosts(String postType, String searchVal, String searchType, String type) {
        PostDto postDto = PostDto.builder()
                .postType(postType)
                .searchVal(searchVal)
                .searchType(searchType)
                .type(type)
                .build();

        return postMapper.selectPosts(postDto);
    }

    public PostDto selectPost(Integer postSeq) {
        return postMapper.selectPost(postSeq);
    }
}
