CREATE TABLE Company (
    name VARCHAR(255) PRIMARY KEY,
    capital INTEGER NOT NULL,
    income INTEGER NOT NULL,
    costs INTEGER NOT NULL,
    is_discount_enabled BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO Company (name, capital, income, costs)
VALUES ('Clothes shop', 100000, 0, 0);
CREATE TABLE Product (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    icon_source VARCHAR(255),
    category VARCHAR(255),
    price INTEGER NOT NULL,
    discounted_price INTEGER NOT NULL,
    cost INTEGER NOT NULL,
    stock INTEGER NOT NULL,
    clothing_size INTEGER,
    shoe_size INTEGER

);
INSERT INTO Product (
        name,
        icon_path,
        category,
        price,
        discounted_price,
        cost,
        stock
    )
VALUES (
        'T-shirt',
        'tshirt.png',
        'clothes',
        100,
        90,
        50,
        100
    );