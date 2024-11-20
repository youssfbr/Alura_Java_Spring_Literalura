package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.AuthorResponseDTO;
import com.github.youssfbr.literalura.entities.Author;
import com.github.youssfbr.literalura.repositories.IAuthorRepository;
import com.github.youssfbr.literalura.services.exceptions.ResourceNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorResponseDTO> findAllAuthors() {
        return getList(authorRepository.findAll());
    }

    @Override
    public List<AuthorResponseDTO> findLivingAuthorsByYear(int year) {
        return getList(authorRepository.findLivingAuthorsByYear(year));
    }

    @Override
    public AuthorResponseDTO findByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name)
                .map(AuthorResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Autor " + name + " não encontrado!"));
    }

    @NotNull
    private List<AuthorResponseDTO> getList(List<Author> authors) {
        return authors.stream()
                .map(AuthorResponseDTO::new)
                .toList();
    }
}
