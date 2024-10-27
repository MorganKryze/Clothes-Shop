package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.Product;

public class ProductRepositoryImplementation implements ProductRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gSswtP@jiWjArvTY**15ALjasSzOVgE!iENWz9y0Ip5&JSw^";

    public static CompanyRepositoryImplementation companyRepositoryImplementation = new CompanyRepositoryImplementation();

    public ProductRepositoryImplementation() {
    }

    @Override
    public boolean createProduct(Product product) {
        String query = "INSERT INTO Product (id, name, category, price, cost, stock, company_name, shoe_size, clothing_size) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, product.getUuid());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setDouble(5, product.getCost());
            preparedStatement.setInt(6, product.getStock());
            preparedStatement.setString(7, product.getCompany().getName());
            preparedStatement.setInt(8, product.getShoeSize());
            preparedStatement.setInt(9, product.getClothingSize());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Product getProductByUUID(int uuid) {
        String query = "SELECT * FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double cost = resultSet.getDouble("cost");
                int stock = resultSet.getInt("stock");
                String companyName = resultSet.getString("company_name");
                String category = resultSet.getString("category");
                int shoeSize = resultSet.getInt("shoe_size");
                int clothingSize = resultSet.getInt("clothing_size");

                return new Product(uuid, name, category, price, cost, stock, companyRepositoryImplementation.getCompanyByName(companyName), clothingSize, shoeSize);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String getProductNameByUUID(int uuid) {
        String query = "SELECT name FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateProductNameByUUID(int uuid, String newName) {
        String query = "UPDATE Product SET name = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String getProductCategoryByUUID(int uuid) {
        String query = "SELECT category FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("category");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateProductCategoryByUUID(int uuid, String category) {
        String query = "UPDATE Product SET category = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, category);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double getProductPriceByUUID(int uuid) {
        String query = "SELECT price FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("price");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean updateProductPriceByUUID(int uuid, double price) {
        String query = "UPDATE Product SET price = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double getProductCostByUUID(int uuid) {
        String query = "SELECT cost FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("cost");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean updateProductCostByUUID(int uuid, double cost) {
        String query = "UPDATE Product SET cost = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, cost);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int getProductStockByUUID(int uuid) {
        String query = "SELECT stock FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("stock");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean updateProductStockByUUID(int uuid, int stock) {
        String query = "UPDATE Product SET stock = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String getProductCompanyByUUID(int uuid) {
        String query = "SELECT company_name FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("company_name");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateProductCompanyByUUID(int uuid, String company) {
        String query = "UPDATE Product SET company = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, company);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int getShoeSizeByUUID(int uuid) {
        String query = "SELECT shoe_size FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("shoe_size");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean updateShoeSizeByUUID(int uuid, int shoeSize) {
        String query = "UPDATE Product SET shoe_size = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, shoeSize);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int getClothingSizeByUUID(int uuid) {
        String query = "SELECT clothing_size FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("clothing_size");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean updateClothingSizeByUUID(int uuid, int clothingSize) {
        String query = "UPDATE Product SET clothing_size = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, clothingSize);
            preparedStatement.setInt(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return false;
    }

    @Override
    public boolean deleteProductByUUID(int uuid) {
        String query = "DELETE FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Product[] getAllProducts() {
        String query = "SELECT * FROM Product";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            Product[] products = new Product[100];
            int i = 0;

            while (resultSet.next()) {
                int uuid = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double cost = resultSet.getDouble("cost");
                int stock = resultSet.getInt("stock");
                String companyName = resultSet.getString("company_name");
                String category = resultSet.getString("category");
                int shoeSize = resultSet.getInt("shoe_size");
                int clothingSize = resultSet.getInt("clothing_size");

                products[i] = new Product(uuid, name, category, price, cost, stock, companyRepositoryImplementation.getCompanyByName(companyName), clothingSize, shoeSize);
                i++;
            }

            return products;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
