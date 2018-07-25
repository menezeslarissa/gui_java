/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.SituacaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Situacao;

/**
 *
 * @author Aluno
 */
public class SituacaoControle {
    private Situacao situacao = new Situacao();
    private List<Situacao> s = new ArrayList<>();
    private SituacaoDAO situacaoDAO = new SituacaoDAO();

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Situacao> getS() {
        return s;
    }

    public void setS(List<Situacao> s) {
        this.s = s;
    }
    
    public void inserir() throws SQLException{
        situacaoDAO.inserir(this.situacao);
    }
    
    public void excluir() throws SQLException{
        situacaoDAO.remover(this.situacao);
    }
    
    public void pesquisar(String texto) throws SQLException{
        this.s = situacaoDAO.pesquisar(texto);
    }
    
    
    
 }
