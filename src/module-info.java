module Team_project_cafe {
	exports menu.dto;
	exports cafe.payment.service;
	exports cafe.payment.dto;
	exports cafe.order.controller;
	exports cafe.payment.controller;
	exports cafe.receipt.dao;
	exports cafe.order.url;
	exports cafe.payment.main;
	exports cafe.order.main;
	exports cafe.receipt.service;
	exports cafe.receipt.main;
	exports cafe.main;
	exports cafe.receipt.controller;
	exports cafe.receipt.dto;
	exports cafe.order.dao;
	exports cafe.order.dto;
	exports cafe.order.service;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}