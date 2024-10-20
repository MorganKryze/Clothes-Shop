package org.example.repositories;

import org.example.products.Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRepositoryImplementation {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gSswtP@jiWjArvTY**15ALjasSzOVgE!iENWz9y0Ip5&JSw^";

    public static Company getCompanyByName(String name) {
        Company company = null;
        String query = "SELECT * FROM Company WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                company = new Company(resultSet.getString("name"), resultSet.getInt("capital"));
            }
            resultSet.close();
            return company;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }
}