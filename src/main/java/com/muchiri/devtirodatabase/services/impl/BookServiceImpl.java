package com.muchiri.devtirodatabase.services.impl;


import com.muchiri.devtirodatabase.dao.BookDao;
import com.muchiri.devtirodatabase.domain.Book;
import com.muchiri.devtirodatabase.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.listBooks();
    }
}
