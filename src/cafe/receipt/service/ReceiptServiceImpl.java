package cafe.receipt.service;

import cafe.order.main.OrderMain;
import javafx.scene.Parent;

public class ReceiptServiceImpl implements ReceiptService{
	Parent root;
	private Integer orderNum;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}	
	
	@Override
	public void backFunc() {
		System.out.println("처음으로 ...");	
		OrderMain om = new OrderMain();
		om.viewFx(root);
	}
	
	
}
