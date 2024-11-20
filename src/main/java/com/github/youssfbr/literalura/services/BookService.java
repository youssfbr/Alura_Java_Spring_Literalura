package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.BookResponseDTO;
import com.github.youssfbr.literalura.entities.Book;
import com.github.youssfbr.literalura.repositories.IBookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponseDTO> findAllBooks() {
        return getList(bookRepository.findAll());
    }

    @Override
    public List<BookResponseDTO> findBooksByLanguage(List<String> language) {
        return getList(bookRepository.findBooksByLanguage(language));
    }

    @Override
    public List<BookResponseDTO> findTop10ByOrderByDownloadCountDesc() {
        return getList(bookRepository.findTop10ByOrderByDownloadCountDesc());
    }

    @NotNull
    private List<BookResponseDTO> getList(List<Book> books) {
        return books
                .stream()
                .map(BookResponseDTO::new)
                .toList();
    }
}
