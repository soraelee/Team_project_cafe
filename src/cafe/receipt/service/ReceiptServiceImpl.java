package cafe.receipt.service;

import java.text.SimpleDateFormat;

import cafe.order.main.OrderMain;
import javafx.scene.Parent;

public class ReceiptServiceImpl implements ReceiptService{
	Parent root;
	
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
	public String dateFunc() {
		long time = System.currentTimeMillis();
		System.out.println(time);
		SimpleDateFormat si = 
				new SimpleDateFormat("yyyy년 MM월 dd일"); //aa hh시 mm분 ss초
		String s = si.format(time);
		System.out.println(s);
		
		return s;
	}
	
}
