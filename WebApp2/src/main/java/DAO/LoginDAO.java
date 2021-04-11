package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.connectionDao;
import com.model.modelUser;


public class LoginDAO {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public modelUser checkLogin(String user, String pass) {
		try {
			String query="SELECT * FROM db_28.account WHERE username=? and password=?";
			con = connectionDao.getConnection();
			ps= con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs= ps.executeQuery();
			while(rs.next()) {
				modelUser a = new modelUser(rs.getString(1), rs.getString(2));
				return a;
			}
		} catch (Exception e) {
		}
		return null;
	}
}
