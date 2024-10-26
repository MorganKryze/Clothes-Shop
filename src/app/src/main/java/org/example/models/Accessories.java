package org.example.models;

import org.example.interfaces.Discountable;

/**
 * The {@code Accessories} class represents a type of product that is an
 * accessory. It extends the {@code Product} class and implements the
 * {@code Discountable} interface.
 * <p>
 * This class includes additional attributes and methods specific to
 * accessories, such as applying discounts.
 * </p>
 */
public class Accessories extends Product implements Discountable {

    private static final double DISCOUNT_PERCENTAGE = 0.5;

    /**
     * Constructs a new {@code Accessories} object with the specified
     * attributes.
     *
     * @param uuid the unique identifier of the product
     * @param name the name of the product
     * @param iconPath the path to the product's icon
     * @param price the price of the product
     * @param cost the cost of the product
     * @param stock the stock quantity of the product
     * @param company the company associated with the product
     */
    public Accessories(String uuid, String name, double price, double cost, int stock,
            Company company) {
        super(uuid, name, price, cost, stock, company);
    }

    /**
     * Returns the price of the accessory as a double. If the company's discount
     * is enabled, the discounted price is returned.
     *
     * @return the price of the accessory
     */
    @Override
    public double getPrice() {
        if (super.getCompany().isDiscountEnabled()) {
            return applyDiscount(super.getPrice());
        }
        return super.getPrice();
    }

    /**
     * Applies a discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * DISCOUNT_PERCENTAGE;
    }

    /**
     * Returns a string representation of the {@code Accessories} object.
     *
     * @return a string representation of the {@code Accessories} object
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
