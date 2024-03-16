package cafe.manage.service;

import cafe.login.main.MainClass;
import cafe.manage.close.dao.CloseDAO;
import cafe.manage.close.main.CloseMain;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		stockMain.MainClass sm = new stockMain.MainClass();
		sm.viewFx(root);
		
	}

	@Override
	public void closeFunc() {
		System.out.println("마감 버튼");
		int a = cdao.setTotalOrder();
		System.out.println("총 주문 내역 : "+ a);
		int b = cdao.setManagerid();
		System.out.println("매니저 아이디 : "+ b);
		
		if(a == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			String msg = "마감 내역이 없습니다." ;
			alert.setContentText(msg);
		}else {
			CloseMain cm = new CloseMain();
			cm.viewFx(root);
		}
		
	}

	@Override
	public void logoutFunc() {
		MainClass lm = new MainClass();
		lm.viewFx(root);
		
	}
	
}
