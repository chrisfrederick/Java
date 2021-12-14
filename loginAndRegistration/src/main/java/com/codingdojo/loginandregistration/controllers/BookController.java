package com.codingdojo.loginandregistration.controllers;


import com.codingdojo.loginandregistration.models.Book;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.BookService;
import com.codingdojo.loginandregistration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

//    @GetMapping
//    public String allBooks(Model model) {
//        List<Book> books = bookService.allBooks();
//        model.addAttribute("books", books);
//        return "welcome.jsp";
//    }

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("newBook") Book book, Model model, HttpSession session) {
        Long userId = (Long)session.getAttribute("user_id");
        model.addAttribute("userId", userId);
        return "newBook.jsp";
    }

    @GetMapping("/books/{id}")
    public String getBookById(Model model, @PathVariable(value = "id")Long id, HttpSession session){
        Book book = bookService.findBookById(id);
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("book", book);
        return "bookDetail.jsp";
    }


    @PostMapping("/create/book")
    public String createNew(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            System.out.println(result);
            Long userId = (Long)session.getAttribute("user_id");
            model.addAttribute("userId", userId);
            return "newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/welcome";
        }
    }

}

