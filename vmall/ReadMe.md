# vmall - Microservices E-Commerce Project

`vmall` là một dự án giả lập hệ thống thương mại điện tử (E-Commerce) quy mô siêu nhỏ, được xây dựng trên kiến trúc **Microservices** thuộc repository `Java-backend-study` (nhánh `microservice`). 

Dự án được triển khai với mục tiêu chính là **nghiên cứu, tìm hiểu sâu về hệ sinh thái Java Backend, Spring Cloud** và cách giải quyết các bài toán đặc trưng của một hệ thống bán hàng phân tán (quản lý kho, đơn hàng, thanh toán, luồng dữ liệu...).

---

## 🚀 Mục Tiêu Nghiên Cứu & Học Tập
* **Làm chủ Spring Cloud Ecosystem:** Thực hành cấu hình và vận hành các thành phần cốt lõi của một hệ thống microservices.
* **Tư duy thiết kế cơ sở dữ liệu phân tán:** Tìm hiểu cách mỗi service sở hữu một database riêng biệt (Database-per-service) và cách chúng đồng bộ dữ liệu.
* **Xử lý bài toán E-Commerce:** Nghiên cứu luồng đi của một đơn hàng từ lúc đặt hàng, kiểm tra kho (inventory), cho đến khi hoàn tất.

## 🛠 Công Nghệ & Công Cụ Khảo Sát

### 1. Backend Core
* **Java**: Ngôn ngữ nền tảng để tìm hiểu cấu trúc dữ liệu, thuật toán và tư duy hướng đối tượng trong backend.
* **Spring Boot**: Framework chính để đóng gói các dịch vụ nghiệp vụ độc lập.

### 2. Hạ Tầng Microservices (Spring Cloud)
* **API Gateway**: Quản lý tập trung các luồng request từ phía client, phân quyền và định tuyến.
* **Discovery Server (Eureka)**: Quản lý vòng đời, đăng ký và phát hiện dịch vụ tự động.
* **Config Server**: Lưu trữ và đồng bộ cấu hình hệ thống tập trung.
* **Feign Client / RestTemplate**: Cơ chế giao tiếp đồng bộ giữa các microservices.

### 3. Lưu Trữ & Tối Ưu
* **Relational Database (MySQL/PostgreSQL)**: Lưu trữ dữ liệu có cấu trúc cho từng service (User, Product, Order).
* **Spring Data JPA / Hibernate**: Công cụ ORM giúp tương tác với database trực quan bằng Java.

---

## 📐 Kiến Trúc Các Service Trong `vmall`

Thư mục `vmall` được phân rã thành các module chức năng trọng tâm của một hệ thống e-commerce:

```text
vmall/
├── discovery-server/      # Eureka Server - Trung tâm điều phối dịch vụ
├── api-gateway/           # Cửa ngõ kiểm soát và điều hướng Request
├── config-server/         # Quản lý cấu hình tập trung cho toàn hệ thống
├── product-service/       # Quản lý danh mục, thông tin và biến thể sản phẩm
├── order-service/         # Xử lý quy trình đặt hàng, tính toán giỏ hàng
├── inventory-service/     # Quản lý số lượng tồn kho, kiểm tra trạng thái hàng
└── README.md
```
# Nhật Ký Học Tập (Key Takeaways)
- Qua việc xây dựng dự án vmall, các kiến thức cốt lõi đã thu hoạch được bao gồm:

- Hiểu sâu sắc cách tách biệt các domain nghiệp vụ (Domain-Driven Design cơ bản) trong một hệ thống bán hàng.

- Biết cách tối ưu hóa hiệu năng bằng cách tách dịch vụ Kho (inventory) ra khỏi dịch vụ Đơn hàng (order) để giảm tải khi có lượng truy cập lớn.

- Rèn luyện kỹ năng đọc log, trace lỗi giữa các dịch vụ phân tán khi xảy ra sự cố luồng đi của dữ liệu.
