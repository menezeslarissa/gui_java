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
import modelo.GrupoTecnico;
import modelo.Tecnico;
import util.ControlaConexao;

/**
 *
 * @author Aluno
 */



public class GrupoTecnicoDao {

   public GrupoTecnico consultaGrupo(int id) {
       Connection conexao = null;
       GrupoTecnico grupoTecnico = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "select *from grupotecnico where gru_id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {    
                grupoTecnico = new GrupoTecnico(rs.getInt("gru_id"),rs.getString("gru_descricao"));
            }
            
            conexao.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        
        }
        return grupoTecnico;
    }
   
    public List<GrupoTecnico> listar() {
        
        List<GrupoTecnico> grupoTecnicos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select *from grupotecnico";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                GrupoTecnico grupoTecnico = new GrupoTecnico(rs.getInt("gru_id"),rs.getString("gru_descricao"));
                        
                grupoTecnicos.add(grupoTecnico);
           }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return grupoTecnicos;
    }

    public void inserir(GrupoTecnico grupoTecnico) {
        Connection c = null;
        try {
            c = ControlaConexao.getConnection();
            String sql = "insert into grupoTecnico (gru_descricao) values (?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, grupoTecnico.getGru_descricao());
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public List<GrupoTecnico> pesquisar(String text) {
        List<GrupoTecnico> grupoTecnicos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select * from grupotecnico where gru_descricao LIKE ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%"+text+"%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                GrupoTecnico grupoTecnico = new GrupoTecnico(rs.getInt("gru_id"),rs.getString("gru_descricao"));
                        
                grupoTecnicos.add(grupoTecnico);
           }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return grupoTecnicos;
    }

    public void excluir(GrupoTecnico grupoTecnico) {
        Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "delete from grupotecnico where gru_id = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setLong(1, grupoTecnico.getGru_id());
            st.execute();
            
            conexao.close();
            
        } catch (SQLException ex) {
            System.out.println("erro ao remover" + ex.getMessage());
        } 
    
    
    }
}
