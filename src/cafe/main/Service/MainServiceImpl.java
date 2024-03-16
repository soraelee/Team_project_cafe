package cafe.main.Service;

import cafe.login.main.MainClass;
import cafe.menu.dto.MenuDTO;
import javafx.scene.Parent;

public class MainServiceImpl implements MainService{
	
	@Override
	public void cusFunc() {
		System.out.println("---고객 서비스 실행---");
	}

	@Override
	public void empFunc(Parent root) {
		System.out.println("---직원 서비스 실행---");
		
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}

	
}
