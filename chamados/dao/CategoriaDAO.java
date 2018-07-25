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
import javax.swing.JOptionPane;
import modelo.Categoria;
import util.ControlaConexao;

/**
 *
 * @author Aluno
 */
public class CategoriaDAO {

    public void inserir(Categoria c) throws SQLException {
        Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "insert into categoria (cat_descricao) values (?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, c.getCat_descricao());
            st.execute();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria no banco", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public void remover(Categoria c) throws SQLException {
        Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "delete from categoria where cat_id = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, c.getCat_id());
            st.execute();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover categoria!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public List<Categoria> pesquisar(String texto) throws SQLException {
        Connection conexao = null;
        List<Categoria> categorias = new ArrayList<>();
        try {
            conexao = ControlaConexao.getConnection();

            String sql = "";
            PreparedStatement st = null;

            if (texto.trim().equals("")) {
                sql = "select cat_id, cat_descricao from categoria";
                st = conexao.prepareStatement(sql);
            } else {

                sql = "select cat_id, cat_descricao from categoria where cat_descricao like ?";
                st = conexao.prepareStatement(sql);
                st.setString(1, "%" + texto + "%");

            }

            ResultSet resultado = st.executeQuery();

            while (resultado.next()) {
                Categoria c = new Categoria();

                c.setCat_id(resultado.getInt("cat_id"));
                c.setCat_descricao(resultado.getString("cat_descricao"));
                categorias.add(c);
            }
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar categoria!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
        return categorias;
    }

}
