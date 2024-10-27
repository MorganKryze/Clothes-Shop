package org.example.controller;

import java.util.Arrays;

import org.example.model.Company;
import org.example.model.Product;
import org.example.repository.CompanyRepositoryImplementation;
import org.example.repository.ProductRepositoryImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

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

    @FXML
    private TableColumn<Product, Void> marketColumn;

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
        marketColumn.setCellFactory((TableColumn<Product, Void> param) -> new TableCell<Product, Void>() {
            private final Button sellButton = new Button("Sell");
            private final Button buyButton = new Button("Buy");

            {
                sellButton.setOnAction(event -> {
                    int index = getIndex();
                    handleSellProduct(index);
                });
                buyButton.setOnAction(event -> {
                    int index = getIndex();
                    handleBuyProduct(index);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || getIndex() < 0) {
                    setGraphic(null);
                } else {
                    Product product = productTable.getItems().get(getIndex());
                    if (product != null) {
                        HBox hbox = new HBox(sellButton, buyButton);
                        setGraphic(hbox);
                    } else {
                        setGraphic(null);  
                    }
                }
            }

        });
        Company company = companyRepository.getCompanyByName("Clothes shop");
        companyInfoLabel.setText(company.toString());

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

    @FXML
    @SuppressWarnings("unused")
    private void handleBuyProduct(int index) {
        Company company = companyRepository.getCompanyByName("Clothes shop");
        Product product = productTable.getItems().get(index);
        product.purchase(1);
        productTable.getItems().setAll(productRepository.getAllProducts());
        companyInfoLabel.setText(company.toString());
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleSellProduct(int index) {
        Company company = companyRepository.getCompanyByName("Clothes shop");
        Product product = productTable.getItems().get(index);
        product.sell(1);
        productTable.getItems().setAll(productRepository.getAllProducts());
        companyInfoLabel.setText(company.toString());
        
    }

}
