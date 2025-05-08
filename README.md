# 🚗 GPS Tracking Microservice

Halo, saya Muhammad Irsyad Nataprawira, fresh graduate dari SMK yang sedang belajar menjadi backend developer.  
Proyek ini saya buat sebagai bagian dari **take-home test interview kerja**, dengan fokus membangun **microservice untuk melacak lokasi kendaraan secara realtime** menggunakan Spring Boot dan PostgreSQL.

---

## 📦 Fitur Utama

- Menyimpan data lokasi kendaraan (latitude, longitude, speed, timestamp)
- Mengambil lokasi terakhir kendaraan berdasarkan ID
- Menampilkan histori perjalanan kendaraan dalam waktu tertentu

---

## 🧰 Teknologi yang Digunakan

- **Java 22**
- **Spring Boot 3.4.5**
- **PostgreSQL**
- **Spring Data JPA (Hibernate)**
- **Maven**
- **Postman** (buat testing API)

---

## 🚀 Cara Menjalankan Project

### 1. Clone repo-nya

```bash
git clone https://github.com/username/gps-tracking-service.git
cd gps-tracking-service
```
### 2. Setup Database
   Buat database baru di PostgreSQL dengan nama gps_tracking

Edit file src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gps_tracking
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```
Ganti username dan password sesuai setting PostgreSQL pada device local.

### 3. Run Project
```bash
mvn clean install
mvn spring-boot:run
```

atau F5 pada parent directory ```/src/main/java/com.example.tracking_microservice/TrackingMicroServiceApplication```

API bisa diakses di http://localhost:8080

### 📬 Endpoint API

**POST	/api/gps**

**GET	/api/vehicles/{id}/last-location**

**GET	/api/vehicles/{id}/history?from=...&to=...**

Contoh Payload POST /api/gps
```json
{
  "vehicleId": 1,
  "latitude": -6.200000,
  "longitude": 106.816666,
  "speed": 45.5,
  "timestamp": "2025-05-08T12:00:00"
}
```

### 🧪 Testing dengan Postman
- Saya sudah buat file Postman Collection untuk mencoba semua endpoint.
- File-nya ada di dalam repo: postman_collection.json
- Tinggal import ke Postman dan bisa langsung dicoba.
