import java.time.LocalDate;

public class RentalConfirmation {
    private long id;                    // 대여확정id
    private LocalDate actualReturnDate;  // 실제반납날짜
    private int penaltyPoints;           // 벌점
    private int overdueDays;             // 연체일
    private long rentalPostId;           // 대여글id
    private long requesterId;            // 요청자id
    private long providerId;             // 제공자id

    public RentalConfirmation() {}

    public RentalConfirmation(long id, LocalDate actualReturnDate, int penaltyPoints, int overdueDays,
                              long rentalPostId, long requesterId, long providerId) {
        this.id = id;
        this.actualReturnDate = actualReturnDate;
        this.penaltyPoints = penaltyPoints;
        this.overdueDays = overdueDays;
        this.rentalPostId = rentalPostId;
        this.requesterId = requesterId;
        this.providerId = providerId;
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

    public long getRentalPostId() {
        return rentalPostId;
    }

    public void setRentalPostId(long rentalPostId) {
        this.rentalPostId = rentalPostId;
    }

    public long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(long requesterId) {
        this.requesterId = requesterId;
    }

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    @Override
    public String toString() {
        return "RentalConfirmation{" +
                "id=" + id +
                ", actualReturnDate=" + actualReturnDate +
                ", penaltyPoints=" + penaltyPoints +
                ", overdueDays=" + overdueDays +
                ", rentalPostId=" + rentalPostId +
                ", requesterId=" + requesterId +
                ", providerId=" + providerId +
                '}';
    }
}
