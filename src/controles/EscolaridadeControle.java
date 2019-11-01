/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.Vector;
import modelos.Escolaridade;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author ruanw
 */
public class EscolaridadeControle {
    
    Escolaridade objEscolaridade;
    JTable jtbEscolaridade = null;
    
    public EscolaridadeControle(Escolaridade objEscolaridade, JTable jtbEscolaridade){
        this.objEscolaridade = objEscolaridade;
        this.jtbEscolaridade = jtbEscolaridade; 
        
    }
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO escolaridades(escolaridade) VALUES(?)");
            stmt.setString(1, objEscolaridade.getEscolaridade());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
    
    
    public boolean alterar(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE escolaridades SET escolaridade=? WHERE id=?");
            stmt.setString(1, objEscolaridade.getEscolaridade());
            stmt.setInt(2, objEscolaridade.getId());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
    
    public void preencher(){

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Código");
        cabecalhos.add("Escolaridade");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, escolaridade ";
            SQL += " FROM escolaridades ";
            SQL += " WHERE data_exclusao is null ";
            SQL += " ORDER BY escolaridade ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbEscolaridade.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbEscolaridade.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbEscolaridade.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(180);
                    break;
                case 2:
                    column.setPreferredWidth(180);
                    break;
                case 3:
                    column.setPreferredWidth(20);
                    break;
            }
        }
        
        jtbEscolaridade.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }
    
     public Escolaridade buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, escolaridade ";
            SQL += " FROM escolaridades ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null ";
            //SQL = " SELECT b.id, b.nome, b.id_cidade, e.uf ";
            //SQL += " FROM bairros b, cidades c, estados e ";
            //SQL += " WHERE b.id_cidade = c.id AND c.uf_estados = e.uf AND b.id = '" + id + "'";
            //SQL += " AND b.data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objEscolaridade = new Escolaridade();
                if(rs.next() == true)
                {
                    objEscolaridade.setId(rs.getInt(1));
                    objEscolaridade.setEscolaridade(rs.getString(2));
                    //objBairro.setUf_estado(rs.getString(4));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar escolaridades com sucesso");
        return objEscolaridade;
    }
     
     public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE escolaridades SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objEscolaridade.getId());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
}
