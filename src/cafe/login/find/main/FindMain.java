package cafe.login.find.main;

import java.net.URL;

import cafe.login.find.fxml.FindController;
import cafe.login.url.URLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindMain {
	public void viewfx(Parent root) {
		Stage findStage = (Stage)root.getScene().getWindow();
		try {
			URL url = new URL(URLService.fxPath + "cafe/login/find/fxml/findFXML.fxml"); 
			System.out.println(url);
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			FindController ctrl = loader.getController();
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		findStage.setScene(scene);
		findStage.show();
	}

}
