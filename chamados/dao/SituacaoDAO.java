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
import modelo.Situacao;
import util.ControlaConexao;

/**
 *
 * @author Aluno
 */
public class SituacaoDAO {

    public Situacao consultaSit(int id) {
        Connection conexao = null;
        Situacao situacao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "select *from situacao where sit_id  = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                situacao = new Situacao();
                situacao.setSit_descricao(rs.getString("sit_descricao"));
                situacao.setSit_id(rs.getInt("sit_id"));
            }

            conexao.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return situacao;
    }

    private Object conexao;

    public void inserir(Situacao s) throws SQLException {
        Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "insert into situacao (sit_descricao) values (?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, s.getSit_descricao());
            st.execute();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria no banco", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public void remover(Situacao s) throws SQLException {
        Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "delete from situacao where sit_id = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, s.getSit_id());
            st.execute();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover categoria!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public List<Situacao> pesquisar(String texto) throws SQLException {
        Connection conexao = null;
        List<Situacao> situacoes = new ArrayList<>();
        try {
            conexao = ControlaConexao.getConnection();

            String sql = "";
            PreparedStatement st = null;

            if (texto.trim().equals("")) {
                sql = "select sit_id, sit_descricao from situacao";
                st = conexao.prepareStatement(sql);
            } else {

                sql = "select sit_id, sit_descricao from situacao where sit_descricao like ?";
                st = conexao.prepareStatement(sql);
                st.setString(1, "%" + texto + "%");

            }

            ResultSet resultado = st.executeQuery();

            while (resultado.next()) {
                Situacao s = new Situacao();

                s.setSit_id(resultado.getInt("sit_id"));
                s.setSit_descricao(resultado.getString("sit_descricao"));
                situacoes.add(s);
            }
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar situação!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
        return situacoes;
    }
}
