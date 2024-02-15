package com.jac.springboot.librarymanagement.controller;


import com.jac.springboot.librarymanagement.entity.Book;
import com.jac.springboot.librarymanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // Listing all books
    @GetMapping("/list")
    public String listAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "Book/bookList";
    }

    // Adding a book
    @GetMapping("/add")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "Book/bookForm";
    }

    // saving book add/edit
    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Book/bookForm";
        }
        bookService.save(book);
        return "redirect:/books/list";
    }

    // Editing a book
    @GetMapping("/edit")
    public String showEditBookForm(@RequestParam("bookId") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "Book/bookForm";
    }

    // Delete a book
    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id) {
        bookService.delete(id);
        return "redirect:/books/list";
    }

    // Search for a book
    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        List<Book> searchResults = bookService.search(keyword);
        model.addAttribute("books", searchResults);
        return "Book/bookList";
    }

}
