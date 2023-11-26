/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package main.java.gui;

import Recetario.Controladora;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */

public class VentanaAgregarReceta extends javax.swing.JDialog {
    private String nombreReceta;
    private boolean ver = false;
    /**
     * Creates new form VentanaAgregarReceta
     */
    public VentanaAgregarReceta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        agregarEtiqueta.setEnabled(false);
        eliminarEtiqueta.setEnabled(false);
        agregarIngrediente.setEnabled(false);
        eliminarIngrediente.setEnabled(false);
        guardar.setEnabled(false);
        procedimiento.setEnabled(false);
        porciones.setEnabled(false);
        duracion.setEnabled(false);
        dificultad.setEnabled(false);
    }
    public VentanaAgregarReceta(java.awt.Frame parent, boolean modal, String nombreReceta, boolean ver) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        cargarDatos();
        this.nombreReceta = nombreReceta;
        nombre.setText(nombreReceta);
        this.ver = true;
        if (ver) {
            agregarEtiqueta.setEnabled(false);
            eliminarEtiqueta.setEnabled(false);
            agregarIngrediente.setEnabled(false);
            eliminarIngrediente.setEnabled(false);
            guardar.setEnabled(false);
            procedimiento.setEditable(false);
            porciones.setEditable(false);
            duracion.setEditable(false);
            dificultad.setEnabled(false); 
            nombre.setEditable(false);
            guardarNombre.setEnabled(false);
            agregarUtensilio.setEnabled(false);
            eliminarUtensilio.setEnabled(false);
        }
    }
    
    
    
    public void cargarDatos() {
        Controladora control = Controladora.getInstance();
        DefaultTableModel model = (DefaultTableModel)ingredientes.getModel();
        model.setRowCount(0);
        if (nombreReceta != null) {
            try {
                Map<String, String> ordenada = new TreeMap<>(control.verListaIngredientesReceta(nombreReceta));
                for (Map.Entry<String, String> entry : ordenada.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    model.addRow(new Object[]{key, value});
                    } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());  
            }
            try {
                ArrayList<String> ordenada = new ArrayList(control.verListaUtensiliosReceta(nombreReceta));
                Collections.sort(ordenada);
                DefaultListModel<String> listModel = new DefaultListModel();
                for (String s : ordenada) {
                    listModel.addElement(s);
                }
                utensilios.setModel(listModel);
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e.getMessage());   
            }
            try {
                ArrayList<String> ordenada = new ArrayList(control.verListaEtiquetasReceta(nombreReceta));
                Collections.sort(ordenada);
                DefaultListModel<String> listModel = new DefaultListModel();
                for (String s : ordenada) {
                    listModel.addElement(s);
                }
                etiquetas.setModel(listModel);
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e.getMessage());   
            }
            try {
                String procedimiento = control.getProcedimiento(nombreReceta);
                if(procedimiento != null) {
                    this.procedimiento.setText(procedimiento);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            try {
                String dificultad = control.getDificultad(nombreReceta);
                this.dificultad.setSelectedItem(dificultad);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            try {
                float porciones = control.getPorciones(nombreReceta);
                if(porciones>0) {
                    this.porciones.setText(Float.toString(porciones));
                }
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e.getMessage()); 
            }
            
            try {
                float duracion = control.getDuracion(nombreReceta);
                if(duracion>0) {
                    this.duracion.setText(Float.toString(duracion));
                }
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e.getMessage()); 
            }
            
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
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        etiquetas = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        procedimiento = new javax.swing.JTextArea();
        agregarIngrediente = new javax.swing.JButton();
        eliminarIngrediente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        agregarEtiqueta = new javax.swing.JButton();
        eliminarEtiqueta = new javax.swing.JButton();
        duracion = new javax.swing.JTextField();
        porciones = new javax.swing.JTextField();
        dificultad = new javax.swing.JComboBox<>();
        guardarNombre = new javax.swing.JButton();
        agregarUtensilio = new javax.swing.JButton();
        eliminarUtensilio = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        utensilios = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        guardar.setText("guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        ingredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ingredientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ingredientes);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Ingredientes");

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Receta");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Utensilios");

        jScrollPane3.setViewportView(etiquetas);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Etiquetas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Procedimiento");

        procedimiento.setColumns(20);
        procedimiento.setRows(5);
        jScrollPane4.setViewportView(procedimiento);

        agregarIngrediente.setText("+");
        agregarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarIngredienteActionPerformed(evt);
            }
        });

        eliminarIngrediente.setText("-");
        eliminarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarIngredienteActionPerformed(evt);
            }
        });

        jLabel6.setText("duracion:");

        jLabel7.setText("porciones:");

        jLabel8.setText("Dificultad:");

        agregarEtiqueta.setText("+");
        agregarEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEtiquetaActionPerformed(evt);
            }
        });

        eliminarEtiqueta.setText("-");
        eliminarEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEtiquetaActionPerformed(evt);
            }
        });

        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });

        dificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Medio", "Dificil", "Experto" }));

        guardarNombre.setText("guardar");
        guardarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNombreActionPerformed(evt);
            }
        });

        agregarUtensilio.setText("+");
        agregarUtensilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarUtensilioActionPerformed(evt);
            }
        });

        eliminarUtensilio.setText("-");
        eliminarUtensilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUtensilioActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(utensilios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(agregarIngrediente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eliminarIngrediente))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardarNombre))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(nombre)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(porciones, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(agregarUtensilio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarUtensilio))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(volver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(agregarEtiqueta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eliminarEtiqueta)))
                                .addGap(35, 35, 35))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(agregarIngrediente)
                                    .addComponent(eliminarIngrediente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(guardarNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarUtensilio)
                            .addComponent(eliminarUtensilio))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(dificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(porciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarEtiqueta)
                            .addComponent(eliminarEtiqueta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardar)
                            .addComponent(volver))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Controladora c = Controladora.getInstance();
        try {
            if(!procedimiento.getText().isBlank() && !c.verListaIngredientesReceta(nombreReceta).isEmpty()) {
                try {
                    c.setProcedimiento(procedimiento.getText(), nombreReceta);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                if(!duracion.getText().isBlank()) {
                    try {
                        float duracion = Float.parseFloat(this.duracion.getText());
                        if(duracion>0)
                            c.setDuracion(duracion, nombreReceta);
                        else
                            c.setDuracion(0,nombreReceta);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Duracion debe ser un numero positivo");
                        return;
                    }
                } else {
                    try {
                        c.setDuracion(0,nombreReceta);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                if(!porciones.getText().isBlank()) { 
                    try {
                        float porcion = Float.parseFloat(porciones.getText());
                        if(porcion>0)
                            c.setPorciones(porcion, nombreReceta);
                        else
                            c.setPorciones(0,nombreReceta);
                    } catch(Exception e) {
                        JOptionPane.showMessageDialog(this, "Porciones debe ser un numero positivo");
                        return;
                    }
                } else {
                    try {
                        c.setPorciones(0,nombreReceta);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                try {
                    c.setDificultad((String)dificultad.getSelectedItem(),nombreReceta);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    return;
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrediente y procedimiento no pueden estar vacios");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Controladora c = Controladora.getInstance();
        if (nombreReceta != null && ver == false) {
            try {
                c.eliminarReceta(nombreReceta);
                dispose();
                VentanaRecetas v = new VentanaRecetas(null, true);
                v.setVisible(true);   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            dispose();
            VentanaRecetas v = new VentanaRecetas(null, true);
            v.setVisible(true);
        }    
    }//GEN-LAST:event_volverActionPerformed

    private void agregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarIngredienteActionPerformed
        VentanaSeleccionarIngrediente v = new VentanaSeleccionarIngrediente(null,true,nombreReceta);
        v.setVisible(true);
    }//GEN-LAST:event_agregarIngredienteActionPerformed

    private void eliminarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarIngredienteActionPerformed
       int selectedRow = ingredientes.getSelectedRow();
        if (selectedRow >= 0) {
            String nombre = (String) ingredientes.getValueAt(ingredientes.getSelectedRow(), 0);
                int confirmar = JOptionPane.showConfirmDialog(this,"Esta seguro que desea eliminar " + nombre + "?",
                        "Confirmación",JOptionPane.YES_NO_OPTION);
                if(confirmar == JOptionPane.YES_OPTION) {
                    try {
                        Controladora c = Controladora.getInstance();
                        c.eliminarIngredienteReceta(nombre,nombreReceta);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un ingrediente para eliminar.");
        }  
    }//GEN-LAST:event_eliminarIngredienteActionPerformed

    private void agregarEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEtiquetaActionPerformed
        VentanaSeleccionarEtiqueta v = new VentanaSeleccionarEtiqueta(null,true,nombreReceta);
        v.setVisible(true);
    }//GEN-LAST:event_agregarEtiquetaActionPerformed

    private void eliminarEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEtiquetaActionPerformed
        Controladora c = Controladora.getInstance();
        if (!etiquetas.isSelectionEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(
            this,
            "Seguro que desea eliminar " + etiquetas.getSelectedValue() + "?",
            " ",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
            try {
                c.eliminarEtiquetaReceta(etiquetas.getSelectedValue(), nombreReceta);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            }
        } else {
            JOptionPane.showMessageDialog(this, "seleccione una etiqueta para eliminar");
        }
    }//GEN-LAST:event_eliminarEtiquetaActionPerformed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void guardarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNombreActionPerformed
        Controladora c = Controladora.getInstance();
        if (nombreReceta == null) {
            try {
                c.agregarReceta(nombre.getText());
                agregarEtiqueta.setEnabled(true);
                eliminarEtiqueta.setEnabled(true);
                agregarIngrediente.setEnabled(true);
                eliminarIngrediente.setEnabled(true);
                guardar.setEnabled(true);
                procedimiento.setEnabled(true);
                porciones.setEnabled(true);
                duracion.setEnabled(true);
                dificultad.setEnabled(true);
                nombre.setEnabled(false);
                guardarNombre.setEnabled(false);
                nombreReceta = nombre.getText();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            try {
               c.editarNombreReceta(nombre.getText(),nombreReceta);
               nombreReceta = nombre.getText();
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e.getMessage()); 
            }
        }
    }//GEN-LAST:event_guardarNombreActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        cargarDatos();
    }//GEN-LAST:event_formWindowGainedFocus

    private void agregarUtensilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarUtensilioActionPerformed
        VentanaSeleccionarUtensilio v = new VentanaSeleccionarUtensilio(null,true,nombreReceta);
        v.setVisible(true);
    }//GEN-LAST:event_agregarUtensilioActionPerformed

    private void eliminarUtensilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUtensilioActionPerformed
        Controladora c = Controladora.getInstance();
        if (!utensilios.isSelectionEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(
            this, 
            "Seguro que desea eliminar " + utensilios.getSelectedValue() + "?",
            " ",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
            try {
                c.eliminarUtensilioReceta(utensilios.getSelectedValue(), nombreReceta);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            }
        } else {
            JOptionPane.showMessageDialog(this, "seleccione un utensilio para eliminar");
        }
    }//GEN-LAST:event_eliminarUtensilioActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(VentanaAgregarReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaAgregarReceta dialog = new VentanaAgregarReceta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarEtiqueta;
    private javax.swing.JButton agregarIngrediente;
    private javax.swing.JButton agregarUtensilio;
    private javax.swing.JComboBox<String> dificultad;
    private javax.swing.JTextField duracion;
    private javax.swing.JButton eliminarEtiqueta;
    private javax.swing.JButton eliminarIngrediente;
    private javax.swing.JButton eliminarUtensilio;
    private javax.swing.JList<String> etiquetas;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarNombre;
    private javax.swing.JTable ingredientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField porciones;
    private javax.swing.JTextArea procedimiento;
    private javax.swing.JList<String> utensilios;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
