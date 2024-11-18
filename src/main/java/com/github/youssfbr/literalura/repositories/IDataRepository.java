package com.github.youssfbr.literalura.repositories;

import com.github.youssfbr.literalura.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDataRepository extends JpaRepository<Data, Long> {
}
