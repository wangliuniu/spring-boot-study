package com.spring.boot.quickstart.dao;

import com.spring.boot.quickstart.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> getBook(){
        List<Book> books=new ArrayList<>();
        books.add(new Book(1,"springboot",30.2));
        books.add(new Book(1,"spring",30.2));
        books.add(new Book(1,"spboot",30.3));
        return books;
    }
}
