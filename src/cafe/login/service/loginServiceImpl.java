package cafe.login.service;

import cafe.login.dao.LoginDAO;
import cafe.login.dto.LoginDTO;
import cafe.login.register.main.RegisterMain;
import cafe.main.MainClass;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginServiceImpl implements loginService{
	@FXML public TextField id;
	@FXML public PasswordField pwd;

	Parent root;
	LoginDAO dao;
	
	public loginServiceImpl() {
		dao = new LoginDAO();
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		System.out.println("로그인 하부코드");
	}

	@Override
	public void loginFunc(TextField id, PasswordField pwd) {
		System.out.println(" --- 서비스 로그인 확인 --- ");
		System.out.println("id : " + id.getText());
		System.out.println("pwd : " + pwd.getText());
//		LoginDTO dto = LoginDAO.db.get(id.getText());
		
		LoginDTO dto = dao.getUser(id.getText());
		
		System.out.println("dto : " + dto);// 있는 값을 꺼내는 경우 객체값, 아닌경우 null 
		
		String msg = null;
		
		Alert alert = new Alert(AlertType.INFORMATION);
		
		if (dto != null) {
			if (dto.getManagerpwd().equals(pwd.getText())) {
				msg = dto.getManagername()	+ "님 인증 성공!";
			} else {
				msg = "비밀번호 틀림!";
			}
		}else {
			msg = "존재하지 않는 아이디 입니다";
		}
		alert.setContentText(msg);
		alert.show();
		
	}

	@Override
	public void registerFunc() {
		System.out.println("---로그인 -> 회원가입 ---");
		RegisterMain rm = new RegisterMain();
		rm.viewfx(root);
	}

	@Override
	public void findFunc() {
		
	}
	@Override
	public void mainFunc() {
		System.out.println("메인으로 가기");
		MainClass mm = new MainClass();
		mm.viewFx(root);
	}
	
}
