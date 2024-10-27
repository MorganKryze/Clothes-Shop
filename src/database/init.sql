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
    id VARCHAR(255) PRIMARY KEY,
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
        '01',
        'Winter Dress',
        'clothes',
        100.0,
        50.0,
        10,
        40,
        'Clothes shop'
    ),
    (
        '02',
        'Professional Shirt',
        'clothes',
        50.0,
        25.0,
        10,
        38,
        'Clothes shop'
    ),
    (
        '03',
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
        '04',
        'Cheap Little Clock',
        'accessories',
        100.0,
        50.0,
        10,
        'Clothes shop'
    ),
    (
        '05',
        'Portable Parachute',
        'accessories',
        50.0,
        25.0,
        10,
        'Clothes shop'
    ),
    (
        '06',
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
        '07',
        'Classy shoe',
        'shoes',
        100.0,
        50.0,
        10,
        40,
        'Clothes shop'
    ),
    (
        '08',
        'Work Shoe',
        'shoes',
        50.0,
        25.0,
        10,
        38,
        'Clothes shop'
    ),
    (
        '09',
        'Aerodynamic shoe',
        'shoes',
        100.0,
        50.0,
        10,
        42,
        'Clothes shop'
    );