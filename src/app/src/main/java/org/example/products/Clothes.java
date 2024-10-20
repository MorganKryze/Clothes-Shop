package org.example.products;

import org.example.interfaces.Discountable;

public class Clothes extends Product implements Discountable {
    private static double discountPercentage = 0.7;
    private int clothingSize;

    public Clothes(String uuid, String name, int price, int cost, int stock, Company company, int size) {
        super(uuid, name, price, cost, stock, company);
        try {
            if (isSizeValid(size) == false) {
                throw new IllegalArgumentException("wrong size!");
            }
            this.clothingSize = size;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getClothingSize() {
        return clothingSize;
    }

    public void updateSize(int size) {
        if (!isSizeValid(size)) {
            System.out.println("Wrong size!");
            return;
        }
        this.clothingSize = size;

        // TODO : try and catch + repo
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
        return super.toString() + ", size=" + getClothingSize();
    }
}
