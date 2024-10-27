package org.example.controller;

import java.util.Arrays;

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
    @SuppressWarnings("unused")
    private void handleAddProduct() {
        Product[] allProducts = productRepository.getAllProducts();

        int newUUID = 1;
        if (allProducts.length > 0) {
            int highestUUID = Arrays.stream(allProducts)
                    .filter(product -> product != null)
                    .mapToInt(Product::getUuid)
                    .max()
                    .orElse(0);
            newUUID = highestUUID + 1;
        }

        Product newProduct = new Product(
                newUUID,
                "New Product",
                "accessories",
                0.0,
                0.0,
                0,
                companyRepository.getCompanyByName("Clothes shop"),
                0,
                0
        );
        productRepository.createProduct(newProduct);
        productTable.getItems().setAll(productRepository.getAllProducts());
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleToggleDefaultDiscount() {
        Company company = companyRepository.getCompanyByName("Clothes shop");
        company.updateDiscountEnabled();
        productTable.getItems().setAll(productRepository.getAllProducts());
    }
}
