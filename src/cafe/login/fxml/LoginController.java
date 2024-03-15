package cafe.login.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.login.service.loginService;
import cafe.login.service.loginServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	@FXML public TextField id;
	@FXML public PasswordField pwd;
	Parent root;
	loginService ls ;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new loginServiceImpl();
		
	}

	
	public void idFunc() {
	}
	public void pwdFunc() {
	}
	
	public void loginFunc() {
		ls.loginFunc(id, pwd);
	}
	public void registerFunc() {
		ls.registerFunc();
	}
	public void findFunc() {
		ls.findFunc();
	}
	
	public void setRoot( Parent root) {
		ls.setRoot(root);
		this.root = root;
	}
	public void mainFunc() {
		ls.mainFunc();
	}

}
