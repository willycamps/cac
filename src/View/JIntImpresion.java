/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP PAVILION
 */
public class JIntImpresion extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIntImpresion
     */
    GestionController GC = new GestionController();
    ImpresionController IC = new ImpresionController();
           
    private void AmountEnter(java.awt.event.MouseEvent evt)
    {
        int row = JTableBuscar.rowAtPoint(evt.getPoint());
        int col = JTableBuscar.columnAtPoint(evt.getPoint());
        Integer _idtype=-1;
        Double _price;
        Double _result;
        String _name;
        
        try
        {
            if (row >= 0 && col >= 0) 
            {
                _idtype = (Integer) JTableBuscar.getValueAt(row, 0);       
                _name = JTableBuscar.getValueAt(row, 1).toString();
                _price= Double.parseDouble(JTableBuscar.getValueAt(row, 2).toString());                                                               
                String _cantidad = JOptionPane.showInputDialog( "CANTIDAD DE IMPRESIONES:");
                
                if (_cantidad !=null)
                {
                    int _amount = Integer.parseInt(_cantidad.trim());
                    if (_amount > 0)
                    {   
                        _result = IC.create(_idtype, _amount, _price, true, "");
                        if (_result > 0)
                        {                               
                            JLabel label = new JLabel("Cantidad: "+_amount+"   "+ _name+"\r\n  "+" Q. "+ _result);                            
                            label.setFont(new Font("Arial", Font.BOLD, 24));                            
                            JOptionPane.showMessageDialog(null, label , "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
                        }                        
                    } 
                    else if(_amount ==0)
                    {
                        JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a CERO", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }                                
            }                
        }
       catch (NumberFormatException nfe) 
        {            
             JOptionPane.showMessageDialog(null, nfe.getMessage(), "Error - View",
                                   JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public JIntImpresion() 
    {
        initComponents();
        JTableBuscar.setRowSorter(null);
        
        //Hide the _idtype
        JTableBuscar.getColumnModel().getColumn(0).setMinWidth(0);
        JTableBuscar.getColumnModel().getColumn(0).setMaxWidth(0);
        
        //Hide the _idtype
        JTableBuscar.getColumnModel().getColumn(3).setMinWidth(0);
        JTableBuscar.getColumnModel().getColumn(3).setMaxWidth(0);
        
       // JTableBuscar.setRowSorter(sorter);
        
        jTxtBuscar.getDocument().addDocumentListener(new DocumentListener() 
        {

            @Override
            public void insertUpdate(DocumentEvent e) 
            {
              // put your filter code here upon data insertion
                //JTableBuscar.setRowFilter();
                //JTableBuscar.setRowSorter(null);
                //JTableBuscar.setRowFilter(RowFilter.regexFilter("(?i)",0));
                //sorter.setRowFilter(RowFilter.regexFilter("(?i)", 0));
                //JOptionPane.showMessageDialog(null, jTxtBuscar.getText(), "Insert",
                  //      JOptionPane.INFORMATION_MESSAGE);
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) 
            { 
                  //put your filter code here upon data removal
                //JOptionPane.showMessageDialog(null, jTxtBuscar.getText(), "Remove",
                  //      JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                //JOptionPane.showMessageDialog(null, jTxtBuscar.getText(), "Changed",
                  //      JOptionPane.INFORMATION_MESSAGE);
            }

          });     
        
         JTableBuscar.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
               AmountEnter(evt);
            }
        });    
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBuscar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Busqueda Impresiones");
        setToolTipText("");

        jTxtBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        JTableBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JTableBuscar.setModel(GC.read());
        JTableBuscar.setColumnSelectionAllowed(true);
        JTableBuscar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTableBuscar.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableBuscar);
        JTableBuscar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/search20.jpe"))); // NOI18N
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtBuscar;
    // End of variables declaration//GEN-END:variables
}
