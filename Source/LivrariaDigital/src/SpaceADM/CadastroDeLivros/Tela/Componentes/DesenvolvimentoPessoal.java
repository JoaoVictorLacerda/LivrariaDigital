package SpaceADM.CadastroDeLivros.Tela.Componentes;

public class DesenvolvimentoPessoal extends Literatura{

    @Override
    public String[] getGeneros() {
        return new String[] {"Autoajuda","Religião","Saúde"};
    }
    @Override
    public String getTipo(){
        return "Desenvolvimento Pessoal";
    }


}
