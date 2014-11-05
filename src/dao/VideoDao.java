package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






import object.Video;
import object.VideoJson;

import com.DBConn;
import com.google.gson.Gson;
public class VideoDao {
	public int insertVideo(Video cls)
	{
		String sql="insert into video values (null ,?,?,?,?,?,null,null)";
		try {
			PreparedStatement state=DBConn.getConnection()
					.prepareStatement(sql);
			state.setString(1, cls.getAuthor());
			state.setString(2, cls.getTime());
			state.setString(3, cls.getIp());
			state.setString(4, cls.getName());
			state.setString(5, cls.getType());
			int result=state.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	public int InsertPIp(String time, String ip) {
		String sql = "update video set pictureip = ? where time=? ";
		try {

			PreparedStatement state = (PreparedStatement) DBConn
					.getConnection().prepareStatement(sql);
			state.setString(1, ip);
			state.setString(2, time);

			int result = state.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int answerQues(String result,String name) throws SQLException
	{
		String sql="update video set problem = ? where name=? ";
		PreparedStatement ps=DBConn.getConnection().prepareStatement(sql);			
		ps.setString(1, result);
		ps.setString(2, name);
		int re=ps.executeUpdate();
		return re;
	}
	public String judgeVideoIp(String name)
	{
		String sql="select * from video where username =?";
		try {
			PreparedStatement state=DBConn.getConnection().
					prepareStatement(sql);
			state.setString(1, name);
			ResultSet set=state.executeQuery();
			if(set.next())
			{
				String ip=set.getString("ip");
				
//			    Person person=new Person(pass, num, grade);
//			    Gson gson=new Gson();
//				return gson.toJson(person);
				return ip;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
//	sql="select * from 数据表 where字段名between 值1 and 值2"
	public String judgeTenVideo(int start,int end)
	{
		String sql="select * from video where id between ? and ?";
		try {
			PreparedStatement state=DBConn.getConnection().
					prepareStatement(sql);
			state.setInt(1, start);
			state.setInt(1, end);
			ResultSet set=state.executeQuery();
			String JJson="";
			if(set.next())
			{
				String author=set.getString("author");
				String ip=set.getString("ip");
				String time=set.getString("time");
				String name=set.getString("name");
				String type=set.getString("type");
				String pictureip=set.getString("pictureip");
				VideoJson video=new VideoJson(author, ip, name, type, time,pictureip);
		        Gson gson=new Gson();
		      JJson=JJson+gson.toJson(video);
//			    Person person=new Person(pass, num, grade);
//			    Gson gson=new Gson();
//				return gson.toJson(person);
//				return "password:"+pass+"\n"+"num:"+num+"\n"+"grade:"+grade;
				
			}
			return JJson;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
