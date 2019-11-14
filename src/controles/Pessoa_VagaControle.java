/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Cargo_Empresa;
import modelos.Pessoa_Vaga;

/**
 *
 * @author ruanw
 */
public class Pessoa_VagaControle {
    Pessoa_Vaga objPessoa_Vaga;
    JTable jtbPessoa_Vaga = null;
    
    public Pessoa_VagaControle(Pessoa_Vaga objPessoa_Vaga, JTable jtbPessoa_Vaga) {
        this.objPessoa_Vaga = objPessoa_Vaga;
        this.jtbPessoa_Vaga = jtbPessoa_Vaga;
    }
    
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO pessoas_vagas(id_pessoa,id_cargo_empresa) VALUES(?,?)");
            stmt.setInt(1, objPessoa_Vaga.getId_pessoa());
            stmt.setInt(2, objPessoa_Vaga.getId_cargo_empresa());
            
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
            stmt = con.prepareStatement("UPDATE pessoas_vagas SET id_pessoa=?,id_cargo_empresa=? WHERE id=?");
            stmt.setInt(1, objPessoa_Vaga.getId_pessoa());
            stmt.setInt(2, objPessoa_Vaga.getId_cargo_empresa());
            stmt.setInt(3, objPessoa_Vaga.getId());
            
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
        cabecalhos.add("Pessoa");
        cabecalhos.add("Empresa");
        cabecalhos.add("Cargo");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {
            String SQL = "";
            SQL = " SELECT pv.id as codigo, p.nome as pessoa, c.nome as cargo, e.nome as empresa ";
            SQL += " FROM pessoas p,  cargos c, empresas e, pessoas_vagas pv, cargo_empresa ce ";
            SQL += " WHERE p.id = pv.id_pessoa AND ce.id = pv.id_cargo_empresa AND ";
            SQL += " ce.id_cargo = c.id AND ce.id_empresa = e.id AND pv.data_exclusao is null ";
            SQL += " ORDER BY e.nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbPessoa_Vaga.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbPessoa_Vaga.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbPessoa_Vaga.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(10);
                    break;
                case 1:
                    column.setPreferredWidth(100);
                    break;
                case 2:
                    column.setPreferredWidth(10);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbPessoa_Vaga.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Pessoa_Vaga buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, id_pessoa, id_cargo_empresa ";
            SQL += " FROM pessoas_vagas ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objPessoa_Vaga = new Pessoa_Vaga();
                if(rs.next() == true)
                {
                    objPessoa_Vaga.setId(rs.getInt(1));
                    objPessoa_Vaga.setId_pessoa(rs.getInt(2));
                    objPessoa_Vaga.setId_cargo_empresa(rs.getInt(3));
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
        
        System.out.println ("Executou buscar area com sucesso");
        return objPessoa_Vaga;
    }
      
    
     public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pessoas_vagas SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objPessoa_Vaga.getId());
                        
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
