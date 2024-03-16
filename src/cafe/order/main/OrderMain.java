package cafe.order.main;

import java.net.URL;
import java.nio.file.Paths;

import cafe.order.controller.OrderController;
import cafe.payment.controller.PaymentController;
import cafe.url.URLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderMain extends Application{
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		URL url = new URL( "file:/" + (Paths.get("").toAbsolutePath().toString()) + "/bin/cafe/order/fxml/order.fxml" );
		
		FXMLLoader loader = new FXMLLoader( url );
		Parent root = loader.load();
		
		OrderController ctrl = loader.getController();
		ctrl.setRoot(root);
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}
	public void viewFx(Parent root) {
		Stage OrderStage = (Stage)root.getScene().getWindow();
		
		try {
			URL url = new URL( URLService.fxPath + "cafe/order/fxml/order.fxml" );
			
			FXMLLoader loader = new FXMLLoader( url) ;
			root = loader.load();
			
			OrderController ctrl = loader.getController();
			
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		OrderStage.setScene(scene);
		OrderStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}