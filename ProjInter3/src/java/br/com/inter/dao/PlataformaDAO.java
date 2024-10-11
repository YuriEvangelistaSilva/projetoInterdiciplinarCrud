package br.com.inter.dao;


import br.com.inter.utils.SingleConnection;
import br.curso.inter.model.Plataforma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlataformaDAO implements GenericDAO {

    private Connection conexao;

    public PlataformaDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Plataforma oPlataforma = (Plataforma) objeto;
        Boolean retorno = false;
        if (oPlataforma.getIdPlataforma() == 0) {
            retorno = this.inserir(oPlataforma);
        } else {
            retorno = this.alterar(oPlataforma);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Plataforma oPlataforma = (Plataforma) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into plataforma (nomeplataforma) values (?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPlataforma.getNomePlataforma());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a plataforma! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Plataforma oPlataforma = (Plataforma) objeto;
        PreparedStatement stmt = null;
        String sql = "update plataforma set nomeplataforma=? where idplataforma=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPlataforma.getNomePlataforma());
            stmt.setInt(2, oPlataforma.getIdPlataforma());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Plataforma! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idPlataforma = numero;
        PreparedStatement stmt = null;

        String sql = "delete from plataforma where idplataforma=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPlataforma);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Plataforma! Erro: "
                    + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rolback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idPlataforma = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Plataforma oPlataforma = null;
        String sql = "select * from plataforma where idplataforma=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPlataforma);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oPlataforma = new Plataforma();
                oPlataforma.setIdPlataforma(rs.getInt("idplataforma"));
                oPlataforma.setNomePlataforma(rs.getString("nomeplataforma"));
            }
            return oPlataforma;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Publico! Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from plataforma order by idplataforma";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Plataforma oPlataforma = new Plataforma();
                oPlataforma.setIdPlataforma(rs.getInt("idplataforma"));
                oPlataforma.setNomePlataforma(rs.getString("nomeplataforma"));
                resultado.add(oPlataforma);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Genero! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
