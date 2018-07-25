/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class Chamado {
    private long id;
    private Categoria categoria;
    private Tecnico tecnico;
    private Situacao situacao;
    private String titulo;
    private String descricao;
    private Calendar date;

    
    
    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public Chamado(long id, String titulo,Calendar Date, Tecnico tecnico,Situacao situacao){
        this.id = id;
        this.titulo = titulo;
        this.date = date;
        this.tecnico = tecnico;
        this.situacao = situacao;
    }

    public Chamado(String titulo, String descricao, Calendar date, Tecnico tecnico, Situacao situacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.date = date;
        this.tecnico = tecnico;
        this.situacao = situacao;
    }

    public Chamado(Categoria categoria, Tecnico tecnico, Situacao situacao, String titulo, String descricao, Calendar date) {
        this.categoria = categoria;
        this.tecnico = tecnico;
        this.situacao = situacao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.date = date;
    }
    
    
    
    public long getId(){
        return this.id;
    }
     public void setId(long id){
          this.id = id;
     }
     
     public String  getTitulo(){
         return this.titulo;
     }
     
     public void setTitulo(){
         this.titulo = titulo;
     }
     
     public Calendar getDate(){
         return this.date;
     }
     
     public void setDate(Calendar Date){
          this.date = date;
     }
     public void setTecnico(Tecnico tecnico){
         this.tecnico = tecnico;
     }
     
     public Situacao getSituacao(){
         return  this.situacao;
     }
     
     public void setSituacao(Situacao situacao){
         this.situacao = situacao;
     }
}
