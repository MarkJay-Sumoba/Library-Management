package com.jac.springboot.librarymanagement.service;

import com.jac.springboot.librarymanagement.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    void delete(int id);
    List<Book> search(String keyword);
}
