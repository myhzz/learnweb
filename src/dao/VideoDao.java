package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;







import object.Video;
import object.VideoJson;

import com.DBConn;
import com.google.gson.Gson;
public class VideoDao {
	private int  point;
	public int insertVideo(Video cls)
	{
		String sql="insert into video values (null ,?,?,?,?,?,?,null,?,?)";
		try {
			PreparedStatement state=DBConn.getConnection()
					.prepareStatement(sql);
			state.setString(1, cls.getAuthor());
			state.setString(2, cls.getTime());
			state.setString(3, cls.getIp());
			state.setString(4, cls.getName());
			state.setString(5, cls.getType());
			state.setString(6, cls.getProblem());
			state.setString(7, cls.getIntroduction());
			state.setInt(8, 0);
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
	
	
	
	public String   pointed(String time){
		String sql="select * from video where time =?";
		
		try {
			PreparedStatement state=DBConn.getConnection().
					prepareStatement(sql);
			state.setString(1, time);
			ResultSet set=state.executeQuery();
			if(set.next())
			{
				point=set.getInt("point");
		    }
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "查找异常";
		}
		sql = "update video set point = ? where time=? ";
		try {
			PreparedStatement state=DBConn.getConnection().prepareStatement(sql);
			state.setInt(1, point+1);
			state.setString(2, time);
			int result=state.executeUpdate();
		  return  "成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "修改异常";
		}
	}
	
	
	
	public String judgeVideoProblem(String time)
	{
		String sql="select * from video where time =?";
		try {
			PreparedStatement state=DBConn.getConnection().
					prepareStatement(sql);
			state.setString(1, time);
			ResultSet set=state.executeQuery();
			if(set.next())
			{
				String ip=set.getString("promblem");
				
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
			
			if(set.next())
			{
				String author=set.getString("author");
				String ip=set.getString("ip");
				String time=set.getString("time");
				String name=set.getString("name");
				String type=set.getString("type");
				String pictureip=set.getString("pictureip");
				String introduction=set.getString("introduction");
				int point=set.getInt("point");
				VideoJson video=new VideoJson(author, ip, name, type, time,pictureip,introduction,point);
		        Gson gson=new Gson();
		        return gson.toJson(video);
//			    Person person=new Person(pass, num, grade);
//			    Gson gson=new Gson();
//				return gson.toJson(person);
//				return "password:"+pass+"\n"+"num:"+num+"\n"+"grade:"+grade;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	public String judgeOneKindsVideo(String tpye)
	{
		String sql="select * from video where type = ? ";
		try {
			PreparedStatement state=DBConn.getConnection().
					prepareStatement(sql);
		   state.setString(1, tpye);
			ResultSet set=state.executeQuery();
			
			if(set.next())
			{
				String author=set.getString("author");
				String ip=set.getString("ip");
				String time=set.getString("time");
				String name=set.getString("name");
				String type=set.getString("type");
				String pictureip=set.getString("pictureip");
				String problem=set.getString("problem");
				int point =set.getInt("point");
				
				VideoJson video=new VideoJson(author, ip, name, type, time,pictureip,problem,point);
		        Gson gson=new Gson();
		        return gson.toJson(video);
//			    Person person=new Person(pass, num, grade);
//			    Gson gson=new Gson();
//				return gson.toJson(person);
//				return "password:"+pass+"\n"+"num:"+num+"\n"+"grade:"+grade;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
