package cafe.order.service;

import java.util.ArrayList;

import cafe.main.MainClass;
//import cafe.common.CommonService;
import cafe.order.dao.OrderDAO;
import cafe.order.dto.OrderDTO;
import cafe.payment.main.PaymentMain;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import menu.dto.MenuDTO;

public class OrderServiceImpl implements OrderService{
	CheckBox chkame, chkcappu, chkespres, chkcafelatte, chkgreentea, chkchoco, chkstraw, chkearlg, chkchamo, chkpepper;
	TextField amecnt, cappucnt, esprescnt, cafelattecnt, greenteacnt, chococnt, strawcnt, earlgcnt, chamocnt, peppercnt;
	
	OrderDAO dao;
	Parent root;
	
	//고객 주문 내역 결제창으로 가져오는 리스트
	public static ArrayList<OrderDTO> OrderMenu ;
	public static String orderStrNum;
	private Integer orderNum;
	private static int orderN;
	
	public OrderServiceImpl() {
		dao = new OrderDAO();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void orderFunc() {
		amecnt = (TextField)root.lookup("#amecnt");
		cappucnt = (TextField)root.lookup("#cappucnt");
		esprescnt = (TextField)root.lookup("#esprescnt");
		cafelattecnt = (TextField)root.lookup("#cafelattecnt");
		greenteacnt = (TextField)root.lookup("#greenteacnt");
		chococnt = (TextField)root.lookup("#chococnt");
		strawcnt = (TextField)root.lookup("#strawcnt");
		earlgcnt = (TextField)root.lookup("#earlgcnt");
		chamocnt = (TextField)root.lookup("#chamocnt");
		peppercnt = (TextField)root.lookup("#peppercnt");
				
		chkame = (CheckBox)root.lookup("#chkame");
		chkcappu = (CheckBox)root.lookup("#chkcappu");
		chkespres = (CheckBox)root.lookup("#chkespres");
		chkcafelatte = (CheckBox)root.lookup("#chkcafelatte");
		chkgreentea = (CheckBox)root.lookup("#chkgreentea");
		chkchoco = (CheckBox)root.lookup("#chkchoco");
		chkstraw = (CheckBox)root.lookup("#chkstraw");
		chkearlg = (CheckBox)root.lookup("#chkearlg");
		chkchamo = (CheckBox)root.lookup("#chkchamo");
		chkpepper = (CheckBox)root.lookup("#chkpepper");
		
		System.out.println("chkame : " + chkame.isSelected() );
		System.out.println("chkcappu : " + chkcappu.isSelected() );
		System.out.println("chkespres : " + chkespres.isSelected() );
		System.out.println("chkcafelatte : " + chkcafelatte.isSelected() );
		System.out.println("chkgreentea : " + chkgreentea.isSelected() );
		System.out.println("chkchoco : " + chkchoco.isSelected() );
		System.out.println("chkstraw : " + chkstraw.isSelected() );
		System.out.println("chkearlg : " + chkearlg.isSelected() );
		System.out.println("chkchamo : " + chkchamo.isSelected() );
		System.out.println("chkpepper : " + chkpepper.isSelected() );
		
		ArrayList<OrderDTO> menu = new ArrayList<>();
		
		
		orderNum = ++orderN;
		System.out.println("ordernum : " + orderNum);
		orderStrNum = orderNum.toString();
		System.out.println("orderStrnum : " + orderStrNum);
		orderNum = dao.getInt(orderStrNum);
		orderN = (int)orderNum;
		System.out.println("ordernum : " + orderNum);
		orderStrNum = orderNum.toString();

		if( chkame.isSelected() == true ) {
			menu.add(dao.menuPackage("americano", amecnt.getText(), orderStrNum));
		}
		if( chkcappu.isSelected() == true ) {	
			menu.add(dao.menuPackage("cappuccino", cappucnt.getText(), orderStrNum));
		}
		if( chkespres.isSelected() == true ) {
			menu.add(dao.menuPackage("espresso", esprescnt.getText(), orderStrNum));
		}
		if( chkcafelatte.isSelected() == true ) {
			menu.add(dao.menuPackage("cafelatte", cafelattecnt.getText(), orderStrNum));
		}
		if( chkgreentea.isSelected() == true ) {
			menu.add(dao.menuPackage("greentealatte", greenteacnt.getText(), orderStrNum));
		}
		if( chkchoco.isSelected() == true ) {
			menu.add(dao.menuPackage("chocolatte", chococnt.getText(), orderStrNum));
		}
		if( chkstraw.isSelected() == true ) {
			menu.add(dao.menuPackage("strawberrylatte", strawcnt.getText(), orderStrNum));
		}
		if( chkearlg.isSelected() == true ) {
			menu.add(dao.menuPackage("earlgray", earlgcnt.getText(), orderStrNum));
		}
		if( chkchamo.isSelected() == true ) {
			menu.add(dao.menuPackage("chamomile", chamocnt.getText(), orderStrNum));
		}
		if( chkpepper.isSelected() == true ) {
			menu.add(dao.menuPackage("peppermint", peppercnt.getText(), orderStrNum));
		}
		
		OrderServiceImpl.OrderMenu = menu;
		
		// 재고가 5개 이하일 경우 알람이 뜨도록 설정
		ArrayList<String> stockLoss = dao.searchStock(menu);
		if (stockLoss.size() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			for (String s : stockLoss) {
				String msg = s + " 상품의 남은 재고가 5개 이하입니다.";
				alert.setContentText(msg);
				alert.show();
			}
		}
		//상품 구매목록 추가(orderlist)
		dao.getMenu(menu);
		//재고목록에서 구매한 메뉴만큼 재고 수 감소
		dao.delStock(menu);
	
		PaymentMain pm = new PaymentMain();
		pm.viewFx(root);
		
	}

	@Override
	public void homeFunc() {
		MainClass mm = new MainClass();
		mm.viewFx(root);
	}
	
}