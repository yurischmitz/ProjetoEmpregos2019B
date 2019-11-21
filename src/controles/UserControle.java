/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO usuarios(login, nome, senha, nivel) VALUES (?, ?, ?, ?)");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getNome());
            stmt.setString(3, objUsuario.getSenha());
            stmt.setString(4, objUsuario.getNivel());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
}
