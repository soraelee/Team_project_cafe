package cafe.payment.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cafe.order.controller.OrderController;
import cafe.order.dao.OrderDAO;
import cafe.order.dto.OrderDTO;
import cafe.order.service.OrderService;
import cafe.order.service.OrderServiceImpl;
import cafe.payment.service.PaymentServiceImpl;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class PaymentController implements Initializable{
	Parent root;
	PaymentServiceImpl ps;
	OrderDAO dao;
	
	public static String totPrice;
		
    @FXML public Button card;
    @FXML public Button cash;
    
    ArrayList<OrderDTO> arr;
    
    @FXML public TableView<OrderDTO> orderListTbl = new TableView<>();
    @FXML public TableColumn<OrderDTO, String> fxproduct;
    @FXML public TableColumn<OrderDTO, String> fxcnt;
    @FXML public TableColumn<OrderDTO, Integer> fxprice;
	
	@FXML public Label fxtotCnt;
    @FXML public Label fxtotPrice;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//    	System.out.println("결제창 주문목록 화면");
    	System.out.println("결제 컨트롤러 시작");
    	ps = new PaymentServiceImpl();
    	dao = new OrderDAO();
    	
    	fxproduct.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProduct()));
    	System.out.println("1" + fxproduct);
    	fxcnt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCnt()));
    	System.out.println("2" + fxcnt);
    	fxprice.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getPrice()));
    	System.out.println("3" + fxprice);
    	
    	arr = OrderServiceImpl.OrderMenu;
    	orderListTbl.getItems().setAll(arr);
//    	System.out.println("테이블 완료");
    	
    	setValues();
	}
    	private void setValues() {
    	Integer totCnt = 0, totPrice = 0;
    	
    	for(OrderDTO dto : arr) {
    		totCnt += Integer.parseInt(dto.getCnt());
		   	totPrice += dto.getPrice();
    	}
    	fxtotCnt.setText(totCnt.toString());
    	fxtotPrice.setText(totPrice.toString());
    	
    	PaymentController.totPrice = totPrice.toString();
	}
    	
	//카드 결제 버튼 >> 카드 삽입 알림 창 -> 확인 버튼 클릭 : 결제 완료 => 영수증 화면으로 전환
	public void cardFunc() {
		ps.cardFunc();
		
	}
	//현금 결제 버튼 >> 받은돈, 거스름돈 출력 -> 결제 버튼 클릭 : 결제완료 -> 영수증 화면으로 전환
	public void cashFunc() {
		System.out.println();
		ps.cashFunc();
		 
	}
	public void setRoot(Parent root) {
		ps.setRoot(root);
		this.root = root;
	}
}