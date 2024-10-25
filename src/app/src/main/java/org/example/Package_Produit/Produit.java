package org.example.Package_Produit;

public class Produit {
    private int ID;
    private String name;
    private String imagesource;
    private String description;
    private double purchase_price;;
    private double sell_price;
    private double discount_price;
    private int nbItems;

    public static double capital = 1000000;
    public static double income = 0;
    public static double cost = 0;
    public static String footer = "Capital : " + Produit.capital + "  Income : " + Produit.income + "   Cost : " + Produit.cost;

    public Produit(String name, String imagesource, double purchase_price, double sell_price, double discount_price, int nbItems, int ID) {
        this.ID = ID;
        this.name = name;
        this.imagesource = imagesource;
        this.purchase_price = purchase_price;
        this.sell_price = sell_price;
        this.discount_price = discount_price;
        this.nbItems = nbItems;
        this.description = "  Number : " + ID + "\n  Purchase Price : " + purchase_price + "\n  Sell Price : " + sell_price +
                "\n  Discount Price : " + purchase_price + "\n  Stock : " + nbItems;
    }

    public void updateDescription(){
        this.description = "  Number : " + ID + "\n  Purchase Price : " + purchase_price + "\n  Sell Price : " + sell_price +
                "\n  Discount Price : " + purchase_price + "\n  Stock : " + nbItems;
    }

    public static void updateFooter(){
        footer = "Capital : " + Produit.capital + "  Income : " + Produit.income + "   Cost : " + Produit.cost;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagesource() {
        return imagesource;
    }

    public void setImagesource(String imagesource) {
        this.imagesource = imagesource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public double getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(double discount_price) {
        this.discount_price = discount_price;
    }

    public int getNbItems() {
        return nbItems;
    }

    public void setNbItems(int nbItems) {
        this.nbItems = nbItems;
    }
}
