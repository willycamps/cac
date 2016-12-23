/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.*;
import javax.swing.*;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

/**
 *
 * @author W. Estuardo
 */

public class JIntGestion extends javax.swing.JInternalFrame 
{

    /**
     * Creates new form CACGestion
     */
    private double amount;
    private boolean _valid;
    private NumberFormat amountFormat;
    private JFormattedTextField amountField;
    private Integer _idtype;
    
    GestionController GC = new GestionController();
        
    public JIntGestion() 
    {
        initComponents();
        this.requestFocus();
        jTxtTipo.setToolTipText("Tipos de Papel");
        jTxtImpresion.setToolTipText("Tipos de Impresion");
        jTxtPrecio.setToolTipText("Agregar precio al servicio");
                
        setUpFormats();
        
         //Create the text fields and set them up.
        amountField = new JFormattedTextField(amountFormat);
        amountField.setValue(new Double(amount));
        amountField.setColumns(10);       
        
        // It creates and displays the table
        tlbType = new JTable(GC.read());   
        jScrollPane2.setViewportView(tlbType);        
        jScrollPane2.getViewport().add(tlbType, null);        
                
        tlbType.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                int row = tlbType.rowAtPoint(evt.getPoint());
                int col = tlbType.columnAtPoint(evt.getPoint());
                cleanFields();
                try{
                    if (row >= 0 && col >= 0) 
                    {
                        _idtype = (Integer) tlbType.getValueAt(row, 0);                    
                        String T =tlbType.getValueAt(row, 1).toString();                    
                        String[] tokens = T.split(" ");
                        jTxtTipo.setText(tokens[0]);
                        
                        jTxtImpresion.setText(tokens[1]);

                        jTxtPrecio.setText(tlbType.getValueAt(row, 2).toString());
                                                

                        if (tlbType.getValueAt(row, 3).toString().isEmpty())
                        {
                            jTextArea1.setText("");                                
                        }else{
                            jTextArea1.setText(tlbType.getValueAt(row, 3).toString());
                        }                                        
                    }                
                }
                catch(Exception e)
                {
                     
                
                }
            }
        });               
    }

    /**
     *
     */
   
    public void validate_()
    {
        try
        {
            String texto=jTxtTipo.getText();
            //How to remove leading and trailing whitespace from the string 
            String txtTipo = texto.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
           
            amountField = new JFormattedTextField(amountFormat);
            amountField.setValue(new Double(jTxtPrecio.getText()));
            amountField.setColumns(10);
            amount = ((Number)amountField.getValue()).doubleValue();                
        }
        catch(Exception e)
        {
            
        }
    }
    
     private void setUpFormats() 
     {
        amountFormat = NumberFormat.getNumberInstance();        
        amountFormat.setMinimumIntegerDigits(1);
        amountFormat.setMaximumIntegerDigits(3);
        amountFormat.setMaximumFractionDigits(0);
        
    }   
     
    private void valid()
    {        
        try
        {   
            _valid=true;                
        
            if("".equals(jTxtTipo.getText()))
            {
                JOptionPane.showMessageDialog(null, " 'Tipo' no debe estar en blanco", "Error",
                                    JOptionPane.ERROR_MESSAGE);     
                _valid=false;
                                
            }else if("".equals(jTxtImpresion.getText()))
            {
                JOptionPane.showMessageDialog(null, " 'Impresion' no debe estar en blanco", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                _valid=false;
            }else if("".equals(jTxtPrecio.getText()))
            {
                JOptionPane.showMessageDialog(null, " 'Precio' no debe estar en blanco", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                _valid=false;
            }
            amount = Double.parseDouble(jTxtPrecio.getText());
        }
        
        catch (NumberFormatException e) 
        {
            JOptionPane.showConfirmDialog(null, "Por favor ingresar solo numeros en la casilla de 'Precio'", "Error", JOptionPane.CANCEL_OPTION);
            _valid=false;
        }
        
    }
    
    private void refreshTable()
    {
        tlbType.setModel(GC.read());
        tlbType.setColumnSelectionAllowed(true);
        tlbType.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tlbType);     
        tlbType.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
    }
    private void cleanFields()
    {
        jTxtTipo.setText("");
        jTxtImpresion.setText("");
        jTxtPrecio.setText("");
        jTextArea1.setText("");        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        BtnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTxtTipo = new javax.swing.JTextField();
        jTxtImpresion = new javax.swing.JTextField();
        jTxtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbType = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Gestion CAC");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(190, 134));
        setPreferredSize(new java.awt.Dimension(768, 548));
        setVerifyInputWhenFocusTarget(false);

        label1.setName(""); // NOI18N
        label1.setText("Tipo");

        label2.setName(""); // NOI18N
        label2.setText("Impresion");

        label3.setName(""); // NOI18N
        label3.setText("Precio");

        label4.setName(""); // NOI18N
        label4.setText("Comentario");

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar");

        jTxtPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        tlbType.setModel(GC.read());
        tlbType.setColumnSelectionAllowed(true);
        tlbType.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tlbType.getTableHeader().setReorderingAllowed(false);
        tlbType.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(tlbType);
        tlbType.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAgregar)
                        .addGap(61, 61, 61)
                        .addComponent(jButton2)
                        .addGap(57, 57, 57)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:        
        valid();
        if (_valid)
        {
            if (GC.create(jTxtTipo.getText(), jTxtImpresion.getText(), amount, jTextArea1.getText()))
                        JOptionPane.showMessageDialog(null, "Datos ingresados exitosamente", "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
            cleanFields();
            refreshTable();
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:              
        valid();
        if(_valid)
        {
            if(GC.update(_idtype,jTxtTipo.getText(), jTxtImpresion.getText(), amount, jTextArea1.getText()))
            {
                JOptionPane.showMessageDialog(null, "Datos modificados exitosamente", "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
                cleanFields();
                refreshTable();
            }
        
        }                
    }//GEN-LAST:event_jButton2ActionPerformed
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTxtImpresion;
    private javax.swing.JTextField jTxtPrecio;
    private javax.swing.JTextField jTxtTipo;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    public javax.swing.JTable tlbType;
    // End of variables declaration//GEN-END:variables
}
