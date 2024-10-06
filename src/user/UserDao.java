package user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    // 1. Create - 새로운 사용자 추가
    public void createUser(User user) throws SQLException {
        String query = "INSERT INTO users (loginId, password, nickname, dormitoryName, roomNumber, profilePicture, points) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLoginId());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getNickname());
            statement.setString(4, user.getDormitoryName());
            statement.setString(5, user.getRoomNumber());
            statement.setString(6, user.getProfilePicture());
            statement.setInt(7, user.getPoints());
            statement.executeUpdate();
        }
    }

    // 2. Read - ID로 사용자 조회
    public User getUserById(Long id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("loginId"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname"),
                    resultSet.getString("dormitoryName"),
                    resultSet.getString("roomNumber"),
                    resultSet.getString("profilePicture"),
                    resultSet.getInt("points")
                );
            }
            return null; // 해당 ID의 사용자가 없을 경우
        }
    }

    // 2-1. Read - 로그인 ID로 사용자 조회
    public User getUserByLoginId(String loginId) throws SQLException {
        String query = "SELECT * FROM users WHERE loginId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, loginId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("loginId"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname"),
                    resultSet.getString("dormitoryName"),
                    resultSet.getString("roomNumber"),
                    resultSet.getString("profilePicture"),
                    resultSet.getInt("points")
                );
            }
            return null; // 해당 로그인 ID의 사용자가 없을 경우
        }
    }

    // 3. Update - 사용자 정보 수정
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET password = ?, nickname = ?, dormitoryName = ?, roomNumber = ?, profilePicture = ?, points = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getNickname());
            statement.setString(3, user.getDormitoryName());
            statement.setString(4, user.getRoomNumber());
            statement.setString(5, user.getProfilePicture());
            statement.setInt(6, user.getPoints());
            statement.setLong(7, user.getId());
            statement.executeUpdate();
        }
    }

    // 4. Delete - 사용자 삭제
    public void deleteUser(Long id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    // 5. 모든 사용자 조회 - 필요 없으면 나중에 삭제 예정
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("loginId"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname"),
                    resultSet.getString("dormitoryName"),
                    resultSet.getString("roomNumber"),
                    resultSet.getString("profilePicture"),
                    resultSet.getInt("points")
                );
                users.add(user);
            }
        }
        return users;
    }
}
