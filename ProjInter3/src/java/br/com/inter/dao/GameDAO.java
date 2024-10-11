package br.com.inter.dao;

import br.com.inter.utils.SingleConnection;
import br.curso.inter.model.Game;
import br.curso.inter.model.Genero;
import br.curso.inter.model.Publico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements GenericDAO {

    private Connection conexao;

    public GameDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Game oGame = (Game) objeto;
        Boolean retorno = false;
        if (oGame.getIdGame() == 0) {
            retorno = this.inserir(oGame);
        } else {
            retorno = this.alterar(oGame);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Game oGame = (Game) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into Game (nome,categoria,nota_total,descricao_game,situacao,idgenero) values (?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oGame.getNome());
            stmt.setString(2, oGame.getCategoria());
            stmt.setString(3, oGame.getNotaTotal());
            stmt.setString(4, oGame.getDescricaoGame());
            stmt.setString(5, oGame.getSituacao());
            stmt.setInt(6, oGame.getGenero().getIdGenero());            
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Game! Erro: " + ex.getMessage());
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
        Game oGame = (Game) objeto;
        PreparedStatement stmt = null;
        String sql = "update game set nome=?, idgenero=?,categoria=?,nota_total=?,descricao_game=?,situacao=? where idgame=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oGame.getNome());
            stmt.setInt(2, oGame.getGenero().getIdGenero());  
            stmt.setString(3, oGame.getCategoria());
            stmt.setString(4, oGame.getNotaTotal());
            stmt.setString(5, oGame.getDescricaoGame());         
            stmt.setString(6, oGame.getSituacao());
             stmt.setInt(7, oGame.getIdGame());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Game! Erro: " + ex.getMessage());
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
        int idGame = numero;
        PreparedStatement stmt = null;
        String sql = "update game set situacao=? where idgame=?";
        try {
            Game oGame = (Game) this.carregar(idGame);
            stmt = conexao.prepareStatement(sql);
            if (oGame.getSituacao().equals("A")) {
                stmt.setString(1, "I");
            } else {
                stmt.setString(1, "A");
            }
            stmt.setInt(2, idGame);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Game! Erro: " + ex.getMessage());
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
        int idGame = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Game oGame = null;
        String sql = "select * from GAME where idgame=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idGame);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oGame = new Game();
                oGame.setIdGame(rs.getInt("idgame"));
                oGame.setNome(rs.getString("nome"));
                oGame.setCategoria(rs.getString("categoria"));
                oGame.setNotaTotal(rs.getString("nota_total"));
                oGame.setDescricaoGame(rs.getString("descricao_game"));
                oGame.setSituacao(rs.getString("situacao"));

                GeneroDAO oGeneroDAO = new GeneroDAO();
                oGame.setGenero((Genero) oGeneroDAO.carregar(rs.getInt("idgenero")));
            }
            return oGame;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Cidade! Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
        public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from game order by nome";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Game oGame = new Game();
                oGame.setIdGame(rs.getInt("idgame"));
                oGame.setNome(rs.getString("nome"));
                oGame.setCategoria(rs.getString("categoria"));
                oGame.setNotaTotal(rs.getString("nota_total"));
                oGame.setDescricaoGame(rs.getString("descricao_game"));
                oGame.setSituacao(rs.getString("situacao"));

                GeneroDAO oGeneroDAO = null;

                try {
                    oGeneroDAO = new GeneroDAO();

                } catch (Exception ex) {
                    System.out.println("Erro buscar genero" + ex.getMessage());
                    ex.printStackTrace();
                }
                oGame.setGenero((Genero) oGeneroDAO.carregar(rs.getInt("idgenero")));
                resultado.add(oGame);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Game! Erro: "
                    + ex.getMessage());
        }
        return resultado;
    }

}
