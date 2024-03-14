package cafe.manage.close.fxml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cafe.manage.close.dao.CloseDAO;
import cafe.manage.close.dto.CloseDTO;
import cafe.manage.close.property.CloseProperty;
import cafe.manage.close.service.CloseService;
import cafe.manage.close.service.CloseServiceImpl;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class CloseController extends AnchorPane{
	Parent root;
	CloseService cs;
	CloseDAO dao;
	
	@FXML TableView<CloseDTO> closeTable = new TableView<>();;
	@FXML TableColumn<CloseDTO, String> fxManagerId;
	@FXML TableColumn<CloseDTO, String> fxProductId;
	@FXML TableColumn<CloseDTO, String> fxProduct;
	@FXML TableColumn<CloseDTO, String> fxType;
	@FXML TableColumn<CloseDTO, String> fxCnt;
	@FXML TableColumn<CloseDTO, String> fxPrice;
	
//	ObservableList<CloseDTO> closeList = FXCollections.observableArrayList();
//	
//	public void fn() {
//		
//		for (CloseDTO dto : arr) {
////			CloseProperty cp = new CloseProperty(new SimpleStringProperty(dto.getManagerid()), new SimpleStringProperty(dto.getProductid()), 
////					new SimpleStringProperty(dto.getProduct()), new SimpleStringProperty(dto.getCoffee_type()), 
////					new SimpleStringProperty(dto.getTotcnt()), new SimpleStringProperty(dto.getTotprice()));
//			
////			String cp = dto.getManagerid(), new SimpleStringProperty(dto.getProductid()), 
////					new SimpleStringProperty(dto.getProduct()), new SimpleStringProperty(dto.getCoffee_type()), 
////					new SimpleStringProperty(dto.getTotcnt()), new SimpleStringProperty(dto.getTotprice()));
////			
//			closeList.add(dto) ;
//			
//		}
//	}
	
	
	public List<CloseDTO> tableData() {
		ArrayList<CloseDTO> arr = dao.getTotalOrder();
		List<CloseDTO> tableList = new ArrayList<>();
		for (CloseDTO dto : arr) {
			tableList.add(dto);
		}
		
		return tableList;
	}
	public CloseController() {
		System.out.println("마감 컨트롤러 시작");
		cs = new CloseServiceImpl();
		dao = new CloseDAO();
		
		fxManagerId.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getManagerid()));
		System.out.println("1" + fxManagerId);
		fxProductId.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProductid()));
		System.out.println("2" + fxProductId);
		fxProduct.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProduct()));
		System.out.println("3" + fxProduct);
		fxType.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCoffee_type()));
		System.out.println("4" + fxType);
		fxCnt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTotcnt()));
		System.out.println("5" + fxCnt);
		fxPrice.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTotprice()));
		System.out.println("6" + fxPrice);
		
		ArrayList<CloseDTO> arr = dao.getTotalOrder();
		List<CloseDTO> tableList = new ArrayList<>();
		for (CloseDTO dto : arr) {
			tableList.add(dto);
		}
		closeTable.getItems().setAll(tableList);
	}

	
//	@Override
//	public void initialize(List<CloseDTO> tableList) {
//		cs = new CloseServiceImpl();
//		dao = new CloseDAO();
//		
//		fxManagerId.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getManagerid()));
//		fxProductId.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProductid()));
//		fxProduct.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProduct()));
//		fxType.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCoffee_type()));
//		fxCnt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTotcnt()));
//		fxPrice.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTotprice()));
//		
//		closeTable.getItems().setAll(tableList);
//		
//	}

	public void setRoot(Parent root) {
		cs.setRoot(root);
		this.root = root;
	}
	
	public void closeFunc() {
		cs.closeFunc();
		System.out.println("마감 완료");
	}

}
