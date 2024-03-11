package cafe.login.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.login.service.loginService;
import cafe.login.service.loginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class LoginController implements Initializable{
	Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new loginServiceImpl();
		
	}

	loginService ls ;
	
	public void idFunc() {
		System.out.println("아이디 입력");
	}
	public void pwdFunc() {
		System.out.println("아이디 입력");
	}
	
	public void loginFunc() {
		System.out.println("로그인 버튼");
	}
	public void registerFunc() {
		System.out.println("회원가입 버튼");
	}
	public void findFunc() {
		System.out.println("아이디 비밀번호 찾기 버튼");
	}
	
	public void setRoot( Parent root) {
		ls.setRoot(root);
		this.root = root;
	}

}
