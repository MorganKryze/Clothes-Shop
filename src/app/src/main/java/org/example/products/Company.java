package org.example.products;

import org.example.repositories.CompanyRepositoryImplementation;

/**
 * The {@code Company} class represents a company with attributes such as name,
 * capital, income, costs, and discount status.
 * It provides methods to get and update these attributes.
 * <p>
 * This class ensures that the company name does not contain digits and is not
 * null, empty, or blank.
 * It also ensures that capital, income, and costs are non-negative.
 * </p>
 */
public class Company {
    private String name;
    private int capital;
    private double income;
    private double costs;
    private boolean isDiscountEnabled;

    public static CompanyRepositoryImplementation companyRepositoryImplementation = new CompanyRepositoryImplementation();

    /**
     * Constructs a new {@code Company} object with the specified name and capital.
     * Initializes income and costs to zero and discount status to false.
     *
     * @param name    the name of the company
     * @param capital the initial capital of the company
     * @throws IllegalArgumentException if the name is null, empty, blank, contains
     *                                  digits, or if the capital is negative
     */
    public Company(String name, int capital, double income, double costs, boolean isDiscountEnabled) {
        try {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            } else if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            } else if (name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank.");
            } else {
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isDigit(name.charAt(i))) {
                        throw new IllegalArgumentException("Name cannot contain digits.");
                    }
                }
            }
            this.name = name;

            if (capital < 0) {
                throw new IllegalArgumentException("Capital cannot be negative.");
            }
            this.capital = capital;

            this.income = income;
            this.costs = costs;
            this.isDiscountEnabled = isDiscountEnabled;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the name of the company.
     *
     * @return the name of the company
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name of the company.
     *
     * @param name the new name of the company
     * @throws IllegalArgumentException if the name is null, empty, blank, or
     *                                  contains digits
     */
    public void updateName(String name) {
        try {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            } else if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            } else if (name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank.");
            } else {
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isDigit(name.charAt(i))) {
                        throw new IllegalArgumentException("Name cannot contain digits.");
                    }
                }
            }
            if (companyRepositoryImplementation.updateCompanyNameByName(this.name, name)) {
                this.name = name;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the capital of the company.
     *
     * @return the capital of the company
     */
    public int getCapital() {
        return capital;
    }

    /**
     * Updates the capital of the company.
     *
     * @param capital the new capital of the company
     * @throws IllegalArgumentException if the capital is negative
     */
    public void updateCapital(int capital) {
        if (capital < 0) {
            throw new IllegalArgumentException("Capital can't be negative");
        }
        try {
            if (companyRepositoryImplementation.updateCompanyCapitalByName(getName(), capital)) {
                this.capital = capital;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the income of the company.
     *
     * @return the income of the company
     */
    public double getIncome() {
        return income;
    }

    /**
     * Updates the income of the company.
     *
     * @param income the new income of the company
     * @throws IllegalArgumentException if the income is negative
     */
    public void updateIncome(int income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income can't be negative");
        }
        try {
            if (companyRepositoryImplementation.updateCompanyIncomeByName(getName(), income)) {
                this.income = income;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds to the income of the company.
     *
     * @param incomeToAdd the amount to add to the income
     * @throws IllegalArgumentException if the income to add is negative
     */
    public void addIncome(double incomeToAdd) {
        if (incomeToAdd < 0) {
            throw new IllegalArgumentException("Income can't be negative");
        }
        try {
            if (companyRepositoryImplementation.updateCompanyIncomeByName(getName(), getIncome() + incomeToAdd)) {
                this.income += incomeToAdd;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the costs of the company.
     *
     * @return the costs of the company
     */
    public double getCosts() {
        return costs;
    }

    /**
     * Updates the costs of the company.
     *
     * @param costs the new costs of the company
     * @throws IllegalArgumentException if the costs are negative
     */
    public void updateCosts(double costs) {
        if (costs < 0) {
            throw new IllegalArgumentException("Costs can't be negative");
        }

        try {
            if (companyRepositoryImplementation.updateCompanyCostsByName(getName(), costs)) {
                this.costs = costs;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds to the costs of the company.
     *
     * @param costToAdd the amount to add to the costs
     * @throws IllegalArgumentException if the cost to add is negative
     */
    public void addCosts(double costToAdd) {
        if (costToAdd < 0) {
            throw new IllegalArgumentException("Costs can't be negative");
        }

        try {
            if (companyRepositoryImplementation.updateCompanyCostsByName(getName(), getCosts() + costToAdd)) {
                this.costs += costToAdd;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns whether the discount is enabled for the company.
     *
     * @return {@code true} if the discount is enabled, {@code false} otherwise
     */
    public boolean isDiscountEnabled() {
        return isDiscountEnabled;
    }

    /**
     * Toggles the discount status of the company.
     */
    public void updateDiscountEnabled() {
        try {
            if (companyRepositoryImplementation.updateDiscountStatusByName(getName())) {
                this.isDiscountEnabled = !this.isDiscountEnabled;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Capital: %s  Income: %s  Cost: %s", getCapital(), getIncome(), getCosts());
    }
}