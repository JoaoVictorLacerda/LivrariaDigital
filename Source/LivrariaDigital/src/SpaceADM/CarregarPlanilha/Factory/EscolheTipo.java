package SpaceADM.CarregarPlanilha.Factory;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.DesenvolvimentoPessoal;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Literatura;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Periodicos;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Tecnicos;

import java.util.ArrayList;
import java.util.Arrays;

public class EscolheTipo {

    public static Livro factory(ArrayList<String> info) throws Exception {
        String tipo = info.get(0);
        ArrayList<String> literatura =new ArrayList<String>(Arrays.asList(
                info.get(1),info.get(2),
                info.get(3),info.get(4), info.get(5),
                info.get(6),info.get(7),
                info.get(8)
        ));
        if(!literatura.contains("")|| !literatura.contains("0")){
            switch (tipo.toLowerCase()) {
                case "literatura":
                    if(!info.get(10).equals("")){
                        return new Literatura(info.get(1), Integer.parseInt(info.get(2)),
                                info.get(3),info.get(4), info.get(5),
                                Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                                info.get(8),info.get(10));
                    }else{
                        throw new Exception("Preencha todos os campos de Literatura");
                    }
                case "desenvolvimento pessoal":
                    if(!info.get(10).equals("")){
                        return new DesenvolvimentoPessoal(info.get(1), Integer.parseInt(info.get(2)),
                                info.get(3),info.get(4), info.get(5),
                                Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                                info.get(8),info.get(10));
                    }else{
                        throw new Exception("Preencha todos os campos de Desenvolvimento Pessoal");
                    }
                case "periódicos":
                    ArrayList<String> periodicos= new ArrayList<String>(Arrays.asList(
                            info.get(11),info.get(9),info.get(10)
                    ));
                    if(!periodicos.contains("")||periodicos.contains("0")){
                        return new Periodicos(
                                info.get(1), Integer.parseInt(info.get(2)),
                                info.get(3),info.get(4), info.get(5),
                                Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                                info.get(8),Long.parseLong(info.get(11)),info.get(9),info.get(10));
                    }else{
                        throw new Exception("Preencha todos os campos de Periódicos");
                    }
                case "técnico":
                    if(!info.get(12).equals("")||!info.get(10).equals("")){
                        return new Tecnicos(
                                info.get(1), Integer.parseInt(info.get(2)),
                                info.get(3),info.get(4), info.get(5),
                                Integer.parseInt(info.get(6)),Float.parseFloat(info.get(7)),
                                info.get(8),info.get(12),info.get(10));
                    }else{
                        throw new Exception("Preencha todos os campos de Técnicos");
                    }
                default:
                    return null;
            }

        }else{
            throw new Exception("Preencha todos os campos");
        }
    }
}
