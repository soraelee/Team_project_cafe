package stockController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import stockService.Serviece;
import stockService.ServieceImpl;

public class Controller implements Initializable{
	@FXML public TextField search, stockAdd, price, num ;
	@FXML public ListView<String> list;
	
	Parent root;
	ServieceImpl ss;
	
	public void setRoot(Parent root) { 
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ss = new ServieceImpl();
		System.out.println("초기화 메소드");
		
	}
	public void stockAddFunc() {
		System.out.println("물품 추가 실행");
		ss.stockAddFunc(root);
		
	}
	public void cancelFunc() {
		System.out.println("물품 목록 창 닫기");
		System.out.println("root : "+ root);
		ss.cancelFunc(root);
	}
	
	
	public void searchFunc() {
		System.out.println("searchF확인");
		System.out.println("상품명 : " +stockAdd.getText());
		System.out.println("가격 : " +price.getText());
		System.out.println("개수 : " +num.getText());
		
	}
	
	public void lessFunc() {
		
	}
	public void changeFunc() {
		
	}
	public void deleteFunc() {
		
	}
}
