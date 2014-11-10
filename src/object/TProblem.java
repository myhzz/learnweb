package object;

public class TProblem {
	private String problem;
	private String A;
	private String B;
	private String C;
	private String D;
	private String time;
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public TProblem(String problem, String a, String b, String c, String d,
			String time) {
		super();
		this.problem = problem;
		A = a;
		B = b;
		C = c;
		D = d;
		this.time = time;
	}
	@Override
	public String toString() {
		return "TProblem [problem=" + problem + ", A=" + A + ", B=" + B
				+ ", C=" + C + ", D=" + D + ", time=" + time + "]";
	}
	
	
	
	
}
