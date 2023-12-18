package kr.co.changh0.breath.service;

import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        List<UserDto> userDto = userMapper.selectAllUser();

        return userDto;
    }

    public UserDto save(UserDto user) {
        //같은 아이디, 이메일, 휴대전화, 닉네임 있는지 확인
        String userId = user.getUserId();
        String nickname = user.getNickname();
        String mobilePhone = user.getMobilePhone();
        String email = user.getEmail();

        if(duplicateCheck("id", userId)) {
            throw new RuntimeException("동일한 아이디가 존재합니다.");
        }

        if(duplicateCheck("nickname", nickname)) {
            throw new RuntimeException("동일한 닉네임이 존재합니다.");
        }

        if(duplicateCheck("mobilePhone", mobilePhone)) {
            throw new RuntimeException("동일한 휴대전화번호가 존재합니다.");
        }

        if(duplicateCheck("email", email)) {
            throw new RuntimeException("동일한 이메일이 존재합니다.");
        }

        userMapper.insertUser(user);
        userMapper.insertUserLogin(user);

        //이메일 인증

        return user;
    }

    public boolean duplicateCheck(final String type, final String value) {
        UserDto userDto;

        String checkType = null;
        if("id".equals(type)) {
            userDto = userMapper.selectUserId(value);
        }else {
            if("nickname".equals(type)) checkType = "NICKNAME";
            if("mobilePhone".equals(type)) checkType = "MOBILE_PHONE";
            if("email".equals(type)) checkType = "EMAIL";

            userDto = userMapper.duplicateCheck(checkType, value);
        }

        Optional<UserDto> userDtoOptional = Optional.ofNullable(userDto);
        if(userDtoOptional.isPresent()) return true;

        return false;
    }
    public UserDto findOne(int id) {


        return null;
    }

    public UserDto deleteUser(final int userSeq) {
        userMapper.insertUserHistory(userSeq);

        return userMapper.deleteUser(userSeq);
    }
}
