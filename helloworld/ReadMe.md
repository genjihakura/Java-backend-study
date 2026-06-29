# Helloworld - Spring Framework Core Learning

`helloworld` là một dự án nền tảng (Base Project) nằm trong repository `Java-backend-study` (nhánh `spring`). 

Dự án này được xây dựng như một bước đệm đầu tiên, tập trung hoàn toàn vào việc **học tập, nghiên cứu và thấu hiểu các khái niệm cốt lõi của Spring Framework** (như Dependency Injection, Inversion of Control, Bean Lifecycle) và cách cấu hình một ứng dụng Spring Web truyền thống.

---

## 🚀 Mục Tiêu Học Tập & Nghiên Cứu
* **Thấu hiểu IoC & DI:** Thực hành cách Spring Container quản lý các đối tượng (Beans) và tự động tiêm các phụ thuộc (Dependency Injection) qua `@Component`, `@Service`, `@Autowired`,...
* **Làm quen cấu trúc Spring Web:** Tìm hiểu mô hình Request-Response, cách hoạt động của `DispatcherServlet` và cách tổ chức mã nguồn theo các layer chuẩn.
* **Cấu hình ứng dụng cơ bản:** Học cách quản lý cấu hình hệ thống (Environment profile, Port, Logs) thông qua file cấu hình của Spring.

---

## 🛠 Công Nghệ Sử Dụng

* **Java**: Ngôn ngữ cốt lõi được sử dụng để học tư duy lập trình backend hướng đối tượng.
* **Spring Boot (Spring Web)**: Sử dụng các tính năng cơ bản của hệ sinh thái Spring để tạo ứng dụng web độc lập, giảm thiểu cấu hình XML truyền thống.
* **Build Tool (Maven/Gradle)**: Quản lý các starter dependencies của Spring.

---

## 📐 Cấu Trúc Mã Nguồn

Thư mục được tổ chức theo cấu trúc phân lớp (Layered Architecture) tiêu chuẩn của một ứng dụng Spring:

```text
helloworld/
├── src/main/java/com/example/helloworld/
│   ├── controller/   # Tiếp nhận Request từ client và trả về dữ liệu (REST API)
│   ├── service/      # Xử lý logic nghiệp vụ cốt lõi của ứng dụng
│   ├── model/        # Định nghĩa các cấu trúc dữ liệu, đối tượng (POJO)
│   └── HelloworldApplication.java  # Lớp khởi chạy chính, kích hoạt Spring Context
├── src/main/resources/
│   └── application.properties       # Cấu hình thuộc tính của ứng dụng Spring
└── pom.xml / build.gradle          # Quản lý các thư viện Spring Starter
