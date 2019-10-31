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
import modelos.Bairro;
/**
 *
 * @author Jonas Dhein
 */
public class BairroControle {
    
    Bairro objBairro;
    JTable jtbBairros = null;
    
    public BairroControle(Bairro objBairro, JTable jtbBairros) {
        this.objBairro = objBairro;
        this.jtbBairros = jtbBairros;
    }
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO bairros(nome,id_cidade) VALUES(?,?)");
            stmt.setString(1, objBairro.getNome());
            stmt.setInt(2, objBairro.getId_cidade());
            
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
            stmt = con.prepareStatement("UPDATE bairros SET nome=?,id_cidade=? WHERE id=?");
            stmt.setString(1, objBairro.getNome());
            stmt.setInt(2, objBairro.getId_cidade());
            stmt.setInt(3, objBairro.getId());
            
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
        cabecalhos.add("Bairro");
        cabecalhos.add("Cidade");
        cabecalhos.add("UF");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT b.id, b.nome as bairro, c.nome as cidade, e.uf as estado ";
            SQL += " FROM bairros b, cidades c, estados e ";
            SQL += " WHERE b.id_cidade = c.id AND c.uf_estados = e.uf AND b.data_exclusao is null ";
            SQL += " ORDER BY b.nome, c.nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbBairros.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbBairros.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbBairros.getColumnModel().getColumn(i);
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
        
        jtbBairros.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Bairro buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, nome, id_cidade ";
            SQL += " FROM bairros ";
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

                objBairro = new Bairro();
                if(rs.next() == true)
                {
                    objBairro.setId(rs.getInt(1));
                    objBairro.setNome(rs.getString(2));
                    objBairro.setId_cidade(rs.getInt(3));
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
        
        System.out.println ("Executou buscar area com sucesso");
        return objBairro;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE bairros SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objBairro.getId());
                        
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
