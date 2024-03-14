package cafe.login.register.service;

import cafe.login.dao.LoginDAO;
import cafe.login.dto.LoginDTO;
import cafe.login.main.MainClass;
import cafe.main.Service.MainService;
import cafe.main.Service.MainServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterServiceImpl implements RegisterService{
	TextField fxId, fxName, fxBirth, fxPhone;
	PasswordField fxPwd, fxPwdChk;
	
	Parent root;
	LoginDAO dao;
	
	public RegisterServiceImpl() {
		dao = new LoginDAO();
	}
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

//	@Override
	public void registerFunc() {
		
		System.out.println("실행222222");
		
		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		fxBirth = (TextField)root.lookup("#fxBirth");
		fxPhone = (TextField)root.lookup("#fxPhone");
		fxPwd = (PasswordField)root.lookup("#fxPwd");
		fxPwdChk = (PasswordField)root.lookup("#fxPwdChk");
		
		Alert alert = new Alert(AlertType.INFORMATION);
		String msg = null;
		if (fxId.getText().isEmpty()) {
			msg = "아이디를 입력하세요";
		}else if (fxPwd.getText().isEmpty()) {
			msg = "비밀번호를 입력하세요";
		}else if (fxPwdChk.getText().isEmpty()) {
			msg = "비밀번호를 확인하세요";
		}else if (!fxPwd.getText().equals(fxPwdChk.getText())) {
			msg = "비밀번호를 확인하세요";
		}else if (fxBirth.getText().isEmpty()) {
			msg = "생년월일을 입력하세요";
		}else if (fxBirth.getText().length() != 6) {
			msg = "생년월일을 확인하세요";
		}else if (fxPhone.getText().isEmpty()) {
			msg = "휴대폰 번호를 입력하세요";
		}else if (fxPhone.getText().length() != 11) {
			msg = "휴대폰 번호를 확인하세요";
		}else {
			msg = "회원가입이 완료되었습니다";
		}
		alert.setContentText(msg);
		alert.show();
		
		LoginDTO dto = new LoginDTO();
		
		dto.setManagerid(fxId.getText());
		dto.setManagerpwd(fxPwd.getText());
		dto.setManagername(fxName.getText());
		dto.setBirth(fxBirth.getText());
		dto.setPhone(fxPhone.getText());
		
		dao.setUser(dto);
	
		MainClass lm = new MainClass();
		lm.viewFx(root);
	}

	@Override
	public void backFunc() {
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}
	
	
}
