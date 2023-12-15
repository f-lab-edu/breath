package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.entity.User;
import kr.co.changh0.breath.entity.UserLogin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userLogin.userId", target = "userId")
    @Mapping(source = "userLogin.password", target = "password")
    @Mapping(source = "user.userSeq", target = "id")
    @Mapping(source = "user.createDt", target = "createDt")
    @Mapping(source = "user.updateDt", target = "updateDt")
    UserDto userAndLoginToUserDto(User user, UserLogin userLogin);

    UserDto userToUserDto(User user);
    List<UserDto> listUserToUserDto(List<User> user);
    User userDtoToUser(UserDto userDto);

    @Mapping(source = "user.userSeq", target = "user.userSeq")
    @Mapping(source = "user.createDt", target = "createDt")
    @Mapping(source = "user.updateDt", target = "updateDt")
    UserLogin userDtoToUserLogin(UserDto userDto, User user);
}
