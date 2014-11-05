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
					System.out.println("登陆成功");
					return 1;
				}
				else
				{
					System.out.println("密码错误");
					return 2;
				}
			}
			else
			{
				System.out.println("该账户不存在");
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("异常");
			return 3;
		}
	
	}
}
