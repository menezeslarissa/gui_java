/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.GrupoTecnicoDao;
import java.util.ArrayList;
import java.util.List;
import modelo.GrupoTecnico;

/**
 *
 * @author Aluno
 */
public class GrupoTecnicoControle {
    private List<GrupoTecnico> grupoTecnicos = new ArrayList<>();
    private GrupoTecnico grupoTecnico;

    public GrupoTecnicoControle() {
    }

    public List<GrupoTecnico> getGrupoTecnicos() {
        return grupoTecnicos;
    }

    public void setGrupoTecnicos(List<GrupoTecnico> grupoTecnicos) {
        this.grupoTecnicos = grupoTecnicos;
    }

    public GrupoTecnico getGrupoTecnico() {
        return grupoTecnico;
    }

    public void setGrupoTecnico(GrupoTecnico grupoTecnico) {
        this.grupoTecnico = grupoTecnico;
    }
    
    public void listar(){
        GrupoTecnicoDao dao = new GrupoTecnicoDao();
        this.grupoTecnicos = dao.listar();
    }
    
    
    public void inserir(){
        GrupoTecnicoDao dao = new GrupoTecnicoDao();
        dao.inserir(grupoTecnico);
    }

    public void pesquisa(String text) {
        GrupoTecnicoDao dao = new GrupoTecnicoDao();
        this.grupoTecnicos = dao.pesquisar(text);
    }

    public void remover() {
        GrupoTecnicoDao dao = new GrupoTecnicoDao();
        dao.excluir(grupoTecnico);
        
    }
    
    
}
