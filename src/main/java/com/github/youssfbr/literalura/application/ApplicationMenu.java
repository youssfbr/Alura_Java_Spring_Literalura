package com.github.youssfbr.literalura.application;

import com.github.youssfbr.literalura.entities.Data;
import com.github.youssfbr.literalura.services.ConsumoApi;
import com.github.youssfbr.literalura.services.IConverteDados;
import com.github.youssfbr.literalura.services.IDadosService;
import com.github.youssfbr.literalura.utils.Messages;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ApplicationMenu {
    private final ConsumoApi consumoApi;
    private final IConverteDados conversor;
    private final IDadosService dataService;
    private final Scanner sc = new Scanner(System.in);
    private static final String URL = "https://gutendex.com/books/?search=";

    public ApplicationMenu(ConsumoApi consumoApi , IConverteDados conversor , IDadosService dadosService) {
        this.consumoApi = consumoApi;
        this.conversor = conversor;
        this.dataService = dadosService;
    }

    public void showMenu() {
        int option = -1;
        while (option != 0) {
            System.out.println(Messages.MESSAGING_OPTIONS);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0 -> System.out.println("Saindo...");
                case 1 -> findBookByTitleWeb();
//                case 2 -> listarLivrosRegistrados();
//                case 3 -> listarAutoresRegistrados();
//                case 4 -> listarAutoresVivosEmUmDeterminadoAno();
//                case 5 -> listarLivrosEmUmDeterminadoIdioma();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void findBookByTitleWeb() {
        Data data = getDataBooks();
        data = dataService.dadosCreate(data);
        System.out.println(data);
    }

    private Data getDataBooks() {
        System.out.print("\nDigite o nome do livro que você deseja procurar: ");
        String nameBook = sc.nextLine();
        String uri = URL + nameBook.replace(" " , "+");
        var json = consumoApi.obterDados(uri);
        return conversor.obterDados(json , Data.class);
    }
}

