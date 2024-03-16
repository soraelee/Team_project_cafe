package stockService;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public interface Serviece {
	public void cancelFunc(Parent root);
	public void stockAddFunc(Parent root);
	public void addFunc(Parent root);
	public void setRoot(Parent root);
	public void searchFunc(TextField search);
	

}
