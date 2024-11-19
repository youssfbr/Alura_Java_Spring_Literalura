package com.github.youssfbr.literalura.dtos;

import com.github.youssfbr.literalura.entities.Author;
import com.github.youssfbr.literalura.entities.Book;

import java.util.List;

public record AuthorResponseDTO(

        String name ,
        Integer birthYear ,
        Integer deathYear ,
        List<String> books

) {
    public AuthorResponseDTO(Author entity) {
        this(
                entity.getName() ,
                entity.getBirthYear() ,
                entity.getDeathYear() ,

                entity.getBooks()
                        .stream()
                        .map(Book::getTitle)
                        .toList()
        );
    }

    @Override
    public String toString() {
        return  "\n----- AUTOR -----" +
                "\nNome: " + name +
                "\nAno de nascimento: " + birthYear +
                "\nAno de falecimento: " + deathYear +
                "\nLivros: " + books +
                "\n-------------------\n";
    }
}