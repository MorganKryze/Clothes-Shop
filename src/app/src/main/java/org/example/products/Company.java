package org.example.products;

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
        // TODO : try and catch + repo
    }

    public double getCapital() {
        return capital / 100.0;
    }

    public void updateCapital(int capital) {
        if (capital < 0) {
            throw new IllegalArgumentException("Capital can't be negative");
        }
        this.capital = capital;

        // TODO : try and catch + repo
    }

    public double getIncome() {
        return income / 100.0;
    }

    public void updateIncome(int income) {
        this.income = income;

        // TODO : try and catch + repo
    }

    public void addIncome(int incomeToAdd) {
        this.income += incomeToAdd;

        // TODO : try and catch + repo
    }

    public double getCosts() {
        return costs / 100.0;
    }

    public void updateCosts(int costs) {
        this.costs = costs;

        // TODO : try and catch + repo
    }

    public void addCosts(double costToAdd) {
        this.costs += costToAdd;

        // TODO : try and catch + repo
    }

    public boolean isDiscountEnabled() {
        return isDiscountEnabled;
    }

    public void updateDiscountEnabled() {
        this.isDiscountEnabled = !this.isDiscountEnabled;

        // TODO : try and catch + repo
    }
}
