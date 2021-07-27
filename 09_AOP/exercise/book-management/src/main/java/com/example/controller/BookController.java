package com.example.controller;

import com.example.exception.BookException;
import com.example.model.entity.Book;
import com.example.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping(value = "")
    public String showListBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/list";
    }

    //view
    @GetMapping("/view")
    public String showView(@RequestParam("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "view";
    }


    // mượn sách
    @GetMapping("/borrow")
    public String getBorrow(@RequestParam("id") Long id, Model model) throws BookException {
        Book book = bookService.findById(id);
        if (book.getQuantity() <= 0) {
            throw new BookException();
        }
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        model.addAttribute("books", bookService.findAll());
        return "/list";
    }

    //trả sách
    @GetMapping("/pay")
    public String goPay() {
        return "/pay";
    }

    @GetMapping("/payBook")
    public String payBook(@RequestParam("id") Long id, Model model) throws BookException {
        Book book = bookService.findById(id);
        if (book == null) {
            throw new BookException();
        }
        book.setQuantity(book.getQuantity() + 1);
        bookService.save(book);
        model.addAttribute("books", bookService.findAll());
        return "/list";
    }


    @ExceptionHandler(BookException.class)
    public String showErrorPage() {
        return "/error";
    }
}
