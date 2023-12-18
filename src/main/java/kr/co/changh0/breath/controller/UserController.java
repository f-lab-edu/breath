package kr.co.changh0.breath.controller;

import jakarta.validation.Valid;
import kr.co.changh0.breath.common.exception.UserNotFoundException;
import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userservice;

    @GetMapping // 단일 유저 조회로 변경 예정
    public List<UserDto> retrieveAllUsers() {
        return userservice.findAll();
    }

    @GetMapping("/{seq}")
    public UserDto retrieveUser(@PathVariable final int seq) {
        UserDto userDto = userservice.findOne(seq);

        if(userDto == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", seq));
        }

        return userDto;
    }

    @PostMapping
    public ResponseEntity signUp(@Valid @RequestBody final UserDto userDto) {
        UserDto saveUser = userservice.save(userDto);

//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(saveUser.getId())
//                .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/duplicateCheck/{type}/{value}")
    public ResponseEntity<Map<String, Object>> duplicateCheck(@PathVariable final String type, @PathVariable final String value) {
        boolean duplicateResult = userservice.duplicateCheck(type, value);

        Map<String, Object> result = new HashMap<>();
        result.put(type, duplicateResult);

        return ResponseEntity.ok().body(result);

    }
    @DeleteMapping("/{seq}")
    public ResponseEntity deleteUser(@PathVariable final int seq) {
        UserDto deleteUser = userservice.deleteUser(seq);

        if(deleteUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", seq));
        }

        return ResponseEntity.noContent().build();
    }

    //@PutMapping("/{userSeq}")

    //@GetMapping("/postList")
}
