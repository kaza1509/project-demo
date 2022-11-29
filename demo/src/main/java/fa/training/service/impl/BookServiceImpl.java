package fa.training.service.impl;

import fa.training.entity.Book;
import fa.training.repository.BookRepository;
import fa.training.repository.impl.BookRepositoryImpl;
import fa.training.service.BookService;

public class BookServiceImpl implements BookService {
    private BookRepository repository = new BookRepositoryImpl();

    @Override
    public void saveBook(Book book) {
        repository.saveBook(book);
    }

    @Override
    public void deleteBook(int id) {
        repository.deleteBookById(id);
    }

    @Override
    public Book findBookById(int id) {
        Book book = repository.findBookById(id);
        return book;
    }
}
