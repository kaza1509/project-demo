package fa.training.repository;

import fa.training.entity.Book;

import java.util.List;

public interface BookRepository {

    /**
     * Find all book in database
     * @return list off book
     */
    public List<Book> findByAllBooks();

    /**
     * Save include save and update to database
     * save new book if not include id
     * update a book if include id
     *
     * @param book book object
     * @return status successful 1 or 0
     */
    public int saveBook(Book book);

    /**
     * Delete a book exist in database
     *
     * @param id book's id
     * @return status successful 1 or 0
     */
    public int deleteBookById(int id);

    /**
     * Find a book exist in database by id
     *
     * @param id book's id
     * @return status successful 1 or 0
     */
    public Book findBookById(int id);
    /**
     * Many other function continues
     * ...
     */
}
