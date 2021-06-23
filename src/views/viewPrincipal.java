/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;

/**
 *
 * @author grupo1
 */
public class viewPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form viewPrincipal
     */
    imagenPanel fondo = new imagenPanel();
    
    public viewPrincipal() {
        this.setContentPane(fondo);
        
        initComponents();
        setWindow();
    }

   

    public JButton getBtnContender() {
        return btnContender;
    }

    public JButton getBtnCountry() {
        return btnCountry;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnWars() {
        return btnWars;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnContender = new javax.swing.JButton();
        btnWars = new javax.swing.JButton();
        btnCountry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setDefaultCapable(false);
        btnExit.setFocusPainted(false);
        btnExit.setFocusable(false);
        btnExit.setRequestFocusEnabled(false);

        btnContender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnContender.setForeground(new java.awt.Color(51, 51, 51));
        btnContender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contendientes.png"))); // NOI18N
        btnContender.setText("Contendientes");
        btnContender.setBorderPainted(false);
        btnContender.setIconTextGap(16);
        btnContender.setPreferredSize(new java.awt.Dimension(219, 77));

        btnWars.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnWars.setForeground(new java.awt.Color(51, 51, 51));
        btnWars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GuerrasA.png"))); // NOI18N
        btnWars.setText("Guerras");
        btnWars.setBorderPainted(false);
        btnWars.setFocusable(false);
        btnWars.setIconTextGap(16);
        btnWars.setPreferredSize(new java.awt.Dimension(219, 77));

        btnCountry.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCountry.setForeground(new java.awt.Color(51, 51, 51));
        btnCountry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Paises.png"))); // NOI18N
        btnCountry.setText("Paises");
        btnCountry.setBorderPainted(false);
        btnCountry.setIconTextGap(16);
        btnCountry.setPreferredSize(new java.awt.Dimension(219, 77));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnWars, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnContender, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWars, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContender, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContender;
    private javax.swing.JButton btnCountry;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnWars;
    // End of variables declaration//GEN-END:variables
 private void setWindow() {
        setTitle("GUERRAS DEL MUNDO");
        setLocationRelativeTo(this);
    }

}
