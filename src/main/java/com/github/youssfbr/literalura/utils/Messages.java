package com.github.youssfbr.literalura.utils;

public class Messages {

    private Messages() {
        throw new IllegalStateException("Utility class");
    }

    public static final String MESSAGING_OPTIONS = """
                        
                        Escolha o número de sua opção:
                        
                        1 - Buscar livro pelo título
                        2 - Listar livros registrados
                        3 - Listar autores registrados
                        4 - Listar autores vivos em um determinado ano
                        5 - Listar livros em um determinado idioma
                        6 - Listar autores pelo nome [BONUS]
                        6 - Listar os 10 livros mais baixados [BONUS]
                        -
                        0 - Sair
                        """;
}

