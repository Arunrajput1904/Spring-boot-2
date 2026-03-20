CREATE TABLE department (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(255)
);

ALTER TABLE product_table
    ADD COLUMN department_id BIGINT;

ALTER TABLE product_table
    ADD CONSTRAINT fk_product_table_department
        FOREIGN KEY (department_id)
            REFERENCES department(id);