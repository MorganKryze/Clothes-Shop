package org.example.repositories;

import org.example.products.Product;

public interface ProductRepository {

    public Product getProductByUUID(String uuid);

    public boolean updateName(String uuid, String newName);

    public String getProductIconPath(String uuid);

    public boolean updateIconPath(String uuid, String iconPath);

    public int getProductPrice(String uuid);

    public boolean updatePrice(String uuid, int price);

    public int getProductCost(String uuid);

    public boolean updateCost(String uuid, int cost);

    public int getProductStock(String uuid);

    public boolean updateStock(String uuid, int stock);

    public boolean addToStock(String uuid, int amount);

    public boolean removeFromStock(String uuid, int amount);

    public String getProductCompany(String uuid);

    public int getShoeSize(String uuid);

    public boolean updateShoeSize(String uuid, int shoeSize);

    public int getClothingSize(String uuid);

    public boolean updateClothingSize(String uuid, int clothingSize);

}
