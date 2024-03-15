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
        try {
            double amount = Double.parseDouble(PaymentController.totPrice);//(amountTextField.getText());//(amountTextField.setText(totPrice.toString());//(amountTextField.getText());//	fxtotPrice.setText(totPrice.toString());
            double received = Double.parseDouble(receivedTextField.getText());

            if (received >= amount) {
                double change = received - amount;
                changeLabel.setText("거스름돈 : " + change);
                // 주문서(대기번호 출력 화면) 전환
                cps.handlePayment();
                
            } else {
                changeLabel.setText("받은 돈이 부족합니다.");
            }
        } catch (NumberFormatException e) {
            changeLabel.setText("숫자를 입력해주세요.");
        }
        
        
        
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
}
