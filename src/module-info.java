module Team_project_coffee {
	exports cafe.main;
	exports cafe.login.fxml;
	exports cafe.login.dto;
	exports cafe.login.main;
	exports cafe.login.service;
	exports cafe.login.dao;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}