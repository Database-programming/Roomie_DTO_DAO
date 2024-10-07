import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalConfirmationDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 연결 정보
        String username = "your_oracle_username";
        String password = "your_oracle_password";
        return DriverManager.getConnection(url, username, password);
    }

    // 대여 확정 등록
    public void insertRentalConfirmation(RentalConfirmation rentalConfirmation) {
        String sql = "INSERT INTO RentalConfirmations (id, actual_return_date, penalty_points, overdue_days, rental_post_id, requester_id, provider_id) " +
                     "VALUES (rental_confirmation_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(rentalConfirmation.getActualReturnDate().getTime()));
            pstmt.setInt(2, rentalConfirmation.getPenaltyPoints());
            pstmt.setInt(3, rentalConfirmation.getOverdueDays());
            pstmt.setInt(4, rentalConfirmation.getRentalPostId());
            pstmt.setInt(5, rentalConfirmation.getRequesterId());
            pstmt.setInt(6, rentalConfirmation.getProviderId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 특정 대여 확정 조회
    public RentalConfirmation selectRentalConfirmationById(int id) {
        String sql = "SELECT * FROM RentalConfirmations WHERE id = ?";
        RentalConfirmation rentalConfirmation = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                rentalConfirmation = new RentalConfirmation();
                rentalConfirmation.setId(rs.getInt("id"));
                rentalConfirmation.setActualReturnDate(rs.getDate("actual_return_date"));
                rentalConfirmation.setPenaltyPoints(rs.getInt("penalty_points"));
                rentalConfirmation.setOverdueDays(rs.getInt("overdue_days"));
                rentalConfirmation.setRentalPostId(rs.getInt("rental_post_id"));
                rentalConfirmation.setRequesterId(rs.getInt("requester_id"));
                rentalConfirmation.setProviderId(rs.getInt("provider_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalConfirmation;
    }

    // 모든 대여 확정 조회
    public List<RentalConfirmation> selectAllRentalConfirmations() {
        String sql = "SELECT * FROM RentalConfirmations";
        List<RentalConfirmation> rentalConfirmationList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                RentalConfirmation rentalConfirmation = new RentalConfirmation();
                rentalConfirmation.setId(rs.getInt("id"));
                rentalConfirmation.setActualReturnDate(rs.getDate("actual_return_date"));
                rentalConfirmation.setPenaltyPoints(rs.getInt("penalty_points"));
                rentalConfirmation.setOverdueDays(rs.getInt("overdue_days"));
                rentalConfirmation.setRentalPostId(rs.getInt("rental_post_id"));
                rentalConfirmation.setRequesterId(rs.getInt("requester_id"));
                rentalConfirmation.setProviderId(rs.getInt("provider_id"));
                rentalConfirmationList.add(rentalConfirmation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalConfirmationList;
    }

    // 대여 확정 삭제
    public void deleteRentalConfirmation(int id) {
        String sql = "DELETE FROM RentalConfirmations WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 대여 확정 수정
    public void updateRentalConfirmation(RentalConfirmation rentalConfirmation) {
        String sql = "UPDATE RentalConfirmations SET actual_return_date = ?, penalty_points = ?, overdue_days = ?, rental_post_id = ?, requester_id = ?, provider_id = ? " +
                     "WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(rentalConfirmation.getActualReturnDate().getTime()));
            pstmt.setInt(2, rentalConfirmation.getPenaltyPoints());
            pstmt.setInt(3, rentalConfirmation.getOverdueDays());
            pstmt.setInt(4, rentalConfirmation.getRentalPostId());
            pstmt.setInt(5, rentalConfirmation.getRequesterId());
            pstmt.setInt(6, rentalConfirmation.getProviderId());
            pstmt.setInt(7, rentalConfirmation.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
