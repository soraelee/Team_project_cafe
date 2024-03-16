package cafe.login.find.service;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public interface FindService {
	public void setRoot(Parent root);
	public void findFunc(TextField fxName, TextField fxBirth, TextField fxPhone);
	public void backFunc();

}
