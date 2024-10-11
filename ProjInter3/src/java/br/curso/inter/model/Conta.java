package br.com.curso.model;
public class Conta {

    private int idConta;
    private String nomeUsuario;
    private String emailConta;
    private String senhaConta;

    public Conta() {
        this.idConta = 0;
        this.nomeUsuario="";
        this.emailConta = "";
        this.senhaConta = "";
    }

    public Conta(int idConta, String emailConta, String senhaConta, String nomeUsuario) {
        this.idConta = idConta;
        this.nomeUsuario = nomeUsuario;
        this.emailConta = emailConta;
        this.senhaConta = senhaConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setEmailConta(int idConta) {
        this.idConta = idConta;
    }

    public String getEmailConta() {
        return emailConta;
    }

    public void setEmailConta(String emailConta) {
        this.emailConta = emailConta;
    }
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }
}
