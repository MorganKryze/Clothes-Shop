package org.example;

public class App
{
    public static void main(String[] args)
    {
        Clothes clothe1 = new Clothes("habit1", 2, 8, 48);
        Clothes clothe2 = new Clothes("habit2", 0.5, 5, 40);
        Clothes clothe3 = new Clothes("habit3", 5, 33, 50);

        Shoes shoe1 = new Shoes("shoe1", 10, 50, 42);
        Shoes shoe2 = new Shoes("shoe2", 8, 40, 44);
        Shoes shoe3 = new Shoes("shoe3", 5, 35, 45);

        Accessories accessoir1 = new Accessories("accessoir1", 0.1, 3);
        Accessories accessoir2 = new Accessories("accessoir2", 0.2, 6);
        Accessories accessoir3 = new Accessories("accessoir3", 0.3, 7);

        Product[] products = {clothe1, clothe2, clothe3, shoe1, shoe2, shoe3, accessoir1, accessoir2, accessoir3};

        System.out.println("List of Products:");
        for (Product product : products) {
            product.purchase(15);
            System.out.println(product);
        }

        clothe1.purchase(10);
        shoe1.sell(5);
        accessoir1.purchase(3);
        clothe3.sell(2);

        System.out.println("\nList of Products:");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\nTotal Income: " + Product.getIncome());
        System.out.println("Total Cost: " + Product.getCost());
        System.out.println("Remaining Capital: " + Product.getCapital());

        clothe1.applyDiscount();
        clothe3.applyDiscount();
        shoe2.applyDiscount();
        accessoir1.applyDiscount();
        accessoir3.applyDiscount();
    }
}
