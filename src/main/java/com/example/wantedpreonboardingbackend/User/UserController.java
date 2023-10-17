package com.example.wantedpreonboardingbackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(@RequestBody UserApplicationRequestDTO request) {
        boolean applied = userService.applyForJob(request);

        if (applied) {
            return ResponseEntity.ok("지원이 완료되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("지원에 실패했습니다.이미 지원한 공고입니다.");
        }
    }
}
