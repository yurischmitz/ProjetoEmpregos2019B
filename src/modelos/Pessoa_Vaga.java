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
public class Pessoa_Vaga {
    
    private int id;
    private int id_pessoa;
    private int id_cargo_empresa;
    private int id_empresa;
    private int id_cargo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_cargo_empresa() {
        return id_cargo_empresa;
    }

    public void setId_cargo_empresa(int id_cargo_empresa) {
        this.id_cargo_empresa = id_cargo_empresa;
    }
    
    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
}