package kr.co.changh0.breath.service;

import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.entity.Post;
import kr.co.changh0.breath.mapper.PostMapper;
import kr.co.changh0.breath.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public void save(PostDto postDto) {

        Post post = PostMapper.INSTANCE.postDtoToPost(postDto);
        postRepository.save(post);

    }
}
