/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import ferramentas.CaixaDeDialogo;
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
import modelos.Empresa;

/**
 *
 * @author ruanw
 */
public class EmpresaControle {
    
    Empresa objEmpresa;
    JTable jtbEmpresas = null;
    
    public EmpresaControle(Empresa objEmpresa, JTable jtbEmpresas) {
        this.objEmpresa = objEmpresa;
        this.jtbEmpresas = jtbEmpresas;
    }
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO empresas(nome,cnpj) VALUES(?,?)");
            stmt.setString(1, objEmpresa.getNome());
            stmt.setString(2, objEmpresa.getCnpj());
            
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
            stmt = con.prepareStatement("UPDATE empresas SET nome=?,cnpj=? WHERE id=?");
            stmt.setString(1, objEmpresa.getNome());
            stmt.setString(2, objEmpresa.getCnpj());
            stmt.setInt(3, objEmpresa.getId());
            
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
        cabecalhos.add("Nome");
        cabecalhos.add("Cnpj");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, nome, cnpj ";
            SQL += " FROM empresas ";
            SQL += " WHERE data_exclusao is null ";
            SQL += " ORDER BY nome ";
            
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

        jtbEmpresas.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbEmpresas.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbEmpresas.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(150);
                    break;
                case 2:
                    column.setPreferredWidth(180);
                    break;
                case 3:
                    column.setPreferredWidth(180);
                    break;
            }
        }
        
        jtbEmpresas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Empresa buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, nome, cnpj ";
            SQL += " FROM empresas ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null ";


            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objEmpresa = new Empresa();
                if(rs.next() == true)
                {
                    objEmpresa.setId(rs.getInt(1));
                    objEmpresa.setNome(rs.getString(2));
                    objEmpresa.setCnpj(rs.getString(3));
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
        return objEmpresa;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE empresas SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objEmpresa.getId());
                        
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
