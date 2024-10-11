
package br.curso.inter.model;

public class Plataforma {
    private int idPlataforma;
    private String nomePlataforma;
  
    public Plataforma() {
        this.idPlataforma = 0;
        this.nomePlataforma = "";
    }
    public Plataforma(int idPlataforma, String nomePlataforma) {
        this.idPlataforma = idPlataforma;
        this.nomePlataforma = nomePlataforma;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public void setNomePlataforma(String nomePlataforma) {
        this.nomePlataforma = nomePlataforma;
    }
    
}
