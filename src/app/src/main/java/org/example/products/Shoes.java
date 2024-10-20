package org.example.products;

import org.example.interfaces.Discountable;
import org.example.repositories.ProductRepositoryImplementation;

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

    public boolean updateShoeSize(int shoeSize) {
        try {
            if (isSizeValid(shoeSize) == false) {
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

    private boolean isSizeValid(int size) {
        return size >= 36 && size <= 50 && size % 2 == 0;
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
