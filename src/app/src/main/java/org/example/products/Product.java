package org.example.products;

public abstract class Product {
    private String uuid;
    private String name;
    private String iconPath;
    private int price;
    private int cost;
    private int stock;
    private Company company;

    public Product(String uuid, String name, int price, int cost, int stock, Company company) {
        try {
            this.uuid = uuid;
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            } else if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            } else if (name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank.");
            } else {
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isDigit(name.charAt(i))) {
                        throw new IllegalArgumentException("Name cannot contain digits.");
                    }
                }
            }
            this.name = name;

            if (price < 0 || cost < 0 || stock < 0) {
                throw new IllegalArgumentException("No negative values allowed.");
            }
            this.cost = cost;
            this.price = price;
            this.stock = stock;
            this.company = company;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        } else {
            for (int i = 0; i < name.length(); i++) {
                if (Character.isDigit(name.charAt(i))) {
                    throw new IllegalArgumentException("Name cannot contain digits.");
                }
            }
        }
        this.name = name;

        // TODO : try and catch + repo
    }

    public String getIconPath() {
        return iconPath;
    }

    public void updateIconPath(String iconPath) {
        this.iconPath = iconPath;

        // TODO : try and catch + repo
    }

    public double getDoublePrice() {
        return price / 100.0;
    }

    public int getIntPrice() {
        return price;
    }

    public double getCost() {
        return cost / 100.0;
    }

    public int updateCost(int cost) {
        try {
            if (cost < 0) {
                throw new IllegalArgumentException("Negative price!");
            }
            this.cost = cost;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this.cost;

        // TODO : try and catch + repo
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            this.stock = items;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TODO : try and catch + repo
    }

    public void addToStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            }
            this.stock += items;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TODO : try and catch + repo
    }

    public void removeFromStock(int items) {
        try {
            if (items < 0) {
                throw new IllegalArgumentException("Negative items number.");
            } else if (items > this.stock) {
                throw new IllegalArgumentException("Not enough items in stock.");
            }
            this.stock -= items;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TODO : try and catch + repo
    }

    public Company getCompany() {
        return company;
    }

    public void updateCompany(Company company) {
        this.company = company;

        // TODO : try and catch + repo
    }

    public void sell(int numberOfItems) {
        try {
            removeFromStock(numberOfItems);
            company.addIncome(numberOfItems * getIntPrice());

            // TODO : try and catch + repo
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void purchase(int numberOfItems) {
        addToStock(numberOfItems);
        company.addCosts(numberOfItems * this.cost);

        // TODO : try and catch + repo
    }

    @Override
    public String toString() {
        return String.format("Product %s: number=%s, purchase_price=%s, sell_price=%s, nbItems=%s",
                name, uuid, cost, price, stock);
    }

}