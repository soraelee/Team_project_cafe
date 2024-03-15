package search.main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import stockDAO.DAO;
import stockDTO.DTO;

public class SearchMain extends Application{

	DAO dao;
	public static TextField search;
	
	@Override
	public void start(Stage arg0) throws Exception {
		dao = new DAO();

		ObservableList<String> data = FXCollections.observableArrayList();
		ArrayList<DTO> arr = dao.invenSearch();	
		System.out.println("arr : " + arr);
		for(DTO dto : arr) {
			data.add(dto.getProductld());

		}
		ListView<String> lv = new ListView<>(data);

		System.out.println("검색 실행");



		TextField search = new TextField();
		search.setPromptText("Search..");

		search.textProperty().addListener((observable, oldValue, newValue)->{
			if(newValue.isEmpty()) {
				lv.setItems(data);
				return;
			}

			//검색 기능
			ObservableList<String> filteredList = FXCollections.observableArrayList();
			for(String name : data) {

				if(name.toLowerCase().contains(newValue.toLowerCase())) {
					filteredList.add(name);
				} 
			}
			lv.getItems().setAll(filteredList);
		});
		
		SearchMain.search = search;
		VBox root = new VBox(search, lv);
		Scene scene = new Scene(root, 200, 300);

		arg0.setScene(scene);
		arg0.show();

	}
	public static void main(String[] args) {
		launch(args);
	}


}
