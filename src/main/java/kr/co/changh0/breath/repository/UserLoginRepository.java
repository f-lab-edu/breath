package kr.co.changh0.breath.repository;

import kr.co.changh0.breath.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

    public UserLogin findByUserId(String userId);

}
