package kr.co.changh0.breath.service;

import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.entity.User;
import kr.co.changh0.breath.entity.UserLogin;
import kr.co.changh0.breath.mapper.UserMapper;
import kr.co.changh0.breath.repository.UserLoginRepository;
import kr.co.changh0.breath.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserLoginRepository userLoginRepository;

    public List<UserDto> findAll() {
        List<UserDto> userDto = UserMapper.INSTANCE.listUserToUserDto(userRepository.findAll());
        return userDto;
    }

    public UserDto save(final UserDto user) {
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


        User userInfo = userRepository.save(UserMapper.INSTANCE.userDtoToUser(user));

        UserLogin userLogin = UserMapper.INSTANCE.userDtoToUserLogin(user, userInfo);

        userLoginRepository.save(userLogin);
        //이메일 인증

        return user;
    }

    public boolean duplicateCheck(final String type, final String value) {
        boolean result = true;

        UserLogin userLogin;
        User user = null;

        if("id".equals(type)) {
            userLogin = userLoginRepository.findByUserId(value);
            if(userLogin != null) return true;
        }
        if("nickname".equals(type)) {
            user = userRepository.findByNickname(value);
        }
        if("mobilePhone".equals(type)) {
            user = userRepository.findByMobilePhone(value);
        }
        if("email".equals(type)) {
            user = userRepository.findByEmail(value);
        }

        if(user == null) result = false;

        return result;
    }
    public UserDto findOne(int id) {


        return null;
    }

    public UserDto deleteById(int id) {

        return null;
    }
}
