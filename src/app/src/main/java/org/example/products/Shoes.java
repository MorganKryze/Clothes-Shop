package org.example.products;

import org.example.interfaces.Discountable;
import org.example.repositories.ProductRepositoryImplementation;

/**
 * The {@code Shoes} class represents a type of product that is a pair of shoes.
 * It extends the {@code Product} class and implements the {@code Discountable}
 * interface.
 * <p>
 * This class includes additional attributes and methods specific to shoes, such
 * as shoe size.
 * </p>
 */
public class Shoes extends Product implements Discountable {
    private static double discountPercentage = 0.8;
    private int shoeSize;

    /**
     * Constructs a new {@code Shoes} object with the specified attributes.
     *
     * @param uuid     the unique identifier of the product
     * @param name     the name of the product
     * @param iconPath the path to the product's icon
     * @param price    the price of the product
     * @param cost     the cost of the product
     * @param stock    the stock quantity of the product
     * @param company  the company associated with the product
     * @param shoeSize the size of the shoes
     * @throws IllegalArgumentException if the shoe size is invalid
     */
    public Shoes(String uuid, String name, String iconPath, int price, int cost, int stock, Company company,
            int shoeSize) {
        super(uuid, name, iconPath, price, cost, stock, company);
        try {
            if (!isSizeValid(shoeSize)) {
                throw new IllegalArgumentException("wrong size!");
            }
            this.shoeSize = shoeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
     * Updates the size of the shoes.
     *
     * @param shoeSize the new shoe size
     * @return {@code true} if the update was successful, {@code false} otherwise
     * @throws IllegalArgumentException if the shoe size is invalid
     */
    public boolean updateShoeSize(int shoeSize) {
        try {
            if (!isSizeValid(shoeSize)) {
                throw new IllegalArgumentException("wrong size!");
            }
            if (ProductRepositoryImplementation.updateShoeSize(super.getUuid(), shoeSize)) {
                this.shoeSize = shoeSize;
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Checks if the given shoe size is valid.
     *
     * @param size the shoe size to check
     * @return {@code true} if the size is valid, {@code false} otherwise
     */
    private boolean isSizeValid(int size) {
        return size >= 36 && size <= 50 && size % 2 == 0;
    }

    /**
     * Returns the price of the shoes as an integer.
     * If the company's discount is enabled, the discounted price is returned.
     *
     * @return the price of the shoes
     */
    @Override
    public int getIntPrice() {
        if (super.getCompany().isDiscountEnabled()) {
            return applyDiscount(super.getIntPrice());
        }
        return super.getIntPrice();
    }

    /**
     * Returns the price of the shoes as a double.
     * If the company's discount is enabled, the discounted price is returned.
     *
     * @return the price of the shoes
     */
    @Override
    public double getDoublePrice() {
        if (super.getCompany().isDiscountEnabled()) {
            return applyDiscount(super.getIntPrice()) / 100.0;
        }
        return super.getDoublePrice();
    }

    /**
     * Applies a discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public int applyDiscount(int price) {
        return (int) (price * discountPercentage);
    }

    /**
     * Returns a string representation of the {@code Shoes} object.
     *
     * @return a string representation of the {@code Shoes} object
     */
    @Override
    public String toString() {
        return super.toString() + "\nsize:" + getShoeSize();
    }
}