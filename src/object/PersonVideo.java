package object;

public class PersonVideo {
     private String ip;
     private String time;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "PersonVideo [ip=" + ip + ", time=" + time + "]";
	}
	public PersonVideo(String ip, String time) {
		super();
		this.ip = ip;
		this.time = time;
	}
}
