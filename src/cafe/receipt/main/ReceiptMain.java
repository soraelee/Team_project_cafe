package cafe.receipt.main;

import java.net.URL;

import cafe.order.url.OrderURLservice;
import cafe.payment.controller.PaymentController;
import cafe.receipt.controller.ReceiptController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReceiptMain {
	public void viewFx(Parent root) {
		Stage receiptStage = (Stage)root.getScene().getWindow();
		
		try {
			URL url = new URL( OrderURLservice.fxPath + "cafe/receipt/fxml/receipt.fxml" );
			
			FXMLLoader loader = new FXMLLoader( url) ;
			root = loader.load();
			
			ReceiptController ctrl = loader.getController();
			
			ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		receiptStage.setScene(scene);
		receiptStage.show();
	}
}
