/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Equipamento;
import model.bean.Os;
import model.bean.Tiposerv;
import model.dao.ClienteDAO;
import model.dao.EquipamentoDAO;
import model.dao.OsDAO;
import model.dao.TiposervDAO;

/**
 *
 * @author Master
 */
public class FormOs extends javax.swing.JFrame {

//    //declaração de variaveis
//    private String statusPeca;
//    private String statusRetirado;
//    private String statusFechada;
    /**
     * Creates new form FormOs
     */
    public FormOs() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTableCliente.getModel();
        jTableCliente.setRowSorter(new TableRowSorter(modelo));

        DefaultTableModel mod = (DefaultTableModel) jTableOsAberta.getModel();
        jTableOsAberta.setRowSorter(new TableRowSorter(mod));

        readAllTableCliente();//chama o metodo que preenche a tabela de clientes
        readAllTableOsAbertas();//chama o metodo que preenche a tabela os
        combobox();//chama o metodo que preenche o combobox de clientes
//        comboboxEquipamento();//chama o metodo que preenche o combobox equipamento
        comboboxTipoServ();//chama o metodo que preenche o combobox tipo de servico

        //preparo inicial de campos
        desabilitaCampos();
        desabilitaBottons();

    }

//    private void inicializaVariaveis() {
//
//        statusPeca = "Não";
//        statusRetirado = "Não";
//        statusFechada = "Não";
//
//    }
    public void desabilitaCampos() {
        jComboBoxCliente.setEnabled(false);
        jComboBoxEquip.setEnabled(false);
        jComboBoxDefeito.setEnabled(false);
        jComboBoxTipoServ.setEnabled(false);
        txtObs.setEnabled(false);
    }

    public void desabilitaBottons() {
        btnLimpar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnNovoCli.setEnabled(false);
        btnNovoEquip.setEnabled(false);
    }

    public void habilitaCampos() {
        jComboBoxCliente.setEnabled(true);
        jComboBoxEquip.setEnabled(true);
        jComboBoxDefeito.setEnabled(true);
        jComboBoxTipoServ.setEnabled(true);
        txtObs.setEnabled(true);
    }

    public void habilitaBottonsNovo() {
        btnLimpar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnNovoCli.setEnabled(true);
        btnNovoEquip.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }

    private void habilitaBottonsEscolhaCli() {
        btnLimpar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnNovoCli.setEnabled(false);
        btnNovoEquip.setEnabled(true);
    }

    private void habilitaBottonsEscolhaOs() {
        btnLimpar.setEnabled(true);
        btnSalvar.setEnabled(false);
        if (FormMenu.lblUsuario.getText().equals("ADMGERAL")) {
            btnExcluir.setEnabled(true);
        } else {
            btnExcluir.setEnabled(true);
        }
        btnAtualizar.setEnabled(true);
        btnNovoCli.setEnabled(false);
        btnNovoEquip.setEnabled(false);
    }

    public void limpaCampos() {
        jComboBoxCliente.setSelectedIndex(0);
        jComboBoxEquip.setSelectedIndex(0);
        jComboBoxDefeito.setSelectedIndex(0);
        jComboBoxTipoServ.setSelectedIndex(0);
        txtObs.setText("");
        txtBuscaCli.setText("");
        txtCodigoOs.setText("");

    }

    public void combobox() {

        ClienteDAO cdao = new ClienteDAO();
        jComboBoxCliente.removeAllItems();
        jComboBoxCliente.addItem("Escolha");
        for (Cliente cl : cdao.readComboboxClienteForOs()) {
            jComboBoxCliente.addItem(cl);
        }
        if (jComboBoxCliente.getSelectedIndex() == 0) {
            EquipamentoDAO edao = new EquipamentoDAO();
            jComboBoxEquip.removeAllItems();
            jComboBoxEquip.addItem("Escolha");
        }
    }

    public void comboboxEquipamentoOsClick() {
        EquipamentoDAO edao = new EquipamentoDAO();
        jComboBoxEquip.removeAllItems();
        jComboBoxEquip.addItem("Escolha");
        for (Equipamento e : edao.readAllEquipamento()) {
            jComboBoxEquip.addItem(e);
        }
    }

    public void comboboxTipoServ() {
        TiposervDAO tdao = new TiposervDAO();
        jComboBoxTipoServ.removeAll();
        jComboBoxTipoServ.addItem("Escolha");
        for (Tiposerv ts : tdao.readAllTiposerv()) {
            jComboBoxTipoServ.addItem(ts);
        }
    }

    public void readAllTableCliente() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCliente.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();

        for (Cliente c : dao.readTableClienteForOs()) {
            modelo.addRow(new Object[]{
                c.getIdcliente(),
                c.getNome(),
                c.getRua(),
                c.getNumero(),
                c.getComplemento(),
                c.getReferencia(),
                c.getBairro(),
                c.getFone1(),
                c.getFone2(),
                c.getCelular(),
                c.getContato(),
                c.getEmail(),
                c.getEstado(),
                c.getCidade()
            });
        }
    }

    public void readAllTableOsAbertas() {
        DefaultTableModel mod = (DefaultTableModel) jTableOsAberta.getModel();
        mod.setNumRows(0);
        OsDAO dao = new OsDAO();

        for (Os o : dao.readTableOsAbertura()) {
            mod.addRow(new Object[]{
                o.getIdos(),
                o.getData(),
                o.getCliente(),
                o.getEquipamento(),
                o.getDefeito(),
                o.getTiposerv(),
                o.getObs(),
                o.getTecnico(),
                o.getDt_inicio(),
                o.getDt_fim(),
                o.getServico(),
                o.getAberta_fech()
            });
        }
    }

    public void readAllTableOsAbertasForCli(String nome) {
        DefaultTableModel mod = (DefaultTableModel) jTableOsAberta.getModel();
        mod.setNumRows(0);
        OsDAO dao = new OsDAO();

        for (Os o : dao.readConsultaTableOsAbertura(nome)) {
            mod.addRow(new Object[]{
                o.getIdos(),
                o.getData(),
                o.getCliente(),
                o.getEquipamento(),
                o.getDefeito(),
                o.getTiposerv(),
                o.getTecnico(),
                o.getDt_inicio(),
                o.getDt_fim(),
                o.getServico()
            });
        }
    }

    public void readAllTableOsAbertasForId(int id) {
        DefaultTableModel mod = (DefaultTableModel) jTableOsAberta.getModel();
        mod.setNumRows(0);
        OsDAO dao = new OsDAO();

        for (Os o : dao.readConsultaTableOsAberturaForId(id)) {
            mod.addRow(new Object[]{
                o.getIdos(),
                o.getData(),
                o.getCliente(),
                o.getEquipamento(),
                o.getDefeito(),
                o.getTiposerv(),
                o.getObs(),
                o.getTecnico(),
                o.getDt_inicio(),
                o.getDt_fim(),
                o.getServico(),
                o.getAberta_fech()
            });
        }
    }

    public void readTableCliente(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCliente.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();

        for (Cliente c : dao.readAllTableClienteForOs(nome)) {
            modelo.addRow(new Object[]{
                c.getIdcliente(),
                c.getNome(),
                c.getRua(),
                c.getNumero(),
                c.getComplemento(),
                c.getReferencia(),
                c.getBairro(),
                c.getFone1(),
                c.getFone2(),
                c.getCelular(),
                c.getContato(),
                c.getEmail(),
                c.getEstado(),
                c.getCidade()
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

        btnSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblDefeito = new javax.swing.JLabel();
        lblEquip = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxDefeito = new javax.swing.JComboBox<>();
        jComboBoxEquip = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();
        jComboBoxTipoServ = new javax.swing.JComboBox<>();
        btnNovoCli = new javax.swing.JButton();
        lblObs = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        btnNovoEquip = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtBuscaCli = new javax.swing.JTextField();
        btnBuscaCli = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtOsConsulta = new javax.swing.JTextField();
        btnOsConsulta = new javax.swing.JButton();
        lblCodigoOs = new javax.swing.JLabel();
        txtCodigoOs = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOsAberta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMULÁRIO EMISSÃO DE ORDEM DE SERVIÇO");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")).getImage());

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("TABELA DE CLIENTES"));

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD.", "NOME", "ENDEREÇO", "NÚMERO", "COMPLEM.", "REFERÊNCIA", "BAIRRO", "FONE1", "FONE2", "CELULAR", "CONTATO", "EMAIL", "ESTADO", "CIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jTableCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableClienteKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCliente);
        if (jTableCliente.getColumnModel().getColumnCount() > 0) {
            jTableCliente.getColumnModel().getColumn(0).setMinWidth(30);
            jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableCliente.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DA 'OS'"));

        lblDefeito.setText("*Defeito");

        lblEquip.setText("*Equip.");

        jComboBoxCliente.setMaximumRowCount(10);
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha" }));
        jComboBoxCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jComboBoxDefeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha", "Orçamento", "Equipamento parado", "Com ruido ao acionar", "Com ruido constante", "Com vibração", "Com atraso", "Com vazamento", " ", " " }));

        jComboBoxEquip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha" }));
        jComboBoxEquip.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxEquipPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBoxEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxEquipMouseClicked(evt);
            }
        });

        lblCliente.setText("*Cliente");

        lblServico.setText("*Tipo Serv.");

        btnNovoCli.setBackground(new java.awt.Color(0, 153, 153));
        btnNovoCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNovoCli.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_add_35760 (1).png"))); // NOI18N
        btnNovoCli.setText("NOVO");
        btnNovoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCliActionPerformed(evt);
            }
        });

        lblObs.setText("Obs");

        btnNovoEquip.setBackground(new java.awt.Color(0, 153, 153));
        btnNovoEquip.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNovoEquip.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoEquip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_add_35760 (1).png"))); // NOI18N
        btnNovoEquip.setText("NOVO");
        btnNovoEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoEquipActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_error_35763 (1).png"))); // NOI18N
        jLabel1.setText("(*) - Campo de preenchimento OBRIGATÓRIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDefeito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(lblEquip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipoServ, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNovoCli)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNovoEquip)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObs)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovoCli)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquip)
                    .addComponent(jComboBoxEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoEquip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDefeito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServico)
                    .addComponent(jComboBoxTipoServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObs, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DIGITE O NOME DO CLIENTE PARA CONSULTA"));

        btnBuscaCli.setBackground(new java.awt.Color(0, 153, 153));
        btnBuscaCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscaCli.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscaCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bg-input-azul.png"))); // NOI18N
        btnBuscaCli.setText("...");
        btnBuscaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnBuscaCli)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscaCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaCli))
                .addContainerGap())
        );

        btnSalvar.setBackground(new java.awt.Color(0, 153, 153));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_add_35760.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(0, 153, 153));
        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_go_35764.png"))); // NOI18N
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
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_delete_35761.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");

        btnAtualizar.setBackground(new java.awt.Color(0, 153, 153));
        btnAtualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_edit_35762.png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("CONSULTA OS PELO CÓDIGO DO CLIENTE"));

        btnOsConsulta.setBackground(new java.awt.Color(0, 153, 153));
        btnOsConsulta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOsConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnOsConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bg-input-azul.png"))); // NOI18N
        btnOsConsulta.setText("...");
        btnOsConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtOsConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOsConsulta)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOsConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOsConsulta))
                .addContainerGap())
        );

        lblCodigoOs.setText("Código da OS selecionada:");

        txtCodigoOs.setEditable(false);
        txtCodigoOs.setForeground(new java.awt.Color(255, 51, 51));
        txtCodigoOs.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblCodigoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoOs)
                            .addComponent(txtCodigoOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("RELAÇÃO DAS OS`S DO CLIENTE SELECIONADO"));

        jTableOsAberta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD.", "DATA", "CLIENTE", "EQUIP.", "DEFEITO", "SERV.SOLICITADO", "OBS", "TÉCNICO", "DT_INICIO", "DT_FIM", "SERVIÇO", "STATUS Os"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOsAberta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOsAbertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOsAberta);
        if (jTableOsAberta.getColumnModel().getColumnCount() > 0) {
            jTableOsAberta.getColumnModel().getColumn(0).setMinWidth(40);
            jTableOsAberta.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableOsAberta.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableOsAberta.getColumnModel().getColumn(1).setMinWidth(90);
            jTableOsAberta.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableOsAberta.getColumnModel().getColumn(1).setMaxWidth(135);
            jTableOsAberta.getColumnModel().getColumn(7).setMinWidth(60);
            jTableOsAberta.getColumnModel().getColumn(7).setPreferredWidth(70);
            jTableOsAberta.getColumnModel().getColumn(7).setMaxWidth(80);
            jTableOsAberta.getColumnModel().getColumn(8).setMinWidth(60);
            jTableOsAberta.getColumnModel().getColumn(8).setPreferredWidth(70);
            jTableOsAberta.getColumnModel().getColumn(8).setMaxWidth(80);
            jTableOsAberta.getColumnModel().getColumn(9).setMinWidth(60);
            jTableOsAberta.getColumnModel().getColumn(9).setPreferredWidth(70);
            jTableOsAberta.getColumnModel().getColumn(9).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1052, 1052, 1052)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(775, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        habilitaCampos();
        readAllTableCliente();
        readAllTableOsAbertas();
        habilitaBottonsNovo();
        combobox();
        jComboBoxCliente.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnBuscaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCliActionPerformed
        // TODO add your handling code here:
        readTableCliente(txtBuscaCli.getText());
        desabilitaBottons();
        limpaCampos();
        desabilitaCampos();
        combobox();
        readAllTableOsAbertas();
    }//GEN-LAST:event_btnBuscaCliActionPerformed

    private void btnNovoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCliActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        readAllTableCliente();
        combobox();
        int numeroLinhasTabelaInicial = 0;
        int numeroLinhasTabelaFinal = 0;

        int numeroLinhasComboEquipInicial = 0;
        int numeroLinhasComboEquipFinal = 0;

//testa o numero de linhas da tabela cliente antes de chamar o formulario
        numeroLinhasTabelaInicial = jTableCliente.getRowCount();

//chama o formulario para cadastrar um novo cliente 
        FormClienteParaOs cliente = new FormClienteParaOs(this, rootPaneCheckingEnabled);
        cliente.setVisible(true);

        //Atualiza tabela
        readAllTableCliente();

        //Testa se cadastro de cliente foi feito
        numeroLinhasTabelaFinal = jTableCliente.getRowCount();
        if (numeroLinhasTabelaFinal == numeroLinhasTabelaInicial) {
            //Como nenhum cliente foi cadastrado o sistema zera o processo
            limpaCampos();
            desabilitaBottons();
            desabilitaCampos();
            readAllTableCliente();//chama o metodo que preenche a tabela de clientes
            readAllTableOsAbertas();//chama o metodo que preenche a tabela os
            combobox();//atualiza os comboboxs cliente e equipamento
        } else {
            combobox();
            jComboBoxCliente.setSelectedIndex(numeroLinhasTabelaFinal);

            //Prepara o combobox de equipamentos para o novo cliente
            jComboBoxEquip.removeAllItems();
            jComboBoxEquip.addItem("Escolha");
            //pegao numero de linhas iniciais do combobox
            numeroLinhasComboEquipInicial = jComboBoxEquip.getItemCount();

            //as linhas abaixo pegam o codigo do cliente diretamente no combobox de cliente e abre o kickformulario de equipamentos para o novo cliente 
            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            FormEquipParaOs equip = new FormEquipParaOs(this, rootPaneCheckingEnabled);
            equip.importaCliente(cli);
            equip.setVisible(true);

            //carrego o combobox equipamento do novo cliente
            EquipamentoDAO eqdao = new EquipamentoDAO();
            jComboBoxEquip.removeAllItems();
            jComboBoxEquip.addItem("Escolha");
            cli.setIdcliente(cli.getIdcliente());
            for (Equipamento e : eqdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
                jComboBoxEquip.addItem(e);
                jComboBoxEquip.setSelectedItem(e);
            }

            //Verifico se foi cadastrado algum equipamento para o novo cliente
            numeroLinhasComboEquipFinal = jComboBoxEquip.getItemCount();
            if (numeroLinhasComboEquipFinal == numeroLinhasComboEquipInicial) {
                //Como nao foi cadastrado nenhum equipamento para o novo cliente o sistema zera o processo com mais um cliente cadastrado
                limpaCampos();
                desabilitaBottons();
                desabilitaCampos();
                readAllTableCliente();//chama o metodo que preenche a tabela de clientes
                readAllTableOsAbertas();//chama o metodo que preenche a tabela os
                combobox();//atualiza os comboboxs cliente e equipamento
            } else {
                btnNovoCli.setEnabled(false);
                jComboBoxDefeito.requestFocus();
            }
        }
    }//GEN-LAST:event_btnNovoCliActionPerformed

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
        // TODO add your handling code here:
        if (jTableCliente.getSelectedRow() != -1) {
            limpaCampos();
            habilitaCampos();
            habilitaBottonsEscolhaCli();
            int itensInicial = 0;
            int itensFinal = 0;

            jComboBoxCliente.setSelectedIndex(Integer.parseInt(jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 0).toString()));

            if (jComboBoxCliente.getSelectedItem() != "Escolha") {
                Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
                cli.setIdcliente(cli.getIdcliente());

                //a linha abaixo lista na tabela de os as oss do cliente selecionado no comboboxcliente quando clicado
                readAllTableOsAbertasForId(cli.getIdcliente());

                //A linha abaixo carrega o combobox equipamento com os equipamentos do cliente selecionado
                EquipamentoDAO equipdao = new EquipamentoDAO();
                jComboBoxEquip.removeAllItems();
                jComboBoxEquip.addItem("Escolha");
                for (Equipamento e : equipdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
                    jComboBoxEquip.addItem(e);
                }

                //a linha abaixo pega o número de itens do combobox equipamentos
                itensInicial = jComboBoxEquip.getItemCount();
//                JOptionPane.showMessageDialog(null, itensInicial);

                //a linha abaixo testa se o combobox equipamento tem apenas a palavra escolha
                if (itensInicial == 1) {
                    //as linhas abaixo pegam o codigo do cliente diretamente no combobox de cliente e abre o kickformulario de equipamentos para cliente 
                    FormEquipParaOs equip = new FormEquipParaOs(this, rootPaneCheckingEnabled);
                    equip.importaCliente(cli);
                    equip.setVisible(true);
//                    JOptionPane.showMessageDialog(null, "VOLTEI");

                    //as linhas abaixo recarregam o combobox do equipamento novo para o cliente selecionado
                    EquipamentoDAO eqdao = new EquipamentoDAO();
                    jComboBoxEquip.removeAllItems();
                    jComboBoxEquip.addItem("Escolha");
                    cli.setIdcliente(cli.getIdcliente());
                    for (Equipamento e : eqdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
                        jComboBoxEquip.addItem(e);
                        jComboBoxEquip.setSelectedItem(e);//esta linha posiciona o combobox no último item de equipamento cadastrado
                    }
                    //A linha abaixo verifica o número de itens do combobox equipamentos que retornara igual a inicial caso nenhum equipamento novo tenha sido cadastrado
                    itensFinal = jComboBoxEquip.getItemCount();

                    //A linha abaixo verifica se foi acrescentado algum equipamento novo ao cliente se afirmativo deve atualizar o combobox equipamento
                    if (itensFinal == itensInicial) {
                        limpaCampos();
                        desabilitaBottons();
                        desabilitaCampos();
                        readAllTableCliente();//chama o metodo que preenche a tabela de clientes
                        readAllTableOsAbertas();//chama o metodo que preenche a tabela os
                        combobox();//atualiza os comboboxs cliente e equipamento
                    } else {
                        btnNovoCli.setEnabled(false);
                        btnNovoEquip.setEnabled(false);
                        jComboBoxDefeito.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_jTableClienteMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (jComboBoxCliente.getSelectedIndex() == 0
                || jComboBoxEquip.getSelectedIndex() == 0
                || jComboBoxDefeito.getSelectedIndex() == 0
                || jComboBoxTipoServ.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios, TODOS DEVEM ESTAR PREENCHIDOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            Os os = new Os();
            OsDAO dao = new OsDAO();

            os.setNome_cliente(jComboBoxCliente.getSelectedItem().toString().toUpperCase());
            os.setNome_equip(jComboBoxEquip.getSelectedItem().toString().toUpperCase());
            os.setDefeito(jComboBoxDefeito.getSelectedItem().toString());
            os.setObs(txtObs.getText().toUpperCase());

            Tiposerv ts = (Tiposerv) jComboBoxTipoServ.getSelectedItem();
            ts.setId_tserv(ts.getId_tserv());
            os.setTiposerv(ts);

            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            cli.setIdcliente(cli.getIdcliente());
            os.setCliente(cli);

            Equipamento equip = (Equipamento) jComboBoxEquip.getSelectedItem();
            equip.setIdequip(equip.getIdequip());
            os.setEquipamento(equip);

            os.setInterna_externa("Externa");
            os.setOs_pai(0);
            os.setOs_filha(0);

            dao.saveAberturaOs(os);
        }
        desabilitaBottons();
        limpaCampos();
        desabilitaCampos();
        readAllTableCliente();
        readAllTableOsAbertas();
        combobox();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jTableClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClienteKeyPressed
        // as linhas abaixo possibilitam alterar alguns items de uma linha diretamente na tabela clientes e salvar as alteracoes

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTableCliente.getSelectedRow() != -1) {
                Cliente cli = new Cliente();
                ClienteDAO dao = new ClienteDAO();

                cli.setIdcliente(Integer.parseInt(jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 0).toString()));
                cli.setRua((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 2).toString().toUpperCase()));
                cli.setNumero((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 3).toString()));
                cli.setComplemento((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 4).toString()));
                cli.setReferencia((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 5).toString().toUpperCase()));
                cli.setBairro((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 5).toString().toUpperCase()));
                cli.setFone1((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 7).toString()));
                cli.setFone2((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 8).toString()));
                cli.setCelular((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 9).toString()));
                cli.setContato((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 10).toString().toUpperCase()));
                cli.setEmail((jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 11).toString()));

                dao.updateClienteForOs(cli);

            }
            readAllTableCliente();
        }
    }//GEN-LAST:event_jTableClienteKeyPressed

    private void jTableClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClienteKeyReleased
        // TODO add your handling code here:
        //esta rotina mostra na tabela OSs as OSs do cliente em acordo com a linha selecionada com as setas na tabela de clientes
        jComboBoxCliente.setSelectedIndex(Integer.parseInt(jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 0).toString()));

        if (jComboBoxCliente.getSelectedItem() != "Escolha") {

            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            cli.setIdcliente(cli.getIdcliente());

            EquipamentoDAO equipdao = new EquipamentoDAO();
            jComboBoxEquip.removeAllItems();
            jComboBoxEquip.addItem("Escolha");
            for (Equipamento e : equipdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
                jComboBoxEquip.addItem(e);
            }
            readAllTableOsAbertasForId(cli.getIdcliente());
        }
    }//GEN-LAST:event_jTableClienteKeyReleased

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        desabilitaBottons();
        desabilitaCampos();
        readAllTableCliente();//chama o metodo que preenche a tabela de clientes
        readAllTableOsAbertas();//chama o metodo que preenche a tabela os
        combobox();//atualiza os combobox cliente
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnOsConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsConsultaActionPerformed
// TODO add your handling code here:
//Executa a pesquisa em OSs abertas com o código do cliente
        if (!txtOsConsulta.getText().isEmpty()) {
            readAllTableOsAbertasForId(Integer.parseInt(txtOsConsulta.getText()));
            txtOsConsulta.setText("");
        } else {
            readAllTableOsAbertas();
        }
    }//GEN-LAST:event_btnOsConsultaActionPerformed

    private void jTableOsAbertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOsAbertaMouseClicked
        // as linhas abaixo preparam campos e bottons
        if (jTableOsAberta.getSelectedRow() != -1) {
            limpaCampos();
            habilitaCampos();
            habilitaBottonsEscolhaOs();
            
            //pega o codigo da os selecionada na tabela
            txtCodigoOs.setText(jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 0).toString());
            
            //pega o codigo do cliente na tabela
            Cliente c = (Cliente) (jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 2));
            c.setIdcliente(c.getIdcliente());
            jComboBoxCliente.setSelectedIndex(c.getIdcliente());

            //posiciona o cliente no combobox de acordo com a os selecionada 
            if (jComboBoxCliente.getSelectedItem() != "Escolha") {
                Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
                cli.setIdcliente(cli.getIdcliente());
                jComboBoxCliente.setEnabled(false);

                //posiciona o equipamento do cliente em acordo com a os selecionada na tabela
                comboboxEquipamentoOsClick();

                Equipamento e = (Equipamento) (jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 3));
                e.setIdequip(e.getIdequip());
                jComboBoxEquip.setSelectedIndex(e.getIdequip());
                jComboBoxEquip.setEnabled(false);

                //pega o defeito na tabela e seleciona i item correspondente no comboboxDefeito
                jComboBoxDefeito.setSelectedItem(jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 4).toString());
//                String def = (jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 4).toString());

                //pega tiposerv do objeto tipo serv e seleciona o combobox
                Tiposerv ts = (Tiposerv) jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 5);
                ts.setId_tserv(Integer.parseInt(String.valueOf(ts.getId_tserv())));
                jComboBoxTipoServ.setSelectedIndex(ts.getId_tserv());

                //pega o texto da obs da tabela e coloca no campo
                txtObs.setText(jTableOsAberta.getValueAt(jTableOsAberta.getSelectedRow(), 6).toString());
            }
        }
    }//GEN-LAST:event_jTableOsAbertaMouseClicked

    private void btnNovoEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoEquipActionPerformed
        // TODO add your handling code here:
        int itensInicial = 0;
        jComboBoxEquip.getItemCount();
        int itensFinal = 0;
        itensInicial = jComboBoxEquip.getItemCount();

        //as linhas abaixo pegam o codigo do cliente diretamente no combobox de cliente e abre o kickformulario de equipamentos para o novo cliente 
        Cliente cl = (Cliente) jComboBoxCliente.getSelectedItem();
        jComboBoxCliente.setEnabled(false);
        FormEquipParaOs equip = new FormEquipParaOs(this, rootPaneCheckingEnabled);
        equip.importaCliente(cl);
        equip.setVisible(true);

        //as linhas abaixo recarregam o combobox do equipamento do novo cliente cadastrado
        EquipamentoDAO eqdao = new EquipamentoDAO();
        jComboBoxEquip.removeAllItems();
        jComboBoxEquip.addItem("Escolha");
        cl.setIdcliente(cl.getIdcliente());
        for (Equipamento e : eqdao.readAllEquipamentoForComboboxOs(cl.getIdcliente())) {
            jComboBoxEquip.addItem(e);
            jComboBoxEquip.setSelectedItem(e);
            jComboBoxEquip.setEnabled(false);
        }
        itensFinal = jComboBoxEquip.getItemCount();
        if (itensInicial == itensFinal) {
            limpaCampos();
            desabilitaBottons();
            desabilitaCampos();
            readAllTableCliente();//chama o metodo que preenche a tabela de clientes
            readAllTableOsAbertas();//chama o metodo que preenche a tabela os
            combobox();//atualiza os comboboxs cliente e equipamento
        }else{
            jComboBoxDefeito.requestFocus();
        }

    }//GEN-LAST:event_btnNovoEquipActionPerformed

    private void jComboBoxClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxClientePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        //inicialização de variáveis
//        int itensInicial = 0;
//        int itensFinal = 0;

        //as linhas testam se combobox habilitado.se estiver e tiver um cliente selecionado preenche o combobox equipamento se não limpa ele e adciona apenas escolha
        if (jComboBoxCliente.getSelectedItem() != ("Escolha")) {

            btnNovoCli.setEnabled(false);
            btnNovoEquip.setEnabled(true);
            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            cli.setIdcliente(cli.getIdcliente());

            //mostra na tabela de OS as OSs correspondente ao cliente selecionado
            readAllTableOsAbertasForId(cli.getIdcliente());

            EquipamentoDAO equipdao = new EquipamentoDAO();
            jComboBoxEquip.removeAllItems();
            jComboBoxEquip.addItem("Escolha");
            for (Equipamento e : equipdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
                jComboBoxEquip.addItem(e);
            }
            jComboBoxEquip.requestFocus();
        }

//        //a linha abaixo pega o número de itens do combobox equipamentos
//        itensInicial = jComboBoxEquip.getItemCount();
//
//        //a linha abaixo testa se o combobox tem apenas a palavra escolha e se for assim, abre o form para cadastro e um novo equipamento 
//        if (itensInicial == 1) {
//            //as linhas abaixo pegam o codigo do cliente diretamente no combobox de cliente e abre o kickformulario de equipamentos para o novo cliente 
//            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
//            cli.setIdcliente(cli.getIdcliente());
//            FormEquipParaOs equip = new FormEquipParaOs(this, rootPaneCheckingEnabled);
//            equip.importaCliente(cli);
//            equip.setVisible(true);
//
//            //as linhas abaixo recarregam o combobox do equipamento do cliente cadastrado e posiciona no novo equipamento
//            EquipamentoDAO eqdao = new EquipamentoDAO();
//            jComboBoxEquip.removeAllItems();
//            jComboBoxEquip.addItem("Escolha");
//            for (Equipamento e : eqdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
//                jComboBoxEquip.addItem(e);
//                jComboBoxEquip.setSelectedItem(e);
//            }
//            
//            //pega a quantidade de itens do combobox equipamento apois a carga para verificar se foi cadastrado um novo equipamento para o cliente selecionado
//            itensFinal = jComboBoxEquip.getItemCount();
//            
//            //As linhas abaixo reinicia o sistema caso nao tenha sido cadastrado um novo equipamento - caso em que a tecla CANCELAR seja presionada
//            if (itensInicial == itensFinal) {
//                limpaCampos();
//                desabilitaBottons();
//                desabilitaCampos();
//                readAllTableCliente();//chama o metodo que preenche a tabela de clientes
//                readAllTableOsAbertas();//chama o metodo que preenche a tabela os
//                combobox();//atualiza os combobox cliente
//            } else {
//                jComboBoxDefeito.requestFocus();
//            }
//        } else {
//            jComboBoxEquip.requestFocus();
//        }
    }//GEN-LAST:event_jComboBoxClientePopupMenuWillBecomeInvisible

    private void jComboBoxEquipPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxEquipPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
//        //inicialização de variáveis
//        int itensInicial = 0;
//        int itensFinal = 0;
//
//        //as linhas testam se combobox habilitado.se estiver e tiver um cliente selecionado preenche o combobox equipamento se não limpa ele e adciona apenas escolha
//        if (jComboBoxCliente.getSelectedItem() != ("Escolha")) {
//
//            btnNovoCli.setEnabled(false);
//            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
//            cli.setIdcliente(cli.getIdcliente());
//
//            //mostra na tabela de OS as OSs correspondente ao cliente selecionado
//            readAllTableOsAbertasForId(cli.getIdcliente());
//
//            EquipamentoDAO equipdao = new EquipamentoDAO();
//            jComboBoxEquip.removeAllItems();
//            jComboBoxEquip.addItem("Escolha");
//            for (Equipamento e : equipdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
//                jComboBoxEquip.addItem(e);
//            }
//        }
//
//        //a linha abaixo pega o número de itens do combobox equipamentos
//        itensInicial = jComboBoxEquip.getItemCount();
//
//        //a linha abaixo testa se o combobox tem apenas a palavra escolha e se for assim, abre o form para cadastro e um novo equipamento 
//        if (itensInicial == 1) {
//            //as linhas abaixo pegam o codigo do cliente diretamente no combobox de cliente e abre o kickformulario de equipamentos para o novo cliente 
//            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
//            cli.setIdcliente(cli.getIdcliente());
//            FormEquipParaOs equip = new FormEquipParaOs(this, rootPaneCheckingEnabled);
//            equip.importaCliente(cli);
//            equip.setVisible(true);
//
//            //as linhas abaixo recarregam o combobox do equipamento do cliente cadastrado e posiciona no novo equipamento
//            EquipamentoDAO eqdao = new EquipamentoDAO();
//            jComboBoxEquip.removeAllItems();
//            jComboBoxEquip.addItem("Escolha");
//            for (Equipamento e : eqdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
//                jComboBoxEquip.addItem(e);
//                jComboBoxEquip.setSelectedItem(e);
//            }
//            
//            //pega a quantidade de itens do combobox equipamento apois a carga para verificar se foi cadastrado um novo equipamento para o cliente selecionado
//            itensFinal = jComboBoxEquip.getItemCount();
//            
//            //As linhas abaixo reinicia o sistema caso nao tenha sido cadastrado um novo equipamento - caso em que a tecla CANCELAR seja presionada
//            if (itensInicial == itensFinal) {
//                limpaCampos();
//                desabilitaBottons();
//                desabilitaCampos();
//                readAllTableCliente();//chama o metodo que preenche a tabela de clientes
//                readAllTableOsAbertas();//chama o metodo que preenche a tabela os
//                combobox();//atualiza os combobox cliente
//            } else {
//                jComboBoxDefeito.requestFocus();
//            }
//        } else {
//            jComboBoxEquip.requestFocus();
//        }
    }//GEN-LAST:event_jComboBoxEquipPopupMenuWillBecomeInvisible

    private void jComboBoxEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxEquipMouseClicked
        // TODO add your handling code here:
//      inicialização de variáveis
        int itensInicial = 0;
        int itensFinal = 0;
        
//        a linha abaixo pega o número de itens do combobox equipamentos
        itensInicial = jComboBoxEquip.getItemCount();

        //a linha abaixo testa se o combobox tem apenas a palavra escolha e se for assim, abre o form para cadastro e um novo equipamento 
        if (itensInicial == 1) {
            //as linhas abaixo pegam o codigo do cliente diretamente no combobox de cliente e abre o kickformulario de equipamentos para o novo cliente 
            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
            cli.setIdcliente(cli.getIdcliente());
            FormEquipParaOs equip = new FormEquipParaOs(this, rootPaneCheckingEnabled);
            equip.importaCliente(cli);
            equip.setVisible(true);

            //as linhas abaixo recarregam o combobox do equipamento do cliente cadastrado e posiciona no novo equipamento
            EquipamentoDAO eqdao = new EquipamentoDAO();
            jComboBoxEquip.removeAllItems();
            jComboBoxEquip.addItem("Escolha");
            for (Equipamento e : eqdao.readAllEquipamentoForComboboxOs(cli.getIdcliente())) {
                jComboBoxEquip.addItem(e);
                jComboBoxEquip.setSelectedItem(e);
            }
            
            //pega a quantidade de itens do combobox equipamento apois a carga para verificar se foi cadastrado um novo equipamento para o cliente selecionado
            itensFinal = jComboBoxEquip.getItemCount();
            
            //As linhas abaixo reinicia o sistema caso nao tenha sido cadastrado um novo equipamento - caso em que a tecla CANCELAR seja presionada
            if (itensInicial == itensFinal) {
                limpaCampos();
                desabilitaBottons();
                desabilitaCampos();
                readAllTableCliente();//chama o metodo que preenche a tabela de clientes
                readAllTableOsAbertas();//chama o metodo que preenche a tabela os
                combobox();//atualiza os combobox cliente
            } else {
                jComboBoxDefeito.requestFocus();
            }
        } 
    }//GEN-LAST:event_jComboBoxEquipMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxCliente.getSelectedIndex() == 0
                || jComboBoxEquip.getSelectedIndex() == 0
                || jComboBoxDefeito.getSelectedIndex() == 0
                || jComboBoxTipoServ.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios, TODOS DEVEM ESTAR PREENCHIDOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            Os os = new Os();
            OsDAO dao = new OsDAO();

//            os.setNome_cliente(jComboBoxCliente.getSelectedItem().toString().toUpperCase());
////            JOptionPane.showMessageDialog(null, jComboBoxCliente.getSelectedItem().toString().toUpperCase());
//            os.setNome_equip(jComboBoxEquip.getSelectedItem().toString().toUpperCase());
            os.setDefeito(jComboBoxDefeito.getSelectedItem().toString());
            os.setObs(txtObs.getText().toUpperCase());

            Tiposerv ts = (Tiposerv) jComboBoxTipoServ.getSelectedItem();
            ts.setId_tserv(ts.getId_tserv());
            os.setTiposerv(ts);
//
//            Cliente cli = (Cliente) jComboBoxCliente.getSelectedItem();
//            cli.setIdcliente(cli.getIdcliente());
//            os.setCliente(cli);
//
//            Equipamento equip = (Equipamento) jComboBoxEquip.getSelectedItem();
//            equip.setIdequip(equip.getIdequip());
//            os.setEquipamento(equip);

//            os.setInterna_externa("Externa");
//            os.setOs_pai(0);
//            os.setOs_filha(0);
            
//            JOptionPane.showMessageDialog(null, Integer.parseInt(txtCodigoOs.getText()));
            
            os.setIdos(Integer.parseInt(txtCodigoOs.getText()));
            

            dao.updateAbertura(os);
        }
        desabilitaBottons();
        limpaCampos();
        desabilitaCampos();
        readAllTableCliente();
        readAllTableOsAbertas();
        combobox();
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FormOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormOs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscaCli;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnNovoCli;
    private javax.swing.JButton btnNovoEquip;
    private javax.swing.JButton btnOsConsulta;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> jComboBoxCliente;
    private javax.swing.JComboBox<Object> jComboBoxDefeito;
    private javax.swing.JComboBox<Object> jComboBoxEquip;
    private javax.swing.JComboBox<Object> jComboBoxTipoServ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableOsAberta;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodigoOs;
    private javax.swing.JLabel lblDefeito;
    private javax.swing.JLabel lblEquip;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblServico;
    private javax.swing.JTextField txtBuscaCli;
    private javax.swing.JTextField txtCodigoOs;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtOsConsulta;
    // End of variables declaration//GEN-END:variables
}
