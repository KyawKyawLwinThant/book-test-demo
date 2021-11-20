package com.example.bookstore.controller;


import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
