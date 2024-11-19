package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.AuthorResponseDTO;
import com.github.youssfbr.literalura.repositories.IAuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                return authorRepository.findAll().stream()
                .map(AuthorResponseDTO::new)
                .toList();
    }
}
