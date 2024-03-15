package cafe.order.main;

import java.net.URL;
import java.nio.file.Paths;

import cafe.order.controller.OrderController;
import cafe.order.url.OrderURLservice;
import cafe.payment.controller.PaymentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderMain extends Application{
	
	@Override
	public void start(Stage arg0) throws Exception {
//		FXMLLoader loader = new FXMLLoader( getClass().getResource("order.fxml") );
//		System.out.println( getClass().getResource("") );
		
//		System.out.println( Paths.get("").toAbsolutePath().toString() );
//		System.out.println( "file:/" + (Paths.get("").toAbsolutePath().toString()) + "/bin/cafe/order/fxml/order.fxml" );
		
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
			URL url = new URL( OrderURLservice.fxPath + "cafe/order/fxml/order.fxml" );
			
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