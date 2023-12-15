package kr.co.changh0.breath.repository;

import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public User findByMobilePhone(String mobilePhone);
    public User findByNickname(String nickname);
}
