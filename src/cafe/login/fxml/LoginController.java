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
		System.out.println("아이디 입력");
	}
	public void pwdFunc() {
		System.out.println("아이디 입력");
	}
	
	public void loginFunc() {
		System.out.println("로그인 버튼");
		ls.loginFunc(id, pwd);
	}
	public void registerFunc() {
		System.out.println("회원가입 버튼");
		ls.registerFunc();
	}
	public void findFunc() {
		System.out.println("아이디 비밀번호 찾기 버튼");
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
