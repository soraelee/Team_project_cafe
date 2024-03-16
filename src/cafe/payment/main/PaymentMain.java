package cafe.payment.main;

import java.net.URL;
import java.util.List;

import cafe.payment.controller.CashPaymentController;
import cafe.payment.controller.PaymentController;
import cafe.url.URLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaymentMain {

	public void viewFx(Parent root) {
		Stage PaymentStage = (Stage)root.getScene().getWindow();
		
		try {
			URL url = new URL( URLService.fxPath + "cafe/payment/fxml/payment.fxml" );
			
			FXMLLoader loader = new FXMLLoader( url) ;
			root = loader.load();
			
			PaymentController ctrl = loader.getController();
			
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		PaymentStage.setScene(scene);
		PaymentStage.show();
	}
}