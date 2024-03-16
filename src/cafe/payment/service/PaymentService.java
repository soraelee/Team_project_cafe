package cafe.payment.service;

import cafe.payment.main.CashPaymentMain;
import javafx.scene.Parent;

public interface PaymentService {
	public void setRoot(Parent root);
	public void cardFunc();
	public void cashFunc();
}
