package ru.yulialyapushkina.library_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yulialyapushkina.library_project.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
