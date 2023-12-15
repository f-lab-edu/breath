package kr.co.changh0.breath.repository;

import kr.co.changh0.breath.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
