package ru.yulialyapushkina.library_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yulialyapushkina.library_project.service.AuthorService;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private  final AuthorService authorService;

    @GetMapping ("/authors")
    String getAuthorsView (Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }
}
