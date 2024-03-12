package cafe.login.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cafe.login.register.dto.RegisterDTO;

public class RegisterDAO {
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public RegisterDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##sorae", pwd = "1234";
		try {
			Class.forName(driver);
			System.out.println("회원가입 드라이브 연동");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("회원가입 DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int setUser(RegisterDTO dto) {
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

}
