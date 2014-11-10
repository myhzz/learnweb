package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






import com.DBConn;

public class UserDao {

	public int judgeUserLogin(String id,String pass)
	{
		String sql="select password from person where id = ?";
		try {
			PreparedStatement state=DBConn.getConnection().prepareStatement(sql);
			state.setString(1, id);
			ResultSet set=state.executeQuery();
			if(set.next())
			{
				String password =set.getString(1);
				if(pass.equals(password))
				{
					System.out.println("��½�ɹ�");
					return 1;
				}
				else
				{
					System.out.println("�������");
					return 2;
				}
			}
			else
			{
				System.out.println("���˻�������");
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�쳣");
			return 3;
		}
		
	
	}
	public int changePassword(String id,String password){
		String sql = "update person set password = ? where id=? ";
		try {
			PreparedStatement state=DBConn.getConnection().prepareStatement(sql);
			state.setString(1, password);
			state.setString(2, id);
			int result=state.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
