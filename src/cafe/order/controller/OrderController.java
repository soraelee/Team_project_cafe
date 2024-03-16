package cafe.order.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cafe.order.service.OrderService;
import cafe.order.service.OrderServiceImpl;
import cafe.payment.controller.PaymentController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderController implements Initializable{
	@FXML public CheckBox chkame, chkcappu, chkespre, chkcafelatte, chkgreentea, chkchoco, chkstraw, chkearlg, chkchamo, chkpepper;
	@FXML public TextField amecnt, cappucnt, esprescnt, cafelattecnt, greenteacnt, chococnt, strawcnt, earlgcnt, chamocnt, peppercnt;
	
	Parent root;
	OrderService os;
	
	public void setRoot(Parent root) {
		os.setRoot(root);
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		os = new OrderServiceImpl();
	}
	
	public void cntFunc() {
		System.out.println("수량 입력");
	}
	
	public void orderFunc() {
		System.out.println("주문하기 버튼");
		os.orderFunc();
	}
	public void homeFunc() {
		os.homeFunc();
	}
}
