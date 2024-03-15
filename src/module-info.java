module Team_project_coffee {
	exports menu.dto;
	exports stockDTO;
	exports stockURL;
	exports cafe.main;
	exports stockAdd;
	exports stockDAO;
	exports stockService;
	exports search.main;
	exports stockController;
	exports stockMain;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}