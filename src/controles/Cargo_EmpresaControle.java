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

/**
 *
 * @author ruanw
 */
public class Cargo_EmpresaControle {
    
    Cargo_Empresa objCargo_Empresa;
    JTable jtbCargos_Empresas = null;
    
    public Cargo_EmpresaControle(Cargo_Empresa objCargo_Empresa, JTable jtbCargos_Empresas) {
        this.objCargo_Empresa = objCargo_Empresa;
        this.jtbCargos_Empresas = jtbCargos_Empresas;
    }
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO cargo_empresa(id_cargo,id_empresa) VALUES(?,?)");
            stmt.setInt(1, objCargo_Empresa.getId_cargo());
            stmt.setInt(2, objCargo_Empresa.getId_empresa());
            
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
            stmt = con.prepareStatement("UPDATE cargo_empresa SET id_cargo=?,id_empresa=? WHERE id=?");
            stmt.setInt(1, objCargo_Empresa.getId_cargo());
            stmt.setInt(2, objCargo_Empresa.getId_empresa());
            stmt.setInt(3, objCargo_Empresa.getId());
            
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
        cabecalhos.add("Empresa");
        cabecalhos.add("Cargo");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {
            String SQL = "";
            SQL = " SELECT ce.id, e.nome as empresa, c.nome as cargo ";
            SQL += " FROM cargo_empresa ce, cargos c, empresas e ";
            SQL += " WHERE ce.id_cargo = c.id AND ce.id_empresa = e.id AND ce.data_exclusao is null ";
            SQL += " ORDER BY e.nome, c.nome ";
            
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

        jtbCargos_Empresas.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCargos_Empresas.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbCargos_Empresas.getColumnModel().getColumn(i);
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
        
        jtbCargos_Empresas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Cargo_Empresa buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, id_cargo, id_empresa ";
            SQL += " FROM cargo_empresa ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objCargo_Empresa = new Cargo_Empresa();
                if(rs.next() == true)
                {
                    objCargo_Empresa.setId(rs.getInt(1));
                    objCargo_Empresa.setId_cargo(rs.getInt(2));
                    objCargo_Empresa.setId_empresa(rs.getInt(3));
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
        return objCargo_Empresa;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cargo_empresa SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objCargo_Empresa.getId());
                        
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
