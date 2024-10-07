import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalPostDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 연결 정보
        String username = "your_oracle_username";
        String password = "your_oracle_password";
        return DriverManager.getConnection(url, username, password);
    }

    // 대여글 등록
    public void insertRentalPost(RentalPost rentalPost) {
        String sql = "INSERT INTO RentalPosts (id, type, title, rental_item, content, rental_point, " +
                     "rental_start_date, rental_end_date, rental_location, return_location, image_url, status, writer_id) " +
                     "VALUES (rental_post_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalPost.getType());
            pstmt.setString(2, rentalPost.getTitle());
            pstmt.setString(3, rentalPost.getRentalItem());
            pstmt.setString(4, rentalPost.getContent());
            pstmt.setInt(5, rentalPost.getRentalPoint());
            pstmt.setDate(6, new java.sql.Date(rentalPost.getRentalStartDate().getTime()));
            pstmt.setDate(7, new java.sql.Date(rentalPost.getRentalEndDate().getTime()));
            pstmt.setString(8, rentalPost.getRentalLocation());
            pstmt.setString(9, rentalPost.getReturnLocation());
            pstmt.setString(10, rentalPost.getImageUrl());
            pstmt.setInt(11, rentalPost.getStatus());
            pstmt.setLong(12, rentalPost.getWriter().getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 특정 대여글 조회
    public RentalPost selectRentalPostById(int id) {
        String sql = "SELECT * FROM RentalPosts WHERE id = ?";
        RentalPost rentalPost = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                rentalPost = new RentalPost();
                rentalPost.setId(rs.getInt("id"));
                rentalPost.setType(rs.getInt("type"));
                rentalPost.setTitle(rs.getString("title"));
                rentalPost.setRentalItem(rs.getString("rental_item"));
                rentalPost.setContent(rs.getString("content"));
                rentalPost.setRentalPoint(rs.getInt("rental_point"));
                rentalPost.setRentalStartDate(rs.getDate("rental_start_date"));
                rentalPost.setRentalEndDate(rs.getDate("rental_end_date"));
                rentalPost.setRentalLocation(rs.getString("rental_location"));
                rentalPost.setReturnLocation(rs.getString("return_location"));
                rentalPost.setImageUrl(rs.getString("image_url"));
                rentalPost.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalPost;
    }

    // 제목으로 대여글 검색
    public List<RentalPost> selectRentalPostsByTitle(String title) {
        String sql = "SELECT * FROM RentalPosts WHERE title LIKE ?";
        List<RentalPost> rentalPostList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + title + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                RentalPost rentalPost = new RentalPost();
                rentalPost.setId(rs.getInt("id"));
                rentalPost.setType(rs.getInt("type"));
                rentalPost.setTitle(rs.getString("title"));
                rentalPost.setRentalItem(rs.getString("rental_item"));
                rentalPost.setContent(rs.getString("content"));
                rentalPost.setRentalPoint(rs.getInt("rental_point"));
                rentalPost.setRentalStartDate(rs.getDate("rental_start_date"));
                rentalPost.setRentalEndDate(rs.getDate("rental_end_date"));
                rentalPost.setRentalLocation(rs.getString("rental_location"));
                rentalPost.setReturnLocation(rs.getString("return_location"));
                rentalPost.setImageUrl(rs.getString("image_url"));
                rentalPost.setStatus(rs.getInt("status"));
                rentalPostList.add(rentalPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalPostList;
    }

    // 모든 대여글 조회
    public List<RentalPost> selectAllRentalPosts() {
        String sql = "SELECT * FROM RentalPosts";
        List<RentalPost> rentalPostList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                RentalPost rentalPost = new RentalPost();
                rentalPost.setId(rs.getInt("id"));
                rentalPost.setType(rs.getInt("type"));
                rentalPost.setTitle(rs.getString("title"));
                rentalPost.setRentalItem(rs.getString("rental_item"));
                rentalPost.setContent(rs.getString("content"));
                rentalPost.setRentalPoint(rs.getInt("rental_point"));
                rentalPost.setRentalStartDate(rs.getDate("rental_start_date"));
                rentalPost.setRentalEndDate(rs.getDate("rental_end_date"));
                rentalPost.setRentalLocation(rs.getString("rental_location"));
                rentalPost.setReturnLocation(rs.getString("return_location"));
                rentalPost.setImageUrl(rs.getString("image_url"));
                rentalPost.setStatus(rs.getInt("status"));
                rentalPostList.add(rentalPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalPostList;
    }

    // 대여글 삭제
    public void deleteRentalPost(int id) {
        String sql = "DELETE FROM RentalPosts WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 대여글 수정
    public void updateRentalPost(RentalPost rentalPost) {
        String sql = "UPDATE RentalPosts SET type = ?, title = ?, rental_item = ?, content = ?, rental_point = ?, " +
                     "rental_start_date = ?, rental_end_date = ?, rental_location = ?, return_location = ?, image_url = ?, status = ? " +
                     "WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalPost.getType());
            pstmt.setString(2, rentalPost.getTitle());
            pstmt.setString(3, rentalPost.getRentalItem());
            pstmt.setString(4, rentalPost.getContent());
            pstmt.setInt(5, rentalPost.getRentalPoint());
            pstmt.setDate(6, new java.sql.Date(rentalPost.getRentalStartDate().getTime()));
            pstmt.setDate(7, new java.sql.Date(rentalPost.getRentalEndDate().getTime()));
            pstmt.setString(8, rentalPost.getRentalLocation());
            pstmt.setString(9, rentalPost.getReturnLocation());
            pstmt.setString(10, rentalPost.getImageUrl());
            pstmt.setInt(11, rentalPost.getStatus());
            pstmt.setInt(12, rentalPost.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
