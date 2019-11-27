package telas;

import controles.BairroControle;
import java.sql.SQLException;
import modelos.Bairro;
import ferramentas.*;
/**
 *
 * @author Jonas Dhein
 */
public class CadBairros extends javax.swing.JFrame {

    /**
     * Creates new form CadBairros
     */
    Bairro objBairro;
    BairroControle objBairroControle;
    Combos cbComboEstado;
    Combos cbComboCidade;
    Boolean selecionaItem;
    
    public CadBairros(){
        initComponents(); //renderiza os elementos na tela
        try{
            selecionaItem = false;
            cbComboEstado = new Combos(jcbEstado);
            cbComboEstado.PreencheCombo(" SELECT uf, uf FROM estados ");
            
            //cbComboCidade = new Combos(jcbCidade);
            //cbComboCidade.PreencheCombo(" SELECT id, nome FROM cidades WHERE 1 = 2 ");
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
        
        limparTela();
    }
    
    private void atualizarTabela(){
        try{
            
            objBairroControle = new BairroControle(null, jtbBairros);
            objBairroControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            lblId.setText("ID");
            txtNome.setText("");
            cbComboEstado.SetaComboBox(String.valueOf(""));
            
            cbComboCidade = new Combos(jcbCidade);
            cbComboCidade.PreencheCombo(" SELECT id, nome FROM cidades WHERE 1 = 2 ");
            
            cbComboCidade.SetaComboBox(String.valueOf(""));
           
            if(TelaPrincipal.usuarioLogado.getNivel().equals("A")){
                btnSalvar.setEnabled(true);
            }else{
                btnSalvar.setEnabled(false);
            }
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }   
    
    private void preencherCampos(){
        try{
            lblId.setText(String.valueOf(objBairro.getId()));
            txtNome.setText(objBairro.getNome());
            
            cbComboEstado.SetaComboBox(String.valueOf(objBairro.getUf_estado()));
            
            int cidade = objBairro.getId_cidade();
            cbComboCidade = new Combos(jcbCidade);
            cbComboCidade.PreencheCombo(" SELECT id, nome FROM cidades WHERE id = '"+ cidade +"' ");
            cbComboCidade.SetaComboBox(String.valueOf(objBairro.getId_cidade()));
                       
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBairros = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jcbCidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jtbBairros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbBairros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbBairrosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBairros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 500, 110));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 310, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jcbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, -1));

        getContentPane().add(jcbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Cidade");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 51));
        jLabel6.setText("Cadastro de Bairros");
        jPanel1.add(jLabel6);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 40));

        setSize(new java.awt.Dimension(555, 421));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;
            //validar os campos
            if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um bairro corretamente", 'a');
                return;
            }
            
            if(jcbEstado.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um estado", 'a');
                return;
            }
            
            if(jcbCidade.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma cidade", 'a');
                return;
            }
                      
            objBairro = new Bairro();
            objBairro.setNome(txtNome.getText().trim());
            
            Combos c = (Combos) jcbCidade.getSelectedItem();
            objBairro.setId_cidade(Integer.parseInt(c.getCodigo()));
                
            if(!lblId.getText().equals("ID")){
                objBairro.setId(Integer.parseInt(lblId.getText()));
                objBairroControle = new BairroControle(objBairro, null); 
                retorno = objBairroControle.alterar();
            }else{
                objBairroControle = new BairroControle(objBairro, null);
                retorno = objBairroControle.incluir();
            }
            
            if(retorno = true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }
            
            atualizarTabela();

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtbBairrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBairrosMousePressed
        try{
            selecionaItem = true;
            int linhaSelecionada = jtbBairros.getSelectedRow();//pega a linha selecionada
            String codigo = jtbBairros.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 4 = EXCLUIR
            if(jtbBairros.isColumnSelected(4)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objBairro = new Bairro();
                        objBairro.setId(Integer.parseInt(codigo));
                        
                        objBairroControle = new BairroControle(objBairro, null);
                        boolean wControle = objBairroControle.excluir();
                        
                        if (wControle){
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                    }
                    atualizarTabela();

                }catch(Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            }else{
            
                objBairroControle = new BairroControle(null, null);
                objBairro = objBairroControle.buscar(codigo);
                if (objBairro != null && objBairro.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                }
            }
            selecionaItem = false;
        
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
            selecionaItem = false;
        }
    }//GEN-LAST:event_jtbBairrosMousePressed
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jcbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoItemStateChanged
        try{
            if(selecionaItem == false){
                if(jcbEstado.getSelectedIndex() > 0){

                    Combos estado = (Combos) jcbEstado.getSelectedItem();
                    String sigla = estado.getCodigo();

                    cbComboCidade = new Combos(jcbCidade);
                    cbComboCidade.PreencheCombo(" SELECT id, nome FROM cidades WHERE uf_estados = '"+ sigla +"' AND data_exclusao IS NULL ");
                    
                }
            }
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }//GEN-LAST:event_jcbEstadoItemStateChanged

      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadBairros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTable jtbBairros;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
