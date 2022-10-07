
insert into person values (1, 'john', '0892008141');
insert into person (id, name, phone) values (2, 'doe', '0892008142');
insert into person (id, name, phone) values (3, 'james', '0892008143');
--
--
insert into category (id, category_name) values (1, 'Fantasy');
insert into category (id, category_name) values (2, 'Sci-Fi');
insert into category (id, category_name) values (3, 'Mystery');
insert into category (id, category_name) values (4, 'Thriller');
insert into category (id, category_name) values (5, 'Romance');

--
insert into users values (1,'Member',1);
insert into users values (2,'Member',3);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('978-3-16-148','The Lord of the rings', 'fiction', 'some-random', 'English', 260, true);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('978-3-16-122','Game of thrones', 'fiction', 'some-random', 'English', 310, true);

insert into book_categories values (1,1);
insert into book_categories values (1,4);
insert into book_categories values (2,1);
insert into book_categories values (2,4);
insert into book_categories values (2,5);
--
--

