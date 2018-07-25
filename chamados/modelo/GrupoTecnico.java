/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class GrupoTecnico {
     private int gru_id;
    private String gru_descricao;

    public GrupoTecnico(int gru_id, String gru_descricao) {
        this.gru_id = gru_id;
        this.gru_descricao = gru_descricao;
    }

    public GrupoTecnico(String gru_descricao) {
        this.gru_descricao = gru_descricao;
    }

    public int getGru_id() {
        return gru_id;
    }

    public void setGru_id(int gru_id) {
        this.gru_id = gru_id;
    }

    public String getGru_descricao() {
        return gru_descricao;
    }

    public void setGru_descricao(String gru_descricao) {
        this.gru_descricao = gru_descricao;
    }
}
