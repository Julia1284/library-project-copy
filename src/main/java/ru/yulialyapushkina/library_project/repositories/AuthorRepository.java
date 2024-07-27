package ru.yulialyapushkina.library_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.yulialyapushkina.library_project.entities.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    Optional <Author> findAuthorBySurname (String surname);

    @Query(nativeQuery = true, value = "SELECT * FROM AUTHOR WHERE surname = ?")
    Optional <Author> findAuthorBySurnameBySql (String surname);
}
