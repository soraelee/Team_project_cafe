package cafe.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import cafe.login.dto.LoginDTO;

public class LoginDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs ;
	
	
//	public static Map<String, LoginDTO> db;
//	static {
//		db = new HashMap<>();
//		for (int i = 0; i < 3; i++) {
//			String id = "aaa" + i;
//			LoginDTO dto = new LoginDTO(id, id, "홍길동" + i);
//			db.put(id,  dto);
//			
//		}
//	}
	public LoginDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##sorae", pwd = "1234";
		
		try {
			Class.forName(driver);
			System.out.println("로그인 드라이브 로드 성공");
			
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("로그인 DB 연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginDTO getUser(String id) {
		LoginDTO dto = null;
		String sql = "select * from manager_table where managerid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				dto = new LoginDTO(rs.getString("managerid"), rs.getString("managerpwd"),
						rs.getString("managername"));
			}
		} catch (Exception e) {
		}
		return dto;
	}

}
