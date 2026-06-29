# QLuser - User Management Microservice

`QLuser` (Quản lý User) là một dịch vụ thành phần (microservice) chịu trách nhiệm quản lý thông tin tài khoản, hồ sơ người dùng và phân quyền trong hệ thống, thuộc repository `Java-backend-study` (nhánh `microservice`).

Dự án này được xây dựng với mục tiêu **học tập, tìm hiểu sâu về công nghệ Java/Spring Boot** và thực hành cách thiết kế, phát triển một dịch vụ cốt lõi (Core Service) phục vụ cho kiến trúc hệ thống phân tán.

---

## 🚀 Mục Tiêu Học Tập & Nghiên Cứu
* **Quản lý thực thể (Entity Management):** Thực hành thiết kế cơ sở dữ liệu và xử lý các nghiệp vụ CRUD (Thêm, sửa, xóa, hiển thị) thông tin người dùng một cách tối ưu.
* **Tích hợp hệ thống phân tán:** Nghiên cứu cách dịch vụ `QLuser` đăng ký với Service Discovery và cung cấp dữ liệu định danh cho các dịch vụ khác thông qua API Gateway.
* **Bảo mật & Phân quyền cơ bản:** Tìm hiểu tư duy xác thực người dùng và phân chia vai trò (Role-based Authorization) trong môi trường Microservices.

---

## 🛠 Công Nghệ & Công Cụ Khảo Sát

* **Java**: Ngôn ngữ cốt lõi được sử dụng để tìm hiểu tư duy lập trình backend và xử lý logic nghiệp vụ.
* **Spring Boot**: Framework hỗ trợ đóng gói ứng dụng độc lập, cấu hình RESTful API nhanh chóng.
* **Spring Data JPA / Hibernate**: Công cụ ORM tương tác với hệ quản trị cơ sở dữ liệu (MySQL / PostgreSQL).
* **Spring Security / JWT (Định hướng tích hợp):** Tìm hiểu cơ chế mã hóa mật khẩu (BCrypt) và tạo/xác thực token định danh.
* **Spring Cloud Client**: Giúp dịch vụ tự động kết nối và đăng ký thông tin với Discovery Server (Eureka).

---

## 📐 Kiến Trúc & Luồng Xử Lý Chính

Trong hệ thống microservices, `QLuser` đóng vai trò là nền tảng cung cấp thông tin định danh:

1.  **Đăng ký & Đăng nhập:** Tiếp nhận yêu cầu từ API Gateway, kiểm tra thông tin dưới Database, mã hóa và xác thực.
2.  **Cung cấp thông tin nội bộ:** Khi các dịch vụ khác (ví dụ: Order, Product) cần kiểm tra thông tin khách hàng, chúng sẽ thực hiện gọi liên dịch vụ (Inter-service communication) tới `QLuser`.

### Cấu trúc mã nguồn cơ bản (Định hướng Spring Boot chuẩn):
```text
QLuser/
├── src/main/java/com/example/qluser/
│   ├── controller/   # Tiếp nhận và điều hướng các HTTP Request (REST API)
│   ├── service/      # Xử lý logic nghiệp vụ (Kiểm tra trùng lặp email, mã hóa mật khẩu...)
│   ├── repository/   # Giao tiếp với database bằng Spring Data JPA
│   ├── entity/       # Định nghĩa các mô hình dữ liệu (User, Role...)
│   └── dto/          # Data Transfer Object - Tối ưu hóa dữ liệu trả về cho client
└── pom.xml / build.gradle
```

# Nhật Ký Phát Triển & Bài Học Rút Ra
- Thấu hiểu cách tổ chức mã nguồn theo mô hình 3 lớp (Controller - Service - Repository) chuẩn trong Java Backend.

- Làm quen với việc xử lý ngoại lệ tập trung (Global Exception Handling) để trả về các mã lỗi rõ ràng cho phía Front-end hoặc Gateway.

- Nhận thức được tầm quan trọng của việc bảo mật dữ liệu nhạy cảm (như mật khẩu người dùng) trong quá trình lưu trữ và truyền tải.
