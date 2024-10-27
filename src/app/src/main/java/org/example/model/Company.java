package org.example.model;

import org.example.repository.CompanyRepositoryImplementation;

/**
 * The {@code Company} class represents a company with attributes such as name,
 * capital, income, costs, and discount status. It provides methods to get and
 * update these attributes.
 * <p>
 * This class ensures that the company name does not contain digits and is not
 * null, empty, or blank. It also ensures that capital, income, and costs are
 * non-negative.
 * </p>
 */
public class Company {

    private String name;
    private double capital;
    private double income;
    private double costs;
    private boolean isDiscountEnabled;
    private double discountRate;

    public static CompanyRepositoryImplementation companyRepositoryImplementation = new CompanyRepositoryImplementation();

    /**
     * Constructs a new {@code Company} object with the specified name and
     * capital. Initializes income and costs to zero and discount status to
     * false.
     *
     * @param name the name of the company
     * @param capital the initial capital of the company
     * @throws IllegalArgumentException if the name is null, empty, blank,
     * contains digits, or if the capital is negative
     */
    public Company(String name, double capital, double income, double costs, boolean isDiscountEnabled, double discountRate) {
        try {
            if (isNameCorrect(name)) {
                this.name = name;
            }

            if (isPositive(capital) && isPositive((int) income) && isPositive((int) costs)) {
                this.capital = capital;
                this.income = income;
                this.costs = costs;
            }

            this.isDiscountEnabled = isDiscountEnabled;

            if (isDiscountRateCorrect(discountRate)) {
                this.discountRate = discountRate;
            }
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

    private boolean isNameCorrect(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null, empty, or blank.");
        }
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Name cannot contain digits.");
        }
        return true;
    }

    /**
     * Updates the name of the company.
     *
     * @param name the new name of the company
     * @throws IllegalArgumentException if the name is null, empty, blank, or
     * contains digits
     */
    public boolean setName(String name) {
        try {
            if (isNameCorrect(name)) {
                if (companyRepositoryImplementation.updateCompanyNameByName(getName(), name)) {
                    this.name = name;
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isPositive(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative.");
        }
        return true;
    }

    /**
     * Returns the capital of the company.
     *
     * @return the capital of the company
     */
    public double getCapital() {
        return capital;
    }

    /**
     * Updates the capital of the company.
     *
     * @param capital the new capital of the company
     * @throws IllegalArgumentException if the capital is negative
     */
    public boolean setCapital(double capital) {

        try {
            if (isPositive(capital)) {
                if (companyRepositoryImplementation.updateCompanyCapitalByName(getName(), capital)) {
                    this.capital = capital;
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
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
    private boolean setIncome(double income) {
        try {
            if (isPositive(income)) {
                if (companyRepositoryImplementation.updateCompanyIncomeByName(getName(), income)) {
                    this.income = income;
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Adds to the income of the company.
     *
     * @param incomeToAdd the amount to add to the income
     * @throws IllegalArgumentException if the income to add is negative
     */
    public boolean addIncome(double incomeToAdd) {
        try {
            if (isPositive(incomeToAdd)) {
                if (setIncome(getIncome() + incomeToAdd) && setCapital(getCapital() + incomeToAdd)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
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
    public boolean setCosts(double costs) {

        try {
            if (isPositive(costs)) {
                if (companyRepositoryImplementation.updateCompanyCostsByName(getName(), costs)) {
                    this.costs = costs;
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Adds to the costs of the company.
     *
     * @param costToAdd the amount to add to the costs
     * @throws IllegalArgumentException if the cost to add is negative
     */
    public boolean addCosts(double costToAdd) {
        try {
            if (isPositive(costToAdd)) {
                if (setCosts(getCosts() + costToAdd) && setCapital(getCapital() - costToAdd)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
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
    public boolean updateDiscountEnabled() {
        try {
            if (companyRepositoryImplementation.updateDiscountStatusByName(getName())) {
                this.isDiscountEnabled = !this.isDiscountEnabled;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    private boolean isDiscountRateCorrect(double discountRate) {
        if (discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 1");
        }
        return true;
    }

    public boolean setDiscountRate(double discountRate) {
        try {
            if (isDiscountRateCorrect(discountRate)) {
                if (companyRepositoryImplementation.updateCompanyDiscountRateByName(getName(), discountRate)) {
                    this.discountRate = discountRate;
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Capital: %s  |  Income: %s  |  Costs: %s", getCapital(), getIncome(), getCosts());
    }
}
