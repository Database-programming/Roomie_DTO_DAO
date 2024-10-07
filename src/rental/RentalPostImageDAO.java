import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalPostImageDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 연결 정보
        String username = "your_oracle_username";
        String password = "your_oracle_password";
        return DriverManager.getConnection(url, username, password);
    }

    // 대여글 사진 등록
    public void insertRentalPostImage(RentalPostImage rentalPostImage) {
        String sql = "INSERT INTO RentalPostImages (id, image_url, rental_post_id) VALUES (rental_post_image_seq.NEXTVAL, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rentalPostImage.getImageUrl());
            pstmt.setInt(2, rentalPostImage.getRentalPostId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 특정 대여글 사진 조회
    public RentalPostImage selectRentalPostImageById(int id) {
        String sql = "SELECT * FROM RentalPostImages WHERE id = ?";
        RentalPostImage rentalPostImage = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                rentalPostImage = new RentalPostImage();
                rentalPostImage.setId(rs.getInt("id"));
                rentalPostImage.setImageUrl(rs.getString("image_url"));
                rentalPostImage.setRentalPostId(rs.getInt("rental_post_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalPostImage;
    }

    // 특정 대여글에 해당하는 사진 조회
    public List<RentalPostImage> selectRentalPostImagesByPostId(int postId) {
        String sql = "SELECT * FROM RentalPostImages WHERE rental_post_id = ?";
        List<RentalPostImage> rentalPostImageList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                RentalPostImage rentalPostImage = new RentalPostImage();
                rentalPostImage.setId(rs.getInt("id"));
                rentalPostImage.setImageUrl(rs.getString("image_url"));
                rentalPostImage.setRentalPostId(rs.getInt("rental_post_id"));
                rentalPostImageList.add(rentalPostImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalPostImageList;
    }

    // 모든 대여글 사진 조회
    public List<RentalPostImage> selectAllRentalPostImages() {
        String sql = "SELECT * FROM RentalPostImages";
        List<RentalPostImage> rentalPostImageList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                RentalPostImage rentalPostImage = new RentalPostImage();
                rentalPostImage.setId(rs.getInt("id"));
                rentalPostImage.setImageUrl(rs.getString("image_url"));
                rentalPostImage.setRentalPostId(rs.getInt("rental_post_id"));
                rentalPostImageList.add(rentalPostImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalPostImageList;
    }

    // 대여글 사진 삭제
    public void deleteRentalPostImage(int id) {
        String sql = "DELETE FROM RentalPostImages WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 대여글 사진 수정
    public void updateRentalPostImage(RentalPostImage rentalPostImage) {
        String sql = "UPDATE RentalPostImages SET image_url = ?, rental_post_id = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rentalPostImage.getImageUrl());
            pstmt.setInt(2, rentalPostImage.getRentalPostId());
            pstmt.setInt(3, rentalPostImage.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
