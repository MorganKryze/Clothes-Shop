package org.example.controller;

import org.example.model.Company;
import org.example.model.Product;
import org.example.repository.CompanyRepositoryImplementation;
import org.example.repository.ProductRepositoryImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private Label companyInfoLabel;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Integer> idColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> categoryColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

    @FXML
    private TableColumn<Product, Double> costColumn;

    @FXML
    private TableColumn<Product, Integer> stockColumn;

    @FXML
    private TableColumn<Product, Integer> clothingSizeColumn;

    @FXML
    private TableColumn<Product, Integer> shoeSizeColumn;

    private final ProductRepositoryImplementation productRepository = new ProductRepositoryImplementation();
    private final CompanyRepositoryImplementation companyRepository = new CompanyRepositoryImplementation();

    @FXML
    public void initialize() {
        // Set up cell value factories for the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        clothingSizeColumn.setCellValueFactory(new PropertyValueFactory<>("clothingSize"));
        shoeSizeColumn.setCellValueFactory(new PropertyValueFactory<>("shoeSize"));

        // Load the company information
        Company company = companyRepository.getCompanyByName("Clothes shop");
        companyInfoLabel.setText(company.toString());

        // Load the product data into the table
        productTable.getItems().setAll(productRepository.getAllProducts());
    }

    @FXML
    private void handleAddProduct() {
        // Implement the logic for adding a new product
    }

    @FXML
    private void handleEditProduct() {
        // Implement the logic for editing an existing product
    }

    @FXML
    private void handleDeleteProduct() {
        // Implement the logic for deleting a product
    }
}
