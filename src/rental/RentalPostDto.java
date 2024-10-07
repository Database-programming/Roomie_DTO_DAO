package rental;
import user.User;
import java.util.Date;
public class RentalPostDto {

    private int id; // 대여글 ID
    private int type; // 대여글 타입 (0: 대여요청, 1: 대여제공
    private int status; // 상태 (0: 진행 전, 1: 완료)
    private String title; // 제목
    private String rentalItem; // 대여 물품
    private String content; // 내용
    private int rentalPoint; // 해당 포인트
    private Date rentalStartDate; // 대여 시작 날짜
    private Date rentalEndDate; // 대여 종료 날짜
    private String rentalLocation; // 대여 장소
    private String returnLocation; // 반납 장소
    private String imageUrl; // 사진
    private User writer; // 작성자 (외래키로 User 객체 참조)

    // 생성자
    public RentalPostDto() {}

    public RentalPostDto(int id, int type, String title, String rentalItem, String content, int rentalPoint, Date rentalStartDate,
                      Date rentalEndDate, String rentalLocation, String returnLocation, String imageUrl, int status, User writer) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.rentalItem = rentalItem;
        this.content = content;
        this.rentalPoint = rentalPoint;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.rentalLocation = rentalLocation;
        this.returnLocation = returnLocation;
        this.imageUrl = imageUrl;
        this.status = status;
        this.writer = writer; // User 객체를 직접 참조
    }

    // Getter Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRentalItem() {
        return rentalItem;
    }

    public void setRentalItem(String rentalItem) {
        this.rentalItem = rentalItem;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRentalPoint() {
        return rentalPoint;
    }

    public void setRentalPoint(int rentalPoint) {
        this.rentalPoint = rentalPoint;
    }

    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getRentalLocation() {
        return rentalLocation;
    }

    public void setRentalLocation(String rentalLocation) {
        this.rentalLocation = rentalLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "RentalPost{id=" + id + ", type=" + type + ", title='" + title + "', rentalItem='" + rentalItem + 
                "', content='" + content + "', rentalPoint=" + rentalPoint + ", rentalStartDate=" + rentalStartDate + 
                ", rentalEndDate=" + rentalEndDate + ", rentalLocation='" + rentalLocation + 
                "', returnLocation='" + returnLocation + "', imageUrl='" + imageUrl + "', status=" + status + 
                ", writer=" + writer + "}";
    }
}