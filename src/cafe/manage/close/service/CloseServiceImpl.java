package cafe.manage.close.service;

import java.util.List;

import cafe.manage.close.dao.CloseDAO;
import cafe.manage.close.property.CloseProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CloseServiceImpl implements CloseService{
	@FXML TableView<CloseProperty> closeTable;
	@FXML TableColumn<CloseProperty, String> fxManagerId;
	@FXML TableColumn<CloseProperty, String> fxProductId;
	@FXML TableColumn<CloseProperty, String> fxProduct;
	@FXML TableColumn<CloseProperty, String> fxType;
	@FXML TableColumn<CloseProperty, String> fxCnt;
	@FXML TableColumn<CloseProperty, String> fxPrice;

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
