package com.muchiri.devtirodatabase.dao.impl;

import com.muchiri.devtirodatabase.dao.BookDao;
import com.muchiri.devtirodatabase.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> listBooks() {
        return jdbcTemplate.query("select isbn, title from books", (ResultSet rs, int rowNum) -> {
                    return Book.builder()
                            .isbn(rs.getString("isbn"))
                            .title(rs.getString("title"))
                            .build();
                });
    }
}
