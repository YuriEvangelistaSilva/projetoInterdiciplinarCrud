package br.curso.inter.model;

public class Publico {

    private int idPublico;
    private String idadePublico;

    public Publico() {
        this.idPublico = 0;
        this.idadePublico = "";

    }

    public Publico(int idPublico, String idadePublico) {
        this.idPublico = idPublico;
        this.idadePublico = idadePublico;
    }

    public int getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(int idPublico) {
        this.idPublico = idPublico;
    }

    public String getIdadePublico() {
        return idadePublico;
    }

    public void setIdadePublico(String idadePublico) {
        this.idadePublico = idadePublico;
    }

}
