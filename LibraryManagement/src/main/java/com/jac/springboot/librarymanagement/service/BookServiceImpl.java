package com.jac.springboot.librarymanagement.service;

import com.jac.springboot.librarymanagement.dao.BookRepository;
import com.jac.springboot.librarymanagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }

    @Override
    public List<Book> findAll() {

        return bookRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book;
        if(optionalBook.isPresent()){
            book = optionalBook.get();
        } else {
            throw new RuntimeException("Did not find Book id - " + id);
        }
        return book;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> search(String keyword) {
        return bookRepository.findByTitleContainingOrAuthorContaining(keyword, keyword);
    }
}
