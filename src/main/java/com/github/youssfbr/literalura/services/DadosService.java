package com.github.youssfbr.literalura.services;

import com.github.youssfbr.literalura.entities.Data;
import com.github.youssfbr.literalura.repositories.IDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DadosService implements IDadosService {

    private final IDataRepository dadosRepository;

    public DadosService(IDataRepository dadosRepository) {
        this.dadosRepository = dadosRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Data> findAllDados() {
        return dadosRepository.findAll();
    }

    @Override
    public Data dadosCreate(Data dados) {

        dados = dadosRepository.saveAndFlush(dados);

        for (int i=0 ; i < dados.getResults().size(); i++) {
            dados.getResults().get(i).setDados(dados);
        }

        return dadosRepository.save(dados);
    }
}
