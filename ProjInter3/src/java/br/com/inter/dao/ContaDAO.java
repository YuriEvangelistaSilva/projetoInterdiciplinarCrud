package br.com.inter.dao;
import br.com.curso.model.Conta;
import br.com.inter.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ContaDAO implements GenericDAO {
    private Connection conexao;

    public ContaDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }
   @Override
    public Boolean cadastrar(Object objeto){
        Conta oConta = (Conta) objeto;
        Boolean retorno=false;
        if (oConta.getIdConta()== 0){
            retorno = this.inserir(oConta);
        }else{
            retorno = this.alterar(oConta);
        }
        return retorno;        
    }
   @Override
    public Boolean inserir(Object objeto){
        Conta oConta = (Conta) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into conta (nomeusuario, emailconta,senhaconta) values (?,?,?)";  
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oConta.getNomeUsuario());
            stmt.setString(2, oConta.getEmailConta());        
            stmt.setString(3, oConta.getSenhaConta());        
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Conta! Erro: "+ex.getMessage());
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
        Conta oConta = (Conta) objeto;
        PreparedStatement stmt = null;
        String sql = "update conta set nomeusuario =?, emailconta=?,senhaconta=? where idconta=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oConta.getNomeUsuario());
            stmt.setString(2, oConta.getEmailConta());        
            stmt.setString(3, oConta.getSenhaConta());        
            stmt.setInt(4, oConta.getIdConta());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Conta! Erro: "+ex.getMessage());
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
        int idConta = numero;
        PreparedStatement stmt= null;

        String sql = "delete from conta where idconta=?";
        try {
            stmt = conexao.prepareStatement(sql);         
            stmt.setInt(1, idConta);            
            stmt.execute();
            conexao.commit();
            return true;         
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Conta! Erro: "
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
        int idConta = numero;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Conta oConta = null;
        String sql="select * from conta where idConta=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idConta);
            rs=stmt.executeQuery();          
            while (rs.next()) {                
                oConta = new Conta();
                oConta.setIdConta(rs.getInt("idconta"));
                oConta.setNomeUsuario(rs.getString("nomeusuario"));
                oConta.setEmailConta(rs.getString("emailconta"));
                oConta.setSenhaConta(rs.getString("senhaconta"));
            }
            return oConta;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Conta! Erro:"+ex.getMessage());
            return false;   
        }
    }
    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from conta order by idconta";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Conta oConta = new Conta();
                oConta.setIdConta(rs.getInt("idconta"));
                oConta.setNomeUsuario(rs.getString("nomeusuario"));
                oConta.setEmailConta(rs.getString("emailconta"));
                oConta.setSenhaConta(rs.getString("senhaconta"));
                resultado.add(oConta);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Conta! Erro: " + ex.getMessage());
        }
        return resultado;
    }
}
