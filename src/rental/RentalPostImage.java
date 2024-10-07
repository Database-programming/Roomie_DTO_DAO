package rental;

public class RentalPostImage {

    private long id;              // 대여글 사진 ID
    private String imageUrl;      // 사진 URL
    private RentalPost rentalPost; // 대여글 객체 (외래키로 RentalPost 객체 참조)

    // 기본 생성자
    public RentalPostImage() {}

    // 모든 필드를 포함하는 생성자
    public RentalPostImage(long id, String imageUrl, RentalPost rentalPost) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.rentalPost = rentalPost; // RentalPost 객체 참조
    }

    // Getter/Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RentalPost getRentalPost() {
        return rentalPost;
    }

    public void setRentalPost(RentalPost rentalPost) {
        this.rentalPost = rentalPost;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "RentalPostImage{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", rentalPost=" + rentalPost + // RentalPost 객체의 정보를 출력
                '}';
    }
}
