package Loja.Tela.DetalhesLivro;


import Loja.Imagens.Imagens;
import Loja.OuvintesDetalhes.OuvinteDosJButtons;
import Loja.Tela.Loja.TelaLoja;
import SpaceADM.CadastroDeLivros.Ouvintes.OuvinteKeyBord;
import TelaPadrao.Tela.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class TelaDetalhes extends TelaPadrao {

    private Color corInfo = new Color(243, 109, 11, 255);
    private Font font = new Font("Arial",Font.BOLD,13);
    private JPanel back;
    private JPanel detalhesDoLivro;
    private Livro livro;
    private Usuario user;

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUser() {
        return user;
    }

    public void chamaTodosOsMetodos(){
        this.addPainelDetalhes();
        this.addPainelBackg();
        this.addButtons();
        this.addJButtonSalvar();
        this.addButtonVoltarUser();
        this.addImagem();
        this.addFormDetalhes();
        this.addInfos();
        this.setVisible(true);
    }

    public TelaDetalhes(Livro livro) {
        super("Detalhes do Livro");

        this.livro = livro;
        this.chamaTodosOsMetodos();
    }

    public TelaDetalhes(Livro livro, Usuario user){
        super("Detalhes do Livro");

        this.livro = livro;
        this.user=user;
        this.chamaTodosOsMetodos();
    }

    public boolean isUser(){
        if(user==null){
            return true;
        }
        return false;
    }

    private class BackgroundTela extends JPanel {
        private ImageIcon img;

        public BackgroundTela(){
            img = new ImageIcon(TelaDetalhes.class.getResource("/loja/telaDetalhes.jpeg"));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

        }

        public void setImg(ImageIcon img){
            this.img = img;
        }

        public ImageIcon getImg(){
            return this.img;
        }

    }

    public void addPainelBackg() {
        back = new BackgroundTela();
        back.setLayout(null);
        back.setBounds(0, 0, 700, 400);
        back.setBackground(Color.DARK_GRAY);
        this.add(back);

    }

    public void addPainelDetalhes() {
        detalhesDoLivro = new JPanel();
        detalhesDoLivro.setLayout(null);
        detalhesDoLivro.setBounds(0, 0, 230, 373);
        detalhesDoLivro.setBackground(Color.DARK_GRAY);
        int i;
        if(this.user==null){
            i=1100;
        }else{
            i=1000;
        }
        this.detalhesDoLivro.setPreferredSize(new Dimension(0,i));

        JScrollPane scroll = new JScrollPane(detalhesDoLivro);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(0, 0, 230 , 373);

        this.add(scroll);

    }


    public void addImagem() {
        String tipo = "Desenvolvimento Pessoal,Literatura,Periódicos,Técnicos";
        ArrayList<String> tipos = new ArrayList<String>(Arrays.asList(tipo.split(",")));
        int index = tipos.indexOf(livro.getTIPO());
        JLabel simula = new JLabel(new ImageIcon(TelaDetalhes.class.getResource(Imagens.todasAsImg[index])));
        simula.setBounds(40, 15, 135, 185);
        this.detalhesDoLivro.add(simula);
    }

    public void addFormDetalhes() {
        JLabel titulo = new JLabel("  Título:",JLabel.LEFT);
        JLabel tipo = new JLabel("  Tipo:",JLabel.LEFT);
        JLabel  resumo = new JLabel("  Resumo:",JLabel.LEFT);
        JLabel  idioma = new JLabel("  Idioma:",JLabel.LEFT);
        JLabel  genero = new JLabel("  Gênero:",JLabel.LEFT);
        JLabel  editora = new JLabel("  Editora:",JLabel.LEFT);
        JLabel  autor = new JLabel("  Autor:",JLabel.LEFT);
        JLabel quantidade = new JLabel("  Quantidade:",JLabel.LEFT);
        JLabel preco = new JLabel("  Preço:",JLabel.LEFT);

        titulo.setFont(font);
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(0, 215, 230, 20);

        tipo.setFont(font);
        tipo.setForeground(Color.WHITE);
        tipo.setBounds(0, 300, 230, 20);

        this.detalhesDoLivro.add(titulo);
        this.detalhesDoLivro.add(tipo);

        resumo.setFont(font);
        resumo.setForeground(Color.WHITE);
        resumo.setBounds(0, 385, 230, 20);
        this.detalhesDoLivro.add(resumo);

        idioma.setFont(font);
        idioma.setForeground(Color.WHITE);
        idioma.setBounds(0, 490, 230, 20);
        this.detalhesDoLivro.add(idioma);

        genero.setFont(font);
        genero.setForeground(Color.WHITE);
        genero.setBounds(0, 575, 230, 20);
        this.detalhesDoLivro.add(genero);

        editora.setFont(font);
        editora.setForeground(Color.WHITE);
        editora.setBounds(0, 660, 230, 20);
        this.detalhesDoLivro.add(editora);

        autor.setFont(font);
        autor.setForeground(Color.WHITE);
        autor.setBounds(0, 745, 230, 20);
        this.detalhesDoLivro.add(autor);

        quantidade.setFont(font);
        quantidade.setForeground(Color.WHITE);
        quantidade.setBounds(0, 830, 230, 20);
        this.detalhesDoLivro.add(quantidade);

        preco.setFont(font);
        preco.setForeground(Color.WHITE);
        preco.setBounds(0, 915, 230, 20);


        this.detalhesDoLivro.add(preco);
    }
    private JTextArea quantidade;

    public JTextArea getQuantidade() {
        return quantidade;
    }
    private JTextArea titulo;
    private JTextArea resumoArea;
    private JTextArea  idioma;
    private JTextArea  editora;
    private JTextArea  autor;
    private JTextArea preco;
    public void addInfos() {
        titulo = new JTextArea(livro.getTitulo());

        titulo.setFont(font);
        titulo.setEnabled(this.isUser());
        titulo.setForeground(corInfo);
        titulo.setBounds(10, 235, 190, 50);
        titulo.setBackground(new Color(51, 51, 51));
        titulo.setLineWrap(true);
        titulo.setWrapStyleWord(true);
        this.detalhesDoLivro.add(titulo);

        JTextArea tipo = new JTextArea(livro.getTIPO());
        tipo.setForeground(corInfo);
        tipo.setEnabled(false);
        tipo.setBounds(10, 320, 190, 50);
        tipo.setFont(font);
        tipo.setBackground(new Color(51, 51, 51));
        tipo.setLineWrap(true);
        tipo.setWrapStyleWord(true);
        this.detalhesDoLivro.add(tipo);


        resumoArea = new JTextArea(livro.getResumo());
        JScrollPane painel = new JScrollPane(resumoArea);
        painel.setBounds(10, 410, 190, 70);
        resumoArea.setEnabled(this.isUser());
        resumoArea.setFont(font);
        resumoArea.setForeground(corInfo);
        resumoArea.setBackground(new Color(51, 51, 51));
        resumoArea.setLineWrap(true);
        resumoArea.setWrapStyleWord(true);
        this.detalhesDoLivro.add(painel);


        idioma = new JTextArea(livro.getIdioma());
        idioma.setFont(font);
        idioma.setEnabled(this.isUser());
        idioma.setForeground(corInfo);
        idioma.setBounds(10, 510, 190, 50);
        idioma.setBackground(new Color(51, 51, 51));
        idioma.setLineWrap(true);
        idioma.setWrapStyleWord(true);
        this.detalhesDoLivro.add(idioma);

        JTextArea genero = new JTextArea(livro.getGenero());
        genero.setFont(font);
        genero.setEnabled(false);
        genero.setForeground(corInfo);
        genero.setBounds(10, 595, 190, 50);
        genero.setBackground(new Color(51, 51, 51));
        genero.setLineWrap(true);
        genero.setWrapStyleWord(true);
        this.detalhesDoLivro.add(genero);

        editora = new JTextArea(livro.getEditora());
        editora.setFont(font);
        editora.setEnabled(this.isUser());
        editora.setForeground(corInfo);
        editora.setBounds(10, 680, 190, 50);
        editora.setBackground(new Color(51, 51, 51));
        editora.setLineWrap(true);
        editora.setWrapStyleWord(true);
        this.detalhesDoLivro.add(editora);

        autor = new JTextArea(livro.getAutor());
        autor.setFont(font);
        autor.setEnabled(this.isUser());
        autor.setForeground(corInfo);
        autor.setBounds(10, 765, 190, 50);
        autor.setBackground(new Color(51, 51, 51));
        autor.setLineWrap(true);
        autor.setWrapStyleWord(true);
        this.detalhesDoLivro.add(autor);

        quantidade = new JTextArea(String.valueOf(livro.getQuantidade()));
        quantidade.setFont(font);
        quantidade.addKeyListener(new OuvinteKeyBord());
        quantidade.setEnabled(this.isUser());
        quantidade.setForeground(corInfo);
        quantidade.setBounds(10, 850, 190, 50);
        quantidade.setBackground(new Color(51, 51, 51));
        quantidade.setLineWrap(true);
        quantidade.setWrapStyleWord(true);
        this.detalhesDoLivro.add(quantidade);

        preco = new JTextArea(String.valueOf(livro.getPreco())+" R$");
        preco.setFont(font);
        preco.setEnabled(this.isUser());
        preco.setForeground(corInfo);
        preco.setBounds(10, 935, 190, 50);
        preco.setBackground(new Color(51, 51, 51));
        preco.setLineWrap(true);
        preco.setWrapStyleWord(true);
        this.detalhesDoLivro.add(preco);


    }
    private class OuvinteADM implements ActionListener{
    	private CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
        private ArrayList<Livro> livrosArray = central.getLivros();
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton  button = (JButton) arg0.getSource();
			
			if(button.getText().equals("Salvar")) {
				ArrayList<String> info = new ArrayList<String>();
                info.add(titulo.getText());
                info.add(resumoArea.getText());
                info.add(idioma.getText());
                info.add(editora.getText());
                info.add(autor.getText());
                info.add(preco.getText());

                if(info.contains("")||info.contains(" ")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
                }else{
                	this.removeLivro();
                    livro.setTitulo(info.get(0));
                    livro.setResumo(info.get(1));
                    livro.setIdioma(info.get(2));
                    livro.setEditora(info.get(3));
                    livro.setAutor(info.get(4));
                    livro.setPreco(Float.parseFloat(info.get(5).replace("R$","")));

                    livro.setQuantidade(Integer.parseInt(quantidade.getText()));
                    central.addLivro(livro);
                    central.salvar();
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                }
			}else {
				int resposta =JOptionPane.showConfirmDialog(
						null, "Tem certeza que deseja apagar o livro?", "Apagar Livro", JOptionPane.YES_NO_OPTION);
				String menssagem = "Cancelado com sucesso";
				if(resposta==0) {
					this.removeLivro();
					menssagem = "Removido com sucesso";
				}
				JOptionPane.showMessageDialog(null, menssagem);
					
			}
			dispose();
			new TelaLoja();
			
		}
		public void removeLivro() {
			for(int i =0;i<livrosArray.size();i++){
                if(livrosArray.get(i).getTitulo().equals(livro.getTitulo())&&
                        livrosArray.get(i).getTIPO().equals(livro.getTIPO())){
                    central.getLivros().remove(i);
                    central.salvar();
                }
            }
		}
    	
    }
    public void addJButtonSalvar(){
    	OuvinteADM ouvinte = new OuvinteADM();
    	
        JButton salvar = new JButton("Salvar");
        salvar.setBounds(45, 1010, 130, 25);
        salvar.setFont(font);
        salvar.setBackground(new Color(102, 102, 102));
        salvar.setBorder(null);
        salvar.addActionListener(ouvinte);
        
        JButton excluir = new JButton("Excluir Livro");
        excluir.setBounds(45, 1050, 130, 25);
        excluir.setFont(font);
        excluir.setBackground(new Color(102, 102, 102));
        excluir.setBorder(null);
        excluir.addActionListener(ouvinte);
        
        
        this.detalhesDoLivro.add(salvar);
        this.detalhesDoLivro.add(excluir);

    }
    private  Color cor = new Color(102, 102, 102);
    public void addButtons() {
        OuvinteDosJButtons ouvinte = new OuvinteDosJButtons(this);

        JButton comprar = new JButton("Comprar");
        JButton addColecao = new JButton("Add a Coleção");
        JButton interesse = new JButton("Tenho interesse");
        interesse.setEnabled(false);
        if(this.livro.getQuantidade()==0){
            comprar.setText("Esgotado");
            comprar.setEnabled(false);
            interesse.setEnabled(true);

        }
        if(this.isUser()){
            comprar.setEnabled(true);
            comprar.setText("Voltar");
            addColecao.setEnabled(false);
            interesse.setEnabled(false);
        }
        comprar.setBounds(260, 170, 130, 35);
        comprar.addActionListener(ouvinte);
        comprar.setFont(font);
        comprar.setBackground(cor);
        comprar.setBorder(null);

        addColecao.setBounds(400, 170, 130, 35);
        addColecao.addActionListener(ouvinte);
        addColecao.setFont(font);
        addColecao.setBackground(cor);
        addColecao.setBorder(null);

        interesse.setBounds(540, 170, 130, 35);
        interesse.addActionListener(ouvinte);
        interesse.setFont(font);
        interesse.setBackground(cor);
        interesse.setBorder(null);

        this.back.add(comprar);
        this.back.add(addColecao);
        this.back.add(interesse);


    }

    public void addButtonVoltarUser() {
        if (!this.isUser()) {
            JButton voltar = new JButton("Voltar");
            voltar.setBounds(400, 220, 130, 35);
            voltar.setFont(font);
            voltar.setBackground(cor);
            voltar.setBorder(null);
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new TelaLoja(user);
                }
            });
            this.back.add(voltar);
        }
    }

}