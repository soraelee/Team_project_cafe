package cafe.manage.close.main;

import java.net.URL;

import cafe.login.url.URLService;
import cafe.manage.close.fxml.CloseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CloseMain {
	
	public void viewFx(Parent root) {
		Stage closeStage = (Stage)root.getScene().getWindow();
		
		try {
			URL url = new URL(URLService.fxPath + "cafe/manage/close/fxml/closeFXML.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			CloseController ctrl = loader.getController();
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		closeStage.setScene(scene);
		closeStage.show();
		
	}

}
