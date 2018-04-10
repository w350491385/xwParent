package com.xw.server.book.impl;

import com.xw.com.xw.dao.book.BookDao;
import com.xw.server.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public int addBook(String desc, int type, int userId) {
        return bookDao.add(userId,type,desc);
    }
}
