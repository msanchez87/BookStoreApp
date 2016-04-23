package com.bookstore.process;

import com.bookstore.entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebService;

@Stateless
@LocalBean
@WebService
public class BookFacade extends AbstractFacade<Book, Long> {

    public BookFacade() {
        super(Book.class);
    }

    public List<Book> finAll() {
        return super.findAll();
    }

}
