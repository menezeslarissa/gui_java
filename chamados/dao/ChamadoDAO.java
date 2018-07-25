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
import java.util.Calendar;
import java.util.List;
import modelo.Chamado;
import modelo.Tecnico;
import util.ControlaConexao;
import util.DataUtil;

/**
 *
 * @author Aluno
 */
public class ChamadoDAO {

    public void remover(Chamado chamado) {
         Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "delete from chamado where cha_id = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setLong(1, chamado.getId());
            st.execute();
            
            conexao.close();
            
        } catch (SQLException ex) {
            System.out.println("erro ao remover chamado" + ex.getMessage());
        } 
    }

    public List<Chamado> listar() {
                List<Chamado> chamados = new ArrayList<>();
                Connection connection = null;
                try {
                    connection = ControlaConexao.getConnection();
                    String sql = "select *from chamado";
                    PreparedStatement st = connection.prepareStatement(sql);
                    ResultSet rs = st.executeQuery();

                    
                    while (rs.next()) {
                        Calendar c = Calendar.getInstance();
                        c.setTime(rs.getDate("cha_data"));
                        TecnicoDao dao = new TecnicoDao();
                        SituacaoDAO Sdao = new SituacaoDAO();
                        Chamado chamado = new Chamado(rs.getInt("cha_id"),rs.getString("cha_titulo"),c, dao.consultaTecnico(rs.getByte("cha_tec_id")),
                                Sdao.consultaSit(rs.getInt("cha_sit_id")));
                        
                        chamados.add(chamado);
                        
                   }
                     connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                return chamados;
    }

    public void inserir(Chamado chamado) {
        Connection c = null;
        try {
            c = ControlaConexao.getConnection();
            String sql = "insert into chamado (cha_cat_id, cha_tec_id, cha_sit_id ,cha_titulo,cha_descricao, cha_data, cat_descricao) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,chamado.getCategoria().getCat_id());
            ps.setInt(2, chamado.getTecnico().getTec_id());
            ps.setInt(3, chamado.getSituacao().getSit_id());
            ps.setString(4,chamado.getTitulo());
            ps.setString(5, chamado.getDescricao());
            ps.setDate(6, new java.sql.Date(chamado.getDate().getTimeInMillis()));
            ps.setString(7, chamado.getCategoria().getCat_descricao());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Chamado> pesquisar(String text) {
       List<Chamado> chamados = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select * from chamado where cha_titulo LIKE ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%"+text+"%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
              Calendar c = Calendar.getInstance();
                        c.setTime(rs.getDate("cha_data"));
                        TecnicoDao dao = new TecnicoDao();
                        SituacaoDAO Sdao = new SituacaoDAO();
                        Chamado chamado = new Chamado(rs.getInt("cha_id"),rs.getString("cha_titulo"),c, dao.consultaTecnico(rs.getByte("cha_tec_id")),
                                Sdao.consultaSit(rs.getInt("cha_sit_id")));
                        
                chamados.add(chamado);
           }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return chamados;
    
    
    }
    
    
    
    
    
}
