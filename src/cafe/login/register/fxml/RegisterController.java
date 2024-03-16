package cafe.login.register.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.login.register.service.RegisterService;
import cafe.login.register.service.RegisterServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class RegisterController implements Initializable {
	Parent root;
	RegisterService rs;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rs = new RegisterServiceImpl(); 
	}
	public void registerFunc() {
		rs.registerFunc();
		
	}
	public void setRoot(Parent root) {
		rs.setRoot(root);
		this.root = root;
	}
	public void backFunc() {
		rs.backFunc();
	}

}
