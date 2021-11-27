package com.example.bookstore.controller;


import com.example.bookstore.service.BookService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import javax.websocket.server.PathParam;
import java.io.Closeable;

@Controller
public class BookController {



    @Autowired
    private BookService bookService;
    @Autowired
    private CartBean cartBean;


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

    @GetMapping("/books/add-to-cart/{id}")
    public String addToCart(@PathVariable int id){
        cartBean.addToBook(bookService.findBooksById(id));
        return "redirect:/books/book?id="+id;
    }

    @GetMapping("/books/cart-view")
    public String showCartView(Model model){
        model.addAttribute("cart",cartBean.getBooks());
        return "cart-view";
    }

    @ModelAttribute("cartSize")
    public Integer cartSize(){
        return cartBean.getBooks().size();
    }
    @ModelAttribute("totalPrice")
    public Double totalPrice(){
        return cartBean.getBooks()
                .stream()
                .mapToDouble(b -> b.getPrice())
                .sum();
    }

    @GetMapping("/books/clear-cart")
    public String clearCart(){
        cartBean.clear();
        return "redirect:/books/cart-view";
    }

    @GetMapping("/books/delete-cart/{id}")
    public String removeBookFromCart(@PathVariable int id){
        cartBean.removeBook(bookService.findBooksById(id));
        return "redirect:/books/cart-view";
    }



}
