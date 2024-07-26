package ru.yulialyapushkina.library_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yulialyapushkina.library_project.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
