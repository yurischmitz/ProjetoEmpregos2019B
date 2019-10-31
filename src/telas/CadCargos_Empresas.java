/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.Cargo_EmpresaControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import java.sql.SQLException;
import modelos.Cargo_Empresa;

/**
 *
 * @author yuris
 */
public class CadCargos_Empresas extends javax.swing.JFrame {


    Cargo_Empresa objCargo_Empresa;
    Cargo_EmpresaControle objCargo_EmpresaControle;
    Combos cbComboCargo;
    Combos cbComboEmpresa;
    
    public CadCargos_Empresas() {
        initComponents();
        try{
            
            cbComboEmpresa = new Combos(jcbEmpresa);
            cbComboEmpresa.PreencheCombo(" SELECT id, nome FROM empresas WHERE data_exclusao is null ");
            
            cbComboCargo = new Combos(jcbCargo);
            cbComboCargo.PreencheCombo(" SELECT id, nome FROM cargos WHERE data_exclusao is null ");
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
        
        limparTela();
    }
    
    private void atualizarTabela(){
        try{
            
            objCargo_EmpresaControle = new Cargo_EmpresaControle(null, jtbCargos_Empresas);
            objCargo_EmpresaControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            lblId.setText("ID");
            cbComboEmpresa.SetaComboBox(String.valueOf(""));
            cbComboCargo.SetaComboBox(String.valueOf(""));
           
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
            lblId.setText(String.valueOf(objCargo_Empresa.getId()));
            
            cbComboCargo.SetaComboBox(String.valueOf(objCargo_Empresa.getId_cargo()));
            cbComboEmpresa.SetaComboBox(String.valueOf(objCargo_Empresa.getId_empresa()));
                       
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            System.out.println("ofjafasnfliasnufas");
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCargos_Empresas = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbCargo = new javax.swing.JComboBox<>();
        jcbEmpresa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cargosem Empresas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbCargos_Empresas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCargos_Empresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCargos_EmpresasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCargos_Empresas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 450, 110));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cargo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        getContentPane().add(jcbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 120, -1));

        getContentPane().add(jcbEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Empresa");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 51));
        jLabel8.setText("Cadastro de Cargos em Empresas");
        jPanel1.add(jLabel8);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 40));

        setSize(new java.awt.Dimension(496, 348));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbCargos_EmpresasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCargos_EmpresasMousePressed
        try{

            int linhaSelecionada = jtbCargos_Empresas.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCargos_Empresas.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            if(jtbCargos_Empresas.isColumnSelected(3)){ 
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objCargo_Empresa = new Cargo_Empresa();
                        objCargo_Empresa.setId(Integer.parseInt(codigo));

                        objCargo_EmpresaControle = new Cargo_EmpresaControle(objCargo_Empresa, null);
                        boolean wControle = objCargo_EmpresaControle.excluir();

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

                objCargo_EmpresaControle = new Cargo_EmpresaControle(null, null);
                objCargo_Empresa = objCargo_EmpresaControle.buscar(codigo);
                if (objCargo_Empresa != null && objCargo_Empresa.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbCargos_EmpresasMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;

            if(jcbEmpresa.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma empresa", 'a');
                return;
            }
            
            if(jcbCargo.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um cargo", 'a');
                return;
            }
                      
            objCargo_Empresa = new Cargo_Empresa();
            
            Combos c = (Combos) jcbEmpresa.getSelectedItem();
            objCargo_Empresa.setId_empresa(Integer.parseInt(c.getCodigo()));
            
            c = (Combos) jcbCargo.getSelectedItem();
            objCargo_Empresa.setId_cargo(Integer.parseInt(c.getCodigo()));
                
            if(!lblId.getText().equals("ID")){
                objCargo_Empresa.setId(Integer.parseInt(lblId.getText()));
                objCargo_EmpresaControle = new Cargo_EmpresaControle(objCargo_Empresa, null); 
                retorno = objCargo_EmpresaControle.alterar();
            }else{
                objCargo_EmpresaControle = new Cargo_EmpresaControle(objCargo_Empresa, null); 
                retorno = objCargo_EmpresaControle.incluir();
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
            java.util.logging.Logger.getLogger(CadCargos_Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCargos_Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCargos_Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCargos_Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCargos_Empresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JComboBox<String> jcbEmpresa;
    private javax.swing.JTable jtbCargos_Empresas;
    private javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables
}
