/* 20220803 컴퓨터학과 정여진 */
/* 쪽지 코드 */
import java.util.Date;

public class Message {
    private int id; // 쪽지 ID
    private String content; // 내용
    private Date sentDate; // 작성일
    private int status; // 상태 (0 : 진행 전, 1: 완료)
    private RentalPost rentalPostId; // 대여글 id 외래키로
    private User sender; // 발신자
    private User receiver; // 수신자

    // 생성자
    public Message() {}

    public Message(int id, String content, Date sentDate, int status, RentalPost rentalPostId, User sender, User receiver) {
        this.id = id;
        this.content = content;
        this.sentDate = sentDate;
        this.status = status;
        this.rentalPostId = rentalPostId;
        this.sender = sender;
        this.receiver = receiver;
    }

    // getter, setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RentalPost getRentalPostId() {
        return rentalPostId;
    }

    public void setRentalPostId(RentalPost rentalPostId) {
        this.rentalPostId = rentalPostId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
