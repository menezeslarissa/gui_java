/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class SituacaoTableModel extends AbstractTableModel {

    private Situacao situacao;
    private List<Situacao> s;
            
    public SituacaoTableModel(List<Situacao> s) {
        this.s = s;
    }

    @Override
    public int getRowCount() {
        return s.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        situacao = s.get(linha);
        switch(coluna){
            case 0:
                return situacao.getSit_id();
            case 1:
                return situacao.getSit_descricao();
        }
        return null;
    }

    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0:
                return "Código";
            case 1:
                return "Descricão";
        }
        return null;
    }
    
    

}
