package ru.yulialyapushkina.library_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yulialyapushkina.library_project.service.BookService;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
//    @PreAuthorize("hasAutority('ADMIN')")
    String getBooksView(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/book/v2")
    String getBookByName(Model model, @RequestParam("name") String name) {
        model.addAttribute("book", bookService.getByNameV2(name));
        return  "book";
    }
}


