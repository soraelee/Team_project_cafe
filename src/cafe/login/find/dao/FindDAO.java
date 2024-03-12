package cafe.login.find.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FindDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public FindDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##sorae", pwd = "1234";
		
		try {
			Class.forName(driver);
			System.out.println("비번 찾기 드라이브 연동");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
