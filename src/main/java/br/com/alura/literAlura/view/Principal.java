package br.com.alura.literAlura.view;

import br.com.alura.literAlura.model.DadosLivro;
import br.com.alura.literAlura.model.Livro;
import br.com.alura.literAlura.model.Resultados;
import br.com.alura.literAlura.service.ConsumoApi;

import java.util.List;
import java.util.Scanner;

public class Principal {
  private ConsumoApi consumoApi = new ConsumoApi();

  public void exibeMenu() {
    int opcao = 9;
    Scanner leitura = new Scanner(System.in);
    while (opcao != 0) {
      System.out.println("--------- \n"
          + "Bem vindo ao LiterAlura \n Digite uma das opções: \n"
          + "1 - Buscar o livro pelo título\n"
          + "2 - Listar livros registrados\n"
          + "3 - Listar autores registrados\n"
          + "4 - Listar autores vivos em um determinado ano\n"
          + "5 - Listar livros em um determinado idioma\n"
          + "0 - Sair");
      opcao = leitura.nextInt();
      leitura.nextLine();
      switch (opcao) {
        case 1:
          System.out.println("Informe o nome do livro");
          var nomeLivro = leitura.nextLine();

          if(nomeLivro.contains(" ")){
            nomeLivro = (nomeLivro.replace(" ", "%20"));
          }
          String livro = consumoApi.obterDados(nomeLivro);
          var livroJson = consumoApi.converterDados(livro, Resultados.class);
          livroJson.resultados().forEach( d -> System.out.println("Titulo: "+d.titulo()
                  + "\nAutores: " + d.autores() + "\nIdioma: " + d.idiomas().get(0)));
          break;
      }
    }
  }
}
