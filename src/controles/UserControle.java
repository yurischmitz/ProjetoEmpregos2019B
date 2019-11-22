/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import ferramentas.CaixaDeDialogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import modelos.Usuario;

/**
 *
 * @author yuris
 */
public class UserControle {
    
    Usuario objUsuario;
    
    public UserControle(Usuario objUsuario, JTable jtbBairros) {
        this.objUsuario = objUsuario;
        //this.jtbUsuario = jtbUsuario;
    }
    
    public boolean incluir(){
        
        if(verificaExistenciaCPF() == true){
            return false;
        }
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO usuarios(login, nome, senha, nivel, cpf) VALUES (?, ?, MD5(?), ?, ?)");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getNome());
            stmt.setString(3, objUsuario.getSenha());
            stmt.setString(4, objUsuario.getNivel());
            stmt.setString(5, objUsuario.getCpf());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public Boolean verificaExistenciaCPF(){
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id ";
            SQL += " FROM usuarios ";
            SQL += " WHERE cpf = '" + objUsuario.getCpf() + "'";
            //SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    if(rs.getString(1) != objUsuario.getCpf()){
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Esse CPF já existe");
                        return true; //Já existe uma pessoa com este CPF
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return false;
        }
    }
    
}
