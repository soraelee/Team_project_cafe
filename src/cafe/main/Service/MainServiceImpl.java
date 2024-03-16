package cafe.main.Service;

import cafe.login.main.MainClass;
import cafe.menu.dto.MenuDTO;
import cafe.order.main.OrderMain;
import javafx.scene.Parent;

public class MainServiceImpl implements MainService{
	Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	@Override
	public void cusFunc() {
		System.out.println("---고객 서비스 실행---");
		OrderMain om = new OrderMain();
		om.viewFx(root);
	}

	@Override
	public void empFunc() {
		System.out.println("---직원 서비스 실행---");
		
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}

	
}
