package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog._core.util.Resp;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @PutMapping("/s/api/user")
    public ResponseEntity<?> update(@Valid @RequestBody UserRequest.UpdateDTO reqDTO, Errors errors) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        UserResponse.DTO respDTO = userService.회원정보수정(reqDTO, sessionUser.getId());
        return Resp.ok(respDTO);
    }

    @GetMapping("/api/check-username-available/{username}")
    public ResponseEntity<?> checkUsernameAvailable(@PathVariable("username") String username) {
        Map<String, Object> respDTO = userService.유저네임중복체크(username);
        return Resp.ok(respDTO);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(
            @Valid @RequestBody UserRequest.JoinDTO reqDTO,
            Errors errors,
            HttpServletResponse response,
            HttpServletRequest request) {

        log.debug(reqDTO.toString());
        log.trace("트레이스ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        log.debug("디버그---------");
        log.info("인포ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        log.warn("워닝ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        log.error("에러ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");

        String hello = request.getHeader("X-Key");
        System.out.println("X-good : " + hello);

        response.setHeader("Authorization", "jooho");

        UserResponse.DTO respDTO = userService.회원가입(reqDTO);
        return Resp.ok(respDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody UserRequest.LoginDTO loginDTO,
            Errors errors,
            HttpServletResponse response) {
        UserResponse.TokenDTO respDTO = userService.로그인(loginDTO);
        return Resp.ok(respDTO);
    }
}