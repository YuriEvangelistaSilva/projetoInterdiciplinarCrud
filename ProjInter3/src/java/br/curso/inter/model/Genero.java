package br.curso.inter.model;
public class Genero {

    private int idGenero;
    private String tipoGenero;
    private String descricaoGenero;

    public Genero() {
        this.idGenero = 0;
        this.tipoGenero = "";
        this.descricaoGenero = "";
    }

    public Genero(int idGenero, String tipoGenero, String descricaoGenero) {
        this.idGenero = idGenero;
        this.tipoGenero = tipoGenero;
        this.descricaoGenero = descricaoGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setTipoGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(String tipoGenero) {
        this.tipoGenero = tipoGenero;
    }

    public String getDescricaoGenero() {
        return descricaoGenero;
    }

    public void setDescricaoGenero(String descricaoGenero) {
        this.descricaoGenero = descricaoGenero;
    }
}
