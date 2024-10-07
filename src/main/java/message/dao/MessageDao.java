/*쪽지 dao - 20220803 컴퓨터학과 정여진*/

package message.dao;
import java.sql.Connection;
import java.util.List;

public interface MessageDao {
	
	// sql과연결
	private Connection getConnection() throws SQLException {
	    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB 정보
	    String username = "사용자이름";
	    String password = "비밀번호";
	    return DriverManager.getConnection(url, username, password);
	}


	// 전체 메시지 조회
    public List<MessageDto> showAllMessages() {
        List<MessageDto> messages = new ArrayList<>();
        String sql = "SELECT * FROM Messages";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
            	MessageDto message = new MessageDto();
                message.setId(rs.getInt("id"));
                message.setContent(rs.getString("content"));
                message.setSentDate(rs.getDate("sentDate"));
                message.setStatus(rs.getInt("status"));
                message.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    // 보낸 메시지 조회
    public List<MessageDto> showSentMessages(int senderId) {
        List<MessageDto> messages = new ArrayList<>();
        String sql = "SELECT * FROM Messages WHERE senderId = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, senderId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	MessageDto message = new MessageDto();
                message.setId(rs.getInt("id"));
                message.setContent(rs.getString("content"));
                message.setSentDate(rs.getDate("sentDate"));
                message.setStatus(rs.getInt("status"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    // 받은 메시지 조회
    public List<MessageDto> showReceivedMessages(int receiverId) {
        List<MessageDto> messages = new ArrayList<>();
        String sql = "SELECT * FROM Messages WHERE receiverId = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, receiverId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	MessageDto message = new MessageDto();
                message.setId(rs.getInt("id"));
                message.setContent(rs.getString("content"));
                message.setSentDate(rs.getDate("sentDate"));
                message.setStatus(rs.getInt("status"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    // 새로운 메시지 생성
    public void createMessage(MessageDto message) {
        String sql = "INSERT INTO Messages (id, content, sentDate, status, rentalPostId, senderId, receiverId) "
                   + "VALUES (message_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, message.getContent());
            pstmt.setDate(2, new java.sql.Date(message.getSentDate().getTime()));
            pstmt.setInt(3, message.getStatus());
            pstmt.setInt(4, message.getRentalPostId().getId());
            pstmt.setInt(5, message.getSender().getId());
            pstmt.setInt(6, message.getReceiver().getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // 메시지 검색
    @Override
    public List<MessageDto> searchMessages(String query) {
        List<MessageDto> messages = new ArrayList<>();
        String sql = "SELECT * FROM Messages WHERE content LIKE ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + query + "%"); // 검색어 포함된 메시지를 찾기!
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                MessageDto message = new MessageDto();
                message.setId(rs.getInt("id"));
                message.setContent(rs.getString("content"));
                message.setSentDate(rs.getDate("sentDate"));
                message.setStatus(rs.getInt("status"));
            
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}