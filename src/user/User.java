package user;

public class User {

	  private Long id;                 
	    private String loginId;          
	    private String password;         
	    private String nickname;         
	    private String dormitoryName;    
	    private String roomNumber;       
	    private String profilePicture;   
	    private int points;              

	    public User() {
	    }

	    public User(Long id, String loginId, String password, String nickname, String dormitoryName,
	                   String roomNumber, String profilePicture, int points) {
	        this.id = id;
	        this.loginId = loginId;
	        this.password = password;
	        this.nickname = nickname;
	        this.dormitoryName = dormitoryName;
	        this.roomNumber = roomNumber;
	        this.profilePicture = profilePicture;
	        this.points = points;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getLoginId() {
	        return loginId;
	    }

	    public void setLoginId(String loginId) {
	        this.loginId = loginId;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getNickname() {
	        return nickname;
	    }

	    public void setNickname(String nickname) {
	        this.nickname = nickname;
	    }

	    public String getDormitoryName() {
	        return dormitoryName;
	    }

	    public void setDormitoryName(String dormitoryName) {
	        this.dormitoryName = dormitoryName;
	    }

	    public String getRoomNumber() {
	        return roomNumber;
	    }

	    public void setRoomNumber(String roomNumber) {
	        this.roomNumber = roomNumber;
	    }

	    public String getProfilePicture() {
	        return profilePicture;
	    }

	    public void setProfilePicture(String profilePicture) {
	        this.profilePicture = profilePicture;
	    }

	    public int getPoints() {
	        return points;
	    }

	    public void setPoints(int points) {
	        this.points = points;
	    }

	    @Override
	    public String toString() {
	        return "UserDto{" +
	                "id=" + id +
	                ", loginId='" + loginId + '\'' +
	                ", password='" + password + '\'' +
	                ", nickname='" + nickname + '\'' +
	                ", dormitoryName='" + dormitoryName + '\'' +
	                ", roomNumber='" + roomNumber + '\'' +
	                ", profilePicture='" + profilePicture + '\'' +
	                ", points=" + points +
	                '}';
	    }
}
