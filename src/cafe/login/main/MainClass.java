package cafe.login.main;

import java.net.URL;

import cafe.login.fxml.LoginController;
import cafe.login.url.URLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass {

	public void viewFx(Parent root) {
		System.out.println("로그인 루트");
		Stage loginStage = (Stage)root.getScene().getWindow(); // 여기서 막힘

		System.out.println("로그인 루트22");
		try {
			URL url = new URL(URLService.fxPath + "cafe/login/fxml/loginFXML.fxml");
			System.out.println(url);

			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			System.out.println("로그인 루트33");
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
