package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.PostDto;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostMapper {

    void insertPost(PostDto postDto);

    List<PostDto> selectPosts(String type);

    List<PostDto> selectUserPosts(int id);
}
