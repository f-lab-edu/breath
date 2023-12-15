package kr.co.changh0.breath.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import kr.co.changh0.breath.common.boolType;
import kr.co.changh0.breath.common.genderType;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
@Getter
@Setter
public class UserDto {

    public UserDto() {}

    private Integer id;

    @NotBlank(message = "아이디는 필수값 입니다.")
    @Pattern(regexp = "^[a-z0-9_-]{6,20}$", message = "아이디는 6 ~ 20자의 영문 소문자, 숫자, 특수문자(-,_)만 사용할 수 있습니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수값 입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+\\-=[{]};:'\",<.>/?]{8,16}$", message = "닉네임은 8 ~ 16자의 영문 대/소문자, 숫자, 특수문자를 사용할 수 있습니다.")
    private String password;

    @NotBlank(message = "닉네임은 필수값 입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9-_ㄱ-ㅎㅏ-ㅣ-가-힣]{2,16}$", message = "닉네임은 2 ~ 16자의 영문 대/소문자, 숫자, 특수문자(-,_)만 사용할 수 있습니다.")
    private String nickname;

    @NotBlank(message = "이름은 필수값 입니다.")
    private String name;

    private String birthDay;

    private String mobilePhone;

    @Enumerated(EnumType.STRING)
    private genderType gender;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    private String address;

    private String introduction;

    private char authority;

    @Enumerated(EnumType.STRING)
    private boolType masterStatus = boolType.N;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

    @Enumerated(EnumType.STRING)
    private boolType deleteYn = boolType.N;

}
