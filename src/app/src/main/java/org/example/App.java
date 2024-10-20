package org.example;

import org.example.products.Accessories;
import org.example.products.Clothes;
import org.example.products.Company;
import org.example.products.Shoes;
import org.example.repositories.CompanyRepositoryImplementation;
import org.example.repositories.ProductRepositoryImplementation;

public class App {
    public static void main(String[] args) {
        Company company = CompanyRepositoryImplementation.getCompanyByName("Clothes shop");

        Clothes dress = ProductRepositoryImplementation.getClothesByUUID("40e6215d-b5c6-4896-987c-f30f3678f608"); 
        Clothes shirt = ProductRepositoryImplementation.getClothesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1c");
        Clothes jean = ProductRepositoryImplementation.getClothesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1d");

        Accessories clock = ProductRepositoryImplementation.getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1e");
        Accessories parachute = ProductRepositoryImplementation.getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1f");
        Accessories sunglasses = ProductRepositoryImplementation.getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1g");

        Shoes classy = ProductRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1h");
        Shoes work = ProductRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1i");
        Shoes aero = ProductRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1j");
    }
}
