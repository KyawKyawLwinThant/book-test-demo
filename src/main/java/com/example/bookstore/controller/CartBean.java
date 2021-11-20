package com.example.bookstore.controller;


import com.example.bookstore.entities.Books;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CartBean {

    private List<Books> books=new ArrayList<>();


    public List<Books> getBooks() {
        return books;
    }

    public Books addToBook(Books book){
        books.add(book);
        return book;
    }

    public void clear(){
        books.clear();
    }
}
