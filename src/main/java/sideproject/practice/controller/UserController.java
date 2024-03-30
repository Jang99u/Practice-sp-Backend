package sideproject.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sideproject.practice.dto.user.request.CreateUserRequest;
import sideproject.practice.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void saveUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.saveUser(createUserRequest);
    }

    @GetMapping
    public ResponseEntity<String> getUserName(@RequestParam Long userId) {
        return userService.getUserName(userId);
    }
}
