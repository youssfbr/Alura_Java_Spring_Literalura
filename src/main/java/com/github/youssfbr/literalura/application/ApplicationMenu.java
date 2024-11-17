package com.github.youssfbr.literalura.application;

import com.github.youssfbr.literalura.utils.Messages;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ApplicationMenu {

    private final Scanner sc = new Scanner(System.in);

    public void showMenu() {
        int option = -1;
        while (option != 0) {
            System.out.println(Messages.MESSAGING_OPTIONS);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0 -> System.out.println("Saindo...");
//                case 1 -> buscarLivroPeloTitulo();
//                case 2 -> listarLivrosRegistrados();
//                case 3 -> listarAutoresRegistrados();
//                case 4 -> listarAutoresVivosEmUmDeterminadoAno();
//                case 5 -> listarLivrosEmUmDeterminadoIdioma();
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

