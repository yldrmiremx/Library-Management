package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.book;
import com.example.librarymanagement.service.BookService;
import org.springframework.web.bind.annotation.*;
import com.example.librarymanagement.dto.BookRequestDto;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET - tüm kitapları getir
    @GetMapping
    public List<book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // POST - kitap ekle
    @PostMapping
    public book addBook(@Valid @RequestBody BookRequestDto dto) {
        return bookService.saveBook(dto);
    }

    // DELETE - kitap sil
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/test-rollback")
    public book testRollback(@Valid @RequestBody BookRequestDto dto) {
        return bookService.saveBookWithError(dto);
    }

    @PutMapping("/{id}")
    public book updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDto dto) {
        return bookService.updateBook(id, dto);
    }

    // Başlığa göre arama
    @GetMapping("/search")
    public List<book> searchBooks(@RequestParam String title) {
        return bookService.searchBooks(title);
    }

    // Duruma göre listeleme
    @GetMapping("/available/{available}")
    public List<book> getAvailableBooks(@PathVariable boolean available) {
        return bookService.getAvailableBooks(available);
    }

    // Kitap var mı kontrolü
    @GetMapping("/exists")
    public boolean existsBook(@RequestParam String title) {
        return bookService.existsBook(title);
    }

    // Son 5 kitap
    @GetMapping("/latest")
    public List<book> latestBooks() {
        return bookService.latestBooks();
    }
}