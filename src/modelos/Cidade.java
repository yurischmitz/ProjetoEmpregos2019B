/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author ruanw
 */
public class Cidade {
    
    private int id;
    private String nome;
    private String uf_estados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf_estados() {
        return uf_estados;
    }

    public void setUf_estados(String uf_estados) {
        this.uf_estados = uf_estados;
    }

    
}
