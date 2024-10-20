package org.example.products;

import org.example.interfaces.Discountable;

public class Accessories extends Product implements Discountable {
    private static double discountPercentage = 0.5;

    public Accessories(String uuid, String name, String iconPath, int price, int cost, int stock, Company company) {
        super(uuid, name, iconPath, price, cost, stock, company);
    }

    @Override
    public int getIntPrice() {
        if (super.getCompany().isDiscountEnabled()) {
            return applyDiscount(super.getIntPrice());
        }
        return super.getIntPrice();
    }

    @Override
    public double getDoublePrice() {
        if (super.getCompany().isDiscountEnabled()) {
            return applyDiscount(super.getIntPrice()) / 100.0;
        }
        return super.getDoublePrice();
    }

    @Override
    public int applyDiscount(int price) {
        return (int) (price * discountPercentage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
