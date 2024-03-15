package cafe.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import cafe.login.dto.LoginDTO;
import cafe.menu.dto.MenuDTO;


public class LoginDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs ;
	public static String managerId;
	
	public LoginDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##sorae", pwd = "1234";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginDTO getUser(String id) {
		LoginDTO dto = null;
		LoginDAO.managerId = id;
		String sql = "select managerid, managerpwd, managername from manager_table where managerid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				dto = new LoginDTO(rs.getString("managerid"), rs.getString("managerpwd"),
						rs.getString("managername"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public int setUser(LoginDTO dto) {
		String sql = "insert into manager_table values(?, ?, ?, ?, ?)";
		int result = 0 ;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getManagerid());
			ps.setString(2, dto.getManagerpwd());
			ps.setString(3, dto.getManagername());
			ps.setString(4, dto.getBirth());
			ps.setString(5, dto.getPhone());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public LoginDTO getUser(String name, String birth, String phone) {
		LoginDTO dto = null;
		String sql = "select * from manager_table where managername = ? and birth = ? and phone = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, birth);
			ps.setString(3, phone);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new LoginDTO(rs.getString("managerid"), rs.getString("managerpwd"), 
						rs.getString("managername"), rs.getString("birth"), rs.getString("phone"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	
}
