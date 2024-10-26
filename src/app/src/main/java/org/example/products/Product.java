package org.example.products;

import org.example.repositories.ProductRepositoryImplementation;

/**
 * The {@code Product} class represents a generic product with attributes such
 * as UUID, name, icon path, price, cost, stock, and company. It provides
 * methods to get and update these attributes, as well as methods to manage
 * stock and sales.
 * <p>
 * This class is intended to be extended by specific product types.
 * </p>
 */
public abstract class Product {

    private String uuid;
    private String name;
    private String iconPath;
    private double price;
    private double cost;
    private int stock;
    private Company company;

    private ProductRepositoryImplementation productRepositoryImplementation = new ProductRepositoryImplementation();

    /**
     * Constructs a new {@code Product} object with the specified attributes.
     *
     * @param uuid the unique identifier of the product
     * @param name the name of the product
     * @param iconPath the path to the product's icon
     * @param price the price of the product
     * @param cost the cost of the product
     * @param stock the stock quantity of the product
     * @param company the company associated with the product
     * @throws IllegalArgumentException if any of the input values are invalid
     */
    public Product(String uuid, String name, String iconPath, double price, double cost, int stock, Company company) {
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
            this.iconPath = iconPath;

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

    /**
     * Returns the UUID of the product.
     *
     * @return the UUID of the product
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name of the product.
     *
     * @param name the new name of the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the name is invalid
     */
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
            if (productRepositoryImplementation.updateProductNameByUUID(getUuid(), getName())) {
                this.name = name;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns the icon path of the product.
     *
     * @return the icon path of the product
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * Updates the icon path of the product.
     *
     * @param iconPath the new icon path of the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     */
    public boolean updateIconPath(String iconPath) {
        try {
            if (productRepositoryImplementation.updateProductIconPathByUUID(getUuid(), getIconPath())) {
                this.iconPath = iconPath;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns the price of the product as a double.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    public boolean updatePrice(double price) {
        try {
            if (price < 0) {
                throw new IllegalArgumentException("Negative price!");
            }
            if (productRepositoryImplementation.updateProductPriceByUUID(getUuid(), getCost())) {
                this.price = price;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns the cost of the product as a double.
     *
     * @return the cost of the product
     */
    public double getCost() {
        return cost;
    }

    /**
     * Updates the cost of the product.
     *
     * @param cost the new cost of the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the cost is negative
     */
    public boolean updateCost(double cost) {
        try {
            if (cost < 0) {
                throw new IllegalArgumentException("Negative price!");
            }
            if (productRepositoryImplementation.updateProductCostByUUID(getUuid(), getCost())) {
                this.cost = cost;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns the stock quantity of the product.
     *
     * @return the stock quantity of the product
     */
    public int getStock() {
        return stock;
    }

    /**
     * Updates the stock quantity of the product.
     *
     * @param items the new stock quantity of the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the stock quantity is negative
     */
    public boolean updateStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            if (productRepositoryImplementation.updateProductStockByUUID(getUuid(), getStock())) {
                this.stock = items;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Adds to the stock quantity of the product.
     *
     * @param items the amount to add to the stock
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the amount is negative
     */
    public boolean addToStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            if (productRepositoryImplementation.addToProductStockByUUID(getUuid(), items)) {
                this.stock += items;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Removes from the stock quantity of the product.
     *
     * @param items the amount to remove from the stock
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the amount is negative or greater
     * than the current stock
     */
    public boolean removeFromStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            } else if (items > this.stock) {
                throw new IllegalArgumentException("Not enough items in stock.");
            }
            if (productRepositoryImplementation.removeFromProductStockByUUID(getUuid(), items)) {
                this.stock -= items;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns the company associated with the product.
     *
     * @return the company associated with the product
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sells a specified number of items of the product.
     *
     * @param numberOfItems the number of items to sell
     * @return {@code true} if the sale was successful, {@code false} otherwise
     * @throws IllegalArgumentException if the number of items is negative or
     * greater than the current stock
     */
    public boolean sell(int numberOfItems) {
        // TODO : Remove
        try {
            if (numberOfItems < 0) {
                throw new IllegalArgumentException("Negative items number.");
            } else if (numberOfItems > getStock()) {
                throw new IllegalArgumentException("Not enough items in stock.");
            }

            if (removeFromStock(numberOfItems)) {
                getCompany().addIncome(numberOfItems * getPrice());
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Purchases a specified number of items of the product.
     *
     * @param numberOfItems the number of items to purchase
     * @return {@code true} if the purchase was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the number of items is negative
     */
    public boolean purchase(int numberOfItems) {
        // TODO : Remove
        try {
            if (numberOfItems < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            if (addToStock(numberOfItems)) {
                getCompany().addCosts(numberOfItems * getCost());
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code Product} object.
     *
     * @return a string representation of the {@code Product} object
     */
    @Override
    public String toString() {
        return String.format("Purchase_price : %s€ \nsell_price : %s€ \nstock : %s",
                getPrice(), getCost(), getStock());
    }
}
