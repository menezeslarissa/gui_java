/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

/**
 *
 * @author Aluno
 */
public class CategoriaControle {
    private Categoria categoria;
    private List<Categoria> categorias = new ArrayList<>();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    public void pesquisar(String texto) throws SQLException{
        
        this.categorias = categoriaDAO.pesquisar(texto);
    }
    public void excluir() throws SQLException{
        categoriaDAO.remover(this.categoria);
    }
    public void inserir() throws SQLException{
        categoriaDAO.inserir(this.categoria);
    }
}
