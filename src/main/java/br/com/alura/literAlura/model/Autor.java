package br.com.alura.literAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private int anoNascimento;
  private int anoFalecimento;
  @ManyToMany(mappedBy = "autores")
  private List<Livro> livros;


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

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }

  @Override
  public String toString() {
    return "Autor{"  +
            ", nome='" + nome + '\'' +
            ", anoNascimento=" + anoNascimento +
            ", anoFalecimento=" + anoFalecimento +
            ", livros=" + livros +
            '}';
  }
}
