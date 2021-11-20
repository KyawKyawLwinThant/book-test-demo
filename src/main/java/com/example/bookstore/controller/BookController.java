package com.example.bookstore.controller;


import com.example.bookstore.service.BookService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import javax.websocket.server.PathParam;
import java.io.Closeable;

@Controller
public class BookController {

    Closeable closeable;

    @Autowired
    private BookService bookService;


    @ResponseBody
    @GetMapping("/test")
    public String test(){
        bookService.createDB();
        return "success";
    }
    @GetMapping("/books")
    public String showAllBooks(Model model){
        model.addAttribute("books",bookService.findAllBooks());
        return "show-books";
    }
    //http://localhost:8080/books/7
 /*   @GetMapping("/books/{id}")
    public String goDetails(Model model, @PathVariable int id){
        model.addAttribute("book",bookService.findBooksById(id));
        return "book-details";
    }

  */
    //http://localhost:8080/books/book?id=4
    @GetMapping("/books/book")
    public String goDetails(Model model, @PathParam("id")int id){
        model.addAttribute("book",bookService.findBooksById(id));
        return "book-details";
    }



}
