package object;

public class VideoJson {
	private String author;
	private String ip;
	private String name;
	private String type;
	private String time;
	private String  pictureip;
	public VideoJson(String author, String ip, String name, String type,
			String time, String pictureip) {
		super();
		this.author = author;
		this.ip = ip;
		this.name = name;
		this.type = type;
		this.time = time;
		this.pictureip = pictureip;
	}
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
	@Override
	public String toString() {
		return "VideoJson [author=" + author + ", ip=" + ip + ", name=" + name
				+ ", type=" + type + ", time=" + time + ", pictureip="
				+ pictureip + "]";
	}
}
