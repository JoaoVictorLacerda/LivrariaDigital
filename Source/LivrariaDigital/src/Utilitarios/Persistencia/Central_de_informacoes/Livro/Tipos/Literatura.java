package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Literatura  extends Livro{

    private final String TIPO = "Literatura";

    public Literatura(String titulo, int anoDePublicacao, String resumo,
        String idioma, String editora, int quantidade, float preco,String genero,
        String autores) {
        super(titulo, anoDePublicacao, resumo, idioma, editora, quantidade, preco,genero,autores);
    }

    public String getTIPO() {
        return TIPO;
    }


}
