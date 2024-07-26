package ru.yulialyapushkina.library_project.service;


import org.springframework.stereotype.Service;
import ru.yulialyapushkina.library_project.dto.GenreDto;
import ru.yulialyapushkina.library_project.entities.Genre;


public interface GenreService {
    GenreDto getGenreById (Long id);
}
