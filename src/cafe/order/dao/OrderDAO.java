package cafe.order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cafe.order.dto.OrderDTO;
import cafe.order.service.OrderServiceImpl;
//import cafe.payment.dto.PaymentDTO;
//import cafe.payment.orderProperty.OrderProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import menu.dto.MenuDTO;

public class OrderDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public OrderDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.42.91:1521:orcl";
		String id = "c##sorae", pwd = "1234";
		try {
			Class.forName( driver );
			System.out.println("드라이브 로드 성공!!!");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("디비 연결 성공!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Integer> getMenu( ArrayList<OrderDTO> menu ) {
		ArrayList<Integer> arr = new ArrayList<>();
		String sql = "insert into orderlist(productId, product, coffee_type, cnt, price, customerid)" 
						+ "values(?,?,?,?,?,?)";
		int result = 0;
		try {
			for (OrderDTO dto : menu) {
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getProductId() );
				ps.setString(2, dto.getProduct() );
				ps.setString(3, dto.getCoffee_type() );
				ps.setString(4, dto.getCnt() );
				ps.setInt(5, dto.getPrice() );
				ps.setString(6, dto.getCustomerid() );
				result = ps.executeUpdate();
				arr.add(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	public MenuDTO getmenu(String id) {
			
			MenuDTO dto = null;
			String sql = "select * from menu where productid = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
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
	public int getInt(String cnt) {
		System.out.println("cnt : " + cnt);
        return Integer.parseInt(cnt);
    }

	public OrderDTO menuPackage(String id, String cnt, String orderNum) {
		OrderDTO dto = new OrderDTO();
		
		dto.setProductId(id);
		dto.setCnt(cnt);
		
		MenuDTO gdto = getmenu(id);
		int num = getInt(cnt);
		dto.setProduct(gdto.getProduct());
		dto.setPrice(gdto.getPrice() * num);
		dto.setCoffee_type(gdto.getCoffee_type());		
		dto.setCustomerid(orderNum);		
		return dto;		
	}
}