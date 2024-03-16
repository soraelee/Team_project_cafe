package cafe.payment.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.payment.service.CashPaymentServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CashPaymentController implements Initializable {
	Parent root;
	CashPaymentServiceImpl cps;
	
	@FXML public Label paymentAmount;
    @FXML public TextField receivedTextField;
    @FXML public Label changeLabel;
    
    @FXML public void handlePayment() {
                cps.handlePayment();
                //여기 있던 내용 implements로 옮겼어요
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cps = new CashPaymentServiceImpl();
		paymentAmount.setText(PaymentController.totPrice);
	}
	
	public void setRoot(Parent root) {
		cps.setRoot(root);
		this.root = root;
	}
	public void cntFunc() {
	}
	public void receivedFunc() {
		cps.receivedFunc(receivedTextField, changeLabel);
	}
}
