-- ProductCategory
INSERT INTO product_category (id, name) VALUES
                                            (1, 'Pizza'),
                                            (2, 'Trà sữa'),
                                            (3, 'Beefsteak');

-- Product
INSERT INTO product (id, name, price, category_id, description) VALUES
                                                                    (1, 'Pizza Hải sản', 120000, 1, 'Ngon, nhiều topping'),
                                                                    (2, 'Trà sữa truyền thống', 30000, 2, 'Trà đen + sữa tươi'),
                                                                    (3, 'Beefsteak bò Úc', 180000, 3, 'Bò mềm, sốt tiêu đen');

-- Cart
INSERT INTO cart (id, user_id, status) VALUES
                                           (1, 1, 'ACTIVE'),
                                           (2, 2, 'IN_ACTIVE');

-- CartItem
INSERT INTO cart_item (id, cart_id, product_id, quantity) VALUES
                                                              (1, 1, 1, 1),
                                                              (2, 1, 2, 2),
                                                              (3, 2, 3, 1);

-- Order
INSERT INTO order_users (id, user_id, cart_id, total_amount, status, shipping_address, payment_method, created_at) VALUES
                                                                                                                  (1, 1, 1, 180000, 'CREATED', '123 PHU LOI', 'COD', '2025-07-18T10:00:00'),
                                                                                                                  (2, 2, 2, 180000, 'CREATED', '45 LE HONG PHONG', 'MOMO', '2025-07-17T14:20:00');

-- OrderItem
INSERT INTO order_item (id, order_id, product_id, quantity, product_price) VALUES
                                                                       (1, 1, 1, 1, 120000),
                                                                       (2, 1, 2, 2, 60000),
                                                                       (3, 2, 3, 1, 180000);