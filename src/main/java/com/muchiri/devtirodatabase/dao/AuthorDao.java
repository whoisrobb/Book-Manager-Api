package com.muchiri.devtirodatabase.dao;

import com.muchiri.devtirodatabase.domain.Author;

import java.util.Optional;

public interface AuthorDao {

    Optional<Author> getAuthorByBookIsbn(String isbn);

}
