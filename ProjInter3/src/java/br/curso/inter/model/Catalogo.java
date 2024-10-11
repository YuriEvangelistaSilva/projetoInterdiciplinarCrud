package br.curso.inter.model;
public class Catalogo {

    private int idCatalogo;
    private String nomeCatalogo;
    private Game game;
    private String tipoCatalogo;
    private String situacao;

    public Catalogo() {
        this.idCatalogo = 0;
        this.nomeCatalogo = "";
        this.game = new Game();
        this.tipoCatalogo = "";
        this.situacao = "A";
    }

    public Catalogo(int idCatalogo, String nomeCatalogo, Game game, String situacao, String tipoCatalogo) {
        this.idCatalogo = idCatalogo;
        this.nomeCatalogo = nomeCatalogo;
        this.game = game;
        this.tipoCatalogo = tipoCatalogo;
        this.situacao = situacao;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setNomeCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNomeCatalogo() {
        return nomeCatalogo;
    }
    
    public Game getGame(){
        return game;
    }
    
    public void setGame(Game game){
        this.game = game;
    }

    public void setNomeCatalogo(String nomeCatalogo) {
        this.nomeCatalogo = nomeCatalogo;
    }

    public String getTipoCatalogo() {
        return tipoCatalogo;
    }

    public void setTipoCatalogo(String tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }
    
     public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}