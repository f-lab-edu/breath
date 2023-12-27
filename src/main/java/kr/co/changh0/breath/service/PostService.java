package kr.co.changh0.breath.service;

import kr.co.changh0.breath.common.enums.CategoryEnum;
import kr.co.changh0.breath.common.enums.PostEnum;
import kr.co.changh0.breath.common.enums.QnaEnum;
import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    public void save(final PostDto postDto, final String type) {

        Integer postTypeId = PostEnum.valueOf(type.toUpperCase()).getPostTypeId();
        if(postTypeId == 1 || postTypeId == 3) postDto.setStatusId(1);
        postDto.setPostTypeId(postTypeId);

        postMapper.insertPost(postDto);

    }

    public List<PostDto> selectUserPosts(Integer userSeq) {
        return postMapper.selectUserPosts(userSeq);
    }

    public PostDto viewPost(String postType, Integer postSeq) {
        Integer postTypeId = PostEnum.valueOf(postType.toUpperCase()).getPostTypeId();
        PostDto postDto = PostDto.builder()
                .postTypeId(postTypeId)
                .postSeq(postSeq)
                .build();

        return postMapper.viewPost(postDto);
    }


    public List<PostDto> selectPosts(String postType, String searchVal, String searchType, String type) {
        Integer postTypeId = PostEnum.valueOf(postType.toUpperCase()).getPostTypeId();
        PostDto postDto = null;

        if(postTypeId == 1) {
            Integer categoryId = null;
            Integer downCategoryId = null;
            if(type != null) {
                categoryId = CategoryEnum.valueOf(type.toUpperCase()).getCategoryId();
                downCategoryId = CategoryEnum.valueOf(type.toUpperCase()).getDownCategoryId();
            }
            postDto = PostDto.builder()
                    .postTypeId(postTypeId)
                    .searchVal(searchVal)
                    .searchType(searchType)
                    .categoryId(categoryId)
                    .downCategoryId(downCategoryId)
                    .build();
        }
        if(postTypeId == 3) {
            Integer qnaTypeId = null;
            if(type != null) {
                qnaTypeId = QnaEnum.valueOf(type.toUpperCase()).getQnaTypeId();
            }
            postDto = PostDto.builder()
                    .postTypeId(postTypeId)
                    .searchVal(searchVal)
                    .searchType(searchType)
                    .qnaTypeId(qnaTypeId)
                    .build();
        }

        return postMapper.selectPosts(postDto);
    }

    public PostDto selectPost(Integer postSeq) {
        return postMapper.selectPost(postSeq);
    }
}
