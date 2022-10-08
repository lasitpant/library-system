
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

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('978-3-16-148','The Lord of the rings', 'fiction', 'some-random', 'English', 260, false);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('978-3-16-122','Game of thrones', 'fiction', 'some-random', 'English', 310, false);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('178-3-17-102','Harry Potter', 'fiction', 'some-random', 'English', 410, true);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('128-3-17-802','Prince of Persia', 'fiction', 'some-random', 'English', 110, true);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('228-3-17-502','Half Blood Prince', 'fiction', 'some-random', 'English', 110, true);

insert into book (isbn,title,subject,publisher,language,pages,availability)
values ('328-3-17-702','Sherlock Holmes', 'fiction', 'some-random', 'English', 110, true);

insert into book_categories values (1,1);
insert into book_categories values (1,4);
insert into book_categories values (2,1);
insert into book_categories values (2,4);
insert into book_categories values (2,5);

insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ('2022-10-08 18:58:19.517','2022-10-13 18:58:19.517',1,1);
insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ('2022-10-07 18:58:19.517','2022-10-12 18:58:19.517',1,2);
-- insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ('2022-10-06 18:58:19.517','2022-10-11 18:58:19.517',1,3);
-- insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ();
-- insert into books_loaned (borrowed_date,due_date,user_id,book_id) values ();
--
--

