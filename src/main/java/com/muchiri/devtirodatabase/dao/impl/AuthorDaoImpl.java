package com.muchiri.devtirodatabase.dao.impl;

import com.muchiri.devtirodatabase.dao.AuthorDao;
import com.muchiri.devtirodatabase.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Author> getAuthorByBookIsbn(String isbn) {

        final SqlRowSet result = jdbcTemplate.queryForRowSet(
                "select a.id as id, a.name as name, a.age as age" +
                        "from authors a JOIN books b ON a.author_id = a.id" +
                        "where b.isbn = ?",
                isbn);

        if (result.next()) {
            return Optional.of(
                    Author.builder()
                    .id(result.getLong("id"))
                    .name(result.getString("name"))
                    .age(result.getInt("age"))
                    .build()
            );
        }

        return Optional.empty();
    }
}
