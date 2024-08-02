package ru.yulialyapushkina.library_project.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yulialyapushkina.library_project.dto.AuthorCreateDto;
import ru.yulialyapushkina.library_project.dto.AuthorDto;
import ru.yulialyapushkina.library_project.dto.AuthorUpdateDto;
import ru.yulialyapushkina.library_project.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorRestController {
    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById (@PathVariable ("id")Long id){

        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorByName (@RequestParam ("surname") String surname){
        return authorService.getAuthorBySurnameV1(surname);
    }
    @GetMapping("/author/v2")
    AuthorDto getAuthorByNameV2 (@RequestParam ("surname") String surname){
        return authorService.getAuthorBySurnameV2(surname);
    }
    @GetMapping("/author/v3")
    AuthorDto getAuthorByNameV3 (@RequestParam ("surname") String surname){
        return authorService.getAuthorBySurnameV3(surname);
    }

    @PostMapping("/author/create")
    AuthorDto createAuthor (@RequestBody AuthorCreateDto authorCreateDto){
        return authorService.createAuthor(authorCreateDto);
    }
    @PutMapping ("author/update")
    AuthorDto updateAuthor (@RequestBody AuthorUpdateDto authorUpdateDto){
        return authorService.updateAuthor(authorUpdateDto);
    }

    @DeleteMapping("/author/delete/{id}")
    void deleteAuthor (@PathVariable  ("id") Long id){
        authorService.deleteAuthor(id);
    }
}