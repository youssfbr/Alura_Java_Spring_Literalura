package com.github.youssfbr.literalura.repositories;

import com.github.youssfbr.literalura.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("""
            SELECT b FROM Book b
            WHERE b.languages in (:languages)""")
    List<Book> findBooksByLanguage(@Param("languages") List<String> languages);

}
