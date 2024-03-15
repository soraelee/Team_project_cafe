package stockAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import menu.dto.MenuDTO;

public class addDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public addDAO() {
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
	
	public int addFun(addDTO dto) { 
		String sql = "insert into inventory values(?, ?, ?, ?, ?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getProductid());
			ps.setString(2, dto.getProduct());
			ps.setString(3, dto.getCoffee_type());
			ps.setString(4, dto.getCnt());
			ps.setString(5, dto.getPrice());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto);
		return result;

	}
	
public MenuDTO getMenu(String name) {
		
		MenuDTO dto = null;
		String sql = "select * from menu where product = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new MenuDTO(rs.getString("productid"), rs.getString("product"),
						rs.getString("coffee_type"), rs.getInt("price"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(dto);
		return dto;
	}
}
