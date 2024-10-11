
package br.curso.inter.model;

public class Game {
     private int idGame;
    private String nome;
    private String categoria;
    private String notaTotal;
    private String descricaoGame;
    private Genero genero;
    private String situacao;
    
    public Game(int idGame, String nome, String categoria, String notaTotal, String descricaoGame,
                    String situacao, Genero genero) {
        this.idGame = idGame;
        this.nome = nome;
        this.categoria = categoria;
        this.notaTotal = notaTotal;
        this.descricaoGame = descricaoGame;
        this.situacao = situacao;
        this.genero = genero;

    }
    
    public Game(){
    this.idGame = 0;
    this.nome = "";
    this.categoria="";
    this.notaTotal="";
    this.descricaoGame="";
    this.situacao="A";
    this.genero = new Genero();
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNotaTotal() {
        return notaTotal;
    }

    public void setNotaTotal(String notaTotal) {
        this.notaTotal = notaTotal;
    }

    public String getDescricaoGame() {
        return descricaoGame;
    }

    public void setDescricaoGame(String descricaoGame) {
        this.descricaoGame = descricaoGame;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
}
