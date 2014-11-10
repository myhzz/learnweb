package object;

public class Answer {
  private String time;
  private String video;
  private String answer;
  private String personid;
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getVideo() {
	return video;
}
public void setVideo(String video) {
	this.video = video;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getPersonid() {
	return personid;
}
public void setPersonid(String personid) {
	this.personid = personid;
}
@Override
public String toString() {
	return "Answer [time=" + time + ", video=" + video + ", answer=" + answer
			+ ", personid=" + personid + "]";
}
public Answer(String time, String video, String answer, String personid) {
	super();
	this.time = time;
	this.video = video;
	this.answer = answer;
	this.personid = personid;
}
}
