package stockAdd;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addServiceImpl implements serviceAdd{
	TextField search, stockAdd, price, num;

	addDAO dao ;
	
	Parent root;
	
	public addServiceImpl() {
		dao = new addDAO();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void cancellFunc(Parent root) {
//		System.out.println("rrr" + root); 
		System.out.println("창닫기");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	
	public void addFunc(TextField stockAdd,TextField price,TextField num) {
	System.out.println("목록추가 버튼");
	System.out.println("name : " +stockAdd.getText());
	System.out.println("price : " +price.getText());
	System.out.println("num : " +num.getText());
	

	}
	
}
