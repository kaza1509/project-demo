package fa.training.controller;

import fa.training.entity.Book;
import fa.training.service.BookService;
import fa.training.service.impl.BookServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateBookController", value = "/update-book")
public class UpdateBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("html/update-book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService service = new BookServiceImpl();

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");
        String publishDate = request.getParameter("publishDate");

        Book book = Book.builder()
                .bookId(bookId)
                .bookName(bookName)
                .authorName(authorName)
                .publishDate(publishDate)
                .build();

        service.saveBook(book);

        response.sendRedirect("list-book");
    }
}
