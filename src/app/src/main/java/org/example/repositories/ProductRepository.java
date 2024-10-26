package org.example.repositories;

import org.example.products.Accessories;
import org.example.products.Clothes;
import org.example.products.Shoes;

public interface ProductRepository {

    /**
     * Creates a new product.
     *
     * @param name the name of the product
     * @param iconPath the icon path of the product
     * @param price the price of the product
     * @param cost the cost of the product
     * @param stock the stock of the product
     * @param company the company associated with the product
     * @param shoeSize the shoe size of the product
     * @param clothingSize the clothing size of the product
     * @return true if the product was created successfully, false otherwise
     */
    public boolean createProduct(String id, String name, String iconPath, double price, double cost, int stock, String company, String category, int shoeSize, int clothingSize);

    /**
     * Retrieves a cloth by its UUID.
     *
     * @param uuid the UUID of the product
     * @return the cloth with the given UUID
     */
    public Clothes getClothesByUUID(String uuid);

    /**
     * Retrieves a shoe by its UUID.
     *
     * @param uuid the UUID of the product
     * @return the shoe with the given UUID
     */
    public Shoes getShoesByUUID(String uuid);

    /**
     * Retrieves an accessory by its UUID.
     *
     * @param uuid the UUID of the product
     * @return the accessory with the given UUID
     */
    public Accessories getAccessoriesByUUID(String uuid);

    /**
     * Retrieves the name of a product.
     *
     * @param uuid the UUID of the product
     * @return the name of the product
     */
    public String getProductNameByUUID(String uuid);

    /**
     * Updates the name of a product.
     *
     * @param uuid the UUID of the product
     * @param newName the new name for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductNameByUUID(String uuid, String newName);

    /**
     * Retrieves the icon path of a product.
     *
     * @param uuid the UUID of the product
     * @return the icon path of the product
     */
    public String getProductIconPathByUUID(String uuid);

    /**
     * Updates the icon path of a product.
     *
     * @param uuid the UUID of the product
     * @param iconPath the new icon path for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductIconPathByUUID(String uuid, String iconPath);

    /**
     * Retrieves the price of a product.
     *
     * @param uuid the UUID of the product
     * @return the price of the product
     */
    public double getProductPriceByUUID(String uuid);

    /**
     * Updates the price of a product.
     *
     * @param uuid the UUID of the product
     * @param price the new price for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductPriceByUUID(String uuid, double price);

    /**
     * Retrieves the cost of a product.
     *
     * @param uuid the UUID of the product
     * @return the cost of the product
     */
    public double getProductCostByUUID(String uuid);

    /**
     * Updates the cost of a product.
     *
     * @param uuid the UUID of the product
     * @param cost the new cost for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductCostByUUID(String uuid, double cost);

    /**
     * Retrieves the stock of a product.
     *
     * @param uuid the UUID of the product
     * @return the stock of the product
     */
    public int getProductStockByUUID(String uuid);

    /**
     * Updates the stock of a product.
     *
     * @param uuid the UUID of the product
     * @param stock the new stock amount for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductStockByUUID(String uuid, int stock);

    /**
     * Adds to the stock of a product.
     *
     * @param uuid the UUID of the product
     * @param amount the amount to add to the stock
     * @return true if the update was successful, false otherwise
     */
    public boolean addToProductStockByUUID(String uuid, int amount);

    /**
     * Removes from the stock of a product.
     *
     * @param uuid the UUID of the product
     * @param amount the amount to remove from the stock
     * @return true if the update was successful, false otherwise
     */
    public boolean removeFromProductStockByUUID(String uuid, int amount);

    /**
     * Retrieves the company associated with a product.
     *
     * @param uuid the UUID of the product
     * @return the company associated with the product
     */
    public String getProductCompanyByUUID(String uuid);

    /**
     * Retrieves the company associated with a product.
     *
     * @param uuid the UUID of the product
     * @return the company associated with the product
     */
    public boolean  updateProductCompanyByUUID(String uuid, String company);

    /**
     * Retrieves the shoe size of a product.
     *
     * @param uuid the UUID of the product
     * @return the shoe size of the product
     */
    public int getShoeSizeByUUID(String uuid);

    /**
     * Updates the shoe size of a product.
     *
     * @param uuid the UUID of the product
     * @param shoeSize the new shoe size for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateShoeSizeByUUID(String uuid, int shoeSize);

    /**
     * Retrieves the clothing size of a product.
     *
     * @param uuid the UUID of the product
     * @return the clothing size of the product
     */
    public int getClothingSizeByUUID(String uuid);

    /**
     * Updates the clothing size of a product.
     *
     * @param uuid the UUID of the product
     * @param clothingSize the new clothing size for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateClothingSizeByUUID(String uuid, int clothingSize);

    /**
     * Deletes a product by its UUID.
     *
     * @param uuid the UUID of the product
     * @return true if the product was deleted successfully, false otherwise
     */
    public boolean deleteProductByUUID(String uuid);
}
