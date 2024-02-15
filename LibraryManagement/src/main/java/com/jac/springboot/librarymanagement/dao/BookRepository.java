package com.jac.springboot.librarymanagement.dao;

import com.jac.springboot.librarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Integer> {
    List<Book> findAllByOrderByTitleAsc();

    List<Book> findByTitleContainingOrAuthorContaining(String keyword1, String keywords2);
}
