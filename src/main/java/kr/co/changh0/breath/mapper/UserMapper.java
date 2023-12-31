package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    List<UserDto> selectAllUser();

    UserDto selectUserId(String userId);

    void insertUser(UserDto userDto);

    void insertUserLogin(UserDto userDto);

    int deleteUser(Integer userSeq);

    void insertUserHistory(Integer userSeq);

    UserDto duplicateCheck(@Param("type") String type, @Param("value") String value);

    UserDto selectUser(Integer userSeq);
}
