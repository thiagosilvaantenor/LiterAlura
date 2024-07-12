package br.com.alura.literAlura.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String nome;
  private int anoNascimento;
  private int anoFalecimento;
  @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Livro> livros = new ArrayList<>();

  public Autor(){}

  public Autor(String nome, int anoNascimento, int anoFalecimento) {
    this.nome = nome;
    this.anoNascimento = anoNascimento;
    this.anoFalecimento = anoFalecimento;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAnoNascimento() {
    return anoNascimento;
  }

  public void setAnoNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
  }

  public int getAnoFalecimento() {
    return anoFalecimento;
  }

  public void setAnoFalecimento(int anoFalecimento) {
    this.anoFalecimento = anoFalecimento;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setLivros(Livro livro) {
    livros.add(livro);
  }

  @Override
  public String toString() {

    return "\tAutor:"  +
            "\nNome= " + nome +
            "\nAno de nascimento= " + anoNascimento +
            "\nAno de falecimento= " + anoFalecimento +
            "\n" + livros.toString() +
            "\n/////\t/////";
  }
}
