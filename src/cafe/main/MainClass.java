package cafe.main;

import java.net.URL;

import cafe.login.fxml.LoginController;
import cafe.url.URLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainfx.fxml"));
		
		Parent root = loader.load();
		Controller ctrl = loader.getController();
		ctrl.setRoot(root);
		
		Scene scene = new Scene(root);
		
		arg0.setScene(scene);
		arg0.show();
	}
	public void viewFx(Parent root) {
		System.out.println("실행");
		Stage mainStage = (Stage)root.getScene().getWindow(); 

		try {
			URL url = new URL(URLService.fxPath + "cafe/main/mainfx.fxml");
			System.out.println(url);

			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			Controller ctrl = loader.getController();
			ctrl.setRoot(root); //root 전달
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
