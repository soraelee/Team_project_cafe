package cafe.login.service;

import javafx.scene.Parent;

public class loginServiceImpl implements loginService{

	Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		System.out.println("로그인 하부코드");
	}

	@Override
	public void loginFunc() {
		
	}

	@Override
	public void registerFunc() {
		
	}

	@Override
	public void findFunc() {
		
	}

	
	
	
}
