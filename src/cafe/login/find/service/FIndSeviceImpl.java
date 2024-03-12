package cafe.login.find.service;

import cafe.login.main.MainClass;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class FIndSeviceImpl implements FindService{
	TextField fxName, fxBirth, fxPhone;
	
	
	Parent root;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	@Override
	public void findFunc() {
		fxName = (TextField)root.lookup("#fxName");
		fxBirth = (TextField)root.lookup("#fxBirth");
		fxPhone = (TextField)root.lookup("#fxPhone");
		
		
		
	}

	@Override
	public void backFunc() {
		System.out.println("뒤로 가기");
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}
	
	
}
