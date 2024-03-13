package stockMain;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stockController.Controller;
import stockURL.URL.URLService;


public class MainClass extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		
//		System.out.println(getClass().getResource(""));
//		System.out.println(Paths.get("").toAbsolutePath().toString());
//		System.out.println
//		("file:/" +((Paths.get("").toAbsolutePath().toString())+"/bin/stock_control/stock.fxml"));
		
		URL url = new URL(URLService.stkpath + "stock_fxml/stock.fxml");
		
		
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		
		Controller ctrl = loader.getController();
		ctrl.setRoot(root);

		Scene scene = new Scene(root);
		arg0.setScene(scene);		
		arg0.show();
	
	}
	
public static void main(String[] args) {
	launch(args);
}
}

