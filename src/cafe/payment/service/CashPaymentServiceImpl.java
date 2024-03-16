package cafe.payment.service;

import cafe.payment.controller.PaymentController;
import cafe.receipt.main.ReceiptMain;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

	@Override
	public void receivedFunc(TextField receivedTextField, Label changeLable) {
		System.out.println("주문 내역 라벨링 시작");
		
        if(receivedTextField.getText().isEmpty()) {
        	changeLable.setText("숫자를 입력해주세요.");
        }
        else {
        	int amount = Integer.parseInt(PaymentController.totPrice);
        	int received = Integer.parseInt(receivedTextField.getText());
        	if (received >= amount) {
        		int change = received - amount;
        		changeLable.setText("거스름돈 : " + change);
        		
        	} else {
        		changeLable.setText("받은 돈이 부족합니다.");
        	}
        }
	}
	
}
