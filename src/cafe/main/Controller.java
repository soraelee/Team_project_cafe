package cafe.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable{
	@FXML public Button customer;
	@FXML public Button employee;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	public void cusFunc() {
		System.out.println("고객 버튼");
		
	}
	public void empFunc() {
		System.out.println("직원 버튼");
		
	}

}
