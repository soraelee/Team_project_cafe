package stockDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stockDTO.DTO;

public class DAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs ;

	public DAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.42.91:1521:orcl";
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
	
	public DTO search(String name) {
		DTO dto = null;
		String sql = "select * from inventory where product = ? ";
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new DTO(rs.getString("productid"),rs.getString("product") ,rs.getString("coffee_type"), 
						rs.getString("cnt"), rs.getString("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto);
		return dto;
	}
	
	
	

//	public DTO getMenu(String id) {
//		DTO dto = null;
//		String sql = "select * from menu where productid = ?";
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, id);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				dto = new MenuDTO(rs.getString("productid"), rs.getString("product"),
//						rs.getString("coffee_type"), rs.getInt("price"));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		System.out.println(dto);
//		return dto;
//	}
}
