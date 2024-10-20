package org.example.repositories;

import org.example.products.Company;

public interface CompanyRepository {

    /**
     * Retrieves a company by its name.
     *
     * @param name the name of the company
     * @return the company with the specified name, or null if not found
     */
    public Company getCompanyByName(String name);

    /**
     * Updates the name of a company.
     *
     * @param oldName the current name of the company
     * @param newName the new name for the company
     * @return true if the update was successful, false otherwise
     */
    public boolean updateName(String oldName, String newName);

    /**
     * Retrieves the capital of a company.
     *
     * @param name the name of the company
     * @return the capital of the company
     */
    public String getCompanyCapital(String name);

    /**
     * Updates the capital of a company.
     *
     * @param name    the name of the company
     * @param capital the new capital amount
     * @return true if the update was successful, false otherwise
     */
    public boolean updateCapital(String name, int capital);

    /**
     * Retrieves the income of a company.
     *
     * @param name the name of the company
     * @return the income of the company
     */
    public String getCompanyIncome(String name);

    /**
     * Updates the income of a company.
     *
     * @param name   the name of the company
     * @param income the new income amount
     * @return true if the update was successful, false otherwise
     */
    public boolean updateIncome(String name, int income);

    /**
     * Retrieves the costs of a company.
     *
     * @param name the name of the company
     * @return the costs of the company
     */
    public String getCompanyCosts(String name);

    /**
     * Updates the costs of a company.
     *
     * @param name  the name of the company
     * @param costs the new costs amount
     * @return true if the update was successful, false otherwise
     */
    public boolean updateCosts(String name, int costs);

    /**
     * Retrieves the discount status of a company.
     *
     * @param name the name of the company
     * @return the discount status of the company
     */
    public String getCompanyDiscountStatus(String name);

    /**
     * Updates the discount status of a company.
     *
     * @param name the name of the company
     * @return true if the update was successful, false otherwise
     */
    public boolean updateDiscountStatus(String name);

}