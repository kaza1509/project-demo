package fa.training.repository.impl;

import fa.training.entity.Book;
import fa.training.repository.BookRepository;
import fa.training.util.DBContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl extends DBContext implements BookRepository {
    @Override
    public List<Book> findByAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM Book";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = Book.builder()
                        .bookId(rs.getInt(1))
                        .bookName(rs.getString(2))
                        .authorName(rs.getString(3))
                        .publishDate(rs.getString(4))
                        .build();
                list.add(book);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int createBook(Book book) {
        String sql = "INSERT INTO [Book] ([book_name],[author_name],[publish_date])VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, book.getBookName());
            ps.setString(2, book.getAuthorName());
            ps.setString(3, book.getPublishDate());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int updateBook(Book book) {
        String sql = "UPDATE [Book] SET [book_name] = ?\n" +
                "      ,[author_name] = ?\n" +
                "      ,[publish_date] = ?\n" +
                " WHERE book_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, book.getBookName());
            ps.setString(2, book.getAuthorName());
            ps.setString(3, book.getPublishDate());
            ps.setInt(4, book.getBookId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int saveBook(Book book) {
        if(book.getBookId() == 0)
            return createBook(book);
        return updateBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return 0;
    }

    @Override
    public Book findBookById(int id) {
        String sql = "SELECT * FROM Book WHERE book_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = Book.builder()
                        .bookId(rs.getInt(1))
                        .bookName(rs.getString(2))
                        .authorName(rs.getString(3))
                        .publishDate(rs.getString(4))
                        .build();
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        BookRepository repository = new BookRepositoryImpl();
        System.out.println(repository.findByAllBooks());
//        Book book = Book.builder()
//                .bookId(2)
//                .bookName("bookName")
//                .authorName("authorName")
//                .publishDate("20201111")
//                .build();
//        System.out.println(repository.saveBook(book));
        System.out.println(repository.findBookById(2));
    }
}
