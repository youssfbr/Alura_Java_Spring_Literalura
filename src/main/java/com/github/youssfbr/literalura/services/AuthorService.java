package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.AuthorResponseDTO;
import com.github.youssfbr.literalura.entities.Author;
import com.github.youssfbr.literalura.repositories.IAuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jetbrains.annotations.NotNull;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorResponseDTO> findAllAuthors() {
        return getList(authorRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorResponseDTO> findLivingAuthorsByYear(int year) {
        return getList(authorRepository.findLivingAuthorsByYear(year));
    }

    @NotNull
    private List<AuthorResponseDTO> getList(List<Author> authors) {
        return authors.stream()
                .map(AuthorResponseDTO::new)
                .toList();
    }
}
