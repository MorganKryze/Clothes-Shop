package org.example.interfaces;

/**
 * The {@code Discountable} interface provides a method to apply a discount to a price.
 * Implementing classes should define the specific logic for applying the discount.
 * <p>
 * This interface is intended to be implemented by classes that represent items or services
 * which can have discounts applied to their prices.
 * </p>
 */
public interface Discountable {
    /**
     * Applies a discount to the given price.
     * The specific discount logic should be defined in the implementing class.
     *
     * @param price the original price before the discount
     * @return the price after the discount has been applied
     */
    int applyDiscount(int price);
}