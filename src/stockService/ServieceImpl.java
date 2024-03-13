package stockService;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import stockAdd.AddMainClass;
import stockDAO.DAO;
import stockDTO.DTO;

public class ServieceImpl implements Serviece{
	TextField search, stockAdd, price, num;
	
	DAO dao ;
	
	Parent root;
	public ServieceImpl() {
		dao = new DAO();
		
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	

	@Override
	public void stockAddFunc(Parent root) {
		System.out.println("추가물품창 실행");
		AddMainClass add = new AddMainClass();
		add.viewFx(root);//stockAdd 쪽으로 전달한다.
	}

	public void searchFunc() {
		System.out.println("검색 실행");
		
		search = (TextField)root.lookup("#serch");
		price = (TextField)root.lookup("#price");
		num = (TextField)root.lookup("#num");
		
		System.out.println(search.getText());
		
		dao.search(search.getText());
		
		
		
	}

	
	@Override
	public void cancelFunc(Parent root) {
		System.out.println("물품추가창 닫기");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	@Override
	public void addFunc(Parent root) {
		// TODO Auto-generated method stub
		System.out.println("넌 뭐니??");
		
	}

	
	
}

