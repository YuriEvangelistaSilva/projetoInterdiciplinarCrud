package br.com.inter.dao;

import br.com.inter.utils.SingleConnection;
import br.curso.inter.model.Catalogo;
import br.curso.inter.model.Game;
import br.curso.inter.model.Genero;
import br.curso.inter.model.Publico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDAO implements GenericDAO {

    private Connection conexao;

    public CatalogoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Catalogo oCatalogo = (Catalogo) objeto;
        Boolean retorno = false;
        if (oCatalogo.getIdCatalogo() == 0) {
            retorno = this.inserir(oCatalogo);
        } else {
            retorno = this.alterar(oCatalogo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Catalogo oCatalogo = (Catalogo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into catalogo (nomecatalogo,tipocatalogo, situacao, idgame) values (?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oCatalogo.getNomeCatalogo());
            stmt.setString(2, oCatalogo.getTipoCatalogo());
            stmt.setString(3, oCatalogo.getSituacao());
            stmt.setInt(4, oCatalogo.getGame().getIdGame());           
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Catalogo! Erro: " + ex.getMessage());
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
        Catalogo oCatalogo = (Catalogo) objeto;
        PreparedStatement stmt = null;
        String sql = "update catalogo set nomecatalogo=?, idgame=?,tipocatalogo=?, situacao=? where idcatalogo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oCatalogo.getNomeCatalogo());
            stmt.setInt(2, oCatalogo.getGame().getIdGame());  
            stmt.setString(3, oCatalogo.getTipoCatalogo());
            stmt.setString(4, oCatalogo.getSituacao());
            stmt.setInt(5, oCatalogo.getIdCatalogo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Catalogo! Erro: " + ex.getMessage());
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
        int idCatalogo = numero;
        PreparedStatement stmt = null;
        String sql = "update catalogo set situacao=? where idcatalogo=?";
        try {
            Catalogo oCatalogo = (Catalogo) this.carregar(idCatalogo);
            stmt = conexao.prepareStatement(sql);
            if (oCatalogo.getSituacao().equals("A")) {
                stmt.setString(1, "I");
            } else {
                stmt.setString(1, "A");
            }
            stmt.setInt(2, idCatalogo);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Catalogo! Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
        public Object carregar(int numero) {
        int idCatalogo = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Catalogo oCatalogo = null;
        String sql = "select * from catalogo where idcatalogo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCatalogo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oCatalogo = new Catalogo();
                oCatalogo.setIdCatalogo(rs.getInt("idcatalogo"));
                oCatalogo.setNomeCatalogo(rs.getString("nomecatalogo"));
                oCatalogo.setTipoCatalogo(rs.getString("tipocatalogo"));
                oCatalogo.setSituacao(rs.getString("situacao"));

                GameDAO oGameDAO = new GameDAO();
                oCatalogo.setGame((Game) oGameDAO.carregar(rs.getInt("idgame")));
            }
            return oCatalogo;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Catalogo! Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
        public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from catalogo order by nomecatalogo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Catalogo oCatalogo = new Catalogo();
                oCatalogo.setIdCatalogo(rs.getInt("idcatalogo"));
                oCatalogo.setNomeCatalogo(rs.getString("nomecatalogo"));
                oCatalogo.setTipoCatalogo(rs.getString("tipocatalogo"));
                oCatalogo.setSituacao(rs.getString("situacao"));

                GameDAO oGameDAO = null;

                try {
                    oGameDAO = new GameDAO();

                } catch (Exception ex) {
                    System.out.println("Erro buscar game" + ex.getMessage());
                    ex.printStackTrace();
                }
                oCatalogo.setGame((Game) oGameDAO.carregar(rs.getInt("idgame")));
                resultado.add(oCatalogo);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Catalogo! Erro: "
                    + ex.getMessage());
        }
        return resultado;
    }

}
