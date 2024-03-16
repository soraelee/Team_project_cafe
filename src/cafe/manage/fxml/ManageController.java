package cafe.manage.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.manage.service.ManageService;
import cafe.manage.service.ManageServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ManageController implements Initializable{
	Parent root;
	ManageService ms ;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new ManageServiceImpl();
	}
	public void stockFunc() {
		ms.stockFunc();
		
	}
	public void closeFunc() {
		ms.closeFunc();
		
	}
	public void logoutFunc() {
		ms.logoutFunc();
		
	}
	public void setRoot(Parent root) {
		ms.setRoot(root);
		this.root = root;
	}

}
