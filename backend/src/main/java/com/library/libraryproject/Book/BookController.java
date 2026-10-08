package com.library.libraryproject.Book;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.create(book);
    }
}