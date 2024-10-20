package org.example;

import org.example.products.Company;
import org.example.repositories.CompanyRepositoryImplementation;

public class App {
    public static void main(String[] args) {
        Company test = CompanyRepositoryImplementation.getCompanyByName("Clothes shop");

    }
}
