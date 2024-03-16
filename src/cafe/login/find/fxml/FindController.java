package cafe.login.find.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.login.find.service.FIndSeviceImpl;
import cafe.login.find.service.FindService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class FindController implements Initializable{
	Parent root;
	FindService fs;
	@FXML public TextField fxName, fxBirth, fxPhone;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fs = new FIndSeviceImpl();
	}
	public void findFunc() {
		fs.findFunc(fxName, fxBirth, fxPhone);
	}
	public void backFunc() {
		fs.backFunc();
	}
	
	public void setRoot(Parent root) {
		fs.setRoot(root);
		this.root = root;
	}

}
