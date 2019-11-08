package telas;

import ferramentas.CaixaDeDialogo;
import modelos.Usuario;

/**
 *
 * @author Jonas
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public static Usuario usuarioLogado;
    
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);
        
        
        lblBemVindo.setText("Bem-Vindo sistema de cadastro de empregos " + usuarioLogado.getNome());
        
        menuBairros.setVisible(verificaPermissao("M"));
        menuCidade.setVisible(verificaPermissao("M"));

    }
   
    public static boolean verificaPermissao(String tipo){
        /* V = visualizar
        S = salvar
        M = menu
        E = excluir
        */
        if(usuarioLogado.getNivel().equals("N")){
            if(tipo.equals("S")){
                return true; //permissao negada
            }else if(tipo.equals("V")){
                return true; //permissao concedida
            }else if(tipo.equals("E")){
                return false; //permissao negada
            }else if(tipo.equals("M")){
                return false; //permissao negada
            }
        }else{
            return true;
        }
        
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuBairros = new javax.swing.JMenuItem();
        menuCidade = new javax.swing.JMenuItem();
        menuEmpresas = new javax.swing.JMenuItem();
        menuCargos = new javax.swing.JMenuItem();
        menuCargo_Empresa = new javax.swing.JMenuItem();
        menuEscolaridades = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de cadastro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblBemVindo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(0, 204, 51));
        lblBemVindo.setText("LABEL DE BOAS VINDAS");
        jPanel1.add(lblBemVindo);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 90));

        menu.setText("Cadastros");

        menuBairros.setText("Bairros");
        menuBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBairrosActionPerformed(evt);
            }
        });
        menu.add(menuBairros);

        menuCidade.setText("Cidades");
        menuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCidadeActionPerformed(evt);
            }
        });
        menu.add(menuCidade);

        menuEmpresas.setText("Empresas");
        menuEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmpresasActionPerformed(evt);
            }
        });
        menu.add(menuEmpresas);

        menuCargos.setText("Cargos");
        menuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargosActionPerformed(evt);
            }
        });
        menu.add(menuCargos);

        menuCargo_Empresa.setText("Cargos Empresas");
        menuCargo_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargo_EmpresaActionPerformed(evt);
            }
        });
        menu.add(menuCargo_Empresa);

        menuEscolaridades.setText("Escolaridades");
        menuEscolaridades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEscolaridadesActionPerformed(evt);
            }
        });
        menu.add(menuEscolaridades);

        barraMenu.add(menu);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuSairMousePressed(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        barraMenu.add(menuSair);

        setJMenuBar(barraMenu);

        setSize(new java.awt.Dimension(817, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBairrosActionPerformed
        if(usuarioLogado.getNivel().equals("A")){
            CadBairros tela_bairros = new CadBairros();
            tela_bairros.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!");
        }
    }//GEN-LAST:event_menuBairrosActionPerformed


    private void menuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCidadeActionPerformed
        if(usuarioLogado.getNivel().equals("A")){
            CadCidades tela_cidades = new CadCidades();
            tela_cidades.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!");
        }
    }//GEN-LAST:event_menuCidadeActionPerformed

    private void menuEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmpresasActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            CadEmpresas tela_empresas = new CadEmpresas();
            tela_empresas.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!");
        }
    }//GEN-LAST:event_menuEmpresasActionPerformed

    private void menuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargosActionPerformed
        if(usuarioLogado.getNivel().equals("A")){
            CadCargos tela_cargos = new CadCargos();
            tela_cargos.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!");
        }
    }//GEN-LAST:event_menuCargosActionPerformed

    private void menuCargo_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargo_EmpresaActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            CadCargos_Empresas tela_cargos_empresas = new CadCargos_Empresas();
            tela_cargos_empresas.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!");
        }
    }//GEN-LAST:event_menuCargo_EmpresaActionPerformed

    private void menuEscolaridadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEscolaridadesActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            CadEscolaridades tela_escolaridades = new CadEscolaridades();
            tela_escolaridades.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!");
        }
    }//GEN-LAST:event_menuEscolaridadesActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        dispose();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMousePressed
        // TODO add your handling code here:

        boolean resposta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Deseja realmente sair?", "Sair",'p');
        if(resposta)
        System.exit(0);

    }//GEN-LAST:event_menuSairMousePressed


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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuBairros;
    private javax.swing.JMenuItem menuCargo_Empresa;
    private javax.swing.JMenuItem menuCargos;
    private javax.swing.JMenuItem menuCidade;
    private javax.swing.JMenuItem menuEmpresas;
    private javax.swing.JMenuItem menuEscolaridades;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
