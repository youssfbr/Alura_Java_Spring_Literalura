package com.github.youssfbr.literalura.repositories;

import com.github.youssfbr.literalura.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

    @Query("""
            SELECT a FROM Author a
            WHERE a.birthYear >= :year""")
    List<Author>findLivingAuthorsByYear(int year);

}