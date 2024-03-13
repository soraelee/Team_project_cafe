package cafe.login.find.service;

import cafe.login.dao.LoginDAO;
import cafe.login.dto.LoginDTO;
import cafe.login.main.MainClass;
import cafe.menu.dto.MenuDTO;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FIndSeviceImpl implements FindService{
	@FXML public TextField fxName, fxBirth, fxPhone;
	
	
	Parent root;
	LoginDAO dao;
	public FIndSeviceImpl() {
		dao = new LoginDAO();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	@Override
	public void findFunc(TextField fxName, TextField fxBirth, TextField fxPhone) {

		System.out.println("로그인 비밀번호 찾기 하부코드");
		System.out.println("이름 "+ fxName.getText() );
		System.out.println("생일"+ fxBirth.getText());
		System.out.println("전화번호: " + fxPhone.getText());
		LoginDTO dto = dao.getUser(fxName.getText(), fxBirth.getText(), fxPhone.getText());

		String msg = null;

		Alert alert = new Alert(AlertType.INFORMATION);

		if (dto == null) {
			msg ="존재하는 아이디가 없습니다.";
		}else {
			msg = "아이디 : " + dto.getManagerid() + "\n" + "비밀번호 : " + dto.getManagerpwd();
		}
		alert.setContentText(msg);
		alert.show();
		
		
	}

	@Override
	public void backFunc() {
		System.out.println("뒤로 가기");
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}
	
	
}
