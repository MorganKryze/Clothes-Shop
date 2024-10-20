package org.example.products;

import org.example.interfaces.Discountable;

public class Shoes extends Product implements Discountable {
    private static double discountPercentage = 0.8;
    private int shoeSize;

    public Shoes(String uuid, String name, int price, int cost, int stock, Company company, int shoeSize) {
        super(uuid, name, price, cost, stock, company);
        try {
            if (!isSizeValid(shoeSize)) {
                throw new IllegalArgumentException("wrong size!");
            }
            this.shoeSize = shoeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void updateShoeSize(int shoeSize) {
        try {
            if (isSizeValid(shoeSize) == false) {
                throw new IllegalArgumentException("wrong size!");
            }
            this.shoeSize = shoeSize;

            // TODO : try and catch + repo
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isSizeValid(int size) {
        return size >= 34 && size <= 54 && size % 2 == 0;
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
        return super.toString() + ", shoeSize=" + getShoeSize();
    }
}
