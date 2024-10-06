package user;

import org.springframework.stereotype.Component;

@Component 
public class SessionManager {

    // Dummy implementation, you can replace this with real session management logic (JWT, etc.)
    private Long currentUserId;

    public String createSession(Long userId) {
        this.currentUserId = userId; // In a real implementation, you'd return a session token
        return "dummy-session-token";
    }

    public void invalidateSession() {
        this.currentUserId = null;
    }

    public Long getCurrentUserId() {
        if (currentUserId == null) {
            throw new IllegalStateException("No user logged in");
        }
        return currentUserId;
    }
}
