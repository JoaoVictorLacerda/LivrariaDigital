package SpaceADM.CadastroDeLivros.Factory.ComBox;


import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Ouvintes.OuvinteDosJButtons;
import SpaceADM.CadastroDeLivros.Tela.Componentes.DesenvolvimentoPessoal;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Literatura;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Periodicos;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Tecnicos;

import java.awt.event.ActionListener;


public class ChamaComponentesAddNaTela {

    public static ComponentesAddNaTela factory(int chave){
        switch (chave){
            case 1:
                return new Literatura();
            case 2:
                return new Periodicos();
            case 3:
                return new DesenvolvimentoPessoal();
            case 4:
                return new Tecnicos();

            default:
                return null;
        }

    }

}
