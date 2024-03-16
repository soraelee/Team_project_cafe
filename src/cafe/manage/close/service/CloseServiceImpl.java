package cafe.manage.close.service;

import java.util.List;

import cafe.main.MainClass;
import cafe.manage.close.dao.CloseDAO;
import cafe.manage.close.dto.CloseDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CloseServiceImpl implements CloseService{


	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void closeFunc(Parent root) {
		CloseDAO dao = new CloseDAO();
//		dao.deleteOrderList();
		dao.deleteTotalOrderList();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("마감이 완료되었습니다.");
		alert.show();
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		
	}


	
}
