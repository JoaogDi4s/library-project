package com.library.libraryproject.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // o Spring gera o SQL a partir do nome do método
    List<Book> findByGenre(String genre);
}