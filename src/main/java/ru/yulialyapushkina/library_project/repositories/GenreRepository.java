package ru.yulialyapushkina.library_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yulialyapushkina.library_project.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
