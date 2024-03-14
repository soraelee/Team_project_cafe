package cafe.manage.close.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import cafe.manage.close.property.CloseProperty;
import cafe.manage.close.service.CloseService;
import cafe.manage.close.service.CloseServiceImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CloseController implements Initializable{
	Parent root;
	CloseService cs;
	
	@FXML TableView<CloseProperty> tv;
	@FXML TableColumn<CloseProperty, String> mngerId;
	@FXML TableColumn<CloseProperty, String> prdId;
	@FXML TableColumn<CloseProperty, String> prdName;
	@FXML TableColumn<CloseProperty, String> type;
	@FXML TableColumn<CloseProperty, String> totCnt;
	@FXML TableColumn<CloseProperty, String> totPrice;
	
	
	ObservableList<CloseProperty> closeList = FXCollections.observableArrayList(
			new CloseProperty(new SimpleStringProperty(), 
					new SimpleStringProperty(), 
					new SimpleStringProperty(), 
					new SimpleStringProperty(), 
					new SimpleStringProperty(), 
					new SimpleStringProperty())
			);
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cs = new CloseServiceImpl();
		
		mngerId.setCellValueFactory(cellData -> cellData.getValue().getMngerId());
		prdId.setCellValueFactory(cellData -> cellData.getValue().getPrdId());
		prdName.setCellValueFactory(cellData -> cellData.getValue().getPrdName());
		type.setCellValueFactory(cellData -> cellData.getValue().getType());
		totCnt.setCellValueFactory(cellData -> cellData.getValue().getTotCnt());
		totPrice.setCellValueFactory(cellData -> cellData.getValue().getTotPrice());
	}

	public void setRoot(Parent root) {
		cs.setRoot(root);
		this.root = root;
	}
	
	public void closeFunc() {
		cs.closeFunc();
		System.out.println("마감 완료");
	}

}
