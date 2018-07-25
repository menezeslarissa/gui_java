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
public class GrupoTecnicoTableModel extends AbstractTableModel{
    private List<GrupoTecnico> grupoTecnicos;
    private GrupoTecnico grupoTecnico;

    public GrupoTecnicoTableModel(List<GrupoTecnico> grupoTecnicos) {
        this.grupoTecnicos = grupoTecnicos;
    }

    @Override
    public int getRowCount() {
        return grupoTecnicos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        grupoTecnico = grupoTecnicos.get(linha);
        switch(coluna){
            case 0:
                return grupoTecnico.getGru_id();
            case 1: 
                return grupoTecnico.getGru_descricao();
           
        }
        return null;
    }

    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0:
                return "Código";
            case 1:
                return "Descrição";
        }
        return null;
    } 
}
