package stockDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import menu.dto.MenuDTO;
import stockAdd.addDTO;
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
			return;
		} catch (Exception e) {
			e.printStackTrace();
//			return null;
		}

	}

	public ArrayList<DTO> invenSearch() {
		ArrayList<DTO> arr = new ArrayList<>();
		
		String sql = "select productid, product, coffee_type, sum(cnt) sumcnt, sum(price) sumprice "
				+ "from inventory group by productid, product, coffee_type";
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO dto = new DTO();
				
				dto = new DTO(rs.getString("productid") ,rs.getString("product"), rs.getString("coffee_type"), 
						rs.getString("sumcnt"), rs.getString("sumprice"));
				arr.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(dto);
		return arr;
	}
	
	
	
	public ArrayList<DTO> SearchName(String name) {
		ArrayList<DTO> arr = new ArrayList<>();
		
		String sql = "select productid, product, coffee_type, sum(cnt) sumcnt, sum(price) sumprice"
				+ " from inventory where product = ? "
				+ "group by productid, product, coffee_type";
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO dto = new DTO();
				
				dto = new DTO(rs.getString("productid") ,rs.getString("product"), rs.getString("coffee_type"), 
						rs.getString("cnt"), rs.getString("price"));
				arr.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(dto);
		return arr;
	}
	
	
	 
	

	public int delet(ObservableList<DTO> delList) {
		int result = 0;
		String sql = "delete from inventory where productid = ?";
		try {
			for (DTO dto : delList) {
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getProductld());
				result = ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result : " +result);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//public int output(addDTO dto) {
//	String sql = "insert into inventory values(?, ?, ?, ?, ?)";
//	int result = 0;
//	try {
//		ps = con.prepareStatement(sql);
//		ps.setString(1, dto.getProductid());
//		ps.setString(2, dto.getPrice());
//		ps.setString(3, dto.getCoffee_type());
//		ps.setString(4, dto.getCnt());
//		ps.setString(5, dto.getPrice());
//		result = ps.executeUpdate();
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	System.out.println(dto);
//	return result;
//
//}




//	public DAO() {
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@192.168.42.91:1521:orcl";
//		String id = "c##sorae", pwd = "1234";
//
//		try {
//			Class.forName(driver);
//			System.out.println("로그인 드라이브 로드 성공");
//			con = DriverManager.getConnection(url, id, pwd);
//			System.out.println("로그인 DB 연결 성공");
////			return con;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}




//		String sql = "insert into INVENTORY values(?, ?, ?, ?, ?)";
//		int result = 0;
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, dto.getProductld());
//			ps.setString(2, dto.getPrice());
//			ps.setString(3, dto.getCoffee_type());
//			ps.setString(4, dto.getCnt());
//			result = ps.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(dto);
//		return result;


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
