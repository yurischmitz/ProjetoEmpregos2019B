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
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Pessoa;

/**
 *
 * @author ruanw
 */
public class PessoaControle {
    
    Pessoa objPessoa;
    JTable jtbPessoa = null;
    
    public PessoaControle(Pessoa objPessoa, JTable jtbPessoa){
        this.objPessoa = objPessoa;
        this.jtbPessoa = jtbPessoa;
    }
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO pessoas(nome,cpf,data_nascimento,telefone,id_bairro,id_escolaridade) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, objPessoa.getNome());
            stmt.setString(2, objPessoa.getCpf());
            Date data_nasc = Date.valueOf(objPessoa.getData_nascimento());
            stmt.setDate(3, data_nasc);
            stmt.setString(4, objPessoa.getTelefone());
            stmt.setInt(5, objPessoa.getId_bairro());
            stmt.setInt(6, objPessoa.getId_escolaridade());
           
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
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
        cabecalhos.add("CPF");
        cabecalhos.add("Data Nasc.");
        cabecalhos.add("Telefone");
        cabecalhos.add("Bairro");
        cabecalhos.add("Escolaridade");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT p.id, p.nome, p.cpf, p.data_nascimento, p.telefone, b.nome AS bairro, e.escolaridade ";
            SQL += " FROM pessoas p, escolaridades e, bairros b ";
            SQL += " WHERE b.id = p.id_bairro AND e.id = p.id_escolaridade AND p.data_exclusao IS NULL ";
            SQL += " ORDER BY p.nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add(result.getString(5));
                linha.add(result.getString(6));
                linha.add(result.getString(7));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbPessoa.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbPessoa.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbPessoa.getColumnModel().getColumn(i);
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
        
        jtbPessoa.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Pessoa buscar(String id){
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, nome, cpf, data_nascimento, telefone, id_bairro, id_escolaridade  ";
            SQL += " FROM pessoas ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objPessoa = new Pessoa();
                if(rs.next() == true)
                {
                    objPessoa.setId(rs.getInt(1));
                    objPessoa.setNome(rs.getString(2));
                    objPessoa.setCpf(rs.getString(3));
                    objPessoa.setData_nascimento(rs.getString(4));
                    objPessoa.setTelefone(rs.getString(5));
                    objPessoa.setId_bairro(rs.getInt(6));
                    objPessoa.setId_escolaridade(rs.getInt(7));
                    
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
        
        System.out.println ("Executou buscar pessoa com sucesso");
        return objPessoa;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pessoas SET data_exclusao = now() WHERE id=?");
            stmt.setInt(1, objPessoa.getId());
                        
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
