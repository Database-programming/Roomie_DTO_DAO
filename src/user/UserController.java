package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController@RequestMapping("/user")public class UserController {

    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    // POST /user/register: 회원가입 요청
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userManager.register(userDto);
        return ResponseEntity.ok("User registered successfully!");
    }

    // POST /user/login: 로그인 요청
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        String token = userManager.login(loginRequest.getLoginId(), loginRequest.getPassword());
        return ResponseEntity.ok("Login successful, token: " + token);
    }

    // POST /user/logout: 로그아웃 요청
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        userManager.logout();
        return ResponseEntity.ok("Logged out successfully!");
    }

    // GET /user/me: 현재 로그인된 사용자 정보 조회
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        UserDto currentUser = userManager.getCurrentUser();
        return ResponseEntity.ok(currentUser);
    }

    // PUT /user/me: 사용자 정보 수정 (비밀번호, 닉네임)
    @PutMapping("/me")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto) {
        userManager.updateUser(userDto);
        return ResponseEntity.ok("User info updated successfully!");
    }

    // DELETE /user/me: 계정 삭제 요청
    @DeleteMapping("/me")
    public ResponseEntity<String> deleteUser() {
        userManager.deleteCurrentUser();
        return ResponseEntity.ok("User deleted successfully!");
    }
}