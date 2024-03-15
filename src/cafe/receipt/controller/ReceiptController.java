package cafe.receipt.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cafe.order.dao.OrderDAO;
import cafe.order.dto.OrderDTO;
import cafe.order.service.OrderServiceImpl;
import cafe.payment.controller.PaymentController;
import cafe.receipt.service.ReceiptService;
import cafe.receipt.service.ReceiptServiceImpl;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReceiptController implements Initializable{
	Parent root;
	ReceiptService rs;
//	OrderDAO dao;
	
	public static String totPrice;
	
	ArrayList<OrderDTO> arr;
    
    @FXML public TableView<OrderDTO> orderListTbl = new TableView<>();
    @FXML public TableColumn<OrderDTO, String> fxproduct;
    @FXML public TableColumn<OrderDTO, String> fxcnt;
//    @FXML public TableColumn<OrderDTO, Integer> fxprice;
	
	@FXML public Label fxtotCnt;
    @FXML public Label fxtotPrice;
    @FXML public Label fxOrderNum;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("영수증 컨트롤러 시작");
		rs = new ReceiptServiceImpl();
//		dao = new OrderDAO();
		
		fxproduct.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProduct()));
		fxcnt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCnt()));
		
		arr = OrderServiceImpl.OrderMenu;
    	orderListTbl.getItems().setAll(arr);
    	
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
    	
    	fxOrderNum.setText(OrderServiceImpl.orderStrNum);
    	
	}
    	
	public void setRoot(Parent root) {
		rs.setRoot(root);
		this.root = root;
	}
	public void backFunc() {
		rs.backFunc();
	}
	public void cashFunc() {
	}
}
