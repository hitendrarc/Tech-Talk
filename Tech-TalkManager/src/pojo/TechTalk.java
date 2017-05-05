package pojo;

public class TechTalk {
	private int id;
	private String date;
	private String title;
	private String description;
	private String presentor;

	public TechTalk(String date2, String title, String description, String presentor) {
		super();

		this.date = date2;
		this.title = title;
		this.description = description;
		this.presentor = presentor;
	}

	public TechTalk(int id, String date, String title, String description, String presentor) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.description = description;
		this.presentor = presentor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPresentor() {
		return presentor;
	}

	public void setPresentor(String presentor) {
		this.presentor = presentor;
	}

	@Override
	public String toString() {
		return "TechTalk [id=" + id + ", date=" + date + ", title=" + title + ", description=" + description
				+ ", presentor=" + presentor + "]";
	}

}
