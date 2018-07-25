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
public class Tecnico {
     private int tec_id;
        private GrupoTecnico grupoTecnico;
        
        private String tec_nome;
        private String tec_email;
        private String tec_telefone;

    public Tecnico(int tec_id, GrupoTecnico grupoTecnico, String tec_nome, String tec_email, String tec_telefone) {
        this.tec_id = tec_id;
        this.grupoTecnico = grupoTecnico;
        this.tec_nome = tec_nome;
        this.tec_email = tec_email;
        this.tec_telefone = tec_telefone;
    }

    public Tecnico(GrupoTecnico grupoTecnico, String tec_nome, String tec_email, String tec_telefone) {
        this.grupoTecnico = grupoTecnico;
        this.tec_nome = tec_nome;
        this.tec_email = tec_email;
        this.tec_telefone = tec_telefone;
    }

    public int getTec_id() {
        return tec_id;
    }

    public void setTec_id(int tec_id) {
        this.tec_id = tec_id;
    }

    public GrupoTecnico getGrupoTecnico() {
        return grupoTecnico;
    }

    public void setGrupoTecnico(GrupoTecnico grupoTecnico) {
        this.grupoTecnico = grupoTecnico;
    }

    public String getTec_nome() {
        return tec_nome;
    }

    public void setTec_nome(String tec_nome) {
        this.tec_nome = tec_nome;
    }

    public String getTec_email() {
        return tec_email;
    }

    public void setTec_email(String tec_email) {
        this.tec_email = tec_email;
    }

    public String getTec_telefone() {
        return tec_telefone;
    }

    public void setTec_telefone(String tec_telefone) {
        this.tec_telefone = tec_telefone;
    }
}
