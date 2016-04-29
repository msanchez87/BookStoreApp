package com.bookstore.process;

import com.bookstore.entity.Book;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class BookFacade extends AbstractFacade<Book, Long> {

    public BookFacade() {
        super(Book.class);
    }

}
