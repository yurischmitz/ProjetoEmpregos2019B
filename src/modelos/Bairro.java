package modelos;

/**
 *
 * @author jdhein
 */
public class Bairro {
    
    private int id;
    private String nome;
    private int id_cidade;
    //private String uf_estado;

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

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    /*public String getUf_estado() {
        return uf_estado;
    }

    public void setUf_estado(String uf_estado) {
        this.uf_estado = uf_estado;
    }*/
    
}