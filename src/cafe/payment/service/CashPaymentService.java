package cafe.payment.service;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public interface CashPaymentService {
	public void setRoot(Parent root);
	
	public void handlePayment();
	public void receivedFunc(TextField receivedTextField, Label changeLable);
}
