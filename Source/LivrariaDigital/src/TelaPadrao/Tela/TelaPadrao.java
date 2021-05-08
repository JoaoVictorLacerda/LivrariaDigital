package TelaPadrao.Tela;


import DynamicLayout.DynamicLayout;

import java.awt.*;


import javax.swing.*;

public abstract class TelaPadrao extends JFrame{
	private static final long serialVersionUID = 1L;

	private class BackgroundTela extends JPanel {
		private ImageIcon img;

		public BackgroundTela(){
			img = new ImageIcon(TelaPadrao.class.getResource("/loja/livros.png"));
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
	public void addBackground(){

		JPanel painel = new BackgroundTela();
		int width = this.getWidth();
		int height = this.getHeight();

		painel.setBounds(0,0,width,height);
		this.add(painel);
	}


	public TelaPadrao(String titulo) {

		Container div = this.getContentPane();
		div.setBackground(new Color(179, 179, 179));
		this.setLayout(new DynamicLayout(700,400));
		this.setSize(700,400);
		this.setTitle("Livraria Digital - "+titulo);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(650,350));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}



}

