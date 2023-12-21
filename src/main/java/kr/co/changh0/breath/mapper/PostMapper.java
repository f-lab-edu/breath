package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.PostDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostMapper {

    void insertPost(PostDto postDto);

    List<PostDto> selectUserPosts(Integer userSeq);

    PostDto selectPost(@Param("postSeq") Integer postSeq);

    List<PostDto> selectPosts(@Param("postTypeId") String postTypeId,
                              @Param("searchVal") String searchVal,
                              @Param("searchType") String searchType,
                              @Param("typeId") String typeId);
}
