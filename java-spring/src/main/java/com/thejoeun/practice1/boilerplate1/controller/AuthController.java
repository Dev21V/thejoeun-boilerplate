package com.thejoeun.practice1.boilerplate1.controller;

import com.thejoeun.practice1.boilerplate1.model.dto.JwtTokenDto;
import com.thejoeun.practice1.boilerplate1.model.dto.MemberRequestDto;
import com.thejoeun.practice1.boilerplate1.model.dto.MemberResponseDto;
import com.thejoeun.practice1.boilerplate1.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/gettest1")
    public ResponseEntity<String> gettest1() {
        return ResponseEntity.ok("get성공보여짐");
    }

    @GetMapping("/posttest1")
    public ResponseEntity<String> posttest1() {
        return ResponseEntity.ok("post성공보여짐");
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto memberResponseDto = null;
        try {
            memberResponseDto = authService.signup(requestDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpServletResponse.SC_CONFLICT)
                    .body(requestDto.toMemberResponseDto(requestDto));
        }

        return ResponseEntity.ok(memberResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
}
