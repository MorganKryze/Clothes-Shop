package org.example.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.products.Accessories;
import org.example.products.Clothes;
import org.example.products.Shoes;

public class ProductRepositoryImplementation implements ProductRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gSswtP@jiWjArvTY**15ALjasSzOVgE!iENWz9y0Ip5&JSw^";

    public static CompanyRepositoryImplementation companyRepositoryImplementation = new CompanyRepositoryImplementation();

    public ProductRepositoryImplementation() {
    }

    @Override
    public boolean createProduct(String id, String name, String iconPath, double price, double cost, int stock, String company, String category, int shoeSize, int clothingSize) {
        String query = "INSERT INTO Product (id, name, icon_path, price, cost, stock, company_name, category, shoe_size, clothing_size) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, iconPath);
            preparedStatement.setDouble(4, price);
            preparedStatement.setDouble(5, cost);
            preparedStatement.setInt(6, stock);
            preparedStatement.setString(7, company);
            preparedStatement.setString(8, category);
            preparedStatement.setInt(9, shoeSize);
            preparedStatement.setInt(10, clothingSize);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Clothes getClothesByUUID(String uuid) {
        String query = "SELECT * FROM Product WHERE id = ? AND category = 'clothes'";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Clothes clothes = new Clothes(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("icon_path"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("stock"),
                        companyRepositoryImplementation.getCompanyByName(resultSet.getString("company_name")),
                        resultSet.getInt("clothing_size"));

                resultSet.close();
                return clothes;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public Shoes getShoesByUUID(String uuid) {
        String query = "SELECT * FROM Product WHERE id = ? AND category = 'shoes'";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Shoes shoes = new Shoes(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("icon_path"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("stock"),
                        companyRepositoryImplementation.getCompanyByName(resultSet.getString("company_name")),
                        resultSet.getInt("shoe_size"));

                resultSet.close();
                return shoes;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public Accessories getAccessoriesByUUID(String uuid) {
        String query = "SELECT * FROM Product WHERE id = ? AND category = 'accessories'";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Accessories accessories = new Accessories(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("icon_path"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("stock"),
                        companyRepositoryImplementation.getCompanyByName(resultSet.getString("company_name")));

                resultSet.close();
                return accessories;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public String getProductNameByUUID(String uuid) {
        String query = "SELECT name FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            }

        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public boolean updateProductNameByUUID(String uuid, String newName) {
        String query = "UPDATE Product SET name = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public String getProductIconPathByUUID(String uuid) {
        String query = "SELECT icon_path FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("icon_path");
            }

        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public boolean updateProductIconPathByUUID(String uuid, String iconPath) {
        String query = "UPDATE Product SET icon_path = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, iconPath);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public double getProductPriceByUUID(String uuid) {
        String query = "SELECT price FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("price");
            }

        } catch (SQLException e) {
        }

        return -1;
    }

    @Override
    public boolean updateProductPriceByUUID(String uuid, double price) {
        String query = "UPDATE Product SET price = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public double getProductCostByUUID(String uuid) {
        String query = "SELECT cost FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("cost");
            }

        } catch (SQLException e) {
        }

        return -1;
    }

    @Override
    public boolean updateProductCostByUUID(String uuid, double cost) {
        String query = "UPDATE Product SET cost = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, cost);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int getProductStockByUUID(String uuid) {
        String query = "SELECT stock FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("stock");
            }

        } catch (SQLException e) {
        }

        return -1;
    }

    @Override
    public boolean updateProductStockByUUID(String uuid, int stock) {
        String query = "UPDATE Product SET stock = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, stock);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean addToProductStockByUUID(String uuid, int amount) {
        String query = "UPDATE Product SET stock = stock + ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean removeFromProductStockByUUID(String uuid, int amount) {
        String query = "UPDATE Product SET stock = stock - ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public String getProductCompanyByUUID(String uuid) {
        String query = "SELECT company_name FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("company_name");
            }

        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public boolean updateProductCompanyByUUID(String uuid, String company) {
        String query = "UPDATE Product SET company = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, company);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int getShoeSizeByUUID(String uuid) {
        String query = "SELECT shoe_size FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("shoe_size");
            }

        } catch (SQLException e) {
        }

        return -1;
    }

    @Override
    public boolean updateShoeSizeByUUID(String uuid, int shoeSize) {
        String query = "UPDATE Product SET shoe_size = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, shoeSize);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int getClothingSizeByUUID(String uuid) {
        String query = "SELECT clothing_size FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("clothing_size");
            }

        } catch (SQLException e) {
        }

        return -1;
    }

    @Override
    public boolean updateClothingSizeByUUID(String uuid, int clothingSize) {
        String query = "UPDATE Product SET clothing_size = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, clothingSize);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteProductByUUID(String uuid) {
        String query = "DELETE FROM Product WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

}
