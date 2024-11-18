package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.entities.Data;

import java.util.List;

public interface IDadosService {

    List<Data> findAllDados();
    Data dadosCreate(Data dados);
}
