CREATE SCHEMA MANAGEMENT;
CREATE TABLE IF NOT EXISTS management.product (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(100) NOT NULL ,
  PRICE DECIMAL(18,2) NOT NULL ,
  MANUFACTURER VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS management.manufacturer (
  ID INT NOT NULL ,
  NAME VARCHAR(100) NOT NULL ,
  PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS management.manufacturer_products(
  manufacturer_id INT NOT NULL,
  product_id     INT NOT NULL,
  CONSTRAINT uq_manufacturer_products UNIQUE (product_id, manufacturer_id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id),
  FOREIGN KEY (product_id) REFERENCES product(id));