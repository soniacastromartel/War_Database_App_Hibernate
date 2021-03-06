/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author grupo1
 */
public class viewCountries extends JDialog {

    /**
     * Creates new form viewCountrie
     * @param parent
     * @param modal
     */
    
    imagenPanel fondo = new imagenPanel();
     
     public viewCountries(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
    this.setContentPane(fondo);
        
        initComponents();
       setWindow();
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JCheckBox getCheckBoxIndependent() {
        return checkBoxIndependent;
    }

    public JTable getJtableCountries() {
        return jtableCountries;
    }

    public JLabel getLblCountryName() {
        return lblCountryId;
    }

    public JLabel getLblDateBegin() {
        return lblDateBegin;
    }

    public JLabel getLblDateEnd() {
        return lblDateEnd;
    }

    public JLabel getLblSearch() {
        return lblSearch;
    }

    public JYearChooser getTxtfDateBegin() {
	return txtfDateBegin;
    }

    public void setTxtfDateBegin(JYearChooser txtfDateBegin) {
	this.txtfDateBegin = txtfDateBegin;
    }

    public JYearChooser getTxtfDateEnd() {
	return txtfDateEnd;
    }

    public void setTxtfDateEnd(JYearChooser txtfDateEnd) {
	this.txtfDateEnd = txtfDateEnd;
    }

    public JTextField getTxtfCountryName() {
	return txtfCountryName;
    }

    public void setTxtfCountryName(JTextField txtfCountryName) {
	this.txtfCountryName = txtfCountryName;
    }

   

    public JTextField getTxtfSearch() {
        return txtfSearch;
    }

    public JTextField getTF_CountryId() {
	return TF_CountryId;
    }

    public void setTF_CountryId(JTextField TF_CountryId) {
	this.TF_CountryId = TF_CountryId;
    }
    

     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        lblSearch = new javax.swing.JLabel();
        txtfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableCountries = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblCountryId = new javax.swing.JLabel();
        txtfCountryName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        checkBoxIndependent = new javax.swing.JCheckBox();
        lblDateBegin = new javax.swing.JLabel();
        lblDateEnd = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCountryName1 = new javax.swing.JLabel();
        TF_CountryId = new javax.swing.JTextField();
        txtfDateBegin = new com.toedter.calendar.JYearChooser();
        txtfDateEnd = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(204, 204, 204));
        lblSearch.setText("Busqueda");

        jtableCountries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtableCountries);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCountryId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCountryId.setForeground(new java.awt.Color(204, 204, 204));
        lblCountryId.setText("Id. Pa??s:");
        jPanel2.add(lblCountryId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 32));
        jPanel2.add(txtfCountryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 293, 35));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 312, 11));

        checkBoxIndependent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkBoxIndependent.setForeground(new java.awt.Color(204, 204, 204));
        checkBoxIndependent.setText("Pa??s Independiente");
        checkBoxIndependent.setBorderPainted(true);
        checkBoxIndependent.setContentAreaFilled(false);
        checkBoxIndependent.setFocusable(false);
        jPanel2.add(checkBoxIndependent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        lblDateBegin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDateBegin.setForeground(new java.awt.Color(204, 204, 204));
        lblDateBegin.setText("A??o de Inicio:");
        jPanel2.add(lblDateBegin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 101, 32));

        lblDateEnd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDateEnd.setForeground(new java.awt.Color(204, 204, 204));
        lblDateEnd.setText("A??o de Fin:");
        jPanel2.add(lblDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 101, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 19, 12, 304));

        btnInsert.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInsert.setText("Insertar");
        jPanel2.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 40, 147, 53));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Eliminar");
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 113, 147, 50));

        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExit.setText("Salir");
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 113, 147, 54));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setText("Modificar");
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 38, 147, 57));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mundi.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 179, -1, 115));

        lblCountryName1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCountryName1.setForeground(new java.awt.Color(204, 204, 204));
        lblCountryName1.setText("Nombre Pa??s:");
        jPanel2.add(lblCountryName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 117, 32));
        jPanel2.add(TF_CountryId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 30));

        txtfDateBegin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtfDateBegin.setEndYear(2021);
        txtfDateBegin.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        txtfDateBegin.setMinimum(0);
        jPanel2.add(txtfDateBegin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 224, 100, 30));

        txtfDateEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtfDateEnd.setEndYear(2021);
        txtfDateEnd.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        txtfDateEnd.setMinimum(0);
        jPanel2.add(txtfDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 274, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_CountryId;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkBoxIndependent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JTable jtableCountries;
    private javax.swing.JLabel lblCountryId;
    private javax.swing.JLabel lblCountryName1;
    private javax.swing.JLabel lblDateBegin;
    private javax.swing.JLabel lblDateEnd;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextField txtfCountryName;
    private com.toedter.calendar.JYearChooser txtfDateBegin;
    private com.toedter.calendar.JYearChooser txtfDateEnd;
    private javax.swing.JTextField txtfSearch;
    // End of variables declaration//GEN-END:variables
 private void setWindow() {
        setTitle("PAISES");
        setLocationRelativeTo(this);
    }

}

