package ru.yulialyapushkina.library_project.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.yulialyapushkina.library_project.dto.AuthorDto;
import ru.yulialyapushkina.library_project.dto.BookDto;
import ru.yulialyapushkina.library_project.entities.Author;
import ru.yulialyapushkina.library_project.repositories.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements  AuthorService{
    private final AuthorRepository authorRepository;
    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return convertToDto(author);
    }
    @Override
    public AuthorDto getAuthorBySurnameV1(String surname) {
        Author author = authorRepository.findAuthorBySurname(surname).orElseThrow();
        return convertToDto(author);
    }

    @Override
    public AuthorDto getAuthorBySurnameV2(String surname) {
        Author author = authorRepository.findAuthorBySurname(surname).orElseThrow();
        return convertToDto(author);
    }

    @Override
    public AuthorDto getAuthorBySurnameV3(String surname) {
        Specification <Author> specification = Specification.where(new Specification<Author>() {
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("surname"), surname);
            }
        });

        Author author = authorRepository.findOne(specification).orElseThrow();
        return convertToDto(author);
    }

    private AuthorDto convertToDto (Author author){
        List <BookDto> bookDtoList = author.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()).toList();
        return AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name (author.getName())
                .surname(author.getSurname())
                .build();
    }
}
