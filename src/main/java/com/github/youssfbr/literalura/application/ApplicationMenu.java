package com.github.youssfbr.literalura.application;

import com.github.youssfbr.literalura.dtos.AuthorResponseDTO;
import com.github.youssfbr.literalura.dtos.BookResponseDTO;
import com.github.youssfbr.literalura.entities.Data;
import com.github.youssfbr.literalura.services.*;
import com.github.youssfbr.literalura.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.literalura.utils.Messages;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class ApplicationMenu {
    private final ConsumoApi consumoApi;
    private final IBookService bookService;
    private final IAuthorService authorService;
    private final IConverteDados conversor;
    private final IDadosService dataService;
    private final Scanner sc = new Scanner(System.in);
    private static final String URL = "https://gutendex.com/books/?search=";

    public ApplicationMenu(ConsumoApi consumoApi , IBookService bookService , IAuthorService authorService , IConverteDados conversor , IDadosService dadosService) {
        this.consumoApi = consumoApi;
        this.bookService = bookService;
        this.authorService = authorService;
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
                case 2 -> findAllBooks();
                case 3 -> findAllAuthors();
                case 4 -> findLivingAuthorsByYear();
                case 5 -> findBooksByLanguage();
                case 6 -> findAuthorByName();
                case 7 -> findTop10ByOrderByDownloadCountDesc();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void findTop10ByOrderByDownloadCountDesc() {
        final List<BookResponseDTO> top10ByOrderByDownloadCountDesc = bookService.findTop10ByOrderByDownloadCountDesc();
        System.out.println(top10ByOrderByDownloadCountDesc);
    }

    private void findAuthorByName() {
        try {
            System.out.print("Digite o nome do autor: ");
            String authorName = sc.nextLine().toLowerCase();
            final AuthorResponseDTO byName = authorService.findByName(authorName);
            System.out.println(byName);
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private void findBooksByLanguage() {

        final String message = """
                
                Insira o idioma para realizar a busca:
                
                es - espanhol
                en - inglês
                fr - francês
                pt - português
                
                """;

        System.out.print(message);
        String language = sc.nextLine();

        final List<BookResponseDTO> booksByLanguage = bookService.findBooksByLanguage(Collections.singletonList(language));
        if (!booksByLanguage.isEmpty()) {
            System.out.println(booksByLanguage);
        } else {
            System.out.println("Não existem livros nesse idioma no banco de dados");
        }
    }

    private void findLivingAuthorsByYear() {
        int anoAuthor;
        do {
            try {
                System.out.print("\nDigite o ano que deseja pesquisar: ");
                anoAuthor = sc.nextInt();
                break;
            } catch (InputMismatchException ex) {
                sc.next();
                System.out.println("Ano inválido! Deve ser um valor inteiro!");
            }
        } while (true);

        final List<AuthorResponseDTO> livingAuthorsByYear = authorService.findLivingAuthorsByYear(anoAuthor);
        if (!livingAuthorsByYear.isEmpty()) {
            System.out.println(livingAuthorsByYear);
        } else {
            System.out.println("Não existem livros desse período registrado na base de dados");
        }
    }

    private void findAllAuthors() {
        final List<AuthorResponseDTO> allAuthors = authorService.findAllAuthors();
        System.out.println(allAuthors);
    }

    private void findAllBooks() {
        final List<BookResponseDTO> allBooks = bookService.findAllBooks();
        System.out.println(allBooks);
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

