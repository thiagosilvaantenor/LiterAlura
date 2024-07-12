package br.com.alura.literAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  @ManyToMany
  private List<Autor> autores;
  private String idioma;
  private Double numeroDownloads;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public List<Autor> getAutores() {
    return autores;
  }

  public void setAutores(List<Autor> autores) {
    this.autores = autores;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  public Double getNumeroDownloads() {
    return numeroDownloads;
  }

  public void setNumeroDownloads(Double numeroDownloads) {
    this.numeroDownloads = numeroDownloads;
  }

  @Override
  public String toString() {
    return "Livro{" +
            "titulo='" + titulo + '\'' +
            ", autores=" + autores +
            ", idioma='" + idioma + '\'' +
            ", numeroDownloads=" + numeroDownloads +
            '}';
  }
}
