package fa.training.service;

import fa.training.entity.Book;

public interface BookService {
    public void saveBook(Book book);

    public void deleteBook(int id);

    public Book findBookById(int id);

}
