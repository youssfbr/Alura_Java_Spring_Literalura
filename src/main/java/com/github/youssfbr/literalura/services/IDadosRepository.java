package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDadosRepository extends JpaRepository<Data, Long> {
}
