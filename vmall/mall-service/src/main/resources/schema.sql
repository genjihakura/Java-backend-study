-- USER table
drop database if exists vmall_mall;
create database vmall_mall;
use vmall_mall;

DROP TABLE IF EXISTS product_category ;
CREATE TABLE product_category  (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);

DROP TABLE IF EXISTS product  ;
CREATE TABLE product   (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    brand VARCHAR(100),
    price DECIMAL(10,2),
    inventory INT,
    createDate DATE,
    updateDate DATE,
    category_id BIGINT,
    description TEXT
);

DROP TABLE IF EXISTS cart;
CREATE TABLE cart(
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     user_id BIGINT,
     status ENUM('ACTIVE', 'IN_ACTIVE', 'CHECK_OUT', 'UNCHECKED') NOT NULL,
     create_at DATE
);

DROP TABLE IF EXISTS cart_item;
CREATE TABLE cart_item (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     cart_id BIGINT,
     product_id BIGINT,
     product_price BIGINT,
     quantity INT
);

DROP TABLE IF EXISTS order_users ;
CREATE TABLE order_users  (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    cart_id BIGINT,
    total_amount DECIMAL(10,2),
    status ENUM('CREATED', 'DELIVERY', 'RELEASED', 'CANCELED'),
    shipping_address VARCHAR(255),
    payment_method VARCHAR(50),
    created_at DATETIME
);

DROP TABLE IF EXISTS order_item  ;
CREATE TABLE order_item   (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      order_id BIGINT,
      product_id BIGINT,
      quantity INT,
      product_price DECIMAL(10,2)
);


