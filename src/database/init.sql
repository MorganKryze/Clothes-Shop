CREATE TABLE Company (
    name VARCHAR(255) PRIMARY KEY,
    capital INTEGER NOT NULL,
    income DOUBLE PRECISION NOT NULL,
    costs DOUBLE PRECISION NOT NULL,
    is_discount_enabled BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO Company (name, capital, income, costs)
VALUES ('Clothes shop', 100000, 0.0, 0.0);
CREATE TABLE Product (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(255),
    price DOUBLE PRECISION NOT NULL,
    cost DOUBLE PRECISION NOT NULL,
    stock INTEGER NOT NULL,
    clothing_size INTEGER,
    shoe_size INTEGER,
    company_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (company_name) REFERENCES Company(name)
);
INSERT INTO Product (
        id,
        name,
        icon_path,
        category,
        price,
        cost,
        stock,
        clothing_size,
        company_name
    )
VALUES (
        '40e6215d-b5c6-4896-987c-f30f3678f608',
        'Winter Dress',
        'clothes',
        100.0,
        50.0,
        10,
        40,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1c',
        'Professional Shirt',
        'clothes',
        50.0,
        25.0,
        10,
        38,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1d',
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
        icon_path,
        category,
        price,
        cost,
        stock,
        company_name
    )
VALUES (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1e',
        'Cheap Little Clock',
        'accessories',
        100.0,
        50.0,
        10,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1f',
        'Portable Parachute',
        'accessories',
        50.0,
        25.0,
        10,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1g',
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
        icon_path,
        category,
        price,
        cost,
        stock,
        shoe_size,
        company_name
    )
VALUES (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1h',
        'Classy shoe',
        'shoes',
        100.0,
        50.0,
        10,
        40,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1i',
        'Work Shoe',
        'shoes',
        50.0,
        25.0,
        10,
        38,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1j',
        'Aerodynamic shoe',
        'shoes',
        100.0,
        50.0,
        10,
        42,
        'Clothes shop'
    );