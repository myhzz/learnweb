package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.VideoDao;

public class Do extends HttpServlet {

	public static String LOGIN="personlogin";
	public static String BUFFER="gettenvideo";
	public static String PROBLEM="theawserofthequestion";
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
		if(request.getParameter("select").equals(LOGIN))
		{
			String id=request.getParameter("id");
			String password=request.getParameter("passwrod");
			UserDao dao=new UserDao();
			int result=dao.judgeUserLogin(id, password);
		 	if(result==1)
		    {
			response.getOutputStream().write("login success".getBytes());
		    }
	        	else
	     	{
			response.getOutputStream().write("login error".getBytes());
		   }
		}
		else if(request.getParameter("select").equals(BUFFER))
		{
			int start=new Integer(request.getParameter("start"));
			VideoDao dao=new VideoDao();
			String json=dao.judgeTenVideo(start, start+10);
			response.getOutputStream().write(json.getBytes());
		}
		else if(request.getParameter("select").equals(PROBLEM))
		{
			
		}
	}


}
