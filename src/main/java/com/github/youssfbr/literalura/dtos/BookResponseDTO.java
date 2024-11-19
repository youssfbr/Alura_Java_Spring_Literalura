package com.github.youssfbr.literalura.dtos;

import com.github.youssfbr.literalura.entities.Book;

import java.util.List;

public record BookResponseDTO(

        String title ,
        String authors ,
        List<String> languages ,
        Integer downloadCount
) {
    public BookResponseDTO(Book entity) {
        this(
                entity.getTitle() ,
                entity.getAuthors().toString() ,

                entity.getLanguages()
                        .stream()
                        .map(String::toString)
                        .toList() ,

                entity.getDownloadCount()
        );
    }

    @Override
    public String toString() {
        return  "\n----- LIVRO -----" +
                "\nTítulo: " + title +
                "\nAutor: " + authors +
                "\nIdioma: " + languages +
                "\nNúmero de downloads: " + downloadCount +
                "\n-------------------\n";
    }
}
