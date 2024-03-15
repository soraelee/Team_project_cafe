package cafe.payment.service;

import javafx.scene.Parent;

public interface CashPaymentService {
	public void setRoot(Parent root);
	
	public void handlePayment();
}
