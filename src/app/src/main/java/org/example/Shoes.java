package org.example;

public class Shoes extends Product
{
    private int shoeSize;

    public Shoes(String name, double purchase_price, double sell_price, int shoeSize)
    {
        super(name, purchase_price, sell_price);
        try
        {
            if(!correct_value(shoeSize)) {throw new IllegalArgumentException("wrong size!");}
            this.shoeSize = shoeSize;
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getShoeSize() { return shoeSize; }
    public void setShoeSize(int shoeSize) { try { if(correct_value(shoeSize) == false) { throw new IllegalArgumentException("wrong size!"); } this.shoeSize = shoeSize; } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); } }

    @Override
    public String toString() { return super.toString() + ", shoeSize=" + getShoeSize(); }

    private boolean correct_value(int size)
    {
        boolean retour = true;
        if (size < 36) {retour = false;}
        if (size > 50) {retour = false;}
        return retour;
    }

    @Override
    public void applyDiscount()
    {
        setDiscount_price(getSell_price()*0.8);
    }
}
