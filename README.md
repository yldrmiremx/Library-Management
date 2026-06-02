Library Management System
Proje Hakkında
Bu proje, Spring Boot kullanılarak geliştirilmiş bir Kütüphane Otomasyonu REST API uygulamasıdır.
Projenin amacı kitap kayıtlarını yönetmek, CRUD işlemlerini gerçekleştirmek, veri doğrulama yapmak ve kullanıcı yetkilendirmesi sağlamaktır.
Kullanılan Teknolojiler
Java 17
Spring Boot
Spring Data JPA
Microsoft SQL Server
Spring Security
Lombok
Validation
DTO Pattern
Maven
Postman
Proje Mimarisi
Projede katmanlı mimari kullanılmıştır.
Entity
Veritabanındaki tabloları temsil eder.
Repository
Veritabanı işlemlerini gerçekleştirir.
Service
İş mantığının bulunduğu katmandır.
Controller
HTTP isteklerini karşılar.
DTO
Veri transfer işlemleri için kullanılmıştır.
Validation
Kullanıcıdan gelen verilerin doğruluğunu kontrol eder.
Global Exception Handler
Hataların merkezi olarak yönetilmesini sağlar.
Spring Security
Kullanıcı doğrulama ve yetkilendirme işlemlerini gerçekleştirir.
Transaction Management
Hata durumunda işlemlerin geri alınmasını sağlar.
API Endpointleri
Kitap Listeleme
GET /books
Kitap Ekleme
POST /books
Kitap Güncelleme
PUT /books/{id}
Kitap Silme
DELETE /books/{id}
Son Eklenen Kitapları Listeleme
GET /books/latest
Kitap Arama
GET /books/search
Güvenlik
Projede Spring Security kullanılmıştır.
Kullanıcı Rolleri:
USER
ADMIN
ADMIN kullanıcıları kitap ekleme, güncelleme ve silme işlemlerini gerçekleştirebilir.
Veritabanı
Microsoft SQL Server kullanılmıştır.
Veritabanı adı:
librarydb
Geliştirici
İrem Yıldırım
Ders
Orta Düzey Programlama
Sonuç
Bu proje kapsamında Spring Boot ile REST API geliştirme, katmanlı mimari, DTO, Validation, Exception Handling, Spring Security ve SQL Server entegrasyonu uygulanmıştır.
