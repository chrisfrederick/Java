package com.codingdojo.mvc.controllers;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/{bookId}")
    public String getBookById(
            Model model,
            @PathVariable(value = "bookId")Long bookID
            ){
        Book book = bookService.findBook(bookID);
        List<Book> books = bookService.allBooks();
        model.addAttribute("book", book);
        model.addAttribute("books", books);
        return "index.jsp";
    }
}
