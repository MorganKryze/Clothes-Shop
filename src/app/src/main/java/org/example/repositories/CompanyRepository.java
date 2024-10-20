package org.example.repositories;

import org.example.products.Company;

public interface CompanyRepository {

    public Company getCompanyByName(String name);

    public boolean updateName(String oldName, String newName);

    public String getCompanyCapital(String name);

    public boolean updateCapital(String name, int capital);

    public String getCompanyIncome(String name);

    public boolean updateIncome(String name, int income);

    public String getCompanyCosts(String name);

    public boolean updateCosts(String name, int costs);

    public String getCompanyDiscountStatus(String name);

    public boolean updateDiscountStatus(String name);

}
