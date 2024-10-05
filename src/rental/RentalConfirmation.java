package rental;

import java.time.LocalDate;
import user.User;

public class RentalConfirmation {
    private long id;                    // 대여확정 id
    private LocalDate actualReturnDate;  // 실제 반납 날짜
    private int penaltyPoints;           // 벌점
    private int overdueDays;             // 연체 일수
    private RentalPost rentalPost;       // 대여글 (RentalPost 객체 참조)
    private User requester;              // 요청자 (User 객체 참조)
    private User provider;               // 제공자 (User 객체 참조)

    public RentalConfirmation() {}

    public RentalConfirmation(long id, LocalDate actualReturnDate, int penaltyPoints, int overdueDays,
                              RentalPost rentalPost, User requester, User provider) {
        this.id = id;
        this.actualReturnDate = actualReturnDate;
        this.penaltyPoints = penaltyPoints;
        this.overdueDays = overdueDays;
        this.rentalPost = rentalPost;      // RentalPost 객체 참조
        this.requester = requester;        // User 객체 참조
        this.provider = provider;          // User 객체 참조
    }

    // Getter/Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }

    public RentalPost getRentalPost() {
        return rentalPost;
    }

    public void setRentalPost(RentalPost rentalPost) {
        this.rentalPost = rentalPost;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "RentalConfirmation{" +
                "id=" + id +
                ", actualReturnDate=" + actualReturnDate +
                ", penaltyPoints=" + penaltyPoints +
                ", overdueDays=" + overdueDays +
                ", rentalPost=" + rentalPost +
                ", requester=" + requester +
                ", provider=" + provider +
                '}';
    }
}
