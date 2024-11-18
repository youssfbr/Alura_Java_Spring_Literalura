package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.BookResponseDTO;
import com.github.youssfbr.literalura.repositories.IBookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDTO::new)
                .toList();
    }

}
