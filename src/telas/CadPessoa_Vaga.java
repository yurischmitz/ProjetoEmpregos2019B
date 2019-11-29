/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.Pessoa_VagaControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import java.sql.SQLException;
import modelos.Pessoa_Vaga;

/**
 *
 * @author ruanw
 */ 
public class CadPessoa_Vaga extends javax.swing.JFrame {

    /**
     * Creates new form CadPessoa_Vaga
     */
    
    Pessoa_Vaga objPessoa_Vaga;
    Pessoa_VagaControle objPessoa_VagaControle;
    Combos cbComboPessoa;
    Combos cbComboEmpresa;
    Combos cbComboCargo;
    boolean selecionaItem;
    
    
    public CadPessoa_Vaga() {
        initComponents();
        
        lblNomeUsuario.setText(TelaPrincipal.usuarioLogado.getNome());   
        String cpf = TelaPrincipal.usuarioLogado.getCpf();
        
        try{
            if(TelaPrincipal.usuarioLogado.getNivel().equals("N")){ 
                cbComboPessoa = new Combos(jcbPessoa);
                cbComboPessoa.PreencheCombo(" SELECT p.id, p.nome FROM pessoas p, usuarios u WHERE u.cpf = p.cpf AND p.cpf = '" + cpf + "' ");
                jcbPessoa.setSelectedIndex(1);
                
                Combos c = (Combos) jcbPessoa.getSelectedItem();
                objPessoa_Vaga.setId_mostrarpessoa(Integer.parseInt(c.getCodigo()));
                
                jcbPessoa.setEnabled(false);
                
            }else{
                cbComboPessoa = new Combos(jcbPessoa);
                cbComboPessoa.PreencheCombo(" SELECT id, nome FROM pessoas ORDER BY nome ");
            }
            selecionaItem = false;
            cbComboEmpresa = new Combos(jcbEmpresa);
            cbComboEmpresa.PreencheCombo(" SELECT e.id, e.nome FROM empresas e, cargo_empresa ce WHERE ce.id_empresa = e.id AND ce.data_exclusao IS NULL GROUP BY e.id, ce.id_empresa ORDER BY nome ");
            
            
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
        limparTela();
    }

    private void atualizarTabela(){
        try{
            
            if(TelaPrincipal.usuarioLogado.getNivel().equals("N")){
                objPessoa_VagaControle = new Pessoa_VagaControle(null, jtbPessoas);
                
                objPessoa_VagaControle.preencherUsuarioLogado(objPessoa_Vaga.getId_mostrarpessoa());
                
            }else{
                objPessoa_VagaControle = new Pessoa_VagaControle(null, jtbPessoas);
                objPessoa_VagaControle.preencher();
            }
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            selecionaItem = false;
            //cbComboPessoa.SetaComboBox(String.valueOf(""));
            cbComboEmpresa.SetaComboBox(String.valueOf(""));
            
            cbComboCargo = new Combos(jcbCargo);
            cbComboCargo.PreencheCombo(" SELECT id, nome FROM bairros WHERE 1 = 2 ");
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
        atualizarTabela();
    } 
    
    private void preencherCampos(){
        try{
            cbComboPessoa.SetaComboBox(String.valueOf(objPessoa_Vaga.getId_pessoa()));
            cbComboEmpresa.SetaComboBox(String.valueOf(objPessoa_Vaga.getId_empresa()));
            
            int cargo = objPessoa_Vaga.getId_cargo();
            cbComboCargo = new Combos(jcbCargo);
            cbComboCargo.PreencheCombo(" SELECT id, nome FROM cargos WHERE id = '"+ cargo +"' ");
            cbComboCargo.SetaComboBox(String.valueOf(objPessoa_Vaga.getId_cargo()));
                       
            //btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPessoas = new javax.swing.JTable();
        jcbPessoa = new javax.swing.JComboBox<>();
        jcbEmpresa = new javax.swing.JComboBox<>();
        jcbCargo = new javax.swing.JComboBox<>();
        lblEmpresa = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblPessoa = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeUsuario.setText("  Bem-vindo, nomeusuario! ");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jtbPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ));
        jtbPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbPessoasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPessoas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 260, 610, 110));

        jcbPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPessoaItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 170, -1));

        jcbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa" }));
        jcbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEmpresaItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, -1));

        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargo" }));
        jcbCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCargoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 170, -1));

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmpresa.setText("Empresa:");
        getContentPane().add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, -1));

        lblCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCargo.setText("Cargo:");
        getContentPane().add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 140, -1));

        lblPessoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPessoa.setText("Pessoa:");
        getContentPane().add(lblPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, -1));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 40, 20));

        setSize(new java.awt.Dimension(758, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
       try{
            boolean retorno;
            //validar os campos
            
            Combos c = (Combos) jcbPessoa.getSelectedItem();
            objPessoa_Vaga.setId_pessoa(Integer.parseInt(c.getCodigo()));
            
            c = (Combos) jcbCargo.getSelectedItem();
            objPessoa_Vaga.setId_cargo(Integer.parseInt(c.getCodigo()));
            
            c = (Combos) jcbEmpresa.getSelectedItem();
            objPessoa_Vaga.setId_empresa(Integer.parseInt(c.getCodigo()));
            
            
            int codigo = objPessoa_VagaControle.buscarCargoEmpresa(objPessoa_Vaga.getId_cargo(), objPessoa_Vaga.getId_empresa());
            objPessoa_Vaga.setId_cargo_empresa(codigo);
            
                
            if(!lblId.getText().equals("ID")){
                objPessoa_Vaga.setId(Integer.parseInt(lblId.getText()));
                //objPessoa_VagaControle = new Pessoa_VagaControle(objPessoa_Vaga, null); 
                //retorno = objPessoa_VagaControle.alterar();
            //}else{
                objPessoa_VagaControle = new Pessoa_VagaControle(objPessoa_Vaga, null);
                retorno = objPessoa_VagaControle.incluir();
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

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jcbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEmpresaItemStateChanged
        // TODO add your handling code here:
        try{
            if(selecionaItem == false){
                if(jcbEmpresa.getSelectedIndex() > 0){

                    Combos empresa = (Combos) jcbEmpresa.getSelectedItem();
                    String idempresa = empresa.getCodigo();

                    cbComboCargo = new Combos(jcbCargo);
                    cbComboCargo.PreencheCombo(" SELECT c.id, c.nome FROM cargos c, empresas e, cargo_empresa ce WHERE ce.id_cargo = c.id AND ce.id_empresa = e.id AND ce.id_empresa = '"+ idempresa +"' ");       
                }
            }
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }//GEN-LAST:event_jcbEmpresaItemStateChanged

    private void jcbPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPessoaItemStateChanged
        // TODO add your handling code here:
        if(selecionaItem == false){
            objPessoa_Vaga = new Pessoa_Vaga();
            if(jcbPessoa.getSelectedIndex() > 0){
                Combos c = (Combos) jcbPessoa.getSelectedItem();
                objPessoa_Vaga.setId(Integer.parseInt(c.getCodigo()));
                lblId.setText(String.valueOf(objPessoa_Vaga.getId()));
            }
        }
    }//GEN-LAST:event_jcbPessoaItemStateChanged

    private void jcbCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCargoItemStateChanged
        // TODO add your handling code here:
        /*try{
            //if(selecionaItem == false){
                if(jcbCargo.getSelectedIndex() > 0){

                    Combos cargo = (Combos) jcbCargo.getSelectedItem();
                    String idcargo = cargo.getCodigo();

                    cbComboEmpresa = new Combos(jcbEmpresa);
                    cbComboEmpresa.PreencheCombo(" SELECT e.id, e.nome FROM empresas e, cargos c, cargo_empresa ce WHERE ce.id_empresa = e.id AND ce.id_cargo = c.id AND ce.id_cargo = '"+ idcargo +"' ");       
                }
            //}
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }*/
    }//GEN-LAST:event_jcbCargoItemStateChanged

    private void jtbPessoasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPessoasMousePressed
        // TODO add your handling code here:
        try{
            selecionaItem = true;
            int linhaSelecionada = jtbPessoas.getSelectedRow();//pega a linha selecionada
            String codigo = jtbPessoas.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 4 = EXCLUIR
            if(jtbPessoas.isColumnSelected(4)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objPessoa_Vaga = new Pessoa_Vaga();
                        objPessoa_Vaga.setId(Integer.parseInt(codigo));
                        
                        objPessoa_VagaControle = new Pessoa_VagaControle(objPessoa_Vaga, null);
                        boolean wControle = objPessoa_VagaControle.excluir();
                        
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
                if(TelaPrincipal.usuarioLogado.getNivel().equals("A")){
                    objPessoa_VagaControle = new Pessoa_VagaControle(null, null);
                    objPessoa_Vaga = objPessoa_VagaControle.buscar(codigo);
                    if (objPessoa_Vaga != null && objPessoa_Vaga.getId() > 0){
                        preencherCampos();
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                    }
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Você não pode editar, apenas excluir!");
                    return;
                }
            }
            selecionaItem = false;
        
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
            selecionaItem = false;
        }
    }//GEN-LAST:event_jtbPessoasMousePressed

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
            java.util.logging.Logger.getLogger(CadPessoa_Vaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa_Vaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa_Vaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa_Vaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa_Vaga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JComboBox<String> jcbEmpresa;
    private javax.swing.JComboBox<String> jcbPessoa;
    private javax.swing.JTable jtbPessoas;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblPessoa;
    // End of variables declaration//GEN-END:variables
}
