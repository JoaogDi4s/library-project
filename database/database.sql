-- creating tables for library database --
create table book (
    id bigserial primary key,
    title varchar(100) not null,
    author varchar(100) not null,
    year int not null,
    genre varchar(50) not null
);

create table member (
    id bigserial primary key,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(15) not null
);

create table member_book (
    member_id bigint not null references member(id) on delete cascade,
    book_id bigint not null references book(id) on delete cascade,
    has_read boolean not null default false,
    primary key (member_id, book_id)
);

-- inserting data into schema --
insert into book (title, author, year, genre) values
    ('Clean Code', 'Robert C. Martin', 2008, 'Software Engineering'),
    ('The Pragmatic Programmer', 'David Thomas, Andrew Hunt', 1999, 'Software Engineering'),
    ('Refactoring', 'Martin Fowler', 1999, 'Software Engineering'),
    ('Design Patterns', 'Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides', 1994, 'Software Design'),
    ('Eloquent JavaScript', 'Marijn Haverbeke', 2018, 'Programming'),
    ('You Don''t Know JS Yet', 'Kyle Simpson', 2020, 'Programming'),
    ('Head First Java', 'Kathy Sierra, Bert Bates', 2005, 'Programming'),
    ('Cracking the Coding Interview', 'Gayle Laakmann McDowell', 2015, 'Interview Preparation');

insert into member (name, email, phone) values
    ('Ana Souza', 'ana.souza@exemplo.com', '15999990001'),
    ('Bruno Lima', 'bruno.lima@exemplo.com', '15999990002'),
    ('Carla Mendes', 'carla.mendes@exemplo.com', '15999990003');

insert into member_book (member_id, book_id, has_read)
select m.id, b.id, x.has_read
from (values
    ('ana.souza@exemplo.com', 'Clean Code', true),
    ('ana.souza@exemplo.com', 'Refactoring', false),
    ('bruno.lima@exemplo.com', 'Eloquent JavaScript', true),
    ('bruno.lima@exemplo.com', 'Head First Java', true),
    ('carla.mendes@exemplo.com', 'The Pragmatic Programmer', false),
    ('carla.mendes@exemplo.com', 'Clean Code', true)
) as x(email, title, has_read)
join member m on m.email = x.email
join book b on b.title = x.title;

-- test queries
select m.name, b.title, mb.has_read
from member_book mb
join member m on m.id = mb.member_id
join book b on b.id = mb.book_id
order by m.name, b.title;
