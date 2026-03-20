CREATE TABLE product_table (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(40) NOT NULL,
    title_x VARCHAR(255),
    price NUMERIC,
    quantity INT,
    created_at TIMESTAMP,
    update_at TIMESTAMP
);
CREATE INDEX sku_index ON product_table(sku);

ALTER TABLE product_table
ADD CONSTRAINT title_price_unique UNIQUE (title_x, price);



















