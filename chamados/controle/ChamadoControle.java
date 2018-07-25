/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ChamadoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Chamado;

/**
 *
 * @author Aluno
 */
public class ChamadoControle {
    private List<Chamado> chamados = new ArrayList<>();
    private Chamado  chamado;

    public ChamadoControle(Chamado chamado) {
        this.chamado = chamado;
    }

    public ChamadoControle() {
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public void listar() {
        ChamadoDAO dAO = new ChamadoDAO();
        this.chamados = dAO.listar();
    }
    
    public void excluir() {
        ChamadoDAO dAO = new ChamadoDAO();
        dAO.remover(chamado);
    }

    public void inserir() {
      ChamadoDAO dAO = new ChamadoDAO();
      dAO.inserir(chamado);
    }

    public void pesquisar(String text) {
      ChamadoDAO dAO = new ChamadoDAO();
      this.chamados = dAO.pesquisar(text);
    }

    
}
