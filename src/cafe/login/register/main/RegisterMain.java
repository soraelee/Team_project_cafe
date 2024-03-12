package cafe.login.register.main;

import java.net.URL;

import cafe.login.register.fxml.RegisterController;
import cafe.login.url.URLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterMain {
	public void viewfx(Parent root) {
		Stage registerStage = (Stage)root.getScene().getWindow();
		try {
			URL url = new URL(URLService.fxPath + "cafe/login/register/fxml/RegisterFXML.fxml");
			System.out.println(url);
			
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			
			RegisterController ctrl = loader.getController();
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		registerStage.setScene(scene);
		registerStage.show();
	}

}
