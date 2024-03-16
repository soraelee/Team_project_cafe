package cafe.login.main;

import java.net.URL;

import cafe.login.fxml.LoginController;
import cafe.url.URLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass {

	public void viewFx(Parent root) {
		Stage loginStage = (Stage)root.getScene().getWindow(); 

		try {
			URL url = new URL(URLService.fxPath + "cafe/login/fxml/loginFXML.fxml");

			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			
			LoginController ctrl = loader.getController();
			
			ctrl.setRoot(root); //root 전달
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.show();
		
	}
}
