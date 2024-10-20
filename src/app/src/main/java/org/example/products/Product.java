package org.example.products;

import org.example.repositories.CompanyRepositoryImplementation;
import org.example.repositories.ProductRepositoryImplementation;

public abstract class Product {
    private String uuid;
    private String name;
    private String iconPath;
    private int price;
    private int cost;
    private int stock;
    private Company company;

    public Product(String uuid, String name, int price, int cost, int stock, Company company) {
        try {
            this.uuid = uuid;
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

            if (price < 0 || cost < 0 || stock < 0) {
                throw new IllegalArgumentException("No negative values allowed.");
            }
            this.cost = cost;
            this.price = price;
            this.stock = stock;
            this.company = company;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public boolean updateName(String name) {
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
        try {
            if (ProductRepositoryImplementation.updateName(uuid, name)) {
                this.name = name;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String getIconPath() {
        return iconPath;
    }

    public boolean updateIconPath(String iconPath) {
        try {
            if (ProductRepositoryImplementation.updateIconPath(uuid, iconPath)) {
                this.iconPath = iconPath;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public double getDoublePrice() {
        return price / 100.0;
    }

    public int getIntPrice() {
        return price;
    }

    public double getDoubleCost() {
        return cost / 100.0;
    }

    public int getIntCost() {
        return cost;
    }

    public boolean updateCost(int cost) {
        try {
            if (cost < 0) {
                throw new IllegalArgumentException("Negative price!");
            }
            if (ProductRepositoryImplementation.updateCost(uuid, cost)) {
                this.cost = cost;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int getStock() {
        return stock;
    }

    public boolean updateStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            if (ProductRepositoryImplementation.updateStock(uuid, items)) {
                this.stock = items;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addToStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            if (ProductRepositoryImplementation.addToStock(uuid, items)) {
                this.stock += items;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean removeFromStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            } else if (items > this.stock) {
                throw new IllegalArgumentException("Not enough items in stock.");
            }
            if (ProductRepositoryImplementation.removeFromStock(uuid, items)) {
                this.stock -= items;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Company getCompany() {
        return company;
    }

    public boolean sell(int numberOfItems) {
        try {
            if (numberOfItems < 0) {
                throw new IllegalArgumentException("Negative items number.");
            } else if (numberOfItems > this.stock) {
                throw new IllegalArgumentException("Not enough items in stock.");
            }
            if (ProductRepositoryImplementation.removeFromStock(uuid, numberOfItems)) {
                removeFromStock(numberOfItems);
            }
            if (CompanyRepositoryImplementation.updateIncome(company.getName(), numberOfItems * getIntPrice())) {
                company.addIncome(numberOfItems * getIntPrice());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean purchase(int numberOfItems) {
        try {
            if (numberOfItems < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            if (ProductRepositoryImplementation.addToStock(uuid, numberOfItems)) {
                addToStock(numberOfItems);
            }
            if (CompanyRepositoryImplementation.updateCosts(company.getName(), numberOfItems * getIntCost())) {
                company.addIncome(numberOfItems * getIntCost());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Product %s: number=%s, purchase_price=%s, sell_price=%s, nbItems=%s",
                name, uuid, cost, price, stock);
    }

}