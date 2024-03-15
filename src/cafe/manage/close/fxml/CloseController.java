package cafe.manage.close.fxml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cafe.manage.close.dao.CloseDAO;
import cafe.manage.close.dto.CloseDTO;
import cafe.manage.close.service.CloseService;
import cafe.manage.close.service.CloseServiceImpl;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CloseController implements Initializable{
	Parent root;
	CloseService cs;
	CloseDAO dao;
	ArrayList<CloseDTO> arr ;
	@FXML public TableView<CloseDTO> closeTable;
	@FXML public TableColumn<CloseDTO, String> fxManagerId;
	@FXML public TableColumn<CloseDTO, String> fxProductId;
	@FXML public TableColumn<CloseDTO, String> fxProduct;
	@FXML public TableColumn<CloseDTO, String> fxType;
	@FXML public TableColumn<CloseDTO, String> fxCnt;
	@FXML public TableColumn<CloseDTO, String> fxPrice;
	@FXML public Label fxTotalCnt;
	@FXML public Label fxTotalPrice;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cs = new CloseServiceImpl();
		dao = new CloseDAO();
		
		fxManagerId.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getManagerid()));
		fxProductId.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProductid()));
		fxProduct.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProduct()));
		fxType.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCoffee_type()));
		fxCnt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTotcnt()));
		fxPrice.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTotprice()));
		
		arr = dao.getTotalOrder();
		
		closeTable.getItems().setAll(arr);
		
		setValues();
	}

	private void setValues() {
		
		Integer finCnt = 0, finPrice = 0;
		
		for (CloseDTO dto : arr) {
			finCnt += Integer.parseInt(dto.getTotcnt());
			finPrice += Integer.parseInt(dto.getTotprice());
		}
		fxTotalCnt.setText(finCnt.toString());
		fxTotalPrice.setText(finPrice.toString());
	}

	public void setRoot(Parent root) {
		cs.setRoot(root);
		this.root = root;
	}
	
	public void closeFunc() {
		cs.closeFunc(root);
	}

}
