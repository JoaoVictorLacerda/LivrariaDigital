package Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse;

public  abstract class Livro {

    private String titulo;
    private String resumo;
    private String idioma;
    private String genero;
    private String editora;
    private int quantidade;
    private float preco;
    private int anoDePublicacao;
    private  String TIPO="";
    private int numeroDeVisualizacoes=0;
    private String autor;
    private int numeroDePessoasQueIndicaramInteresse = 0;

    public int getNumeroDePessoasQueIndicaramInteresse() {
        return numeroDePessoasQueIndicaramInteresse;
    }

    public void setNumeroDePessoasQueIndicaramInteresse(int numeroDePessoasQueIndicaramInteresse) {
        this.numeroDePessoasQueIndicaramInteresse = numeroDePessoasQueIndicaramInteresse;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDeVisualizacoes() {
        return numeroDeVisualizacoes;
    }

    public void setNumeroDeVisualizacoes(int numeroDeVisualizacoes) {
        this.numeroDeVisualizacoes = numeroDeVisualizacoes;
    }

    public String getTIPO() {
        return TIPO;
    }

    public Livro(
            String titulo,int anoDePublicacao, String resumo, String idioma,
            String editora, int quantidade, float preco, String genero,String autor) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.idioma = idioma;
        this.genero = genero;
        this.editora = editora;
        this.quantidade = quantidade;
        this.preco = preco;
        this.anoDePublicacao = anoDePublicacao;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }
    public String getTIPO(String TIPO) {
        return TIPO;
    }
}
