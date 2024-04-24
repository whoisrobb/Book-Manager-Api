DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

--CREATE TABLE 'authors' {
--    'id' bigInt DEFAULT nextval('authors_id_seq') NOT NULL,
--    'name' text,
--    'age' integer,
--    CONSTRAINT 'authors_pkey' PRIMARY KEY ('id')
--};
--
--CREATE TABLE 'books' {
--    'isbn' text NOT NULL,
--    'title' text,
--    'author_id' bigInt,
--    CONSTRAINT 'book_pkey' PRIMARY KEY ('isbn'),
--    CONSTRAINT 'fk_author' FOREIGN KEY(author_id)
--    REFERENCES author_id
--};

CREATE TABLE IF NOT EXISTS authors
(
    id                     BIGINT PRIMARY KEY AUTO_INCREMENT,
    name                   VARCHAR(255) NOT NULL UNIQUE,
    age                    INTEGER
);

CREATE TABLE IF NOT EXISTS books
(
    isbn          VARCHAR(255) PRIMARY KEY,
    title         VARCHAR(255),
    author_id     BIGINT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES authors (id)
);
