package cafe.manage.close.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cafe.login.dao.LoginDAO;
import cafe.manage.close.dto.CloseDTO;
import cafe.order.dto.OrderDTO;
import javafx.collections.ObservableArray;

public class CloseDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs ;
	
	public CloseDAO() {String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##sorae", pwd = "1234";
		
		try {
			Class.forName(driver);
			System.out.println("마감 드라이브 로드 성공");
			
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("마감 DB 연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int setTotalOrder() {
		int result = 0;
		String sql = "insert into totalorder (productid, product, totcnt, totprice, coffee_type) "
				+ "select productid, product, coffee_type, sum(cnt)totcnt, sum(price) totprice "
				+ "from orderlist "
				+ "group by productid, product, coffee_type "
				+ "order by totprice desc";
		
		
		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int setManagerid() {
		int result = 0;
		String sql = "update totalorder set managerid = ? where managerid is null";
		String id = LoginDAO.managerId;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteOrderList() {
		int result = 0;
		String sql = "delete totalorder";
		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<CloseDTO> getTotalOrder() {
		String sql = "select * from totalorder";
		ArrayList<CloseDTO> arr = new ArrayList<CloseDTO>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CloseDTO dto = new CloseDTO(rs.getString("productid"), rs.getString("productid"), rs.getString("coffee_type"),
						rs.getString("totcnt"), rs.getString("totprice"), rs.getString("manageid"));
				
				arr.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	
		
	
	
	
}
