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
        if(!isOldBooks(book)){
            books.add(book);
        }
        return book;
    }

    private boolean isOldBooks(Books book) {
        boolean isExist=false;
        for(Books book1:books){
            if(book1.getId() == book.getId()){
                isExist=true;
                break;
            }
        }
        return isExist;
    }

    public void clear(){
        books.clear();
    }
}
