Library system

Create a library system that is capable of adding new books, removing books and allowing members to loan/return a book. Each book should have an author, category and title.


Business rules

- no need to authenticate the user (we can assume they are members and are already authenticated)
- maximum number of books loaned at any time is 3 per user
- if a member has any outstanding loaned books, they cannot loan any more until all books returned.
- there is only 1 copy of each book
- each book can have more than one category

Functionalities covered -

1. Maximum books a user loan i.e. 3, cannot loan more books
2. User needs to return the loaned book inorder to loan another book
3. User cannot loan the same book, also once book is loaned, any other user cannot loan it
4. User can return the book
5. Some Functionalities for books -
   1. Add books
   2. Delete books
   3. get by ID
   4. Search by title
   5. get all books


Coverage - 
1. Unit Tests covered
2. Dockerized the app 
3. H2 database used.
4. Postman collection


