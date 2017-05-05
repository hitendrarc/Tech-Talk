package pojo;

public class Users {
	private String userName;
	private String title;

	public Users(String userName, String title) {
		super();
		this.userName = userName;
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUseName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Users [useName=" + userName + ", title=" + title + "]";
	}

}
