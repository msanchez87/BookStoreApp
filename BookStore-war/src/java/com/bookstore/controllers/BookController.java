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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private List<Book> books;

    @PostConstruct
    public void initialize() {
        this.current = new Book();
        this.books = bookFacade.findAll();
    }

    public List<Book> getBooks() {
        //return bookFacade.findAll();
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getCurrent() {
        return current;
    }

    public void setCurrent(Book current) {
        this.current = current;
    }

    public void save() {
        bookFacade.create(current);
        setCurrent(new Book());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Datos guardados"));
    }

    public void delete() {        
        bookFacade.delete(current);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se elimino el registro"));
    }

}
