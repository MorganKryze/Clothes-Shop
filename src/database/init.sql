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
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    icon_path VARCHAR(255),
    category VARCHAR(255),
    price INTEGER NOT NULL,
    cost INTEGER NOT NULL,
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
        'batman.jpg',
        'clothes',
        100,
        50,
        10,
        40,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1c',
        'Professional Shirt',
        'unicorn.jpg',
        'clothes',
        50,
        25,
        10,
        38,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1d',
        'Not-Used Jean',
        'jean.jpg',
        'clothes',
        100,
        50,
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
        'Rolex.png',
        'accessories',
        100,
        50,
        10,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1f',
        'Portable Parachute',
        'parachute.jpg',
        'accessories',
        50,
        25,
        10,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1g',
        'Sunglasses',
        'sunglasses.jpg',
        'accessories',
        100,
        50,
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
        'ffs.jpg',
        'shoes',
        100,
        50,
        10,
        40,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1i',
        'Work Shoe',
        'work.jpg',
        'shoes',
        50,
        25,
        10,
        38,
        'Clothes shop'
    ),
    (
        'f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1j',
        'Aerodynamic shoe',
        'aero.jpg',
        'shoes',
        100,
        50,
        10,
        42,
        'Clothes shop'
    );