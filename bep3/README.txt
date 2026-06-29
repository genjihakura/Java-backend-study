#Bep3 - Microservices Learning Project

Thư mục `bep3` là một phần trong hành trình nghiên cứu và thử nghiệm kiến trúc **Microservices** thuộc repository `Java-backend-study` (nhánh `microservice`). Dự án này được xây dựng với mục tiêu chính là **học tập, nghiên cứu và tìm hiểu sâu về các công nghệ, hệ sinh thái xung quanh ngôn ngữ Java** và cách vận hành một hệ thống phân tán.

##Mục Tiêu Dự Án
* **Tìm hiểu công nghệ Java:** Áp dụng các kiến thức cốt lõi của Java và framework Spring Boot vào bài toán thực tế.
* **Kiến trúc Microservices:** Chia nhỏ hệ thống thành các dịch vụ độc lập (services), tìm hiểu cách chúng giao tiếp và phối hợp vận hành.
* **Làm quen với Ecosystem của Spring Cloud:** Thử nghiệm các công cụ hỗ trợ quản lý hệ thống phân tán.

---

##Công Nghệ & Công Cụ Sử Dụng

### 1. Core Tech Stack
* **Java**: Ngôn ngữ lập trình chính dùng để tìm hiểu cấu trúc và tư duy thiết kế hệ thống backend.
* **Spring Boot**: Framework hỗ trợ xây dựng các microservices nhanh chóng và độc lập.
* **Build Tool**: Maven / Gradle (Thay đổi tùy thuộc vào cấu hình thực tế của bạn).

### 2. Kiến Trúc Microservices (Spring Cloud)
* **Service Discovery (Eureka/Consul):** Quản lý và định danh tập trung các service.
* **API Gateway (Spring Cloud Gateway):** Cổng kết nối duy nhất, điều hướng request từ client đến các service tương ứng.
* **Inter-service Communication:** Tìm hiểu cách các service gọi nhau qua *REST Client (Feign Client)* hoặc xử lý bất đồng bộ qua *Message Broker*.
* **Configuration Management (Spring Cloud Config):** Quản lý cấu hình tập trung cho toàn bộ các dịch vụ.

### 3. Database & Caching
* **Relational Database:** MySQL / PostgreSQL (Kết hợp Spring Data JPA để thao tác với dữ liệu).
* **Caching:** Redis (Tìm hiểu tối ưu hiệu năng và giảm tải cho Database).

---

## 📐 Kiến Trúc Tổng Quan (Cấu trúc thư mục)

Thư mục `bep3` được tổ chức theo mô hình phân rã dịch vụ:

```text
bep3/
├── api-gateway/          # Cổng điều hướng và lọc request tập trung
├── discovery-server/     # Service Registry (Eureka Server) để định vị các dịch vụ
├── config-server/        # Quản lý tập trung file cấu hình (.properties/.yml)
├── [service-name-1]/     # Dịch vụ nghiệp vụ 1 (Ví dụ: user-service, product-service...)
├── [service-name-2]/     # Dịch vụ nghiệp vụ 2
└── README.md             # Tài liệu hướng dẫn dự án

# Nhật Ký Học Tập & Bài Học Rút Ra
- Dự án này được thực hiện với tinh thần thực hành để thấu hiểu công nghệ (Hands-on Learning):

- Hiểu được ưu và nhược điểm của kiến trúc Microservices so với Monolith (Kiến trúc nguyên khối).

- Biết cách xử lý bài toán bất đồng bộ, quản lý lỗi vòng lặp (Circuit Breaker) và bảo mật luồng đi của dữ liệu qua Gateway.

- Nâng cao tư duy tổ chức mã nguồn và cấu hình hệ thống một cách khoa học.
