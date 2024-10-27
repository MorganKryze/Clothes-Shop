package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.Company;

public class CompanyRepositoryImplementation implements CompanyRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gSswtP@jiWjArvTY**15ALjasSzOVgE!iENWz9y0Ip5&JSw^";

    public CompanyRepositoryImplementation() {
    }

    @Override
    public boolean createCompany(Company company) {
        String query = "INSERT INTO Company (name, capital, income, costs, is_discount_enabled, discount_rate) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, company.getName());
            preparedStatement.setDouble(2, company.getCapital());
            preparedStatement.setDouble(3, company.getIncome());
            preparedStatement.setDouble(4, company.getCosts());
            preparedStatement.setBoolean(5, company.isDiscountEnabled());
            preparedStatement.setDouble(6, company.getDiscountRate());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Company getCompanyByName(String name) {
        Company company = null;
        String query = "SELECT * FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    company = new Company(
                            resultSet.getString("name"),
                            resultSet.getDouble("capital"),
                            resultSet.getDouble("income"),
                            resultSet.getDouble("costs"),
                            resultSet.getBoolean("is_discount_enabled"),
                            resultSet.getDouble("discount_rate"));
                }
            }
            return company;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return company;
    }

    @Override
    public boolean updateCompanyNameByName(String oldName, String newName) {
        String query = "UPDATE Company SET name = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, oldName);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double getCompanyCapitalByName(String name) {
        String query = "SELECT capital FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("capital");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }

    @Override
    public boolean updateCompanyCapitalByName(String name, double capital) {
        String query = "UPDATE Company SET capital = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, capital);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double getCompanyIncomeByName(String name) {
        String query = "SELECT income FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("income");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public boolean updateCompanyIncomeByName(String name, double income) {
        String query = "UPDATE Company SET income = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, income);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double getCompanyCostsByName(String name) {
        String query = "SELECT costs FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("costs");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean updateCompanyCostsByName(String name, double costs) {
        String query = "UPDATE Company SET costs = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, costs);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean getCompanyDiscountStatusByName(String name) {
        String query = "SELECT isDiscountEnabled FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getBoolean("is_discount_enabled");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateDiscountStatusByName(String name) {
        String query = "UPDATE Company SET is_discount_enabled = NOT is_discount_enabled WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double getCompanyDiscountRateByName(String name) {
        String query = "SELECT discount_rate FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("discount_rate");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean updateCompanyDiscountRateByName(String name, double discountRate) {
        String query = "UPDATE Company SET discount_rate = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, discountRate);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteCompanyByName(String name) {
        String deleteProductsQuery = "DELETE FROM Product WHERE company_name = ?";
        String deleteCompanyQuery = "DELETE FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement deleteProductsStmt = connection.prepareStatement(deleteProductsQuery); PreparedStatement deleteCompanyStmt = connection.prepareStatement(deleteCompanyQuery)) {

            deleteProductsStmt.setString(1, name);
            deleteProductsStmt.executeUpdate();

            deleteCompanyStmt.setString(1, name);
            deleteCompanyStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
