package kr.co.changh0.breath.controller;

import jakarta.validation.Valid;
import kr.co.changh0.breath.common.exception.UserNotFoundException;
import kr.co.changh0.breath.dto.UserDto;
import kr.co.changh0.breath.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userservice;

    public UserController(UserService service) {
        this.userservice = service;
    }

    @GetMapping
    public List<UserDto> retrieveAllUsers() {
        return userservice.findAll();
    }

    @GetMapping("/{id}")
    public UserDto retrieveUser(@PathVariable final int id) {
        UserDto userDto = userservice.findOne(id);

        if(userDto == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
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
        return ResponseEntity.ok().build();
    }

    @GetMapping("/duplicateCheck/{type}/{value}")
    public ResponseEntity<Map<String, Object>> duplicateCheck(@PathVariable final String type, @PathVariable final String value) {
        boolean duplicateResult = userservice.duplicateCheck(type, value);

        Map<String, Object> result = new HashMap<>();
        result.put(type, duplicateResult);

        return ResponseEntity.ok().body(result);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable final int id) {
        UserDto deleteUser = userservice.deleteById(id);

        if(deleteUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return ResponseEntity.noContent().build();
    }
}
