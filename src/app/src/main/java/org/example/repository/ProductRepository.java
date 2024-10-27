package org.example.repository;

import org.example.model.Product;

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
    public boolean createProduct(Product product);

    /**
     * Retrieves a product by its UUID.
     *
     * @param uuid the UUID of the product
     * @return the product with the specified UUID
     */
    public Product getProductByUUID(int uuid);

    /**
     * Retrieves all products.
     *
     * @return an array of all products
     */
    public Product[] getAllProducts();

    /**
     * Updates a product by its UUID.
     *
     * @param uuid the UUID of the product
     * @param product the new product
     * @return true if the product was updated successfully, false otherwise
     */
    public boolean updateProductByUUID(int uuid, Product product);

    /**
     * Retrieves the name of a product.
     *
     * @param uuid the UUID of the product
     * @return the name of the product
     */
    public String getProductNameByUUID(int uuid);

    /**
     * Updates the name of a product.
     *
     * @param uuid the UUID of the product
     * @param newName the new name for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductNameByUUID(int uuid, String newName);

    /**
     * Retrieves category of a product.
     * @param uuid the UUID of the product
     * @return the category of the product
     */
    public String getProductCategoryByUUID(int uuid);

    /**
     * Updates the category of a product.
     *
     * @param uuid the UUID of the product
     * @param category the new category for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductCategoryByUUID(int uuid, String category);

    /**
     * Retrieves the price of a product.
     *
     * @param uuid the UUID of the product
     * @return the price of the product
     */
    public double getProductPriceByUUID(int uuid);

    /**
     * Updates the price of a product.
     *
     * @param uuid the UUID of the product
     * @param price the new price for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductPriceByUUID(int uuid, double price);

    /**
     * Retrieves the cost of a product.
     *
     * @param uuid the UUID of the product
     * @return the cost of the product
     */
    public double getProductCostByUUID(int uuid);

    /**
     * Updates the cost of a product.
     *
     * @param uuid the UUID of the product
     * @param cost the new cost for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductCostByUUID(int uuid, double cost);

    /**
     * Retrieves the stock of a product.
     *
     * @param uuid the UUID of the product
     * @return the stock of the product
     */
    public int getProductStockByUUID(int uuid);

    /**
     * Updates the stock of a product.
     *
     * @param uuid the UUID of the product
     * @param stock the new stock amount for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProductStockByUUID(int uuid, int stock);

    /**
     * Retrieves the company associated with a product.
     *
     * @param uuid the UUID of the product
     * @return the company associated with the product
     */
    public String getProductCompanyByUUID(int uuid);

    /**
     * Retrieves the company associated with a product.
     *
     * @param uuid the UUID of the product
     * @return the company associated with the product
     */
    public boolean  updateProductCompanyByUUID(int uuid, String company);

    /**
     * Retrieves the shoe size of a product.
     *
     * @param uuid the UUID of the product
     * @return the shoe size of the product
     */
    public int getShoeSizeByUUID(int uuid);

    /**
     * Updates the shoe size of a product.
     *
     * @param uuid the UUID of the product
     * @param shoeSize the new shoe size for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateShoeSizeByUUID(int uuid, int shoeSize);

    /**
     * Retrieves the clothing size of a product.
     *
     * @param uuid the UUID of the product
     * @return the clothing size of the product
     */
    public int getClothingSizeByUUID(int uuid);

    /**
     * Updates the clothing size of a product.
     *
     * @param uuid the UUID of the product
     * @param clothingSize the new clothing size for the product
     * @return true if the update was successful, false otherwise
     */
    public boolean updateClothingSizeByUUID(int uuid, int clothingSize);

    /**
     * Deletes a product by its UUID.
     *
     * @param uuid the UUID of the product
     * @return true if the product was deleted successfully, false otherwise
     */
    public boolean deleteProductByUUID(int uuid);
}
