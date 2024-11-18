package com.github.youssfbr.literalura.repositories;

import com.github.youssfbr.literalura.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
