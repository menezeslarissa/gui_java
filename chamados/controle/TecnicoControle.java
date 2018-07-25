/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.TecnicoDao;
import java.util.ArrayList;
import java.util.List;
import modelo.Tecnico;

/**
 *
 * @author Aluno
 */
public class TecnicoControle {

    private List<Tecnico> tecnicos = new ArrayList<>();
    private Tecnico tecnico;

    public TecnicoControle(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public TecnicoControle() {
    
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void listar() {
        TecnicoDao tecnicoDao = new TecnicoDao();
        this.tecnicos = tecnicoDao.listar();
    }

    public void inserir() {
        TecnicoDao tecnicoDao = new TecnicoDao();
        tecnicoDao.inserir(tecnico);
    }
    
    public void pesquisar(String text){
        TecnicoDao dao = new TecnicoDao();
        this.tecnicos = dao.pesquisar(text);
    }

    public void remover() {
        TecnicoDao dao = new TecnicoDao();
        dao.remover(tecnico);
    }
    

}
