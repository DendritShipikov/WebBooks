create table Books (
    id serial primary key,
    title varchar(100),
    pages integer
);

create table Authors (
    id serial primary key,
    name varchar(100)
);

create table BooksToAuthors (
    BookId Integer references Books,
    AuthorId Integer references Authors
);