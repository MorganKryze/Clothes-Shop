package org.example.model;

import org.example.interfaces.Discountable;
import org.example.repository.ProductRepositoryImplementation;

/**
 * The {@code Product} class represents a generic product with attributes such
 * as UUID, name, icon path, price, cost, stock, and company. It provides
 * methods to get and update these attributes, as well as methods to manage
 * stock and sales.
 * <p>
 * This class is intended to be extended by specific product types.
 * </p>
 */
public class Product implements Discountable {

    private int uuid;
    private String name;
    private String category;
    private double price;
    private double cost;
    private int stock;
    private Company company;
    private int clothingSize;
    private int shoeSize;

    private ProductRepositoryImplementation productRepositoryImplementation = new ProductRepositoryImplementation();

    /**
     * Constructs a new {@code Product} object with the specified attributes.
     *
     * @param uuid the unique identifier of the product
     * @param name the name of the product
     * @param category the category of the product
     * @param price the price of the product
     * @param cost the cost of the product
     * @param stock the stock quantity of the product
     * @param company the company associated with the product
     * @throws IllegalArgumentException if any of the input values are invalid
     */
    public Product(int uuid, String name, String category, double price, double cost, int stock, Company company, int clothingSize, int shoeSize) {
        try {
            this.uuid = uuid;
            if (isNameCorrect(name)) {
                this.name = name;
            }

            if (isCategoryCorrect(category)) {
                this.category = category;
            }

            if (isPositive(price) && isPositive(cost) && isPositive(stock)) {
                this.price = price;
                this.cost = cost;
                this.stock = stock;
            }
            this.company = company;

            if (isClothingSizeValid(clothingSize)) {
                this.clothingSize = clothingSize;
            }
            if (isShoeSizeValid(shoeSize)) {
                this.shoeSize = shoeSize;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the UUID of the product.
     *
     * @return the UUID of the product
     */
    public int getUuid() {
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
     * Updates the name of the product.
     *
     * @param name the new name of the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the name is invalid
     */
    public boolean setName(String name) {
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
     * Returns the category of the product.
     *
     * @return the category of the product
     */
    public String getCategory() {
        return category;

    }

    private boolean isCategoryCorrect(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be null, empty, or blank.");
        }
        if (category.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Category cannot contain digits.");
        }
        if (!"clothes".equals(category) && !"shoes".equals(category) && !"accessories".equals(category)) {
            throw new IllegalArgumentException("Invalid category.");
        }
        return true;
    }

    /**
     * Updates the category of the product.
     *
     * @param category the new category of the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the category is invalid
     */
    public boolean setCategory(String category) {
        try {
            if (isCategoryCorrect(category)) {
                if (productRepositoryImplementation.updateProductCategoryByUUID(getUuid(), getCategory())) {
                    this.category = category;
                    return true;
                }
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
        if (getCompany().isDiscountEnabled()) {
            return applyDiscount(price);
        }
        return price;
    }

    private boolean isPositive(double number) {
        return number >= 0;
    }

    public boolean setPrice(double price) {
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
    public boolean setCost(double cost) {
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
    public boolean setStock(int items) {
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
                throw new IllegalArgumentException("Negative items number not allowed.");
            }
            if (setStock(getStock() + items)) {
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
            if (setStock(getStock() - items)) {
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
     * Updates the company associated with the product.
     *
     * @param company the new company associated with the product
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     */
    public boolean setCompany(Company company) {
        try {
            if (productRepositoryImplementation.updateProductCompanyByUUID(getUuid(), getCompany().getName())) {
                this.company = company;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
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
     * Returns the size of the clothing.
     *
     * @return the clothing size
     */
    public int getClothingSize() {
        return clothingSize;
    }

    /**
     * Updates the size of the clothing.
     *
     * @param size the new clothing size
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the clothing size is invalid
     */
    public boolean updateSize(int size) {
        if (!isClothingSizeValid(size)) {
            System.out.println("Wrong size!");
            return false;
        }
        try {
            if (productRepositoryImplementation.updateClothingSizeByUUID(getUuid(), size)) {
                this.clothingSize = size;
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Checks if the given clothing size is valid.
     *
     * @param size the clothing size to check
     * @return {@code true} if the size is valid, {@code false} otherwise
     */
    private boolean isClothingSizeValid(int size) {
        if (size == 0) {
            return true;
        } else if (size >= 34 && size <= 54 && size % 2 == 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid clothing size.");
        }
    }

    /**
     * Returns the size of the shoes.
     *
     * @return the shoe size
     */
    public int getShoeSize() {
        return shoeSize;
    }

    /**
     * Checks if the given shoe size is valid.
     *
     * @param size the shoe size to check
     * @return {@code true} if the size is valid, {@code false} otherwise
     */
    private boolean isShoeSizeValid(int size) {
        if (size == 0) {
            return true;
        } else if (size >= 36 && size <= 50 && size % 2 == 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid shoe size.");
        }
    }

    /**
     * Updates the size of the shoes.
     *
     * @param shoeSize the new shoe size
     * @return {@code true} if the update was successful, {@code false}
     * otherwise
     * @throws IllegalArgumentException if the shoe size is invalid
     */
    public boolean updateShoeSize(int shoeSize) {
        try {
            if (!isShoeSizeValid(shoeSize)) {
                throw new IllegalArgumentException("wrong size!");
            }
            if (productRepositoryImplementation.updateShoeSizeByUUID(getUuid(), shoeSize)) {
                this.shoeSize = shoeSize;
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Applies a discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * getCompany().getDiscountRate();
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
