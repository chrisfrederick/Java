package com.codingdojo.mvc.controllers;


import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookControllerAPI {
    private final BookService bookService;
    public BookControllerAPI(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> index(){
        return bookService.allBooks();
    }

    @PostMapping("/api/books")
    public Book create(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description")String description,
            @RequestParam(value = "language")String language,
            @RequestParam(value = "numberOfPages") Integer pages
    ){
        Book book = new Book(title, description, language, pages);
        return bookService.createBook(book);
    }

    @GetMapping("/api/books/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        Book book = bookService.findBook(id);
        return book;
    }

    @PutMapping(value = "/api/books/{id}")
    public Book update(
            @PathVariable("id")Long id,
            @RequestParam(value = "title")String title,
            @RequestParam(value = "description")String description,
            @RequestParam(value = "language")String language,
            @RequestParam(value = "numberOfPages")Integer pages
    ){
        Book book = new Book(title, description, language, pages);
        book.setId(id);
        book = bookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
    }

}
