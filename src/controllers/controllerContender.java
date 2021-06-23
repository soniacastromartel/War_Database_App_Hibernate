/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.Dao.BandosDAO;
import Models.Dao.ContenderDAO;
import Models.Pojo.Contendiente;
import Models.Pojo.UnionBandos;
import Table_ComboBoxModels.Contender_ComboBox_Models;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;
import views.viewContenders2;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
class controllerContender implements ActionListener {

    viewContenders2 viewContender;
    Contender_ComboBox_Models models;
    ContenderDAO contenderDAO;
    Contendiente contendiente;
    UnionBandos unionBandos;
    BandosDAO bandosDAO;
    //AGREGAR MODELs *** 

    //Constructores
    public controllerContender() {

    }

    public controllerContender(viewPrincipal viewPpal) throws ClassNotFoundException, SQLException {

	//AGREGAR MODELs ***
	viewContender = new viewContenders2(viewPpal, true);
	models = new Contender_ComboBox_Models();
	contenderDAO = new ContenderDAO();
	bandosDAO = new BandosDAO();
	initComponents();
	initEvents();

	viewContender.setVisible(true);
    }//Fin del constructor

    private void initComponents() {
	viewContender.getComboBoxSelectContender().setEnabled(false);
	viewContender.getBtnDeleteSelectedContender().setEnabled(false);

	viewContender.getLblInsertNewContender().setEnabled(false);
	viewContender.getLblContenderName().setEnabled(false);
	viewContender.getTxtfInsertNewContender().setEnabled(false);
	viewContender.getBtnInsertNewContender().setEnabled(false);

	viewContender.getLblUpdateSelectedContender().setEnabled(false);
	viewContender.getLblUpdateContenderName().setEnabled(false);
	viewContender.getTxtfUpdateSelectedContender().setEnabled(false);
	viewContender.getBtnUpdateSelectedContender().setEnabled(false);

	viewContender.getComboBoxSelectCountryADDED().setEnabled(false);
	viewContender.getBtnDeleteSelectCountryADDED().setEnabled(false);

	viewContender.getLblInsertNewCountry().setEnabled(false);
	viewContender.getLblUpdateDateBegin().setEnabled(false);
	viewContender.getLblUpdateDateEnd().setEnabled(false);
	viewContender.getBtnUpdateDate().setEnabled(false);

	viewContender.getLblUpdateSelectedCountry().setEnabled(false);
	viewContender.getLblDateBeginCountryToContender().setEnabled(false);
	viewContender.getLblDateEndCountryToContender().setEnabled(false);
	viewContender.getBtnInsertCountryToContender().setEnabled(false);
	viewContender.getComboBoxSelectCountryToContender().setEnabled(false);

	viewContender.getCb_Ganador().setEnabled(false);
	viewContender.getCb_GanadorInsert().setEnabled(false);

	viewContender.getjDC_BeginDate().setEnabled(false);
	viewContender.getjDC_EndDate().setEnabled(false);

    }

    private void initEvents() {
	viewContender.getTxtfInsertNewContender().addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char validar = e.getKeyChar();

		if (Character.isDigit(validar)) {
		    java.awt.Toolkit.getDefaultToolkit().beep();
		    e.consume();
		    JOptionPane.showMessageDialog(viewContender, "Ingrese solo Letras");
		}
	    }

	});
	viewContender.getTxtfUpdateSelectedContender().addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char validar = e.getKeyChar();

		if (Character.isDigit(validar)) {
		    java.awt.Toolkit.getDefaultToolkit().beep();
		    e.consume();
		    JOptionPane.showMessageDialog(viewContender, "Ingrese solo Letras");
		}
	    }

	});
	viewContender.getBtnInsertNewContender().addActionListener(this);
	viewContender.getBtnInsertCountryToContender().addActionListener(this);

	viewContender.getBtnDeleteSelectedContender().addActionListener(this);
	viewContender.getBtnDeleteSelectCountryADDED().addActionListener(this);

	viewContender.getBtnUpdateDate().addActionListener(this);
	viewContender.getBtnUpdateSelectedContender().addActionListener(this);

	viewContender.getCb_Ganador().addActionListener(this);
	viewContender.getCb_GanadorInsert().addActionListener(this);

	//IMPLEMENTAR AQUÍ VACIADO DE TODO EL FORMULARIO AL CLICKAR FUERA
	viewContender.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		resetComboboxes();
		initComponents();

	    }
	});

	viewContender.getBtnExit().addActionListener(this);

	//COMBOBOX DE GUERRAS
	viewContender.getComboBoxSelectWar().setModel(models.fillComboBoxModelWar());

	viewContender.getComboBoxSelectWar().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {
		    viewContender.getComboBoxSelectContender().setEnabled(true);
		    String nombre = (String) viewContender.getComboBoxSelectWar().getSelectedItem();
		    viewContender.getComboBoxSelectContender().setModel(models.fillComboBoxContender(nombre));
		    contenderInsertSetActive();
		    countriesUpdateDeactivate();
		    cleanContenderForm();
		    cleanCountriesForm();
		    cleanUpdateContenderForm();
		    cleanUpdateCountriesForm();
		    refreshCountriesAddedComboBox();
		}
	    }
	}
	);

	//COMBOBOX CONTENDER
	viewContender.getComboBoxSelectContender().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {
		    viewContender.getLblInsertNewCountry().setEnabled(true);
		    viewContender.getComboBoxSelectCountryADDED().setEnabled(true);
		    viewContender.getComboBoxSelectCountryToContender().setEnabled(true);
		    String nombre = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		    viewContender.getTxtfUpdateSelectedContender().setText(nombre);
		    //marcar checkbox ganador
		    int ganador = 0;
		    ganador = contenderDAO.winnerOrNot(nombre);
		    if (ganador == 1) {
			viewContender.getCb_Ganador().setSelected(true);
		    } else {
			viewContender.getCb_Ganador().setSelected(false);
		    }
		    viewContender.getComboBoxSelectCountryToContender().setModel(models.fillAllCountriesCombobox());
		    viewContender.getComboBoxSelectCountryADDED().setModel(models.fillComboBoxCountry(nombre));

		    contenderUpdateSetActive();
		    contenderInsertDeactivate();

		}
	    }
	});

	//COMBOBOX INSERTAR PAIS
	viewContender.getComboBoxSelectCountryToContender().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {

		    countriesUpdateDeactivate();
		    countriesInsertSetActive();
		    contenderUpdateDeactivate();

		}
	    }
	});

	//COMBOBOX MODIFICAR PAIS	
	viewContender.getComboBoxSelectCountryADDED().addItemListener(new ItemListener() {

	    @Override
	    public void itemStateChanged(ItemEvent e) {
		Date date1 = null;
		Date date2 = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (e.getStateChange() == e.SELECTED) {
		    String fecha1;
		    String fecha2 = "";
		    String nombrePais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
		    String nombreContendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		    unionBandos = bandosDAO.getUnionBandos(nombreContendiente, nombrePais);

		    //parseo de fecha string a date
		    try {
			fecha1 = unionBandos.getFechaUnion();
			date1 = df.parse(fecha1);

		    } catch (ParseException ex) {
			viewContender.getjDC_updateBeginDate().setEnabled(false);
			System.out.println("fallo al parsear fecha1");
		    }
//			String newFecha1=df.format(date1);
		    viewContender.getjDC_updateBeginDate().setDate(date1);

		    try {
			fecha2 = unionBandos.getFechaAbandono();
			date2 = df.parse(fecha2);

		    } catch (ParseException ex) {
			viewContender.getjDC_updateEndDate().setEnabled(false);
			System.out.println("fallo al parsear fecha2");
		    }
		    viewContender.getjDC_updateEndDate().setDate(date2);

		    countriesInsertDeactivate();
		    countriesUpdateSetActive();
		    viewContender.getBtnDeleteSelectCountryADDED().setEnabled(true);

		}
	    }
	});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == viewContender.getBtnExit()) {
	    viewContender.dispose();
	}

	//Insertar nuevo contendiente
	if (e.getSource() == viewContender.getBtnInsertNewContender()) {
	    if (viewContender.getTxtfInsertNewContender().getText().trim().length() > 0 && viewContender.getTxtfInsertNewContender().getText().trim().length() <= 50) {

		int ganador = 0;
		String guerra = (String) viewContender.getComboBoxSelectWar().getSelectedItem();
		contendiente = new Contendiente();
		contendiente.setNombre(viewContender.getTxtfInsertNewContender().getText());
		if (viewContender.getCb_GanadorInsert().isSelected()) {
		    ganador = 1;
		} else {
		    ganador = 0;
		}

		contendiente.setGanador(ganador);
		try {
		    contenderDAO.addContender(contendiente, guerra);
		    cleanContenderForm();
		    refreshContenderComboBox();
		} catch (ConstraintViolationException ex) {
		}
	    } else {
		JOptionPane.showMessageDialog(viewContender, "La longitud del nombre no es adecuada");
	    }

	}

	//Eliminar contendiente seleccionado
	if (e.getSource() == viewContender.getBtnDeleteSelectedContender()) {
	    String contenderName = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
	    contendiente = new Contendiente();
	    contendiente.setNombre(contenderName);
	    contenderDAO.remove(contendiente);
	    refreshContenderComboBox();
	    cleanUpdateContenderForm();

	}

	//Actualizar contendiente seleccionado
	if (e.getSource() == viewContender.getBtnUpdateSelectedContender()) {
	    if (viewContender.getTxtfUpdateSelectedContender().getText().trim().length() > 0 && viewContender.getTxtfUpdateSelectedContender().getText().trim().length() <= 50) {
		int ganador;
		contendiente= new Contendiente();
		String newContenderName = viewContender.getTxtfUpdateSelectedContender().getText();
		String oldContenderName = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		contendiente.setNombre(newContenderName);
		if (viewContender.getCb_Ganador().isSelected()) {
		    ganador = 1;
		} else {
		    ganador = 0;
		}
		contendiente.setGanador(ganador);
		try {
		    contenderDAO.updateContendiente(contendiente, oldContenderName);
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(viewContender, "El contendiente ya existe");
		}
		refreshContenderComboBox();
		cleanUpdateContenderForm();
	    } else {
		JOptionPane.showMessageDialog(viewContender, "La longitud del nombre no es la adecuada");
	    }

	}

	//Insertar países a contendientes
	if (e.getSource() == viewContender.getBtnInsertCountryToContender()) {
	    String pais, contendiente, fecha_abandono;
unionBandos= new UnionBandos();
contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
pais = (String) viewContender.getComboBoxSelectCountryToContender().getSelectedItem();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date date1 = viewContender.getjDC_BeginDate().getDate();
String fecha_union = df.format(date1);
Date date2 = viewContender.getjDC_EndDate().getDate();
fecha_abandono = df.format(date2);
unionBandos.setFechaAbandono(fecha_abandono);
unionBandos.setFechaUnion(fecha_union);
try {
    bandosDAO.addBandos(unionBandos, contendiente, pais);
    cleanCountriesForm();

    

if (viewContender.getComboBoxSelectCountryToContender().getSelectedIndex() == 0) {
    countriesUpdateSetActive();
}
refreshCountriesAddedComboBox();
} catch (ConstraintViolationException ex) {
    JOptionPane.showMessageDialog(viewContender, "País ya vinculado anteriormente");
}
	}

	//Eliminar países de contendientes
	if (e.getSource() == viewContender.getBtnDeleteSelectCountryADDED()) {
	    String pais, contendiente;
	    contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
	    pais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
	    bandosDAO.removeContries(contendiente, pais);
	    refreshCountriesAddedComboBox();
	}

	//Actualizar países de contendientes
	if (e.getSource() == viewContender.getBtnUpdateDate()) {
	    String pais, contendiente;
	    unionBandos= new UnionBandos();
	    contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
	    pais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date date1 = viewContender.getjDC_updateBeginDate().getDate();
	    String fecha_union = df.format(date1);
	    Date date2 = viewContender.getjDC_updateEndDate().getDate();
	    String fecha_abandono = df.format(date2);
	    unionBandos.setFechaAbandono(fecha_abandono);
	    unionBandos.setFechaUnion(fecha_union);
	    try {
		bandosDAO.updateBandos(unionBandos, contendiente, pais);
		
	    } catch (ConstraintViolationException ex) {
		JOptionPane.showMessageDialog(viewContender, "País ya vinculado anteriormente");
	    }
	    refreshCountriesAddedComboBox();
	    cleanUpdateCountriesForm();
	}
    }

    private void resetComboboxes() {
	viewContender.getComboBoxSelectWar().setSelectedIndex(0);
	viewContender.getComboBoxSelectContender().setSelectedIndex(0);
	viewContender.getComboBoxSelectCountryToContender().setSelectedIndex(0);
	viewContender.getComboBoxSelectCountryADDED().setSelectedIndex(0);

    }

    private void contenderInsertSetActive() {
	viewContender.getLblInsertNewContender().setEnabled(true);
	viewContender.getLblContenderName().setEnabled(true);
	viewContender.getTxtfInsertNewContender().setEnabled(true);
	viewContender.getBtnInsertNewContender().setEnabled(true);
	viewContender.getCb_GanadorInsert().setEnabled(true);

    }

    private void contenderInsertDeactivate() {
	viewContender.getLblInsertNewContender().setEnabled(false);
	viewContender.getLblContenderName().setEnabled(false);
	viewContender.getTxtfInsertNewContender().setEnabled(false);
	viewContender.getBtnInsertNewContender().setEnabled(false);
	viewContender.getCb_GanadorInsert().setEnabled(false);
    }

    private void contenderUpdateSetActive() {
	viewContender.getLblUpdateSelectedContender().setEnabled(true);
	viewContender.getLblUpdateContenderName().setEnabled(true);
	viewContender.getTxtfUpdateSelectedContender().setEnabled(true);
	viewContender.getBtnUpdateSelectedContender().setEnabled(true);
	viewContender.getBtnDeleteSelectedContender().setEnabled(true);
	viewContender.getCb_Ganador().setEnabled(true);

    }

    private void contenderUpdateDeactivate() {
	viewContender.getLblUpdateSelectedContender().setEnabled(false);
	viewContender.getLblUpdateContenderName().setEnabled(false);
	viewContender.getTxtfUpdateSelectedContender().setEnabled(false);
	viewContender.getBtnUpdateSelectedContender().setEnabled(false);
	viewContender.getBtnDeleteSelectedContender().setEnabled(false);
	viewContender.getCb_Ganador().setEnabled(false);
    }

    private void countriesInsertSetActive() {
	viewContender.getLblDateBeginCountryToContender().setEnabled(true);
	viewContender.getLblDateEndCountryToContender().setEnabled(true);
	viewContender.getBtnInsertCountryToContender().setEnabled(true);
	viewContender.getjDC_BeginDate().setEnabled(true);
	viewContender.getjDC_EndDate().setEnabled(true);

    }

    private void countriesInsertDeactivate() {
	viewContender.getLblDateBeginCountryToContender().setEnabled(false);
	viewContender.getLblDateEndCountryToContender().setEnabled(false);
	viewContender.getBtnInsertCountryToContender().setEnabled(false);
	viewContender.getComboBoxSelectCountryToContender().setEnabled(false);
	viewContender.getLblInsertNewCountry().setEnabled(false);
	viewContender.getjDC_BeginDate().setEnabled(false);
	viewContender.getjDC_EndDate().setEnabled(false);

    }

    private void countriesUpdateSetActive() {
	viewContender.getComboBoxSelectCountryADDED().setEnabled(true);
	viewContender.getLblUpdateSelectedCountry().setEnabled(true);
	viewContender.getLblUpdateDateBegin().setEnabled(true);
	viewContender.getLblUpdateDateEnd().setEnabled(true);
	viewContender.getBtnUpdateDate().setEnabled(true);
	viewContender.getjDC_updateBeginDate().setEnabled(true);
	viewContender.getjDC_updateEndDate().setEnabled(true);

    }

    private void countriesUpdateDeactivate() {
	viewContender.getLblUpdateDateBegin().setEnabled(false);
	viewContender.getLblUpdateDateEnd().setEnabled(false);
	viewContender.getBtnUpdateDate().setEnabled(false);
	viewContender.getBtnDeleteSelectCountryADDED().setEnabled(false);
	viewContender.getComboBoxSelectCountryADDED().setEnabled(false);
	viewContender.getLblUpdateSelectedCountry().setEnabled(false);
	viewContender.getjDC_updateBeginDate().setEnabled(false);
	viewContender.getjDC_updateEndDate().setEnabled(false);

    }

    private void cleanContenderForm() {
	viewContender.getTxtfInsertNewContender().setText("");
	viewContender.getCb_GanadorInsert().setSelected(false);
    }

    private void cleanUpdateContenderForm() {
	viewContender.getTxtfUpdateSelectedContender().setText("");
	viewContender.getCb_Ganador().setSelected(false);
    }

    private void cleanCountriesForm() {
	viewContender.getjDC_BeginDate().setDate(new Date());
	viewContender.getjDC_EndDate().setDate(new Date());
	viewContender.getComboBoxSelectCountryToContender().setSelectedIndex(0);
    }

    private void cleanUpdateCountriesForm() {
	viewContender.getjDC_updateBeginDate().setDate(new Date());
	viewContender.getjDC_updateEndDate().setDate(new Date());
    }

    private void refreshContenderComboBox() {
	viewContender.getComboBoxSelectContender().removeAllItems();
	viewContender.getComboBoxSelectContender().setModel(models.fillComboBoxContender((String) viewContender.getComboBoxSelectWar().getSelectedItem()));
    }

    private void refreshCountriesAddedComboBox() {
	viewContender.getComboBoxSelectCountryADDED().removeAllItems();
	viewContender.getComboBoxSelectCountryADDED().setModel(models.fillComboBoxCountry((String) viewContender.getComboBoxSelectContender().getSelectedItem()));
    }

}//Fin clase proincipal
