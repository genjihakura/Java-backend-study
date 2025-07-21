-- USER table
drop database if exists vmall_user;
create database vmall_user;
use vmall_user;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255), -- thêm dòng này
    password VARCHAR(255),
    username VARCHAR(255)
    );