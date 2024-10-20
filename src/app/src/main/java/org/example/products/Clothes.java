package org.example.products;

import org.example.interfaces.Discountable;
import org.example.repositories.ProductRepositoryImplementation;

/**
 * The {@code Clothes} class represents a type of product that is a piece of
 * clothing.
 * It extends the {@code Product} class and implements the {@code Discountable}
 * interface.
 * <p>
 * This class includes additional attributes and methods specific to clothing,
 * such as clothing size.
 * </p>
 */
public class Clothes extends Product implements Discountable {
    private static double discountPercentage = 0.7;
    private int clothingSize;

    /**
     * Constructs a new {@code Clothes} object with the specified attributes.
     *
     * @param uuid     the unique identifier of the product
     * @param name     the name of the product
     * @param iconPath the path to the product's icon
     * @param price    the price of the product
     * @param cost     the cost of the product
     * @param stock    the stock quantity of the product
     * @param company  the company associated with the product
     * @param size     the size of the clothing
     * @throws IllegalArgumentException if the clothing size is invalid
     */
    public Clothes(String uuid, String name, String iconPath, int price, int cost, int stock, Company company,
            int size) {
        super(uuid, name, iconPath, price, cost, stock, company);
        try {
            if (!isSizeValid(size)) {
                throw new IllegalArgumentException("wrong size!");
            }
            this.clothingSize = size;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
     * @return {@code true} if the update was successful, {@code false} otherwise
     * @throws IllegalArgumentException if the clothing size is invalid
     */
    public boolean updateSize(int size) {
        if (!isSizeValid(size)) {
            System.out.println("Wrong size!");
            return false;
        }
        try {
            if (ProductRepositoryImplementation.updateClothingSize(super.getUuid(), size)) {
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
    private boolean isSizeValid(int size) {
        return size >= 34 && size <= 54 && size % 2 == 0;
    }

    /**
     * Returns the price of the clothing as an integer.
     * If the company's discount is enabled, the discounted price is returned.
     *
     * @return the price of the clothing
     */
    @Override
    public int getIntPrice() {
        if (super.getCompany().isDiscountEnabled()) {
            return applyDiscount(super.getIntPrice());
        }
        return super.getIntPrice();
    }

    /**
     * Returns the price of the clothing as a double.
     * If the company's discount is enabled, the discounted price is returned.
     *
     * @return the price of the clothing
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
     * Returns a string representation of the {@code Clothes} object.
     *
     * @return a string representation of the {@code Clothes} object
     */
    @Override
    public String toString() {
        return super.toString() + ", size=" + getClothingSize();
    }
}