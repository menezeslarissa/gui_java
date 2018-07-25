/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

/**
 *
 * @author Aluno
 */
public class ChamadoTableModel extends AbstractTableModel{
    private Chamado chamado;
    private List<Chamado> chamados;

    public ChamadoTableModel(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    
    
    @Override
    public int getRowCount() {
        return chamados.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        chamado = chamados.get(linha);
        switch(coluna){
            case 0:
                return chamado.getId();
            case 1: 
                return chamado.getTitulo();
            case 2:
                return chamado.getTecnico().getTec_nome();
            case 3:
                return chamado.getSituacao().getSit_descricao();
        }
        return null;
    }

    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0:
                return "Codigo";
            case 1:
                return "titulo";
            case 2:
                return "Tecnico";
            case 3:
                return "situacão";
           
        }
        return null;
    }
}
