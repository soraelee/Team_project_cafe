package cafe.payment.service;

import cafe.receipt.main.ReceiptMain;
import javafx.scene.Parent;

public class CashPaymentServiceImpl implements CashPaymentService{
	Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void handlePayment() {
		ReceiptMain rm = new ReceiptMain();
		rm.viewFx(root);
	}
	
}
