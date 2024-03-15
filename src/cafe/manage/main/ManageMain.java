package cafe.manage.main;

import java.net.URL;

import cafe.login.url.URLService;
import cafe.manage.fxml.ManageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManageMain {
	
	public void viewFx(Parent root) {
		Stage manageStage = (Stage)root.getScene().getWindow();
		
		try {
			URL url = new URL(URLService.fxPath + "cafe/manage/fxml/manageFXML.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			
			root = loader.load();
			ManageController ctrl = loader.getController();
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		manageStage.setScene(scene);
		manageStage.show();
	}

}
