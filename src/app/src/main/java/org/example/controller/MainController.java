package org.example.controller;

import java.util.Arrays;

import org.example.model.Company;
import org.example.model.Product;
import org.example.repository.CompanyRepositoryImplementation;
import org.example.repository.ProductRepositoryImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
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

    @FXML
    private TableColumn<Product, Void> actionsColumn;

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
                        HBox hbox = new HBox(5, sellButton, buyButton);
                        setGraphic(hbox);
                    } else {
                        setGraphic(null);
                    }
                }
            }

        });
        actionsColumn.setCellFactory((TableColumn<Product, Void> param) -> new TableCell<Product, Void>() {
            private final Button editButton = new Button("Edit");
            private final Button delButton = new Button("Del");

            {
                editButton.getStyleClass().add("button-edit");
                delButton.getStyleClass().add("button-delete");
                editButton.setOnAction(event -> {
                    int index = getIndex();
                    handleEditProduct(index);
                });
                delButton.setOnAction(event -> {
                    int index = getIndex();
                    handleDeleteProduct(index);
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
                        HBox hbox = new HBox(5, editButton, delButton);
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
        if (!company.updateDiscountEnabled()) {
            showErrorDialog("Error", "Failed to toggle discount", "The discount could not be toggled. Please try again.");
        }
        productTable.getItems().setAll(productRepository.getAllProducts());
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleBuyProduct(int index) {
        Company company = companyRepository.getCompanyByName("Clothes shop");
        Product product = productTable.getItems().get(index);
        if (!product.purchase(1)) {
            showErrorDialog("Error", "Failed to buy product", "The product could not be bought. Please try again.");
        }
        companyInfoLabel.setText(company.toString());
        productTable.getItems().setAll(productRepository.getAllProducts());
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleSellProduct(int index) {
        Company company = companyRepository.getCompanyByName("Clothes shop");
        Product product = productTable.getItems().get(index);
        if (!product.sell(1)) {
            showErrorDialog("Error", "Failed to sell product", "The product could not be sold. Please try again if the stock is not empty.");
        }
        companyInfoLabel.setText(company.toString());
        productTable.getItems().setAll(productRepository.getAllProducts());
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleEditProduct(int index) {
        Product product = productTable.getItems().get(index);
        if (product == null) {
            showErrorDialog("Error", "Product not found", "The selected product could not be found.");
            return;
        }

        Dialog<Product> dialog = new Dialog<>();
        dialog.setTitle("Edit Product");
        dialog.setHeaderText("Edit the product details");

        ButtonType updateButtonType = new ButtonType("Update", ButtonType.OK.getButtonData());
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField(product.getName());
        TextField priceField = new TextField(String.valueOf(product.getPrice()));
        TextField costField = new TextField(String.valueOf(product.getCost()));
        TextField clothingSizeField = new TextField(String.valueOf(product.getClothingSize()));
        TextField shoeSizeField = new TextField(String.valueOf(product.getShoeSize()));

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Price:"), 0, 1);
        grid.add(priceField, 1, 1);
        grid.add(new Label("Cost:"), 0, 2);
        grid.add(costField, 1, 2);
        grid.add(new Label("Clothing Size:"), 0, 3);
        grid.add(clothingSizeField, 1, 3);
        grid.add(new Label("Shoe Size:"), 0, 4);
        grid.add(shoeSizeField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                try {
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    double cost = Double.parseDouble(costField.getText());
                    int clothingSize = Integer.parseInt(clothingSizeField.getText());
                    int shoeSize = Integer.parseInt(shoeSizeField.getText());

                    product.setName(name);
                    product.setPrice(price);
                    product.setCost(cost);
                    product.setClothingSize(clothingSize);
                    product.setShoeSize(shoeSize);

                    return product;
                } catch (NumberFormatException e) {
                    showErrorDialog("Error", "Invalid input", "Please enter valid values.");
                }
            }
            return null;
        });

        java.util.Optional<Product> result = dialog.showAndWait();

        result.ifPresent(updatedProduct -> {
            if (!productRepository.updateProductByUUID(updatedProduct.getUuid(), updatedProduct)) {
                showErrorDialog("Error", "Update failed", "The product could not be updated. Please try again.");
            }
            productTable.getItems().setAll(productRepository.getAllProducts());
        });
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleDeleteProduct(int index) {
        Product product = productTable.getItems().get(index);
        if (!productRepository.deleteProductByUUID(product.getUuid())) {
            showErrorDialog("Error", "Failed to delete product", "The product could not be deleted. Please try again.");
        }
        productTable.getItems().setAll(productRepository.getAllProducts());
    }

    private void showErrorDialog(String title, String header, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
