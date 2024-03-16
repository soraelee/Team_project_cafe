package stockService;

import java.util.ArrayList;
import java.util.List;

import cafe.manage.main.ManageMain;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import stockAdd.AddMainClass;
import stockController.Controller;
import stockDAO.DAO;
import stockDTO.DTO;


public class ServieceImpl implements Serviece{
	@FXML public TextField search;
	@FXML public Button btnSearch;
	@FXML public TableView<DTO> listL;

	DAO dao ;
	Parent root;
	DTO dto;
	Controller ctrl;

	public ServieceImpl() {
		dao = new DAO();
		ctrl = new Controller();
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}



	@Override
	public void stockAddFunc(Parent root) {
		System.out.println("추가물품창 실행");
		AddMainClass add = new AddMainClass();
		System.out.println(root);
		add.viewFx(root);//stockAdd 쪽으로 전달한다.
	}


	public void searchFunc(TextField search) {
//		System.out.println("검색 실행-------- : " + search.getText());
//
//		ArrayList<DTO> searchArr = dao.SearchName(search.getText());
//		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				System.out.println("검색 버튼 1");
//				listL.getItems().setAll(searchArr);
//				
//			}
//		});
//		System.out.println("검색 버튼 2");

	}


	@Override
	public void cancelFunc(Parent root) {
		System.out.println("물품추가창 닫기");
		//아예 닫을 경우
//		Stage stage = (Stage)root.getScene().getWindow();
//		stage.close();
		
		//직원 메인으로 이동하는 경우
		ManageMain mm = new ManageMain();
		mm.viewFx(root);
		
	}


	public void deleteFunc(Parent root) {
		
	}
	@Override
	public void addFunc(Parent root) {
		
	}





}


















//===============================================================================

//		search = (TextField)root.lookup("#serch");
//		price = (TextField)root.lookup("#price");
//		num = (TextField)root.lookup("#num");
//		
//		System.out.println(search.getText());
//		
//		dao.search(search.getText());

//		DTO productld = new DTO("아메", "3000", "coffee", "7");
//		DTO price = new DTO("아메", "3000", "coffee", "7");
//		DTO coffee_type = new DTO("아메", "1000", "non_coffee", "33");
//		DTO cnt = new DTO("아메", "5000", "tea", "10");

//		ArrayList<DTO> stList = new ArrayList<>();
//		stList.add(productld);
//		stList.add(price);
//		stList.add(coffee_type);
//		stList.add(cnt);

//		productldL.setCellValueFactory(new PropertyValueFactory("productld"));
//		priceL.setCellValueFactory(new PropertyValueFactory<>("price"));
//		coffee_typeL.setCellValueFactory(new PropertyValueFactory<>("coffee_type"));
//		cntL.setCellValueFactory(new PropertyValueFactory<>("cnt"));


//데이터 추가
//		ObservableList<DTO> list = FXCollections.observableArrayList(
//				productld, price, coffee_type, cnt);
//				
//		listL.setItems(list);
//		DTO dto = new DTO();
//		dto.setProductld(productldL.getText());
//		dto.setPrice(priceL.getText());
//		dto.setCnt(cntL.getText());
//		dto.setCoffee_type(coffee_typeL.getText());
//		
//		dao.searchFunc(dto);
//	}






