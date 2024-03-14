package cafe.manage.close.service;

import cafe.manage.close.dao.CloseDAO;
import javafx.scene.Parent;

public class CloseServiceImpl implements CloseService{
	

	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void closeFunc() {
		CloseDAO dao = new CloseDAO();
		dao.deleteOrderList();
		
	}

	
}
