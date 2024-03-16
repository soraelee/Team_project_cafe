package cafe.login.service;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public interface loginService {
	public void setRoot(Parent root) ;
	public void loginFunc(TextField id, PasswordField pwd);
	public void registerFunc();
	public void findFunc();
	public void mainFunc();
	
	

}
