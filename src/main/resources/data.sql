
insert into person (name, phone) values ('john', '0892008141');
insert into person (name, phone) values ('doe', '0892008142');
insert into person (name, phone) values ('james', '0892008143');
--
--
insert into category (category_name) values ('Fantasy');
insert into category (category_name) values ('Sci-Fi');
insert into category (category_name) values ('Mystery');
insert into category (category_name) values ('Thriller');
insert into category (category_name) values ('Romance');

--
insert into users (person_id, account_type) values (1,'Member');
insert into users (person_id, account_type) values (3,'Member');

--1
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('978-3-16-148','The Lord of the rings', 'fiction', 'some-random', 'English', 260, false);
--2
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('978-3-16-122','Game of thrones', 'fiction', 'some-random', 'English', 310, false);
--3
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('178-3-17-102','Harry Potter', 'fiction', 'some-random', 'English', 410, false);
--4
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('128-3-17-802','Prince of Persia', 'fiction', 'some-random', 'English', 110, true);
--5
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('228-3-17-502','Half Blood Prince', 'fiction', 'some-random', 'English', 110, true);
--6
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('328-3-17-702','Sherlock Holmes', 'fiction', 'some-random', 'English', 110, true);
--7
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('328-3-17-521','Fantastic Beasts', 'fiction', 'some-random', 'English', 110, true);
--8
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('101-3-17-702','Gone Girl', 'Thriller', 'some-random', 'English', 110, true);
--9
insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('201-3-17-301','Girl with dragoon tatto', 'Thriller', 'some-random', 'English', 110, true);

insert into book_categories values (1,1);
insert into book_categories values (1,4);
insert into book_categories values (2,1);
insert into book_categories values (2,4);
insert into book_categories values (3,4);
insert into book_categories values (4,4);
insert into book_categories values (5,4);
insert into book_categories values (6,4);
insert into book_categories values (7,4);
insert into book_categories values (8,4);
insert into book_categories values (9,4);


insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ('2022-10-08 18:58:19.517','2022-10-13 18:58:19.517',2,1);
insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ('2022-10-07 18:58:19.517','2022-10-12 18:58:19.517',2,2);
insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ('2022-10-06 18:58:19.517','2022-10-11 18:58:19.517',2,3);
-- insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ();
-- insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ();
--
--

