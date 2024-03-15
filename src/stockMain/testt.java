package stockMain;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class testt extends Application {

    private ObservableList<String> data = FXCollections.observableArrayList(
            "Apple", "Banana", "Cherry", "Date", "Grape", "Lemon", "Orange", "Peach", "Pear");

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>(data);

        TextField searchField = new TextField();
        searchField.setPromptText("Search...");

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                listView.setItems(data);
                return;
            }

            ObservableList<String> filteredList = FXCollections.observableArrayList();
            for (String item : data) {
                if (item.toLowerCase().contains(newValue.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            listView.setItems(filteredList);
        });

        VBox root = new VBox(searchField, listView);
        Scene scene = new Scene(root, 200, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Search List Demo");
        primaryStage.show();
        
        
    }
    public static void main(String[] args) {
		launch(args);
	}
}

    


