package Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;



public class DesenvolvimentoPessoal extends Livro{


    private final String TIPO = "Desenvolvimento Pessoal";

    public DesenvolvimentoPessoal(
            String titulo, int anoDePublicacao, String resumo,
            String idioma, String editora, int quantidade, float preco,String genero,
            String autores) {
        super(titulo, anoDePublicacao, resumo, idioma, editora, quantidade, preco,genero,autores);
    }

    public String getTIPO() {

        return TIPO;
    }

}
