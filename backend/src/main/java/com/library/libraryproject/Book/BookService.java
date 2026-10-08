package com.library.libraryproject.Book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> listAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: " + id));
    }

    @Transactional
    @Valid 
    public Book create(Book book) {
        if (book.getYear() > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("O ano não pode ser maior que o atual.");
        }
        return repository.save(book);
    }
}