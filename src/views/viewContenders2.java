package views;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class viewContenders2 extends javax.swing.JDialog {

    /**
     * Creates new form viewContenders1
     */
    //     imagenPanel fondo = new imagenPanel();
    public viewContenders2(java.awt.Frame parent, boolean modal) {
	super(parent, modal);

	//        this.setContentPane(fondo);
	initComponents();
	setWindow();
    }

    public JCheckBox getCb_Ganador() {
	return Cb_Ganador;
    }

    public void setCb_Ganador(JCheckBox Cb_Ganador) {
	this.Cb_Ganador = Cb_Ganador;
    }

    public JCheckBox getCb_GanadorInsert() {
	return Cb_GanadorInsert;
    }

    public void setCb_GanadorInsert(JCheckBox Cb_GanadorInsert) {
	this.Cb_GanadorInsert = Cb_GanadorInsert;
    }

    public JComboBox<String> getComboBoxSelectWar() {
	return ComboBoxSelectWar;
    }

    public void setComboBoxSelectWar(JComboBox<String> ComboBoxSelectWar) {
	this.ComboBoxSelectWar = ComboBoxSelectWar;
    }

    public JButton getBtnDeleteSelectCountryADDED() {
	return btnDeleteSelectCountryADDED;
    }

    public void setBtnDeleteSelectCountryADDED(JButton btnDeleteSelectCountryADDED) {
	this.btnDeleteSelectCountryADDED = btnDeleteSelectCountryADDED;
    }

    public JButton getBtnDeleteSelectedContender() {
	return btnDeleteSelectedContender;
    }

    public void setBtnDeleteSelectedContender(JButton btnDeleteSelectedContender) {
	this.btnDeleteSelectedContender = btnDeleteSelectedContender;
    }

    public JButton getBtnExit() {
	return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
	this.btnExit = btnExit;
    }

    public JButton getBtnInsertCountryToContender() {
	return btnInsertCountryToContender;
    }

    public void setBtnInsertCountryToContender(JButton btnInsertCountryToContender) {
	this.btnInsertCountryToContender = btnInsertCountryToContender;
    }

    public JButton getBtnInsertNewContender() {
	return btnInsertNewContender;
    }

    public void setBtnInsertNewContender(JButton btnInsertNewContender) {
	this.btnInsertNewContender = btnInsertNewContender;
    }

    public JButton getBtnUpdateDate() {
	return btnUpdateDate;
    }

    public void setBtnUpdateDate(JButton btnUpdateDate) {
	this.btnUpdateDate = btnUpdateDate;
    }

    public JButton getBtnUpdateSelectedContender() {
	return btnUpdateSelectedContender;
    }

    public void setBtnUpdateSelectedContender(JButton btnUpdateSelectedContender) {
	this.btnUpdateSelectedContender = btnUpdateSelectedContender;
    }

    public JComboBox<String> getComboBoxSelectContender() {
	return comboBoxSelectContender;
    }

    public void setComboBoxSelectContender(JComboBox<String> comboBoxSelectContender) {
	this.comboBoxSelectContender = comboBoxSelectContender;
    }

    public JComboBox<String> getComboBoxSelectCountryADDED() {
	return comboBoxSelectCountryADDED;
    }

    public void setComboBoxSelectCountryADDED(JComboBox<String> comboBoxSelectCountryADDED) {
	this.comboBoxSelectCountryADDED = comboBoxSelectCountryADDED;
    }

    public JComboBox<String> getComboBoxSelectCountryToContender() {
	return comboBoxSelectCountryToContender;
    }

    public void setComboBoxSelectCountryToContender(JComboBox<String> comboBoxSelectCountryToContender) {
	this.comboBoxSelectCountryToContender = comboBoxSelectCountryToContender;
    }

    public JLabel getLblContenderName() {
	return lblContenderName;
    }

    public void setLblContenderName(JLabel lblContenderName) {
	this.lblContenderName = lblContenderName;
    }

    public JLabel getLblDateBeginCountryToContender() {
	return lblDateBeginCountryToContender;
    }

    public void setLblDateBeginCountryToContender(JLabel lblDateBeginCountryToContender) {
	this.lblDateBeginCountryToContender = lblDateBeginCountryToContender;
    }

    public JLabel getLblDateEndCountryToContender() {
	return lblDateEndCountryToContender;
    }

    public void setLblDateEndCountryToContender(JLabel lblDateEndCountryToContender) {
	this.lblDateEndCountryToContender = lblDateEndCountryToContender;
    }

    public JLabel getLblInsertNewContender() {
	return lblInsertNewContender;
    }

    public void setLblInsertNewContender(JLabel lblInsertNewContender) {
	this.lblInsertNewContender = lblInsertNewContender;
    }

    public JLabel getLblInsertNewCountry() {
	return lblInsertNewCountry;
    }

    public void setLblInsertNewCountry(JLabel lblInsertNewCountry) {
	this.lblInsertNewCountry = lblInsertNewCountry;
    }

    public JLabel getLblUpdateContenderName() {
	return lblUpdateContenderName;
    }

    public void setLblUpdateContenderName(JLabel lblUpdateContenderName) {
	this.lblUpdateContenderName = lblUpdateContenderName;
    }

    public JLabel getLblUpdateDateBegin() {
	return lblUpdateDateBegin;
    }

    public void setLblUpdateDateBegin(JLabel lblUpdateDateBegin) {
	this.lblUpdateDateBegin = lblUpdateDateBegin;
    }

    public JLabel getLblUpdateDateEnd() {
	return lblUpdateDateEnd;
    }

    public void setLblUpdateDateEnd(JLabel lblUpdateDateEnd) {
	this.lblUpdateDateEnd = lblUpdateDateEnd;
    }

    public JLabel getLblUpdateSelectedContender() {
	return lblUpdateSelectedContender;
    }

    public void setLblUpdateSelectedContender(JLabel lblUpdateSelectedContender) {
	this.lblUpdateSelectedContender = lblUpdateSelectedContender;
    }

    public JLabel getLblUpdateSelectedCountry() {
	return lblUpdateSelectedCountry;
    }

    public void setLblUpdateSelectedCountry(JLabel lblUpdateSelectedCountry) {
	this.lblUpdateSelectedCountry = lblUpdateSelectedCountry;
    }

    public JTextField getTxtfInsertNewContender() {
	return txtfInsertNewContender;
    }

    public void setTxtfInsertNewContender(JTextField txtfInsertNewContender) {
	this.txtfInsertNewContender = txtfInsertNewContender;
    }

    public JTextField getTxtfUpdateSelectedContender() {
	return txtfUpdateSelectedContender;
    }

    public void setTxtfUpdateSelectedContender(JTextField txtfUpdateSelectedContender) {
	this.txtfUpdateSelectedContender = txtfUpdateSelectedContender;
    }

    public JDateChooser getjDC_BeginDate() {
	return jDC_BeginDate;
    }

    public void setjDC_BeginDate(JDateChooser jDC_BeginDate) {
	this.jDC_BeginDate = jDC_BeginDate;
    }

    public JDateChooser getjDC_EndDate() {
	return jDC_EndDate;
    }

    public void setjDC_EndDate(JDateChooser jDC_EndDate) {
	this.jDC_EndDate = jDC_EndDate;
    }

    public JDateChooser getjDC_updateBeginDate() {
	return jDC_updateBeginDate;
    }

    public void setjDC_updateBeginDate(JDateChooser jDC_updateBeginDate) {
	this.jDC_updateBeginDate = jDC_updateBeginDate;
    }

    public JDateChooser getjDC_updateEndDate() {
	return jDC_updateEndDate;
    }

    public void setjDC_updateEndDate(JDateChooser jDC_updateEndDate) {
	this.jDC_updateEndDate = jDC_updateEndDate;
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
        jPanel2 = new javax.swing.JPanel();
        ComboBoxSelectWar = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUpdateSelectedContender = new javax.swing.JLabel();
        lblUpdateContenderName = new javax.swing.JLabel();
        txtfInsertNewContender = new javax.swing.JTextField();
        Cb_GanadorInsert = new javax.swing.JCheckBox();
        lblInsertNewContender = new javax.swing.JLabel();
        lblContenderName = new javax.swing.JLabel();
        comboBoxSelectContender = new javax.swing.JComboBox<>();
        txtfUpdateSelectedContender = new javax.swing.JTextField();
        Cb_Ganador = new javax.swing.JCheckBox();
        btnDeleteSelectedContender = new javax.swing.JButton();
        btnInsertNewContender = new javax.swing.JButton();
        btnUpdateSelectedContender = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        lblInsertNewCountry = new javax.swing.JLabel();
        comboBoxSelectCountryToContender = new javax.swing.JComboBox<>();
        btnInsertCountryToContender = new javax.swing.JButton();
        lblUpdateDateBegin = new javax.swing.JLabel();
        lblUpdateDateEnd = new javax.swing.JLabel();
        lblUpdateSelectedCountry = new javax.swing.JLabel();
        comboBoxSelectCountryADDED = new javax.swing.JComboBox<>();
        lblDateBeginCountryToContender = new javax.swing.JLabel();
        lblDateEndCountryToContender = new javax.swing.JLabel();
        btnUpdateDate = new javax.swing.JButton();
        btnDeleteSelectCountryADDED = new javax.swing.JButton();
        jDC_BeginDate = new com.toedter.calendar.JDateChooser();
        jDC_EndDate = new com.toedter.calendar.JDateChooser();
        jDC_updateBeginDate = new com.toedter.calendar.JDateChooser();
        jDC_updateEndDate = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GUERRAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        ComboBoxSelectWar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        ComboBoxSelectWar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerra1", "Guerra2", "Guerra3", " " }));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTENDIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        lblUpdateSelectedContender.setBackground(new java.awt.Color(204, 204, 204));
        lblUpdateSelectedContender.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblUpdateSelectedContender.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateSelectedContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateSelectedContender.setText("MODIFICAR");
        lblUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUpdateSelectedContender.setOpaque(true);

        lblUpdateContenderName.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblUpdateContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateContenderName.setText("Nombre");

        Cb_GanadorInsert.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        Cb_GanadorInsert.setText("Ganador");

        lblInsertNewContender.setBackground(new java.awt.Color(204, 204, 204));
        lblInsertNewContender.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblInsertNewContender.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertNewContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertNewContender.setText("AGREGAR");
        lblInsertNewContender.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblInsertNewContender.setOpaque(true);

        lblContenderName.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContenderName.setText("Nombre");

        comboBoxSelectContender.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        comboBoxSelectContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un contendiente...", "Item 2", "Item 3", "Item 4" }));

        Cb_Ganador.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        Cb_Ganador.setText("Ganador");

        btnDeleteSelectedContender.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnDeleteSelectedContender.setText("ELIMINAR");
        btnDeleteSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteSelectedContender.setMaximumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setMinimumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setPreferredSize(new java.awt.Dimension(61, 20));

        btnInsertNewContender.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnInsertNewContender.setText("INSERTAR");
        btnInsertNewContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnUpdateSelectedContender.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUpdateSelectedContender.setText("MODIFICAR");
        btnUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator3.setForeground(new java.awt.Color(0, 51, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtfInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Cb_GanadorInsert)
                            .addComponent(btnInsertNewContender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblUpdateContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Cb_Ganador)
                        .addGap(353, 353, 353)
                        .addComponent(btnDeleteSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSelectContender, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(271, 271, 271)))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblUpdateSelectedContender)
                .addGap(18, 18, 18)
                .addComponent(comboBoxSelectContender, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUpdateContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(Cb_Ganador))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblInsertNewContender)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(Cb_GanadorInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAÍSES ALIADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        lblInsertNewCountry.setBackground(new java.awt.Color(204, 204, 204));
        lblInsertNewCountry.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblInsertNewCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertNewCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertNewCountry.setText("AGREGAR");
        lblInsertNewCountry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblInsertNewCountry.setOpaque(true);

        comboBoxSelectCountryToContender.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        comboBoxSelectCountryToContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país...", "Item 2", "Item 3", "Item 4" }));

        btnInsertCountryToContender.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnInsertCountryToContender.setText("INSERTAR");
        btnInsertCountryToContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUpdateDateBegin.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblUpdateDateBegin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateDateBegin.setText("Fecha Unión");

        lblUpdateDateEnd.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblUpdateDateEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateDateEnd.setText("Fecha Abandono");

        lblUpdateSelectedCountry.setBackground(new java.awt.Color(204, 204, 204));
        lblUpdateSelectedCountry.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblUpdateSelectedCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateSelectedCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateSelectedCountry.setText("MODIFICAR");
        lblUpdateSelectedCountry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUpdateSelectedCountry.setOpaque(true);

        comboBoxSelectCountryADDED.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        comboBoxSelectCountryADDED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país aliado...", "Item 2", "Item 3", "Item 4" }));

        lblDateBeginCountryToContender.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblDateBeginCountryToContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateBeginCountryToContender.setText("Fecha Unión");

        lblDateEndCountryToContender.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblDateEndCountryToContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateEndCountryToContender.setText("Fecha Abandono");

        btnUpdateDate.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUpdateDate.setText("MODIFICAR");
        btnUpdateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDeleteSelectCountryADDED.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnDeleteSelectCountryADDED.setText("ELIMINAR");
        btnDeleteSelectCountryADDED.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator4.setForeground(new java.awt.Color(0, 51, 204));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInsertNewCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSelectCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(lblDateEndCountryToContender)
                                    .addGap(18, 18, 18)
                                    .addComponent(jDC_EndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(lblDateBeginCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jDC_BeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnInsertCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblUpdateDateEnd)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDC_updateBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDC_updateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboBoxSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUpdateSelectedCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUpdateDateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblInsertNewCountry)
                        .addGap(28, 28, 28)
                        .addComponent(comboBoxSelectCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblUpdateSelectedCountry)
                        .addGap(31, 31, 31)
                        .addComponent(comboBoxSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblUpdateDateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jDC_updateBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUpdateDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDC_updateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDC_BeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateBeginCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDateEndCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDC_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btnInsertCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Cb_Ganador;
    private javax.swing.JCheckBox Cb_GanadorInsert;
    private javax.swing.JComboBox<String> ComboBoxSelectWar;
    private javax.swing.JButton btnDeleteSelectCountryADDED;
    private javax.swing.JButton btnDeleteSelectedContender;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsertCountryToContender;
    private javax.swing.JButton btnInsertNewContender;
    private javax.swing.JButton btnUpdateDate;
    private javax.swing.JButton btnUpdateSelectedContender;
    private javax.swing.JComboBox<String> comboBoxSelectContender;
    private javax.swing.JComboBox<String> comboBoxSelectCountryADDED;
    private javax.swing.JComboBox<String> comboBoxSelectCountryToContender;
    private com.toedter.calendar.JDateChooser jDC_BeginDate;
    private com.toedter.calendar.JDateChooser jDC_EndDate;
    private com.toedter.calendar.JDateChooser jDC_updateBeginDate;
    private com.toedter.calendar.JDateChooser jDC_updateEndDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblContenderName;
    private javax.swing.JLabel lblDateBeginCountryToContender;
    private javax.swing.JLabel lblDateEndCountryToContender;
    private javax.swing.JLabel lblInsertNewContender;
    private javax.swing.JLabel lblInsertNewCountry;
    private javax.swing.JLabel lblUpdateContenderName;
    private javax.swing.JLabel lblUpdateDateBegin;
    private javax.swing.JLabel lblUpdateDateEnd;
    private javax.swing.JLabel lblUpdateSelectedContender;
    private javax.swing.JLabel lblUpdateSelectedCountry;
    private javax.swing.JTextField txtfInsertNewContender;
    private javax.swing.JTextField txtfUpdateSelectedContender;
    // End of variables declaration//GEN-END:variables
private void setWindow() {
	setTitle("CONTENDIENTES");
	setLocationRelativeTo(this);
    }

}
