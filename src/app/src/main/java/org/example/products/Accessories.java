package org.example.products;

public class Accessories extends Product
{
    public Accessories(String name, double purchase_price, double sell_price)
    { super(name, purchase_price, sell_price); }

    @Override
    public String toString() { return super.toString(); }

    @Override
    public void applyDiscount()
    {
        setDiscount_price(getSell_price()*0.5);
    }
}
