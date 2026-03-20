# Product Management API

A RESTful API for managing products, built with Spring Boot as part of my backend development learning journey.

## 🚀 Features

- **CRUD Operations**: Create, Read, Update, Delete products
- **Pagination & Sorting**: Efficiently handle large datasets
- **Image Upload**: Upload and retrieve product images
- **Category Filtering**: Filter products by category
- **Input Validation**: Robust validation using Bean Validation
- **Exception Handling**: Global exception handling with meaningful error messages

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**
- **Apache Commons CSV** (for future CSV import feature)

## 📋 Prerequisites

- JDK 17 or higher
- MySQL 8.0
- Maven 3.6+

## ⚙️ Setup & Installation

1. **Clone the repository**
```bash
git clone <your-repo-url>
cd product-api
```

2. **Configure MySQL Database**

Create database:
```sql
CREATE DATABASE product_db;
```

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Run the application**
```bash
mvn spring-boot:run
```

Application will start on `http://localhost:8080`

## 📚 API Endpoints

### Product Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create new product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |
| GET | `/api/products/category/{category}` | Get products by category |

### Pagination

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products/paginated` | Get paginated products |

**Query Parameters:**
- `page` (default: 0) - Page number
- `size` (default: 20) - Items per page
- `sortBy` (default: name) - Field to sort by
- `direction` (default: asc) - Sort direction (asc/desc)

**Example:**
```
GET /api/products/paginated?page=0&size=10&sortBy=price&direction=desc
```

### Image Upload

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/products/with-image` | Create product with image |
| POST | `/api/products/{id}/image` | Upload image to existing product |
| GET | `/api/products/{id}/image` | Get product image |

## 📝 Sample Request/Response

### Create Product

**Request:**
```json
POST /api/products
Content-Type: application/json

{
  "name": "iPhone 15 Pro",
  "price": 129900,
  "category": "Electronics",
  "stock": 50
}
```

**Response:**
```json
{
  "id": 1,
  "name": "iPhone 15 Pro",
  "price": 129900,
  "category": "Electronics",
  "stock": 50,
  "imageUrl": null
}
```

### Paginated Response

**Request:**
```
GET /api/products/paginated?page=0&size=5&sortBy=price&direction=asc
```

**Response:**
```json
{
  "content": [
    {
      "id": 1,
      "name": "Product 1",
      "price": 100,
      "category": "Electronics",
      "stock": 50
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 5
  },
  "totalElements": 25,
  "totalPages": 5,
  "first": true,
  "last": false
}
```

## 🏗️ Project Structure
```
src/main/java/
├── model/           # Entity classes
├── repository/      # JPA Repositories
├── service/         # Business logic layer
├── controller/      # REST Controllers
├── exception/       # Custom exceptions & handlers
└── dto/             # Data Transfer Objects (if applicable)
```

## 🎯 Architecture

This API follows the **3-tier architecture pattern**:

1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic
3. **Repository Layer**: Database access using Spring Data JPA

## ✅ Validation Rules

- **Name**: Not blank, 2-100 characters
- **Price**: Must be positive
- **Category**: Not blank
- **Stock**: Must be zero or positive

## 🔮 Future Enhancements

- [ ] CSV Import/Export functionality
- [ ] Authentication & Authorization
- [ ] Product search with filters
- [ ] Inventory management
- [ ] Deployment to cloud platform

## 📖 What I Learned

This project helped me understand:
- RESTful API design principles
- Spring Boot framework essentials
- 3-tier architecture implementation
- JPA and database relationships
- Exception handling patterns
- Pagination strategies
- File upload handling
- Input validation with Bean Validation

## 👨‍💻 Author

Built as part of my Spring Boot learning journey.

---

**Note:** This is a learning project built to demonstrate Spring Boot fundamentals and REST API development.