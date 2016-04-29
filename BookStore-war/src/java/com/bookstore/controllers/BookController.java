/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.entity.Book;
import com.bookstore.process.BookFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ssanchez
 */
@Named
@ViewScoped
public class BookController implements java.io.Serializable {

    @Inject
    private BookFacade bookFacade;

    private Book current;

    @PostConstruct
    public void initialize() {
        this.current = new Book();
    }

    public Book getCurrent() {
        return current;
    }

    public void setCurrent(Book current) {
        this.current = current;
    }

    public void save() {
        bookFacade.create(current);
    }

    public void delete() {
        bookFacade.delete(current);
    }

    public List<Book> findAll() {
        return bookFacade.findAll();
    }

}
