package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<book, Long> {

    // Başlığa göre arama
    List<book> findByTitleContaining(String title);

    // Duruma göre filtreleme
    List<book> findByAvailable(boolean available);

    // Kitap var mı kontrolü
    boolean existsByTitle(String title);

    // İlk 5 kitabı getir
    List<book> findTop5ByOrderByIdDesc();
}