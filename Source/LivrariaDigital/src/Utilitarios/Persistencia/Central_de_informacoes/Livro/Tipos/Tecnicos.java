package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;


import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Tecnicos extends Livro {

    private String assunto;
    private final String TIPO = "Técnicos";

    public Tecnicos(
        String titulo, int anoDePublicacao, String resumo, String idioma,
        String editora, int quantidade, float preco,String genero,
        String assunto, String autor) {

        super(titulo, anoDePublicacao, resumo, idioma, editora, quantidade, preco,genero,autor);

        this.assunto = assunto;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

}
