package com.codingdojo.mvc.controllers;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "new.jsp";
    }

    @PostMapping("/books")
    public String create(
            @Valid
            @ModelAttribute("book") Book book, BindingResult result){
        if(result.hasErrors()){
            return "new.jsp";
        }else{
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/books/{bookId}")
    public String getBookById(
            Model model,
            @PathVariable(value = "bookId")Long bookID
            ){
        Book book = bookService.findBook(bookID);
        model.addAttribute("book", book);
        return "index.jsp";
    }

    @GetMapping("/books")
    public String index(Model model){
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books.jsp";
    }
}
