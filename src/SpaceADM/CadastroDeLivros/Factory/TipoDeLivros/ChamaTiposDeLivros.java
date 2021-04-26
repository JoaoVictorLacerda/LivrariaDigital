package SpaceADM.CadastroDeLivros.Factory.TipoDeLivros;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.DesenvolvimentoPessoal;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Literatura;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Periodicos;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Tecnicos;

import java.util.ArrayList;

public class ChamaTiposDeLivros {

    public static Livro factory(ArrayList<String> info){
        String tipo = info.get(0);
        switch (tipo) {
            case "Literatura":
                return new Literatura(
                        info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),info.get(9));

            // tipo,titulo,anoDePublicacao, resumo, idioma ,editora,
            // quantidade, preco,genero AUTORES
            case "Desenvolvimento Pessoal":
                return new DesenvolvimentoPessoal(
                        info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),info.get(9));
            case "Periódicos":
                return new Periodicos(
                        info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),Long.parseLong(info.get(11)),info.get(9),info.get(10));
            case "Técnico":
                return new Tecnicos(
                        info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),info.get(9), info.get(10));
            default:
                return null;
        }

    }
}
