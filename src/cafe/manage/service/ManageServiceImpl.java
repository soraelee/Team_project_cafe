package cafe.manage.service;

import cafe.login.main.MainClass;
import cafe.manage.close.dao.CloseDAO;
import cafe.manage.close.main.CloseMain;
import javafx.scene.Parent;

public class ManageServiceImpl implements ManageService {
	Parent root;
	
	CloseDAO cdao;
	public ManageServiceImpl() {
		cdao = new CloseDAO();
	}
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	@Override
	public void stockFunc() {
		
	}

	@Override
	public void closeFunc() {
		System.out.println("마감 버튼");
		int a = cdao.setTotalOrder();
		System.out.println("총 주문 내역 : "+ a);
		int b = cdao.setManagerid();
		System.out.println("매니저 아이디 : "+ b);
		CloseMain cm = new CloseMain();
		cm.viewFx(root);
	}

	@Override
	public void logoutFunc() {
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}
	
}
