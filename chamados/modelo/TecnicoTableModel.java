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
public class TecnicoTableModel extends AbstractTableModel{
    private Tecnico tecnico;
    private List<Tecnico> tecnicos;

    public TecnicoTableModel(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    @Override
    public int getRowCount() {
        return tecnicos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        tecnico = tecnicos.get(linha);
        switch(coluna){
            case 0:
                return tecnico.getTec_id();
            case 1: 
                return tecnico.getGrupoTecnico().getGru_descricao();
            case 2:
                return tecnico.getTec_nome();
            case 3: 
                return tecnico.getTec_email();
            case 4:
                return tecnico.getTec_telefone();
        }
        return null;
    }

    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0:
                return "Código";
            case 1:
                return "Grupo";
            case 2:
                return "Nome";
            case 3:
                return "Email";
            case 4:
                return "Telefone";
        }
        return null;
    }
    
    
}
