/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.PessoaControle;
import ferramentas.*;
import java.sql.SQLException;
import modelos.*;

/**
 *
 * @author ruanw
 */
public class CadPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadPessoa
     */
    
    
    Pessoa objPessoa;
    PessoaControle objPessoaControle;
    Combos cbComboBairro;
    Combos cbComboEstado;
    Combos cbComboCidade;
    Combos cbComboEscolaridade;
    
    public CadPessoa() {
        initComponents();
        
        try{
            System.out.println(TelaPrincipal.usuarioLogado.getNome());
        } catch (Exception e) {
            System.out.println(e);
        }
        lblNomeUsuario.setText(TelaPrincipal.usuarioLogado.getNome());
         
        try{
            
            cbComboEstado = new Combos(jcbEstado);
            
            cbComboEstado.PreencheCombo(" SELECT uf, uf FROM estados ORDER BY uf ");
            
            cbComboEscolaridade = new Combos(jcbEscolaridade);
            cbComboEscolaridade.PreencheCombo(" SELECT id, escolaridade FROM escolaridades ");
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
        limparTela();
    }
    
     private void atualizarTabela(){
        try{
            
           // objPessoaControle = new PessoaControle(null, jtbBairros);
            //objBairroControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            txtNome.setText("");
            txtCpf.setText("");
            txtData.setText("");
            txtTelefone.setText("");
            
            cbComboEstado.SetaComboBox(String.valueOf(""));
            
            cbComboCidade = new Combos(jcbCidade);
            cbComboCidade.PreencheCombo(" SELECT id, nome FROM cidades WHERE 1 = 2 ");
            
            cbComboBairro = new Combos(jcbBairro);
            cbComboBairro.PreencheCombo(" SELECT id, nome FROM bairros WHERE 1 = 2 ");
            
            cbComboEscolaridade.SetaComboBox(String.valueOf(""));
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        btnCandidatar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        jcbEscolaridade = new javax.swing.JComboBox<>();
        txtNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcbBairro = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        btnCandidatar1 = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeUsuario.setText("  Bem-vindo, nomeusuario! ");

        btnCandidatar.setText("Candidatar-se");
        btnCandidatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandidatarActionPerformed(evt);
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
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnCandidatar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCandidatar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 738, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel1.setText("Seus dados cadastrais abaixo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 284, 21));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 58, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CPF:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 51, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Data Nasc.:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Telefone:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 127, 34));

        jcbEscolaridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEscolaridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 300, 40));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 37));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Estado");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Escolaridade");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 101, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Bairro");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jcbBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 300, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cidade");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 126, 34));

        btnCandidatar1.setText("Candidatar-se");
        getContentPane().add(btnCandidatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 260, 40));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 260, 40));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 260, 40));

        setSize(new java.awt.Dimension(751, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoItemStateChanged
        // TODO add your handling code here:
        
        try{
            if(jcbEstado.getSelectedIndex() > 0){
                
                Combos estado = (Combos) jcbEstado.getSelectedItem();
                String sigla = estado.getCodigo();
                
                cbComboCidade = new Combos(jcbCidade);
                cbComboCidade.PreencheCombo(" SELECT id, nome FROM cidades WHERE uf_estados = '"+ sigla +"' ");
                
            }
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
        
    }//GEN-LAST:event_jcbEstadoItemStateChanged

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        // TODO add your handling code here:
        
        try{
            if(jcbCidade.getSelectedIndex() > 0){
                
                Combos cidade = (Combos) jcbCidade.getSelectedItem();
                String id = cidade.getCodigo();
                
                cbComboBairro = new Combos(jcbBairro);
                cbComboBairro.PreencheCombo(" SELECT id, nome FROM bairros WHERE id_cidade  = '"+ id +"' ");
                
            }
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCandidatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandidatarActionPerformed
        // TODO add your handling code here:
        try{
            boolean retorno;
            objPessoa = new Pessoa();
            //validar os campos
            if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um nome corretamente", 'a');
                return;
            }
            
            String cpf = Formatacao.removerFormatacao(txtCpf.getText());        
            if(!Validacao.validarCPF(cpf)){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF corretemente");
                return;
            }
            
            if(!Validacao.validarData(txtData.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente!");
                return;
            }
            
            if(txtTelefone.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um telefone corretamente", 'a');
                return;
            }
            
            if(jcbEstado.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um estado!", 'a');
                return;
            }
            
            if(jcbCidade.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma cidade!", 'a');
                return;
            }
            
            if(jcbBairro.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um bairro", 'a');
                return;
            }
            
            if(jcbEscolaridade.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma escolaridade", 'a');
                return;
            }
                      
            objPessoa.setNome(txtNome.getText().trim());
            objPessoa.setCpf(cpf.trim());
            String data = Formatacao.ajustaDataAMD(txtData.getText());
            objPessoa.setData_nascimento(data);
            String telefone = Formatacao.soNumero(txtTelefone.getText());
            objPessoa.setTelefone(telefone.trim());
            
            Combos c = (Combos) jcbBairro.getSelectedItem();
            objPessoa.setId_bairro(Integer.parseInt(c.getCodigo()));
            c = (Combos) jcbEscolaridade.getSelectedItem();
            objPessoa.setId_escolaridade(Integer.parseInt(c.getCodigo()));
                
            objPessoaControle = new PessoaControle(objPessoa, null);
            retorno = objPessoaControle.incluir();
            
            if(retorno == true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }
            
            
            CadPessoa_Vaga tela_cad_pessoa_vaga = new CadPessoa_Vaga();
            tela_cad_pessoa_vaga.id_pessoa = 1;
            tela_cad_pessoa_vaga.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnCandidatarActionPerformed

    
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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCandidatar;
    private javax.swing.JButton btnCandidatar1;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbBairro;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbEscolaridade;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
