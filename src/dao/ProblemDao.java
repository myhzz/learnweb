package dao;




import java.sql.PreparedStatement;
import java.sql.SQLException;

import object.Answer;

import com.DBConn;
import com.PRConn;

public class ProblemDao {
	public int insertVideo(Answer answer)
	{
		String sql="insert into problem values (?,?,?,?,null)";
		try {
			PreparedStatement state=PRConn.getConnection()
					.prepareStatement(sql);
		    state.setString(1, answer.getTime());
		    state.setString(2, answer.getVideo());
		    state.setString(3, answer.getAnswer());
		    state.setString(4, answer.getPersonid());
		    
			int result=state.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	public int finshed(String finish,String time) throws SQLException
	{
		String sql="update problem set finish = ? where time=? ";
		PreparedStatement ps=DBConn.getConnection().prepareStatement(sql);			
		ps.setString(1, finish);
		ps.setString(2, time);
		int re=ps.executeUpdate();
		return re;
	}
	
}
