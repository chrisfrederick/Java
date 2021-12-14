package com.codingdojo.loginandregistration.services;

import com.codingdojo.loginandregistration.models.Book;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.repositories.BookRepo;
import com.codingdojo.loginandregistration.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;

    public BookService(BookRepo bookRepo, UserRepo userRepo){
        this.bookRepo=bookRepo;
        this.userRepo=userRepo;
    }

    public List<Book> allBooks(){
        return bookRepo.findAll();
    }

    public Book createBook(Book book){
        return bookRepo.save(book);
    }

    public List<User> allUsers(){
        return userRepo.findAll();
    }

    public Book findBookById(Long id){
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else{
            return null;
        }
    }


    public List<User> findAll(){
        return userRepo.findAll();
    }
}
