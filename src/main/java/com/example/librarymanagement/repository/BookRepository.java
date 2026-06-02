package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<book, Long> {


    List<book> findByTitleContaining(String title);


    List<book> findByAvailable(boolean available);

    boolean existsByTitle(String title);

    List<book> findTop5ByOrderByIdDesc();
}