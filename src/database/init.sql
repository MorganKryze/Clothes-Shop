CREATE TABLE Company (
    name VARCHAR(255) PRIMARY KEY,
    capital INTEGER NOT NULL,
    income DOUBLE PRECISION NOT NULL,
    costs DOUBLE PRECISION NOT NULL,
    is_discount_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    discount_rate DOUBLE PRECISION DEFAULT 0.5
);
INSERT INTO Company (name, capital, income, costs)
VALUES ('Clothes shop', 100000, 0.0, 0.0);
CREATE TABLE Product (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    price DOUBLE PRECISION NOT NULL,
    cost DOUBLE PRECISION NOT NULL,
    stock INTEGER NOT NULL,
    clothing_size INTEGER DEFAULT 0,
    shoe_size INTEGER DEFAULT 0,
    company_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (company_name) REFERENCES Company(name)
);
INSERT INTO Product (
        id,
        name,
        category,
        price,
        cost,
        stock,
        clothing_size,
        company_name
    )
VALUES (
        1,
        'Winter Dress',
        'clothes',
        100.0,
        50.0,
        10,
        40,
        'Clothes shop'
    ),
    (
        2,
        'Professional Shirt',
        'clothes',
        50.0,
        25.0,
        10,
        38,
        'Clothes shop'
    ),
    (
        3,
        'Not-Used Jean',
        'clothes',
        100.0,
        50.0,
        10,
        42,
        'Clothes shop'
    );
INSERT INTO Product (
        id,
        name,
        category,
        price,
        cost,
        stock,
        company_name
    )
VALUES (
        4,
        'Cheap Little Clock',
        'accessories',
        100.0,
        50.0,
        10,
        'Clothes shop'
    ),
    (
        5,
        'Portable Parachute',
        'accessories',
        50.0,
        25.0,
        10,
        'Clothes shop'
    ),
    (
        6,
        'Sunglasses',
        'accessories',
        100.0,
        50.0,
        10,
        'Clothes shop'
    );
INSERT INTO Product (
        id,
        name,
        category,
        price,
        cost,
        stock,
        shoe_size,
        company_name
    )
VALUES (
        7,
        'Classy shoe',
        'shoes',
        100.0,
        50.0,
        10,
        40,
        'Clothes shop'
    ),
    (
        8,
        'Work Shoe',
        'shoes',
        50.0,
        25.0,
        10,
        38,
        'Clothes shop'
    ),
    (
        9,
        'Aerodynamic shoe',
        'shoes',
        100.0,
        50.0,
        10,
        42,
        'Clothes shop'
    );