package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.dtos.AuthorResponseDTO;

import java.util.List;

public interface IAuthorService {

    List<AuthorResponseDTO> findAllAuthors();
    List<AuthorResponseDTO> findLivingAuthorsByYear(int year);
    AuthorResponseDTO findByName(String name);
}
