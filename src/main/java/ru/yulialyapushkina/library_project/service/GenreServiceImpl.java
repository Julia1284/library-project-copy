package ru.yulialyapushkina.library_project.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yulialyapushkina.library_project.dto.AuthorDto;
import ru.yulialyapushkina.library_project.dto.BookDto;
import ru.yulialyapushkina.library_project.dto.GenreDto;
import ru.yulialyapushkina.library_project.entities.Author;
import ru.yulialyapushkina.library_project.entities.Genre;
import ru.yulialyapushkina.library_project.repositories.AuthorRepository;
import ru.yulialyapushkina.library_project.repositories.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl  implements GenreService{
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDto(genre);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GenreDto convertToDto (Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .name(book.getName())
                        .id(book.getId())
                        .authors(book.getAuthors().stream()
                                .map(author -> AuthorDto.builder()
                                        .id(author.getId())
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .build()).toList())
                        .build()).toList();

       return  GenreDto.builder()
               .books(bookDtoList)
               .id(genre.getId())
               .name(genre.getName())
               .build();
    }
}
