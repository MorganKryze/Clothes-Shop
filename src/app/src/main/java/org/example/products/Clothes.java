package org.example.products;

public class Clothes extends Product
{
    private int size;

    public Clothes(String name, double purchase_price, double sell_price, int size)
    {
        super(name, purchase_price, sell_price);
        try
        {
            if (correct_value(size) == false) { throw new IllegalArgumentException("wrong size!"); }
            this.size = size;

        } catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getSize() { return size; }
    public void setSize(int size) { try { if(correct_value(size) == false) { throw new IllegalArgumentException("wrong size!"); } this.size = size; } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); } }

    @Override
    public String toString() { return super.toString() + ", size=" + getSize(); }

    private boolean correct_value(int size)
    {
        boolean retour = true;
        if (size < 34) {retour = false;}
        if (size > 54) {retour = false;}
        if (size%2 != 0) {retour = false;}
        return retour;
    }

    @Override
    public void applyDiscount()
    {
        setDiscount_price(getSell_price()*0.7);
    }
}
