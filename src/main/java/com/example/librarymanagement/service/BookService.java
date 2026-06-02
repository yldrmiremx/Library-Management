package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.book;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.dto.BookRequestDto;
import org.springframework.stereotype.Service;
import com.example.librarymanagement.exception.BookNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }

    public book saveBook(book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<book> searchBooks(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<book> getAvailableBooks(boolean available) {
        return bookRepository.findByAvailable(available);
    }

    public boolean existsBook(String title) {
        return bookRepository.existsByTitle(title);
    }

    public List<book> latestBooks() {
        return bookRepository.findTop5ByOrderByIdDesc();
    }
    public book saveBook(BookRequestDto dto) {

        book book = new book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPageCount(dto.getPageCount());
        book.setAvailable(dto.isAvailable());

        return bookRepository.save(book);
    }
    public book updateBook(Long id, BookRequestDto dto) {

        book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Kitap bulunamadı"));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPageCount(dto.getPageCount());
        book.setAvailable(dto.isAvailable());

        return bookRepository.save(book);
    }
    @Transactional
    public book saveBookWithError(BookRequestDto dto) {

        book book = new book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPageCount(dto.getPageCount());
        book.setAvailable(dto.isAvailable());

        bookRepository.save(book);

        throw new RuntimeException("Test hatası oluştu, işlem geri alındı");
    }
}