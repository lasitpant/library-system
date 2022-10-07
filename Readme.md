Library system

Create a library system that is capable of adding new books, removing books and allowing members to loan/return a book. Each book should have an author, category and title.


Business rules

- no need to authenticate the user (we can assume they are members and are already authenticated)
- maximum number of books loaned at any time is 3 per user
- if a member has any outstanding loaned books, they cannot loan any more until all books returned.
- there is only 1 copy of each book
- each book can have more than one category

Users
- *Members*
  1. can register 
  2. can loan books
  3. can return books


- *Librarian*
    1. can add books
    2. can remove books
    3. can block members


