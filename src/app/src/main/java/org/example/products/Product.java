package org.example.products;

import org.example.interfaces.Discount;

public abstract class Product implements Discount, Comparable<Product>
{
    private static int count = 1;
    private static double Capital = 1000000;
    private static double income = 0;
    private static double cost = 0;


    private int number;
    private String name;
    private double purchase_price;
    private double sell_price;
    private double discount_price;
    private int nbItems;

    public Product(String name, double purchase_price, double sell_price)
    {
        try
        {
            this.name = name;
            if(purchase_price < 0) {throw new IllegalArgumentException("Negative price!");}
            this.purchase_price = purchase_price;
            if(sell_price < 0) {throw new IllegalArgumentException("Negative price!");}
            this.sell_price = sell_price;
            this.nbItems = 0;
            this.discount_price = 0;
            this.number = count;
            count++;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int getCount() { return count; }
    public static double getCapital() { return Capital; }
    public static double getIncome() { return income; }
    public static double getCost() { return cost; }
    public int getNumber() { return number; }
    public String getName(){ return name; }
    public double getPurchase_price() { return purchase_price; }
    public double getSell_price() { return sell_price; }
    public double getDiscount_price() { return discount_price; }
    public int getNbItems() { return nbItems; }

    public static void setCount(int count) { Product.count = count; }
    public static void setCapital(double capital) { Product.Capital = capital; }
    public static void setIncome(double income) { Product.income = income; }
    public static void setCost(double cost) { Product.cost = cost; }
    public void setNumber(int number) { this.number = number; }
    public void setName(String newName) { this.name = newName; }
    public void setPurchasePrice(double purchase_price) { try { if (purchase_price < 0) { throw new IllegalArgumentException("Negative price!"); } this.purchase_price = purchase_price; } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); } }
    public void setSell_price(double sell_price) { try { if (sell_price < 0) { throw new IllegalArgumentException("Negative price!"); } this.sell_price = sell_price; } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); } }
    public void setDiscount_price(double discount_price) { try { if (discount_price < 0) { throw new IllegalArgumentException("Negative price!"); } this.discount_price = discount_price; } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); } }
    public void setNbItems(int nbItems) { try { if (nbItems < 0) { throw new IllegalArgumentException("Negative items number!"); } this.nbItems = nbItems; } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); } }

    @Override
    public String toString() {return "Product " + name + ": number=" + number + ", purchase_price=" + purchase_price + ", sell_price=" + sell_price + ", discount_price=" + discount_price + ", nbItems=" + nbItems; }

    public void sell(int nbItems)
    {
        try
        {
            if(nbItems > this.nbItems) { throw new IllegalArgumentException("Product Unavailable");}
            this.nbItems -= nbItems;
            Product.income += nbItems*this.sell_price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void purchase(int nbItems)
    {
        this.nbItems += nbItems;
        Product.cost += nbItems*this.purchase_price;
    }

    public abstract void applyDiscount();

    @Override
    public int compareTo(Product other)
    {
        return Double.compare(this.getSell_price(), other.getSell_price());
    }
}