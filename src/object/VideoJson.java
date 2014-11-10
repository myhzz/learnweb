package object;

public class VideoJson {
	private String author;
	private String ip;
	private String name;
	private String type;
	private String time;
	private String  pictureip;
	private String introduction;
	private int point;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPictureip() {
		return pictureip;
	}
	public void setPictureip(String pictureip) {
		this.pictureip = pictureip;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "VideoJson [author=" + author + ", ip=" + ip + ", name=" + name
				+ ", type=" + type + ", time=" + time + ", pictureip="
				+ pictureip + ", introduction=" + introduction + ", point="
				+ point + "]";
	}
	public VideoJson(String author, String ip, String name, String type,
			String time, String pictureip, String introduction, int point) {
		super();
		this.author = author;
		this.ip = ip;
		this.name = name;
		this.type = type;
		this.time = time;
		this.pictureip = pictureip;
		this.introduction = introduction;
		this.point = point;
	}
	
}
