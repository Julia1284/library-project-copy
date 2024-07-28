package ru.yulialyapushkina.library_project.service;

import ru.yulialyapushkina.library_project.dto.AuthorCreateDto;
import ru.yulialyapushkina.library_project.dto.AuthorDto;
import ru.yulialyapushkina.library_project.dto.AuthorUpdateDto;

public interface AuthorService {
    AuthorDto getAuthorById (Long id);
    AuthorDto getAuthorBySurnameV1 (String surname);
    AuthorDto getAuthorBySurnameV2 (String surname);
    AuthorDto getAuthorBySurnameV3 (String surname);

    AuthorDto createAuthor (AuthorCreateDto authorCreateDto);
    AuthorDto updateAuthor (AuthorUpdateDto authorUpdateDto);

    void deleteAuthor (Long id);
}
