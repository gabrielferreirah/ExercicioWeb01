package br.com.escola.dao;

import br.com.escola.bean.EscolaBean;
import br.com.escola.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel de Oliveira Ferreira
 */
public class EscolaDAO {
    
    public List<EscolaBean> obterTodos() { 
        List<EscolaBean> escolas = new ArrayList<>();
        String sql = "SELECT * FROM boletim";
        
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {                
                EscolaBean escola = new EscolaBean();
                escola.setId(resultSet.getInt("id"));
                escola.setNome(resultSet.getString("nome"));
                escola.setMatricula(resultSet.getString("matricula"));
                escola.setNota01(resultSet.getFloat("nota1"));
                escola.setNota02(resultSet.getFloat("nota2"));
                escola.setNota03(resultSet.getFloat("nota3"));
                escola.setFrequencia(resultSet.getInt("frequencia"));
                escolas.add(escola);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
        return escolas;
    }
    
    public int adicionar(EscolaBean escola){
        String sql = "INSERT INTO boletim (nome, matricula, nota1, nota2, nota3, frequencia)";
        
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, escola.getNome());
            ps.setString(quantidade++, escola.getMatricula());
            ps.setFloat(quantidade++, escola.getNota01());
            ps.setFloat(quantidade++, escola.getNota02());
            ps.setFloat(quantidade++, escola.getNota03());
            ps.setInt(quantidade++, escola.getFrequencia());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }return -1;
    }
    
    public boolean excluir(int id) {
        String sql = "DELETE FROM boletim WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
        return false;
    }
    
    public EscolaBean obterPeloId(int id){
        String sql = "SELECT * FROM  boletim WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                EscolaBean escola = new EscolaBean();
                escola.setId(id);
                escola.setNome(resultSet.getString("nome"));
                escola.setMatricula(resultSet.getString("matricula"));
                escola.setNota01(resultSet.getFloat("nota1"));
                escola.setNota02(resultSet.getFloat("nota2"));
                escola.setNota03(resultSet.getFloat("nota3"));
                escola.setFrequencia(resultSet.getInt("frequencia"));
                return escola;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
        return null;
    }
    
    public boolean alterar(EscolaBean escola){
        String sql  = "UPDATE boletim SET nome = ?, matricula = ?, nota1 = ?, nota2 = ?, nota3 = ?, frequencia = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, escola.getNome());
            ps.setString(2, escola.getMatricula());
            ps.setFloat(3, escola.getNota01());
            ps.setFloat(4, escola.getNota02());
            ps.setFloat(5, escola.getNota03());
            ps.setInt(6, escola.getFrequencia());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
        return false;
    }
}