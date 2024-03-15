package cafe.main;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.main.Service.MainService;
import cafe.main.Service.MainServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class Controller implements Initializable{
	@FXML public Button customer;
	@FXML public Button employee;
	Parent root;
	
	MainService mains;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mains = new MainServiceImpl();
	}
	public void cusFunc() {
		System.out.println("고객 버튼" + root);
		
	}
	public void empFunc() {
		mains.empFunc(root);
	}

}
