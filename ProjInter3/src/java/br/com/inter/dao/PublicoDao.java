package br.com.inter.dao;

import br.com.inter.utils.SingleConnection;
import br.curso.inter.model.Publico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicoDao implements GenericDAO {

    private Connection conexao;

    public PublicoDao() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Publico oPublico = (Publico) objeto;
        Boolean retorno=false;
        if (oPublico.getIdPublico()== 0) {
            retorno = this.inserir(oPublico);
        }else{
            retorno = this.alterar(oPublico);
        }
        return retorno;        
    }

    @Override
    public Boolean inserir(Object objeto) {
        Publico oPublico = (Publico) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into publico (idadePublico) values (?)";  
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPublico.getIdadePublico());                
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o   publico! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:"+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Publico oPublico = (Publico) objeto;
        PreparedStatement stmt = null;
        String sql = "update publico set idadePublico=? where idPublico=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPublico.getIdadePublico());                        
            stmt.setInt(2, oPublico.getIdPublico());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Publico! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:"+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idPublico = numero;
        PreparedStatement stmt= null;

        String sql = "delete from publico where idPublico=?";
        try {
            stmt = conexao.prepareStatement(sql);         
            stmt.setInt(1, idPublico);            
            stmt.execute();
            conexao.commit();
            return true;         
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Publico! Erro: "
                    +ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rolback "+e.getMessage());
                e.printStackTrace();
            }
            return false;           
        }
    }

    @Override
    public Object carregar(int numero) {
        int idPublico = numero;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Publico oPublico = null;
        String sql="select * from publico where idPublico=?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPublico);
            rs=stmt.executeQuery();          
            while (rs.next()) {                
               oPublico = new Publico();
               oPublico.setIdPublico(rs.getInt("idPublico"));
               oPublico.setIdadePublico(rs.getString("idadePublico"));
            }
            return oPublico;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Publico! Erro:"+ex.getMessage());
            return false;   
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from publico order by idPublico";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Publico oPublico = new Publico();
                oPublico.setIdPublico(rs.getInt("idPublico"));            
                oPublico.setIdadePublico(rs.getString("idadePublico"));
                resultado.add(oPublico);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Estado! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}

