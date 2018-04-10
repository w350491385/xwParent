package com.xw.api.book.impl;

import com.xw.api.book.BookApiService;
import com.xw.server.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookApiServiceImpl implements BookApiService {

    @Autowired
    private BookService bookService;

    @Override
    public int add(String sessionid,int userId, int type, String desc) {
        int i = 1/0;
        return bookService.addBook(desc,type,userId);
    }
}
