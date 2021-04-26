package SpaceADM.CarregarPlanilha.Factory;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.DesenvolvimentoPessoal;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Literatura;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Periodicos;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Tecnicos;

import java.util.ArrayList;

public class EscolheTipo {

    public static Livro factory(ArrayList<String> info){
        String tipo = info.get(0);

        switch (tipo.toLowerCase()) {
            case "literatura":
                return new Literatura(info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),info.get(10));
            case "desenvolvimento pessoal":
                return new DesenvolvimentoPessoal(info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),info.get(10));
            case "periódicos":
                return new Periodicos(
                    info.get(1), Integer.parseInt(info.get(2)),
                    info.get(3),info.get(4), info.get(5),
                    Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                    info.get(8),Long.parseLong(info.get(11)),info.get(9),info.get(10));
            case "técnico":
                return new Tecnicos(
                        info.get(1), Integer.parseInt(info.get(2)),
                        info.get(3),info.get(4), info.get(5),
                        Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                        info.get(8),info.get(12),info.get(10));
            default:
                return null;
        }


    }
}
