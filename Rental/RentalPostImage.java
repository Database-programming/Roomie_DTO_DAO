public class RentalPostImage {
    private long id;             // 대여글사진id
    private String imageUrl;     // 사진URL
    private long rentalPostId;   // 대여글id

    public RentalPostImage() {}

    public RentalPostImage(long id, String imageUrl, long rentalPostId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.rentalPostId = rentalPostId;
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

    public long getRentalPostId() {
        return rentalPostId;
    }

    public void setRentalPostId(long rentalPostId) {
        this.rentalPostId = rentalPostId;
    }

    @Override
    public String toString() {
        return "RentalPostImage{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", rentalPostId=" + rentalPostId +
                '}';
    }
}
