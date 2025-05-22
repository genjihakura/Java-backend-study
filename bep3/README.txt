authoziation
Bearer Token
basic auth Account admin


Thêm món ăn mới vào thực đơn
http://localhost:8686/api/v1/menu/create

{
    "name": "bò kho",
    "price" : 65000,
    "description": "Bò kho is a dish of southern Vietnamese origin using the kho cooking method; it is a spicy dish made commonly with beef which is known throughout the country and beyond. In rural areas, the dish is described as being extremely fiery"
}

{
    "name": "Cà Ri Gà",
    "price" : 65000,
    "description": "Cà ri gà là một món ăn phổ biến ở Nam Á"
}

{
    "name": "Cơm sườn",
    "price" : 65000,
    "description": "Cơm sường là một món ăn phổ biến ở Việt Nam"
}

Liệt kê tất cả các món ăn
http://localhost:8686/api/v1/menu/all

cập nhật thông tin món ăn giá cả, nội dung, tên
http://localhost:8686/api/v1/menu/update

Xóa món ăn ra khỏi thực đơn
http://localhost:8686/api/v1/menu/delete/{id}

Cập nhật số lượng món ăn có sẵn
http://localhost:8686/api/v1/menu/numberAvailable


=================================================
authoziation
Bearer Token
basic auth Account admin, employee

Thêm món ăn vào đơn hàng
http://localhost:8686/api/v1/orders/create
{
  "items": [
    { "menuItemId": 2, "quantity": 3 }
  ]
}


Liệt kê tất cả các orders đã gọi
http://localhost:8686/api/v1/orders/all

cập nhật thông tin món ăn giá cả, nội dung, tên
http://localhost:8686/api/v1/orders/update

Xóa món ăn ra khỏi thực đơn
http://localhost:8686/api/v1/orders/delete/{id}


=================================================

authoziation
Bearer Token

Thêm nguyên liệu vào kho
http://localhost:8686/api/v1/IngredientStore/create
{
    "name": "Thit Bo",
    "quantityInStock" : 6,
    "unit": "kg"
}



Liệt kê tất cả nguyên liệu trong kho
http://localhost:8686/api/v1/IngredientStore/all

cập nhật thông tin nguyên liệu
http://localhost:8686/api/v1/IngredientStore/update

Xóa nguyên liệu
http://localhost:8686/api/v1/IngredientStore/delete/{id}
=================================================
authoziation
Bearer Token
basic auth Account admin

Thêm nguyên liệu vào vào món ăn
http://localhost:8686/api/v1/IngredientUsage/create
{
    "menuItemId": 3,
    "name" : "Thit heo",
    "quantityUsed" : 0.1
}

xem tất cả nguyên liệu và các món ăn
http://localhost:8686/api/v1/IngredientUsage/all

cập nhật nguyên liệu của món ăn
http://localhost:8686/api/v1/IngredientUsage/update

xóa nguyên liệu của món ăn
http://localhost:8686/api/v1/delete/{id}