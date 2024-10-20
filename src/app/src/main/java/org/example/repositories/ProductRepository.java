package org.example.repositories;

import org.example.products.Product;

public interface ProductRepository {

    /**
     * Retrieves a product by its UUID.
     *
     * @param uuid the UUID of the product
     * @return the product with the specified UUID, or null if not found
     */
    public Product getProductByUUID(String uuid);

    /**
     * Updates the name of a product.
     *
     * @param uuid    the UUID of the product
     * @param newName the new name for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateName(String uuid, String newName);

    /**
     * Retrieves the icon path of a product.
     *
     * @param uuid the UUID of the product
     * @return the icon path of the product
     */
    public String getProductIconPath(String uuid);

    /**
     * Updates the icon path of a product.
     *
     * @param uuid     the UUID of the product
     * @param iconPath the new icon path for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateIconPath(String uuid, String iconPath);

    /**
     * Retrieves the price of a product.
     *
     * @param uuid the UUID of the product
     * @return the price of the product
     */
    public int getProductPrice(String uuid);

    /**
     * Updates the price of a product.
     *
     * @param uuid  the UUID of the product
     * @param price the new price for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updatePrice(String uuid, int price);

    /**
     * Retrieves the cost of a product.
     *
     * @param uuid the UUID of the product
     * @return the cost of the product
     */
    public int getProductCost(String uuid);

    /**
     * Updates the cost of a product.
     *
     * @param uuid the UUID of the product
     * @param cost the new cost for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateCost(String uuid, int cost);

    /**
     * Retrieves the stock of a product.
     *
     * @param uuid the UUID of the product
     * @return the stock of the product
     */
    public int getProductStock(String uuid);

    /**
     * Updates the stock of a product.
     *
     * @param uuid  the UUID of the product
     * @param stock the new stock amount for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateStock(String uuid, int stock);

    /**
     * Adds to the stock of a product.
     *
     * @param uuid   the UUID of the product
     * @param amount the amount to add to the stock
     * @return true if the update was successful, false otherwise
     */
    public boolean addToStock(String uuid, int amount);

    /**
     * Removes from the stock of a product.
     *
     * @param uuid   the UUID of the product
     * @param amount the amount to remove from the stock
     * @return true if the update was successful, false otherwise
     */
    public boolean removeFromStock(String uuid, int amount);

    /**
     * Retrieves the company associated with a product.
     *
     * @param uuid the UUID of the product
     * @return the company associated with the product
     */
    public String getProductCompany(String uuid);

    /**
     * Retrieves the shoe size of a product.
     *
     * @param uuid the UUID of the product
     * @return the shoe size of the product
     */
    public int getShoeSize(String uuid);

    /**
     * Updates the shoe size of a product.
     *
     * @param uuid     the UUID of the product
     * @param shoeSize the new shoe size for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateShoeSize(String uuid, int shoeSize);

    /**
     * Retrieves the clothing size of a product.
     *
     * @param uuid the UUID of the product
     * @return the clothing size of the product
     */
    public int getClothingSize(String uuid);

    /**
     * Updates the clothing size of a product.
     *
     * @param uuid         the UUID of the product
     * @param clothingSize the new clothing size for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateClothingSize(String uuid, int clothingSize);
}