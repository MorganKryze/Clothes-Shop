package org.example.products;

import org.example.repositories.CompanyRepositoryImplementation;

public class Company {
    private String name;
    private int capital;
    private int income;
    private int costs;
    private boolean isDiscountEnabled;

    public Company(String name, int capital) {
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

            this.income = 0;
            this.costs = 0;
            this.isDiscountEnabled = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

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
            if (CompanyRepositoryImplementation.updateName(this.name, name)) {
                this.name = name;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getCapital() {
        return capital / 100.0;
    }

    public void updateCapital(int capital) {
        if (capital < 0) {
            throw new IllegalArgumentException("Capital can't be negative");
        }
        try {
            if (CompanyRepositoryImplementation.updateCapital(this.name, capital)) {
                this.capital = capital;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getIncome() {
        return income / 100.0;
    }

    public void updateIncome(int income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income can't be negative");
        }
        try {
            if (CompanyRepositoryImplementation.updateIncome(this.name, income)) {
                this.income = income;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addIncome(int incomeToAdd) {
        if (incomeToAdd < 0) {
            throw new IllegalArgumentException("Income can't be negative");
        }
        try {
            if (CompanyRepositoryImplementation.updateIncome(this.name, this.income + incomeToAdd)) {
                this.income += incomeToAdd;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getCosts() {
        return costs / 100.0;
    }

    public void updateCosts(int costs) {
        if (costs < 0) {
            throw new IllegalArgumentException("Costs can't be negative");
        }

        try {
            if (CompanyRepositoryImplementation.updateCosts(this.name, costs)) {
                this.costs = costs;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCosts(double costToAdd) {
        if (costToAdd < 0) {
            throw new IllegalArgumentException("Costs can't be negative");
        }

        try {
            if (CompanyRepositoryImplementation.updateCosts(this.name, this.costs + (int) (costToAdd * 100))) {
                this.costs += (int) (costToAdd * 100);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isDiscountEnabled() {
        return isDiscountEnabled;
    }

    public void updateDiscountEnabled() {
        try {
            if (CompanyRepositoryImplementation.updateDiscountStatus(this.name)) {
                this.isDiscountEnabled = !this.isDiscountEnabled;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }
}
