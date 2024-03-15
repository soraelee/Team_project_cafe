package cafe.payment.main;

import java.net.URL;

import cafe.order.url.OrderURLservice;
import cafe.payment.controller.CashPaymentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CashPaymentMain {
	public void viewFx(Parent root) {
		Stage CashPaymentStage = (Stage)root.getScene().getWindow();
		
		try {
			URL url = new URL( OrderURLservice.fxPath + "cafe/payment/fxml/cashpayment.fxml" );
			
			FXMLLoader loader = new FXMLLoader( url ) ;
//			System.out.println("cp main 1 " + root);
			root = loader.load();
			
			CashPaymentController ctrl = loader.getController();
//			System.out.println("cp main 2 " + root);
			
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		CashPaymentStage.setScene(scene);
		CashPaymentStage.show();
	}
}
