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
import model.bean.Cidade;
import model.bean.Estado;
import model.dao.CidadeDAO;
import model.dao.EstadoDAO;

/**
 *
 * @author Master
 */
public class FormCidade extends javax.swing.JFrame {

    /**
     * Creates new form FormCidade
     */
    public FormCidade() {
        initComponents();
//As linhas abaixo servem para ordenar a JTableAdmin
        DefaultTableModel modelo = (DefaultTableModel) jTableCidade.getModel();
        jTableCidade.setRowSorter(new TableRowSorter(modelo));

//A linha abaixo chama o método que preenche a tabela lendo os dados do banco 
        readTable();
        comboboxEstado();

// Habilita campos
        txtCodigo.setEnabled(false);
        txtNome.setEnabled(false);
        jComboBoxEstado.setEnabled(false);
        txtConsulta.setEnabled(true);
        

//Prepara botões
        btnLimpar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnConsulta.setEnabled(true);
        txtConsulta.requestFocus();
    }
    
    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCidade.getModel();
        modelo.setNumRows(0);
        CidadeDAO pdao = new CidadeDAO();
        
        for (Cidade p : pdao.readAllForCidade()) {
            modelo.addRow(new Object[]{
                p.getIdcidade(),
                p.getNome(),
                p.getEstado()
            });
        }
    }
    
    public void readTableForNameCidade(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCidade.getModel();
        modelo.setNumRows(0);
        CidadeDAO pdao = new CidadeDAO();
        
        for (Cidade p : pdao.readForNameCidade(nome)) {
            modelo.addRow(new Object[]{
                p.getIdcidade(),
                p.getNome(),
                p.getEstado()
            });      
        }
    }
    
    public void comboboxEstado() {
//As linhas abaixo preenchem os combobox estado
        EstadoDAO estdao = new EstadoDAO();
        
        for (Estado e : estdao.readAllEstado()) {
            jComboBoxEstado.addItem(e);
        }
        jComboBoxEstado.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCidade = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtConsulta = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMUÁRIO DE CADASTRO DE CIDADE");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/LogoSys270x250.png")).getImage());

        jTableCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME DA CIDADE", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCidadeMouseClicked(evt);
            }
        });
        jTableCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCidadeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCidade);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DAS CIDADES"));

        txtCodigo.setEditable(false);
        txtCodigo.setForeground(new java.awt.Color(255, 0, 51));
        txtCodigo.setEnabled(false);

        txtNome.setEnabled(false);
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha" }));
        jComboBoxEstado.setEnabled(false);

        lblEstado.setText("* ESTADO");

        lblCodigo.setText("CÓDIGO");

        lblNome.setText("* NOME");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 39, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setBackground(new java.awt.Color(0, 153, 153));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_go_35764.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(0, 153, 153));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_delete_35761.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(0, 153, 153));
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(0, 153, 153));
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_add_35760.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(0, 153, 153));
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_building_edit_35762.png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta cidades por nome"));

        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsultaKeyPressed(evt);
            }
        });

        btnConsulta.setBackground(new java.awt.Color(0, 153, 153));
        btnConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bg-input-azul.png"))); // NOI18N
        btnConsulta.setText("...");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });
        btnConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConsultaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtConsulta))
                    .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSair.setBackground(new java.awt.Color(0, 153, 153));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-url-ee.png"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1810, 1810, 1810))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1386, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
//A linha abaixo chama o método que preenche a tabela lendo os dados do banco 
        readTable();
        comboboxEstado();

// Habilita campos
        txtCodigo.setEnabled(false);
        txtNome.setEnabled(true);
        jComboBoxEstado.setEnabled(true);
        

//Limpa campos
        txtCodigo.setText("");
        txtNome.setText("");
        txtConsulta.setText("");

//Prepara botões
        btnLimpar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
        txtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios, TODOS DEVEM ESTAR PREENCHIDOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!txtNome.getText().isEmpty() && jComboBoxEstado.getSelectedIndex() != 0) {
            
            Cidade cid = new Cidade();
            CidadeDAO dao = new CidadeDAO();
            
            cid.setNome(txtNome.getText());
            
            Estado estado = (Estado) jComboBoxEstado.getSelectedItem();
            estado.setIdestado(estado.getIdestado());
            
            cid.setEstado(estado);
            dao.saveCidade(cid);

//Reinicia tabela
            readTable();

//Reinicia combobox cidade
            comboboxEstado();
            
//Limpa campos
            txtCodigo.setText("");
            txtNome.setText("");

//Reinicia campo de consulta            
            txtConsulta.setText("");

//As linhas abaixo preparam campos
            txtCodigo.setEnabled(false);
            txtNome.setEnabled(false);
            jComboBoxEstado.setEnabled(false);

//Atualiza botões
            btnLimpar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnAtualizar.setEnabled(false);
            txtConsulta.requestFocus();
            
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se nome preenchido e selecione um estado", "ALERTA", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBoxEstado.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios, TODOS DEVEM ESTAR PREENCHIDOS!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (jComboBoxEstado.getSelectedItem() != "Escolha") {
            
            Cidade city = new Cidade();
            CidadeDAO dao = new CidadeDAO();
            
            city.setNome(txtNome.getText());

//As linhas abaixo pegam no combobox, que contem o objeto,  idestado
            Estado estado = (Estado) jComboBoxEstado.getSelectedItem();
            estado.setIdestado(estado.getIdestado());
            city.setEstado(estado);
            
            city.setIdcidade(Integer.parseInt(txtCodigo.getText()));
            
            dao.updateCidade(city);

//Reinicia tabela
            readTable();

//Reinicia combobox cidade
            comboboxEstado();

//Limpa campos
            txtCodigo.setText("");
            txtNome.setText("");

//Reinicia campo de consulta            
            txtConsulta.setText("");
            txtConsulta.requestFocus();

//As linhas abaixo preparam campos
            txtCodigo.setEnabled(false);
            txtNome.setEnabled(false);
            jComboBoxEstado.setEnabled(false);

//Atualiza botões
            btnLimpar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnAtualizar.setEnabled(false);
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Verifique o campo estado, DEVEM HAVER UM ESTADO SELECIONADO!! ", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
// Limpa campos e posicion o cursor
        txtNome.setText("");
        jComboBoxEstado.setSelectedIndex(0);
        txtNome.requestFocus();

//Reinicia botões
        btnLimpar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jTableCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCidadeMouseClicked
//Reinicia combobox cidade
            
            jComboBoxEstado.setSelectedIndex(0);

// As linhas abaixo selecionam um item da tabela para ser alterado e copiam o item para os campos.
        
        if (jTableCidade.getSelectedRow() != -1) {
            txtCodigo.setEnabled(true);
            txtNome.setEnabled(true);
            jComboBoxEstado.setEnabled(true);
            
//            if(FormMenu.lblUsuario.getText().equals("ADMGERAL")){
//            btnExcluir.setEnabled(true);
//        }else{
//            btnExcluir.setEnabled(false);
//        }
            
            btnAtualizar.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnLimpar.setEnabled(false);
            btnExcluir.setEnabled(true);
            
            txtCodigo.setText(jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 0).toString());
            txtNome.setText(jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 1).toString());
            
            Estado est = (Estado) jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 2);
            est.setIdestado(Integer.parseInt(String.valueOf(est.getIdestado())));
            jComboBoxEstado.setSelectedIndex(est.getIdestado());
        }
    }//GEN-LAST:event_jTableCidadeMouseClicked

    private void jTableCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCidadeKeyReleased
        //Reinicia combobox cidade
            
            jComboBoxEstado.setSelectedIndex(0);

// As linhas abaixo selecionam um item da tabela para ser alterado e copiam o item para os campos.
        Cidade cidade = new Cidade();
        
        if (jTableCidade.getSelectedRow() != -1) {
            txtCodigo.setEnabled(true);
            txtNome.setEnabled(true);
            jComboBoxEstado.setEnabled(true);
            
            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnLimpar.setEnabled(false);
            
            txtCodigo.setText(jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 0).toString());
            txtNome.setText(jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 1).toString());
            
            Estado est = (Estado) jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 2);
            est.setIdestado(Integer.parseInt(String.valueOf(est.getIdestado())));
            jComboBoxEstado.setSelectedIndex(est.getIdestado());
        }
    }//GEN-LAST:event_jTableCidadeKeyReleased

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // As linhas abaixo exclui um objeto(registro) do banco de dados

        int excluir = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja EXCLUIR este registro?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (excluir == JOptionPane.YES_OPTION) {
            
            Cidade cid = new Cidade();
            CidadeDAO dao = new CidadeDAO();

            cid.setIdcidade((int) jTableCidade.getValueAt(jTableCidade.getSelectedRow(), 0));
            
            dao.deleteCidade(cid);

//Atualiza a tabela
            readTable();

//Reinicia combobox cidade
            comboboxEstado();

//Limpa campos
            txtCodigo.setText("");
            txtNome.setText("");
            jComboBoxEstado.setSelectedIndex(0);

//Reinicia campo de consulta            
            txtConsulta.setText("");
            txtConsulta.requestFocus();

//As linhas abaixo preparam botões e campos
            txtCodigo.setEnabled(false);
            txtNome.setEnabled(false);
            jComboBoxEstado.setEnabled(false);

//Atualiza botões
            btnLimpar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnAtualizar.setEnabled(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        // TODO add your handling code here:
        readTableForNameCidade(txtConsulta.getText());
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void txtConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnConsulta.requestFocus();
        }
    }//GEN-LAST:event_txtConsultaKeyPressed

    private void btnConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConsultaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            readTableForNameCidade(txtConsulta.getText());
        }
    }//GEN-LAST:event_btnConsultaKeyPressed

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
            java.util.logging.Logger.getLogger(FormCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
