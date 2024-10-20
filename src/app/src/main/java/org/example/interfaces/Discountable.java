package org.example.interfaces;

/**
 * The Discount interface provides a method to apply a discount.
 * Implementing classes should define the logic for applying the discount.
 */
public interface Discountable {
    /**
     * Applies a discount to the implementing class.
     * The specific discount logic should be defined in the implementing class.
     */
    public int applyDiscount(int price);
}
