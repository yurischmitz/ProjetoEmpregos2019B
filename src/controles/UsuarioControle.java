/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author ruanw
 */
public class UsuarioControle {
    
    Usuario objUsuario;
    
    public Usuario Login(String usuario, String senha){
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        Conexao.abreConexao();
        
        Usuario user = null;
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT id, login, nome, nivel, cpf");
        comandoSQL.append(" FROM usuarios");
        comandoSQL.append(" WHERE login = '" + usuario + "'");
        comandoSQL.append(" AND senha = MD5('" + senha + "')");
        //comandoSQL.append(" AND senha = '" + senha + "'");

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = Conexao.stmt.executeQuery(comandoSQL.toString());
            System.out.println("Executou Conexão em buscar area");
            
            if (rs.next() == true) {
                user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setNome(rs.getString("nome"));
                user.setNivel(rs.getString("nivel"));
                user.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            return user;
        }finally{
            Connection con = Conexao.obterConexao();
            System.out.println("Vai fechar a conexão com o banco de dados");
            Conexao.fecharConexao(con);
        }
        
        return user;
        
    }
    
}
