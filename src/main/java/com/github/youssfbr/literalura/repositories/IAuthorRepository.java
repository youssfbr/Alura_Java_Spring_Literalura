package com.github.youssfbr.literalura.repositories;

import com.github.youssfbr.literalura.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

}