/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Contrato;
import model.bean.Equipamento;
import model.dao.ClienteDAO;
import model.dao.ContratoDAO;
import model.dao.EquipamentoDAO;

/**
 *
 * @author Master
 */
public class FormEquipamento extends javax.swing.JFrame {

    /**
     * Creates new form FormEquipamento
     */
    public FormEquipamento() {
        initComponents();

        //As linhas abaixo fazem o sort da tabela
        DefaultTableModel modelo = (DefaultTableModel) jTableEquipamento.getModel();
        jTableEquipamento.setRowSorter(new TableRowSorter(modelo));

        //A linha abaixo chama a tabela
        readTable();
        // Esta linha prenche os comboboxs cliente e contrato
        combobox();
        //limpa todos os campos
        limpaCampos();
        //desabilita campos
        desabilitaCampos();
        //desabilita botões
        desabilitaBottons();
    }

    public void limpaCampos() {
        //Limpar campos
        jComboBoxCliente.setSelectedIndex(0);
        jComboBoxContrato.setSelectedIndex(0);

        txtCodigo.setText("");
        txtNome.setText("");
        txtFabricante.setText("");
        txtModelo.setText("");
        jFormattedTextDtFab.setText("");

        jFormattedTextDtInstal.setText("");
        jFormattedTextGap.setText("");
        jTextAreaHistInicial.setText("");

        //Limpa o label da foto e preenche com foto padrão        
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")));
        lblNomeFoto.setText("");
    }

    public void desabilitaBottons() {
        //Desabilitar botôes
        btnLimpar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void desabilitaCampos() {
        //Desabilitar campos
        jComboBoxCliente.setEnabled(false);
        jComboBoxContrato.setEnabled(false);

        txtNome.setEnabled(false);
        txtFabricante.setEnabled(false);
        txtModelo.setEnabled(false);
        jFormattedTextDtFab.setEnabled(false);
        jFormattedTextDtInstal.setEnabled(false);
        jFormattedTextGap.setEnabled(false);
        jFormattedTextDtUltiManut.setEnabled(false);
        txtAtendimentos.setEnabled(false);
        jTextAreaHistInicial.setEnabled(false);
        lblFoto.setEnabled(false);
    }

    public void habilitarCampos() {
        //habilita campos
        jComboBoxCliente.setEnabled(true);
        jComboBoxContrato.setEnabled(true);

        txtNome.setEnabled(true);
        txtFabricante.setEnabled(true);
        txtModelo.setEnabled(true);
        jFormattedTextDtFab.setEnabled(true);
        jFormattedTextDtInstal.setEnabled(true);
        jFormattedTextGap.setEnabled(true);
        jFormattedTextDtUltiManut.setEnabled(true);
        txtAtendimentos.setEnabled(true);
        jTextAreaHistInicial.setEnabled(true);
        lblFoto.setEnabled(true);
    }

    public void colocaLogo() {
        //Prepara foto
        lblFoto.setEnabled(true);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")));
//        lblNomeFoto.setEnabled(false);
    }

    public void combobox() {

        ClienteDAO clidao = new ClienteDAO();
        for (Cliente cl : clidao.readAllClienteToEquip()) {
            jComboBoxCliente.addItem(cl);
        }

        ContratoDAO condao = new ContratoDAO();
        for (Contrato co : condao.readAllContrato()) {
            jComboBoxContrato.addItem(co);
        }
    }

    //Monta a tabela
    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableEquipamento.getModel();
        modelo.setNumRows(0);
        EquipamentoDAO edao = new EquipamentoDAO();

        for (Equipamento p : edao.readTableAllEquipamento()) {
            modelo.addRow(new Object[]{
                p.getIdequip(),
                p.getDt_cadastro(),
                p.getCliente(),
                p.getContrato(),
                p.getNome(),
                p.getFabricante(),
                p.getModelo(),
                p.getDt_fabric(),
                p.getDt_instal(),
                p.getHistor_inicial(),
                p.getGap_manut(),
                p.getDt_ultimanut(),
                p.getAtendimentos(),
                p.getFoto()
            });
        }
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
        jFormattedTextDtFab = new javax.swing.JFormattedTextField();
        lblDtFabric = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblFabric = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jFormattedTextDtUltiManut = new javax.swing.JFormattedTextField();
        lblUltManut = new javax.swing.JLabel();
        lblGap = new javax.swing.JLabel();
        jFormattedTextGap = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaHistInicial = new javax.swing.JTextArea();
        lblHistInicial = new javax.swing.JLabel();
        lblDtInstal = new javax.swing.JLabel();
        jFormattedTextDtInstal = new javax.swing.JFormattedTextField();
        lblAtendimentos = new javax.swing.JLabel();
        txtAtendimentos = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        lblContrato = new javax.swing.JLabel();
        jComboBoxContrato = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipamento = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblNomeFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMUÁRIO DE CADASTRO DE EQUIPAMENTO");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")).getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DO EQUIPAMENTO"));

        try {
            jFormattedTextDtFab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextDtFab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextDtFabKeyPressed(evt);
            }
        });

        lblDtFabric.setText("Dt.Fabric.");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        lblNome.setText("* Nome");

        lblFabric.setText("* Fabric.");

        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtModeloKeyPressed(evt);
            }
        });

        lblModelo.setText("Modelo");

        txtFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFabricanteKeyPressed(evt);
            }
        });

        lblCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 51, 51));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setEnabled(false);

        jLabel3.setBackground(new java.awt.Color(102, 153, 255));
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_error_35763 (1).png"))); // NOI18N
        jLabel3.setText("(*) - Campo de preenchimento OBRIGATÓRIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(393, 393, 393)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFabric)
                                    .addComponent(lblModelo))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDtFabric)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextDtFab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFabric)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDtFabric)
                    .addComponent(jFormattedTextDtFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS GERAIS DE MANUTENÇÃO"));

        jFormattedTextDtUltiManut.setEditable(false);
        jFormattedTextDtUltiManut.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextDtUltiManut.setForeground(new java.awt.Color(255, 51, 51));
        try {
            jFormattedTextDtUltiManut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextDtUltiManut.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblUltManut.setText("Dt.Últ.Manut.");

        lblGap.setText("* Gap");

        jFormattedTextGap.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextGap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextGapKeyPressed(evt);
            }
        });

        jTextAreaHistInicial.setColumns(20);
        jTextAreaHistInicial.setRows(5);
        jScrollPane1.setViewportView(jTextAreaHistInicial);

        lblHistInicial.setText("Hist.Inicial");

        lblDtInstal.setText("Dt.Instal.");

        try {
            jFormattedTextDtInstal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextDtInstal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextDtInstalKeyPressed(evt);
            }
        });

        lblAtendimentos.setText("N* de Atendimentos");

        txtAtendimentos.setEditable(false);
        txtAtendimentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtAtendimentos.setForeground(new java.awt.Color(255, 51, 51));
        txtAtendimentos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAtendimentos.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblHistInicial)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDtInstal)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextDtInstal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblGap)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextGap, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(lblUltManut)
                        .addGap(29, 29, 29)
                        .addComponent(jFormattedTextDtUltiManut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAtendimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAtendimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGap)
                    .addComponent(jFormattedTextGap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUltManut)
                    .addComponent(jFormattedTextDtUltiManut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDtInstal)
                    .addComponent(jFormattedTextDtInstal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAtendimentos)
                    .addComponent(txtAtendimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHistInicial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSair.setBackground(new java.awt.Color(0, 153, 153));
        btnSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-url-ee.png"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(0, 153, 153));
        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_add_35760.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(0, 153, 153));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(0, 153, 153));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_delete_35761 (1).png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(0, 153, 153));
        btnAtualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_edit_35762 (1).png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 153, 153));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_add_35760 (1).png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha" }));
        jComboBoxCliente.setActionCommand("");
        jComboBoxCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxClienteKeyPressed(evt);
            }
        });

        lblContrato.setText("* Contrato");

        jComboBoxContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha" }));
        jComboBoxContrato.setActionCommand("");
        jComboBoxContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxContratoKeyPressed(evt);
            }
        });

        lblCliente.setText("* Cliente");

        jTableEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód", "Dt Cadastro", "Cliente", "Contrato", "Nome", "Fabricante", "Modelo", "Dt.Fabric", "Dt.Instal.", "Hist.Inicial", "Gap", "Dt.Últ.Manut.", "Atendim.", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquipamentoMouseClicked(evt);
            }
        });
        jTableEquipamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableEquipamentoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEquipamento);
        if (jTableEquipamento.getColumnModel().getColumnCount() > 0) {
            jTableEquipamento.getColumnModel().getColumn(0).setMinWidth(30);
            jTableEquipamento.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableEquipamento.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblFoto.setEnabled(false);
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("NOME DA FOTO"));

        lblNomeFoto.setEnabled(false);
        lblNomeFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lblNomeFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(lblContrato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblContrato)
                                .addComponent(jComboBoxContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCliente)
                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:

        //limpa todos os campos
        limpaCampos();

        //habilita campos
        habilitarCampos();

        //reinicia a tabela
        readTable();

        //Prepara botôes
        btnLimpar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnSalvar.setEnabled(true);

        //Posiciona o cursor
        jComboBoxCliente.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if ((jComboBoxCliente.getSelectedIndex() == 0)
                || (jComboBoxContrato.getSelectedIndex() == 0)
                || (txtNome.getText().isEmpty())
                || (txtFabricante.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios, TODOS DEVEM ESTAR PREENCHIDOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
            jComboBoxCliente.requestFocus();
            return;
        }

        if (jComboBoxCliente.getSelectedItem() != "Escolha" && jComboBoxContrato.getSelectedItem() != "Escolha") {

            Equipamento eq = new Equipamento();
            EquipamentoDAO dao = new EquipamentoDAO();

            eq.setNome(txtNome.getText().toUpperCase());
            eq.setFabricante(txtFabricante.getText().toUpperCase());
            eq.setModelo(txtModelo.getText());
            eq.setDt_fabric(jFormattedTextDtFab.getText());
            eq.setDt_instal(jFormattedTextDtInstal.getText());
            eq.setGap_manut(jFormattedTextGap.getText());
            eq.setDt_ultimanut(jFormattedTextDtUltiManut.getText());
            eq.setAtendimentos(Integer.parseInt(txtAtendimentos.getText()));
            eq.setHistor_inicial(jTextAreaHistInicial.getText());
            eq.setFoto(lblNomeFoto.getText());

            //As linhas abaixo pegam no combobox, que contem o objeto, o idcliente e o idcontrato
            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            cli.setIdcliente(cli.getIdcliente());
            eq.setCliente(cli);

            Contrato contrato = (Contrato) jComboBoxContrato.getSelectedItem();
            contrato.setIdcontrato(contrato.getIdcontrato());
            eq.setContrato(contrato);

            dao.saveEquipamento(eq);
            
             //Reinicia a tabela        
            readTable();

            //limpa todos os campos
            limpaCampos();

            //desabilita todos os campos
            desabilitaCampos();

            //desabilita botões
            desabilitaBottons();

        } else {
            JOptionPane.showMessageDialog(null, "Verifique os campos cliente e contrato, AMBOS DEVEM SER SELECIONADOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        if ((jComboBoxCliente.getSelectedIndex() == 0)
                || (jComboBoxContrato.getSelectedIndex() == 0)
                || (txtNome.getText().isEmpty())
                || (txtFabricante.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios, TODOS DEVEM ESTAR PREENCHIDOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
            jComboBoxCliente.requestFocus();
            return;
        }

        if (jComboBoxCliente.getSelectedItem() != "Escolha" && jComboBoxContrato.getSelectedItem() != "Escolha") {

            Equipamento eq = new Equipamento();
            EquipamentoDAO dao = new EquipamentoDAO();

            eq.setNome(txtNome.getText().toUpperCase());
            eq.setFabricante(txtFabricante.getText().toUpperCase());
            eq.setModelo(txtModelo.getText());
            eq.setDt_fabric(jFormattedTextDtFab.getText());
            eq.setDt_instal(jFormattedTextDtInstal.getText());
            eq.setGap_manut(jFormattedTextGap.getText());
            eq.setDt_ultimanut(jFormattedTextDtUltiManut.getText());
            eq.setAtendimentos(Integer.parseInt(txtAtendimentos.getText()));
            eq.setHistor_inicial(jTextAreaHistInicial.getText());
            eq.setFoto(lblNomeFoto.getText());

            //As linhas abaixo pegam no combobox, que contem o objeto, o idcliente e o idcontrato
            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            cli.setIdcliente(cli.getIdcliente());
            eq.setCliente(cli);

            Contrato contrato = (Contrato) jComboBoxContrato.getSelectedItem();
            contrato.setIdcontrato(contrato.getIdcontrato());
            eq.setContrato(contrato);

            eq.setIdequip(Integer.parseInt(txtCodigo.getText()));

            dao.updateEquipamento(eq);

             //limpa todos os campos
            limpaCampos();

            //desabilita todos os campos
            desabilitaCampos();

            //desabilita botões
            desabilitaBottons();

            //Reinicia a tabela        
            readTable();

        } else {
            JOptionPane.showMessageDialog(null, "Verifique os campos cliente e contrato, AMBOS DEVEM SER SELECIONADOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        // As linhas abaixo exclui um objeto(registro) do banco de dados

        int excluir = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja EXCLUIR este registro?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (excluir == JOptionPane.YES_OPTION) {

            Equipamento equip = new Equipamento();
            EquipamentoDAO dao = new EquipamentoDAO();

            equip.setIdequip((int) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 0));

            dao.deleteEquipamento(equip);

             //limpa todos os campos
            limpaCampos();

            //desabilita todos os campos
            desabilitaCampos();

            //desabilita botões
            desabilitaBottons();

            //Reinicia a tabela        
            readTable();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTableEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquipamentoMouseClicked
        // TODO add your handling code here:
        //Posiciona os comboboxs cliente e contrato e reinicia a tabela
        jComboBoxCliente.setSelectedIndex(0);
        jComboBoxContrato.setSelectedIndex(0);

        //Confirma se uma linha foi escolhida e preenche os campos com o conteudo da tabela
        if (jTableEquipamento.getSelectedRow() != -1) {
            //habilita campos
            habilitarCampos();

            //Prepara bottons
            if (FormMenu.lblUsuario.getText().equals("ADMGERAL")) {
                btnExcluir.setEnabled(true);
            } else {
                btnExcluir.setEnabled(false);
            }
            
            btnAtualizar.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnLimpar.setEnabled(false);

            //Chama os campos da tabela
            txtCodigo.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 0).toString());
            txtNome.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 4).toString());
            txtFabricante.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 5).toString());
            txtModelo.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 6).toString());
            jFormattedTextDtFab.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 7).toString());
            jFormattedTextDtInstal.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 8).toString());
            jTextAreaHistInicial.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 9).toString());
            jFormattedTextGap.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 10).toString());
            jFormattedTextDtUltiManut.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 11).toString());
            txtAtendimentos.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 12).toString());

            Cliente cliente = (Cliente) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 2);
            cliente.setIdcliente(Integer.parseInt(String.valueOf(cliente.getIdcliente())));
//            JOptionPane.showMessageDialog(null, cliente.getIdcliente());
            jComboBoxCliente.setSelectedIndex(cliente.getIdcliente());

            Contrato contrato = (Contrato) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 3);
            contrato.setIdcontrato(Integer.parseInt(String.valueOf(contrato.getIdcontrato())));
            jComboBoxContrato.setSelectedIndex(contrato.getIdcontrato());

            Equipamento c = new Equipamento();
            EquipamentoDAO dao = new EquipamentoDAO();

            c.setFoto((String) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 13));
            String nomeImagem = c.getFoto();

            if (!nomeImagem.isEmpty()) {

                ImageIcon icone = new ImageIcon("C:\\Users\\kamil\\Pictures\\Imagens_ProjetoOs\\" + nomeImagem);
                lblFoto.setIcon(icone);
                lblNomeFoto.setText(nomeImagem);
                
            } else {
                JOptionPane.showMessageDialog(null, "Não existe Imagem para este registro");
                
                //Reinicia label foto 
                lblNomeFoto.setText("");
//                lblNomeFoto.setEnabled(false);
                lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")));
            }
        }
    }//GEN-LAST:event_jTableEquipamentoMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        //limpa todos os campos
        limpaCampos();

        //Reinicia a tabela
        readTable();

        //Posiciona o cursor
//        txtNome.requestFocus();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void jTableEquipamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableEquipamentoKeyReleased
        // TODO add your handling code here:
        //Posiciona os comboboxs cliente e contrato e reinicia a tabela
        jComboBoxCliente.setSelectedIndex(0);
        jComboBoxContrato.setSelectedIndex(0);

        //Confirma se uma linha foi escolhida e preenche os campos com o conteudo da tabela
        if (jTableEquipamento.getSelectedRow() != -1) {
            //habilita campos
            habilitarCampos();

            //Prepara bottons
            if (FormMenu.lblUsuario.getText().equals("ADMGERAL")) {
                btnExcluir.setEnabled(true);
            } else {
                btnExcluir.setEnabled(false);
            }
            
            btnAtualizar.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnLimpar.setEnabled(false);

            //Chama os campos da tabela
            txtCodigo.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 0).toString());
            txtNome.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 4).toString());
            txtFabricante.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 5).toString());
            txtModelo.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 6).toString());
            jFormattedTextDtFab.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 7).toString());
            jFormattedTextDtInstal.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 8).toString());
            jTextAreaHistInicial.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 9).toString());
            jFormattedTextGap.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 10).toString());
            jFormattedTextDtUltiManut.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 11).toString());
            txtAtendimentos.setText(jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 12).toString());

            Cliente cliente = (Cliente) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 2);
            cliente.setIdcliente(Integer.parseInt(String.valueOf(cliente.getIdcliente())));
//            JOptionPane.showMessageDialog(null, cliente.getIdcliente());
            jComboBoxCliente.setSelectedIndex(cliente.getIdcliente());

            Contrato contrato = (Contrato) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 3);
            contrato.setIdcontrato(Integer.parseInt(String.valueOf(contrato.getIdcontrato())));
            jComboBoxContrato.setSelectedIndex(contrato.getIdcontrato());

            Equipamento c = new Equipamento();
            EquipamentoDAO dao = new EquipamentoDAO();

            c.setFoto((String) jTableEquipamento.getValueAt(jTableEquipamento.getSelectedRow(), 13));
            String nomeImagem = c.getFoto();

            if (!nomeImagem.isEmpty()) {

                ImageIcon icone = new ImageIcon("C:\\Users\\kamil\\Pictures\\Imagens_ProjetoOs\\" + nomeImagem);
                lblFoto.setIcon(icone);
                lblNomeFoto.setText(nomeImagem);
                
            } else {
                JOptionPane.showMessageDialog(null, "Não existe Imagem para este registro");
                
                //Reinicia label foto 
                lblNomeFoto.setText("");
//                lblNomeFoto.setEnabled(false);
                lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")));
            }
        }
    }//GEN-LAST:event_jTableEquipamentoKeyReleased

    private void jComboBoxClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxClienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBoxContrato.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxClienteKeyPressed

    private void jComboBoxContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxContratoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNome.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxContratoKeyPressed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFabricante.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtFabricanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFabricanteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtModelo.requestFocus();
        }
    }//GEN-LAST:event_txtFabricanteKeyPressed

    private void jFormattedTextDtFabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextDtFabKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jFormattedTextDtInstal.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextDtFabKeyPressed

    private void txtModeloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jFormattedTextDtFab.requestFocus();
        }
    }//GEN-LAST:event_txtModeloKeyPressed

    private void jFormattedTextDtInstalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextDtInstalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jFormattedTextGap.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextDtInstalKeyPressed

    private void jFormattedTextGapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextGapKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextAreaHistInicial.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextGapKeyPressed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2 && (!txtNome.getText().isEmpty())) {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Procurar arquivos");
            fc.setCurrentDirectory(new File("C:\\Users\\kamil\\Pictures"));
            fc.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    String name = file.getAbsolutePath();
                    return name.endsWith("jpg") | name.endsWith("png") | name.endsWith("bmp") | file.isDirectory();

                }

                @Override
                public String getDescription() {
                    return "Filtro(jpg,png,bmp e Diretórios)";
                }
            });

            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                String path = fc.getSelectedFile().getAbsolutePath();
                ImageIcon icone1 = new ImageIcon(path);
                Image img = icone1.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                lblFoto.setIcon(new ImageIcon(img));
                String nomeImagem = System.currentTimeMillis() + ".jpg";
                lblNomeFoto.setText(nomeImagem);

                File novaImagem = new File("C:\\Users\\kamil\\Pictures\\Imagens_ProjetoOs\\" + nomeImagem);

                BufferedImage bi = new BufferedImage(lblFoto.getWidth(), lblFoto.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bi.createGraphics();
                g2d.drawImage(img, null, null);
                g2d.dispose();
                try {
                    ImageIO.write(bi, "JPG", novaImagem);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Falha na criação, dimensionamento ou gravação do arquivo imagem");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selecione um arquivo de imagem válido");

            }

        }
    }//GEN-LAST:event_lblFotoMouseClicked

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
            java.util.logging.Logger.getLogger(FormEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEquipamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> jComboBoxCliente;
    private javax.swing.JComboBox<Object> jComboBoxContrato;
    private javax.swing.JFormattedTextField jFormattedTextDtFab;
    private javax.swing.JFormattedTextField jFormattedTextDtInstal;
    private javax.swing.JFormattedTextField jFormattedTextDtUltiManut;
    private javax.swing.JFormattedTextField jFormattedTextGap;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEquipamento;
    private javax.swing.JTextArea jTextAreaHistInicial;
    private javax.swing.JLabel lblAtendimentos;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContrato;
    private javax.swing.JLabel lblDtFabric;
    private javax.swing.JLabel lblDtInstal;
    private javax.swing.JLabel lblFabric;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGap;
    private javax.swing.JLabel lblHistInicial;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFoto;
    private javax.swing.JLabel lblUltManut;
    private javax.swing.JTextField txtAtendimentos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
