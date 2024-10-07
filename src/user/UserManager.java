package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UserManager {

    private final UserDao userDao;
    private final SessionManager sessionManager; // Handles sessions (login/logout)

    @Autowired
    public UserManager(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
    }

    // 회원가입
    public void register(User userDto) {
        User user = new User(null, userDto.getLoginId(), userDto.getPassword(),
                             userDto.getNickname(), userDto.getDormitoryName(), 
                             userDto.getRoomNumber(), null, 0);
        userDao.createUser(user);
    }

    // 로그인
    public String login(String loginId, String password) {
        User user = userDao.getUserByLoginId(loginId);
        if (user != null && user.getPassword().equals(password)) {
            return sessionManager.createSession(user.getId()); // Returns a session token
        }
        throw new IllegalArgumentException("Invalid login credentials");
    }

    // 로그아웃
    public void logout() {
        sessionManager.invalidateSession();
    }

    // 현재 로그인된 사용자 정보 조회
    public User getCurrentUser() {
        Long currentUserId = sessionManager.getCurrentUserId();
        User user = userDao.getUserById(currentUserId);
        return new User(user.getId(), user.getLoginId(), null, user.getNickname(),
                           user.getDormitoryName(), user.getRoomNumber(), user.getProfilePicture(), user.getPoints());
    }

    // 사용자 정보 업데이트
    public void updateUser(User userDto) {
        Long currentUserId = sessionManager.getCurrentUserId();
        User user = userDao.getUserById(currentUserId);
        user.setPassword(userDto.getPassword());
        user.setNickname(userDto.getNickname());
        userDao.updateUser(user);
    }

    // 현재 로그인된 사용자 삭제
    public void deleteCurrentUser() {
        Long currentUserId = sessionManager.getCurrentUserId();
        userDao.deleteUser(currentUserId);
        sessionManager.invalidateSession(); // Logout after deletion
    }
}
