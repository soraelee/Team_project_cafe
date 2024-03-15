package stockController;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import menu.dto.MenuDTO;
import search.main.SearchMain;
import stockAdd.addDAO;
import stockAdd.addDTO;
import stockDAO.DAO;
import stockDTO.DTO;
import stockDTO.stockProperty;
import stockService.Serviece;
import stockService.ServieceImpl;

public class Controller implements Initializable{
	@FXML public TableView<DTO> listL;
	@FXML public TableColumn<DTO, String> productldL;
	@FXML public TableColumn<DTO, String> priceL;
	@FXML public TableColumn<DTO, String> coffee_typeL;
	@FXML public TableColumn<DTO, String> cntL;
	@FXML public TextField search;
	@FXML public Button btnSearch;

	Parent root;
	Serviece ss;
	DAO da ;
	DTO dto;

	public void setRoot(Parent root) { 
		ss.setRoot(root);
		this.root = root;
	}

	//	ObservableList<DTO> stockList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ss = new ServieceImpl();
		da = new DAO();

		productldL.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProduct()));
		System.out.println("1" + productldL);
		priceL.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPrice()));
		System.out.println("2" + priceL);
		coffee_typeL.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getCoffee_type()));
		System.out.println("3" + coffee_typeL);
		cntL.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getCnt()));
		System.out.println("4" + cntL);


		ArrayList<DTO> arr = da.invenSearch();	
	
		listL.getItems().setAll(arr);
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(search.getText().isEmpty()) {
					System.out.println("검색창 초기화");
					listL.getItems().setAll(arr);
				}else {
					ArrayList<DTO> searchArr = da.SearchName(search.getText());
					listL.getItems().setAll(searchArr);
					System.out.println("searchArr" + searchArr);
					if (searchArr.size() == 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						System.out.println("데이터 없음");
						String msg = "해당 상품명이 없습니다.";
						alert.setContentText(msg);
						alert.show();
					}
				}
			}
		});




	}
	public void stockAddFunc() {
		System.out.println("물품 추가 실행");
		ss.stockAddFunc(root);
	}
	public void cancelFunc() {
		System.out.println("물품 목록 창 닫기");
		ss.cancelFunc(root);
	}


	public void searchFunc() {
		System.out.println("searchF확인");
		ss.searchFunc(search);
	}


	public void deleteFunc() {
		System.out.println("삭제 기능");
		
		
		ObservableList<DTO> productSelected, allProduct, selectList ;
		
		allProduct = listL.getItems();
		
		System.out.println("listL : " + listL);
		
		productSelected = listL.getSelectionModel().getSelectedItems();
		selectList = productSelected;
		
		productSelected.forEach(allProduct::remove); 
		System.out.println("productSelected" + productSelected);
//		listL.getItems().setAll(allProduct);
		System.out.println("listL" + listL);
		
		da.delet(selectList);

		Alert alert = new Alert(AlertType.INFORMATION);
		String msg = "삭제되었습니다.";
		alert.setContentText(msg);
		alert.show();
		
//		ss.deleteFunc(root);
	}

}
















//		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				if (search.getText().isEmpty()) {
//					listL.getItems().setAll(arr);
//				}
//			}
//		});

//		
//		
//		listL.getColumns().set(0, name);
//		listL.getColumns().set(1, price);
//		listL.getColumns().set(2, type);
//		listL.getColumns().set(3, cnt);
//		listL.getItems().setAll(stockList);


//		TableColumn<stockProperty, String> priceL ;
//		
//		
//		TableColumn<stockProperty, String> coffee_typeL;
//		TableColumn<stockProperty, String> cntL;
//		
//		
//		
//		priceL.setCellValueFactory(TableColumn.CellDataFeatures<stockProperty,String> -> CellDataFeatures.getValue().getPrice());
//		        coffee_typeL.setCellValueFactory(cellData -> cellData.getValue().getType());
//		        cntL.setCellValueFactory(cellData -> cellData.getValue().getCnt());

//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		
//		System.out.println("초기화 메소드");
//	}


//db리스트 대신 추가
//		DTO productld = new DTO("아메", "3000", "coffee", "7");
//		DTO price = new DTO("아메", "3000", "coffee", "7");
//		DTO coffee_type = new DTO("아메", "1000", "non_coffee", "33");
//		DTO cnt = new DTO("아메", "5000", "tea", "10");
//			
//		ArrayList<DTO> stList = new ArrayList<>();
//		stList.add(productld);
//		stList.add(price);
//		stList.add(coffee_type);
//		stList.add(cnt);
//		
//		productldL.setCellValueFactory(new PropertyValueFactory("productld"));
//		priceL.setCellValueFactory(new PropertyValueFactory<>("price"));
//		coffee_typeL.setCellValueFactory(new PropertyValueFactory<>("coffee_type"));
//		cntL.setCellValueFactory(new PropertyValueFactory<>("cnt"));
//		
//		
//		//데이터 추가
//		ObservableList<DTO> list = FXCollections.observableArrayList(
//				productld, price, coffee_type, cnt);
//				
//		listL.setItems(list);
//		DTO dto = new DTO();
//		dto.setProductld(productldL.getText());
//		dto.setPrice(priceL.getText());
//		dto.setCnt(cntL.getText());
//		dto.setCoffee_type(coffee_typeL.getText());

