package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Answer;
import dao.ProblemDao;
import dao.UserDao;
import dao.VideoDao;

public class Do extends HttpServlet {

	public static String LOGIN = "personlogin";
	public static String BUFFER = "gettenvideo";
	public static String PROBLEM = "theawserofthequestion";
	public static String PASSWORDCHANGE = "changethepersonspassword";
	public static String ANSWER="theanswertothequestion";
	public static String FINISH="%finish";
	public static String TYPE="getonekindsofvideo";
	/**
	 * Constructor of the object.
	 */
	public Do() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("select").equals(LOGIN)) {
			String id = request.getParameter("id");
			String password = request.getParameter("passwrod");
			UserDao dao = new UserDao();
			int result = dao.judgeUserLogin(id, password);
			if (result == 1) {
				response.getOutputStream().write("login success".getBytes());
			} else {
				response.getOutputStream().write("login error".getBytes());
			}
		}
		
		
		else if (request.getParameter("select").equals(ANSWER)) {
			long time=System.currentTimeMillis();
			Answer answer=new Answer(time+"",request.getParameter("videoip") ,
					request.getParameter("answer") , request.getParameter("personid"));
			ProblemDao dao=new ProblemDao();
			int re=dao.insertVideo(answer);
			if (re == 1) {
			  System.out.println("问题上传成功");
			} else {
				System.out.println("问题上传失败");
			}
		}
		
		else if (request.getParameter("select").equals(FINISH))
		{
		
			ProblemDao dao=new ProblemDao();
			int re;
			try {
				re = dao.finshed(request.getParameter("time"),request.getParameter("finished"));
				if (re == 1) {
					  System.out.println("问题上传成功");
					} else {
						System.out.println("问题上传失败");
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("问题上传失败");
			}
			
		}
		
		
		else if (request.getParameter("select").equals(BUFFER)) {
			int start = new Integer(request.getParameter("start"));
			VideoDao dao = new VideoDao();
			String json = dao.judgeTenVideo(start, start + 10);
			response.getOutputStream().write(json.getBytes());
		}
		
		
		else if (request.getParameter("select").equals(PROBLEM)) {
			   String time=request.getParameter("time");
			   VideoDao dao=new VideoDao();
			   System.out.println(dao.pointed(time));
			   response.getOutputStream().write(dao.judgeVideoProblem(time).getBytes());
		} 
		
		
		
		else if (request.getParameter("select").equals(PROBLEM)) {
			VideoDao dao = new VideoDao();
			String json=dao.judgeOneKindsVideo(request.getParameter("type"));
			response.getOutputStream().write(json.getBytes());
			
			
		}
		
		
		
		else if (request.getParameter("select").equals(PASSWORDCHANGE)) {
			UserDao user = new UserDao();
			String id = request.getParameter("id");
			String password = request.getParameter("passwrod");
			int result = user.changePassword(id, password);
			if (result == 1) {
				response.getOutputStream().write(
						"passwordchange success".getBytes());
			} else {
				response.getOutputStream().write(
						"passwordchange error".getBytes());
			}
		}
	}

}
