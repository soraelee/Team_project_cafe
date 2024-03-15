package cafe.payment.service;

import cafe.order.dao.OrderDAO;
import cafe.payment.main.CashPaymentMain;
import cafe.payment.main.PaymentMain;
import cafe.receipt.main.ReceiptMain;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PaymentServiceImpl implements PaymentService{
	
	OrderDAO dao;
	Parent root;

	@Override
	public void setRoot(Parent root) {	
		this.root = root;
	}
	@Override
	public void cardFunc() {
		System.out.println("카드 결제 창");
		Alert alert = new Alert(AlertType.INFORMATION);
		String msg = null;
		msg = "카드를 삽입해 주세요.";
		System.out.println( msg );
		alert.setContentText(msg);
		alert.show();
		
		
		System.out.println("카드 결제 완료");

		//영수증 화면으로 전환
		
		ReceiptMain rm = new ReceiptMain();
		rm.viewFx(root);
		
		
	}
	@Override
	public void cashFunc() {
		CashPaymentMain cpm = new CashPaymentMain();
		cpm.viewFx(root);
	}
}
