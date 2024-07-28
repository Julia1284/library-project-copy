package ru.yulialyapushkina.library_project.service;

import ru.yulialyapushkina.library_project.dto.BookCreateDto;
import ru.yulialyapushkina.library_project.dto.BookDto;
import ru.yulialyapushkina.library_project.dto.BookUpdateDto;

public interface BookService {
    BookDto getByNameV1 (String name);
    BookDto getByNameV2 (String name);
    BookDto getByNameV3 (String name);

    BookDto createBook (BookCreateDto bookCreateDto);
    BookDto updateBook (BookUpdateDto bookUpdateDto);
    void deleteBook (Long id);
}
