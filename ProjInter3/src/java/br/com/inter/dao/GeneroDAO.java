package br.com.inter.dao;
import br.curso.inter.model.Genero;
import br.com.inter.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GeneroDAO implements GenericDAO {
    private Connection conexao;

    public GeneroDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }
   @Override
    public Boolean cadastrar(Object objeto){
        Genero oGenero = (Genero) objeto;
        Boolean retorno=false;
        if (oGenero.getIdGenero()== 0){
            retorno = this.inserir(oGenero);
        }else{
            retorno = this.alterar(oGenero);
        }
        return retorno;        
    }
   @Override
    public Boolean inserir(Object objeto){
        Genero oGenero = (Genero) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into genero (tipogenero,descricaogenero) values (?,?)";  
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oGenero.getTipoGenero());        
            stmt.setString(2, oGenero.getDescricaoGenero());        
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Genero! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e){
                System.out.println("Erro:"+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }
   @Override
    public Boolean alterar(Object objeto) {
        Genero oGenero = (Genero) objeto;
        PreparedStatement stmt = null;
        String sql = "update genero set tipogenero=?,descricaogenero=? where idgenero=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oGenero.getTipoGenero());        
            stmt.setString(2, oGenero.getDescricaoGenero());        
            stmt.setInt(3, oGenero.getIdGenero());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Genero! Erro: "+ex.getMessage());
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
        int idGenero = numero;
        PreparedStatement stmt= null;

        String sql = "delete from genero where idgenero=?";
        try {
            stmt = conexao.prepareStatement(sql);         
            stmt.setInt(1, idGenero);            
            stmt.execute();
            conexao.commit();
            return true;         
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Genero! Erro: "
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
        int idGenero = numero;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Genero oGenero = null;
        String sql="select * from genero where idGenero=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idGenero);
            rs=stmt.executeQuery();          
            while (rs.next()) {                
                oGenero = new Genero();
                oGenero.setIdGenero(rs.getInt("idgenero"));
                oGenero.setTipoGenero(rs.getString("tipogenero"));
                oGenero.setDescricaoGenero(rs.getString("descricaogenero"));
            }
            return oGenero;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Genero! Erro:"+ex.getMessage());
            return false;   
        }
    }
    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from genero order by idgenero";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Genero oGenero = new Genero();
                oGenero.setIdGenero(rs.getInt("idgenero"));
                oGenero.setTipoGenero(rs.getString("tipogenero"));
                oGenero.setDescricaoGenero(rs.getString("descricaogenero"));
                resultado.add(oGenero);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Genero! Erro: " + ex.getMessage());
        }
        return resultado;
    }
}
