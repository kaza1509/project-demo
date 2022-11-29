package fa.training.controller;

import fa.training.service.BookService;
import fa.training.service.impl.BookServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteBookController", value = "/delete-book")
public class DeleteBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService service = new BookServiceImpl();

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        service.deleteBook(bookId);

        response.sendRedirect("list-book");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
