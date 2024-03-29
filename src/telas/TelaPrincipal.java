package telas;

import banco.Conexao;
import controle.RelatorioController;
import controles.PessoaControle;
import ferramentas.CaixaDeDialogo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import modelos.Pessoa;
import modelos.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jonas
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public static Usuario usuarioLogado;
    
    Pessoa objPessoa;
    PessoaControle objPessoaControle;
    
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);

        try{
            if(!usuarioLogado.getNivel().equals("A")){
                lblBemVindo.setText("Bem-Vindo sistema de cadastro de empregos " + usuarioLogado.getNome());
            }else{
                lblBemVindo.setText(usuarioLogado.getNome());
            }
            
            System.out.println(usuarioLogado.getNivel());
            menuBairros.setVisible(verificaPermissao("M"));
            menuCidade.setVisible(verificaPermissao("M"));
            menuEmpresas.setVisible(verificaPermissao("M"));
            menuCargos.setVisible(verificaPermissao("M"));
            menuCargo_Empresa.setVisible(verificaPermissao("M"));
            menuEscolaridades.setVisible(verificaPermissao("M"));
            menuRelCadPessoas.setVisible(verificaPermissao("M"));
            menuRelCandidaturas.setVisible(verificaPermissao("M"));
            
            
            
        }catch(Exception e){
               System.out.println(e);
        }
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
    
    public Boolean verificaExistenciaUSER(){
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT u.id ";
            SQL += " FROM pessoas p, usuarios u ";
            SQL += " WHERE u.cpf = p.cpf AND p.cpf = '" + usuarioLogado.getCpf() + "'";
            SQL += " AND p.data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    if(rs.getInt(1) != usuarioLogado.getId()){
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Você precisa fazer um cadastro!", 'a');
                        return false; //Já existe uma pessoa com este CPF
                    }else{
                        return true;
                    }
                }else{
                    return false;
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return false;
        }
    }
    
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuCidade = new javax.swing.JMenuItem();
        menuBairros = new javax.swing.JMenuItem();
        menuEmpresas = new javax.swing.JMenuItem();
        menuCargos = new javax.swing.JMenuItem();
        menuCargo_Empresa = new javax.swing.JMenuItem();
        menuEscolaridades = new javax.swing.JMenuItem();
        menuPessoas = new javax.swing.JMenuItem();
        menuPessoasVagas = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuRelCadPessoas = new javax.swing.JMenuItem();
        menuRelCandidaturas = new javax.swing.JMenuItem();
        menuRelPessoasParametro = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de cadastro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblBemVindo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(255, 255, 255));
        lblBemVindo.setText("LABEL DE BOAS VINDAS");
        jPanel1.add(lblBemVindo);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1440, 90));

        menu.setText("Cadastros");

        menuCidade.setText("Cidades");
        menuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCidadeActionPerformed(evt);
            }
        });
        menu.add(menuCidade);

        menuBairros.setText("Bairros");
        menuBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBairrosActionPerformed(evt);
            }
        });
        menu.add(menuBairros);

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

        menuPessoas.setText("Cadastro");
        menuPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPessoasActionPerformed(evt);
            }
        });
        menu.add(menuPessoas);

        menuPessoasVagas.setText("Candidatura");
        menuPessoasVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPessoasVagasActionPerformed(evt);
            }
        });
        menu.add(menuPessoasVagas);

        barraMenu.add(menu);

        jMenu1.setText("Relatórios");

        menuRelCadPessoas.setText("Cadastro de Pessoas");
        menuRelCadPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelCadPessoasActionPerformed(evt);
            }
        });
        jMenu1.add(menuRelCadPessoas);

        menuRelCandidaturas.setText("Candidaturas");
        menuRelCandidaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelCandidaturasActionPerformed(evt);
            }
        });
        jMenu1.add(menuRelCandidaturas);

        menuRelPessoasParametro.setText("Cadastro de Pessoas com Parâmetros");
        menuRelPessoasParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelPessoasParametroActionPerformed(evt);
            }
        });
        jMenu1.add(menuRelPessoasParametro);

        barraMenu.add(jMenu1);

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBairrosActionPerformed
        if(usuarioLogado.getNivel().equals("A")){
            CadBairros tela_bairros = new CadBairros();
            tela_bairros.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuBairrosActionPerformed

    private void menuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCidadeActionPerformed
        if(usuarioLogado.getNivel().equals("A")){
            CadCidades tela_cidades = new CadCidades();
            tela_cidades.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuCidadeActionPerformed

    private void menuEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmpresasActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            CadEmpresas tela_empresas = new CadEmpresas();
            tela_empresas.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuEmpresasActionPerformed

    private void menuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargosActionPerformed
        if(usuarioLogado.getNivel().equals("A")){
            CadCargos tela_cargos = new CadCargos();
            tela_cargos.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuCargosActionPerformed

    private void menuCargo_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargo_EmpresaActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            CadCargos_Empresas tela_cargos_empresas = new CadCargos_Empresas();
            tela_cargos_empresas.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuCargo_EmpresaActionPerformed

    private void menuEscolaridadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEscolaridadesActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            CadEscolaridades tela_escolaridades = new CadEscolaridades();
            tela_escolaridades.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
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

    private void menuPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPessoasActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A") || usuarioLogado.getNivel().equals("N")){
            CadPessoa tela_pessoas = new CadPessoa();
            tela_pessoas.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuPessoasActionPerformed

    private void menuPessoasVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPessoasVagasActionPerformed
        // TODO add your handling code here:
        if(verificaExistenciaUSER()){
            if(usuarioLogado.getNivel().equals("A") || usuarioLogado.getNivel().equals("N")){
                CadPessoa_Vaga tela_pessoas = new CadPessoa_Vaga();
                tela_pessoas.setVisible(true);
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
            }
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Faça um cadastro!", 'i');
        }
    }//GEN-LAST:event_menuPessoasVagasActionPerformed

    private void menuRelCandidaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelCandidaturasActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            try{
                String wSelect = "";
                wSelect = " SELECT pv.id as codigo, p.nome as pessoa, c.nome as cargo, e.nome as empresa ";
                wSelect += " FROM pessoas p,  cargos c, empresas e, pessoas_vagas pv, cargo_empresa ce ";
                wSelect += " WHERE p.id = pv.id_pessoa AND ce.id = pv.id_cargo_empresa AND ";
                wSelect += " ce.id_cargo = c.id AND ce.id_empresa = e.id AND pv.data_exclusao is null ";
                wSelect += " ORDER BY e.nome ";

                RelatorioController objRelController = new RelatorioController();
                ResultSet resultSet = objRelController.buscarRelatorio(wSelect);//Buscar os dados do relatório

                JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
                JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioCandidatos.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
                JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
                jpViewer.setVisible(true);//abre o relatório para visualização
                jpViewer.toFront();//define o form a frente da aplicação

            }catch(JRException ex){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');
            }
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
        
    }//GEN-LAST:event_menuRelCandidaturasActionPerformed

    private void menuRelCadPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelCadPessoasActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            try{
               String wSelect = "";
               wSelect = " SELECT p.id as id, p.nome as pessoa, b.nome as bairro, c.nome as cidade, e.uf as uf, n.escolaridade as escolaridade ";
               wSelect += " FROM pessoas p, bairros b, estados e, cidades c, escolaridades n ";
               wSelect += " WHERE p.id_bairro = b.id AND b.id_cidade = c.id AND ";
               wSelect += " c.uf_estados = e.uf AND p.id_escolaridade = n.id AND p.data_exclusao IS NULL ";
               wSelect += " ORDER BY p.nome ";

               RelatorioController objRelController = new RelatorioController();
               ResultSet resultSet = objRelController.buscarRelatorio(wSelect);//Buscar os dados do relatório

               JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
               JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioPessoas.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
               JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
               jpViewer.setVisible(true);//abre o relatório para visualização
               jpViewer.toFront();//define o form a frente da aplicação

           }catch(JRException ex){
               CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');
           }
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
        
    }//GEN-LAST:event_menuRelCadPessoasActionPerformed

    private void menuRelPessoasParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelPessoasParametroActionPerformed
        // TODO add your handling code here:
        if(usuarioLogado.getNivel().equals("A")){
            RelPessoas tela_rel = new RelPessoas();
            tela_rel.setVisible(true);
        }else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Sem permissão!!!", 'a');
        }
    }//GEN-LAST:event_menuRelPessoasParametroActionPerformed


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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuBairros;
    private javax.swing.JMenuItem menuCargo_Empresa;
    private javax.swing.JMenuItem menuCargos;
    private javax.swing.JMenuItem menuCidade;
    private javax.swing.JMenuItem menuEmpresas;
    private javax.swing.JMenuItem menuEscolaridades;
    private javax.swing.JMenuItem menuPessoas;
    private javax.swing.JMenuItem menuPessoasVagas;
    private javax.swing.JMenuItem menuRelCadPessoas;
    private javax.swing.JMenuItem menuRelCandidaturas;
    private javax.swing.JMenuItem menuRelPessoasParametro;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
