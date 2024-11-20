package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.BookResponseDTO;

import java.util.List;

public interface IBookService {

    List<BookResponseDTO> findAllBooks();
    List<BookResponseDTO> findBooksByLanguage(List<String> lnguage);

}
