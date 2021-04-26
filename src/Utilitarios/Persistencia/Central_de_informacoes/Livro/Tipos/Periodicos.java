package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;


import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Periodicos extends Livro {
    private long numeroDaEdicao;
    private String mesDeLancamento;
    private final String TIPO = "Periódicos";

    public Periodicos(
         String titulo, int anoDePublicacao, String resumo, String idioma,
        String editora, int quantidade, float preco,String genero,
        long numeroDaEdicao, String mesDeLancamento, String autor) {

        super(titulo, anoDePublicacao, resumo, idioma, editora, quantidade, preco,genero,autor);

        this.numeroDaEdicao = numeroDaEdicao;
        this.mesDeLancamento = mesDeLancamento;
    }

    public String getTIPO() {
        return TIPO;
    }

    public long getNumeroDaEdicao() {
        return numeroDaEdicao;
    }

    public void setNumeroDaEdicao(long numeroDaEdicao) {
        this.numeroDaEdicao = numeroDaEdicao;
    }

    public String getMesDeLancamento() {
        return mesDeLancamento;
    }

    public void setMesDeLancamento(String mesDeLancamento) {
        this.mesDeLancamento = mesDeLancamento;
    }



}
