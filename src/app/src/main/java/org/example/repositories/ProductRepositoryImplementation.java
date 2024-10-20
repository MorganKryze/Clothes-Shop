
package org.example.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.products.Accessories;
import org.example.products.Clothes;
import org.example.products.Product;
import org.example.products.Shoes;

public class ProductRepositoryImplementation {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gSswtP@jiWjArvTY**15ALjasSzOVgE!iENWz9y0Ip5&JSw^";

    public static Product getProductByUUID(String uuid) {
        String query = "SELECT * FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String category = resultSet.getString("category");
                Product product = null;

                switch (category) {
                    case "Shoes":
                        product = new Shoes(
                                resultSet.getString("uuid"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getInt("cost"),
                                resultSet.getInt("stock"),
                                CompanyRepositoryImplementation.getCompanyByName(resultSet.getString("company")),
                                resultSet.getInt("shoe_size"));
                        break;
                    case "Clothes":
                        product = new Clothes(
                                resultSet.getString("uuid"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getInt("cost"),
                                resultSet.getInt("stock"),
                                CompanyRepositoryImplementation.getCompanyByName(resultSet.getString("company")),
                                resultSet.getInt("clothing_size"));
                        break;
                    case "Accessories":
                        product = new Accessories(
                                resultSet.getString("uuid"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getInt("cost"),
                                resultSet.getInt("stock"),
                                CompanyRepositoryImplementation.getCompanyByName(resultSet.getString("company")));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown category: " + category);
                }

                resultSet.close();
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean updateName(String uuid, String newName) {
        String query = "UPDATE Product SET name = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getProductIconPath(String uuid) {
        String query = "SELECT icon_path FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("icon_path");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    public static boolean updateIconPath(String uuid, String iconPath) {
        String query = "UPDATE Product SET icon_path = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, iconPath);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getProductPrice(String uuid) {
        String query = "SELECT price FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("price");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static boolean updatePrice(String uuid, int price) {
        String query = "UPDATE Product SET price = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getProductCost(String uuid) {
        String query = "SELECT cost FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("cost");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static boolean updateCost(String uuid, int cost) {
        String query = "UPDATE Product SET cost = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, cost);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getProductStock(String uuid) {
        String query = "SELECT stock FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("stock");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static boolean updateStock(String uuid, int stock) {
        String query = "UPDATE Product SET stock = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, stock);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addToStock(String uuid, int amount) {
        String query = "UPDATE Product SET stock = stock + ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removeFromStock(String uuid, int amount) {
        String query = "UPDATE Product SET stock = stock - ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getProductCompany(String uuid) {
        String query = "SELECT company FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("company");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    public static int getShoeSize(String uuid) {
        String query = "SELECT shoe_size FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("shoe_size");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    public static boolean updateShoeSize(String uuid, int shoeSize) {
        String query = "UPDATE Product SET shoe_size = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, shoeSize);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getClothingSize(String uuid) {
        String query = "SELECT clothing_size FROM Product WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("clothing_size");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    public static boolean updateClothingSize(String uuid, int clothingSize) {
        String query = "UPDATE Product SET clothing_size = ? WHERE uuid = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, clothingSize);
            preparedStatement.setString(2, uuid);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
