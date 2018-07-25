/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Tecnico;
import util.ControlaConexao;

/**
 *
 * @author Aluno
 */
public class TecnicoDao {

    public void inserir(Tecnico t) {
        Connection c = null;
        try {
            c = ControlaConexao.getConnection();
            String sql = "insert into tecnico (tec_id, tec_gru_id, tec_nome, tec_email,tec_telefone) values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, t.getTec_id());
            ps.setInt(2, t.getGrupoTecnico().getGru_id());
            ps.setString(3, t.getTec_nome());
            ps.setString(4,t.getTec_email());
            ps.setString(5, t.getTec_telefone());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
     public List<Tecnico> listar() {
        
        List<Tecnico> tecnicos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select *from tecnico";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                GrupoTecnicoDao dao = new GrupoTecnicoDao();

                Tecnico tecnico = new Tecnico(rs.getInt("tec_id"),dao.consultaGrupo(rs.getInt("tec_gru_id")),rs.getString("tec_nome"),rs.getString("tec_email"),
                rs.getString("tec_telefone"));
                        
                tecnicos.add(tecnico);
           }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tecnicos;
    }

     
    public void remover(Tecnico t) {
       Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "delete from tecnico where tec_id = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setLong(1, t.getTec_id());
            st.execute();
            
            conexao.close();
            
        } catch (SQLException ex) {
            System.out.println("erro ao remover tecnico" + ex.getMessage());
        } 
    }
    
    
        public List<Tecnico> pesquisar(String text) {
        List<Tecnico> tecnicos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select * from tecnico where tec_nome LIKE ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%"+text+"%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                
                GrupoTecnicoDao dao = new GrupoTecnicoDao();
                Tecnico tecnico = new Tecnico(rs.getInt("tec_id"), dao.consultaGrupo(rs.getInt("tec_gru_id")),rs.getString("tec_nome"),
                        rs.getString("tec_email"), rs.getString("tec_telefone"));
                        
                tecnicos.add(tecnico);
           }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tecnicos;
    }
        
    
     public Tecnico consultaTecnico(int id) {
       Connection conexao = null;
       Tecnico tecnico = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "select *from tecnico where tec_id  = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {    
                 GrupoTecnicoDao dao = new GrupoTecnicoDao();
                 tecnico = new Tecnico(rs.getInt("tec_id"), dao.consultaGrupo(rs.getInt("tec_gru_id")),rs.getString("tec_nome"), rs.getString("tec_email"), rs.getString("tec_telefone"));
            }
            
            conexao.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tecnico;
    }   
    
        
        
}
