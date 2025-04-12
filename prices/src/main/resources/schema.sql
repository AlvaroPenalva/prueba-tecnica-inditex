CREATE TABLE prices (
    brand_id int NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    price_list int NOT NULL,
    product_id int NOT NULL,
    priority int NOT NULL,
    price decimal(10,2) NOT NULL,
    curr char(3) NOT NULL
);