package com.jac.springboot.librarymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

    // Instances
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    @NotNull(message = "Title is required")
    @Size(min = 1, message = "Title must have at least {min} character")
    private String title;
    @Column(name="author")
    @NotNull(message = "Author is required")
    @Size(min = 1, message = "Author must have at least {min} character")
    private String author;
    @Column(name="isbn")
    @NotNull(message = "ISBN is required")
    @Pattern(regexp = "\\d+", message = "ISBN must contain only numeric digits")
    private String isbn;
    @Column(name="status")
    private String status;

    //generate constructor
    public Book(int id, String title, String author, String isbn, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    public Book(String title, String author, String isbn, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    public Book() {
    }

    //generate setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{}";
    }
}
