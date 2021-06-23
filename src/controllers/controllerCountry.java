/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.Dao.PaisDAO;
import Models.Dao.PeriodoIndependeciaDAO;
import Models.Pojo.Pais;
import Models.Pojo.PeriodoIndependecia;
import Table_ComboBoxModels.Country_TableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.viewCountries;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
public final class controllerCountry implements ActionListener {

    viewCountries viewCountrie;
    Country_TableView country_TableView;
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    PaisDAO paisDAO;
    PeriodoIndependeciaDAO periodoDAO;
    Pais pais;

    //AGREGAR MODELs *** 
    //Constructor
    public controllerCountry(viewPrincipal viewPpal) throws ClassNotFoundException, SQLException {

	//AGREGAR MODELs ***
	paisDAO = new PaisDAO();
	periodoDAO = new PeriodoIndependeciaDAO();
	viewCountrie = new viewCountries(viewPpal, true);
//	businness = new Country_Businness();
	initComponents();
	initEvents();

	viewCountrie.setVisible(true);
    }//Fin del constructor

    private void initComponents() {

	viewCountrie.getBtnUpdate().setEnabled(false);
	viewCountrie.getBtnDelete().setEnabled(false);
	viewCountrie.getBtnInsert().setEnabled(true);
	viewCountrie.getTF_CountryId().setEnabled(false);
	viewCountrie.getCheckBoxIndependent().setSelected(false);
	setIndependent();

    }//Fin initComponents

    public void initEvents() throws SQLException {
	//INICIALIZAR EVENTOS
	viewCountrie.getTxtfCountryName().addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char validar = e.getKeyChar();

		if (Character.isDigit(validar)) {
		    java.awt.Toolkit.getDefaultToolkit().beep();
		    e.consume();
		    JOptionPane.showMessageDialog(viewCountrie, "Ingrese solo Letras");
		}
	    }

	});
	viewCountrie.getBtnInsert().addActionListener(this);
	viewCountrie.getBtnUpdate().addActionListener(this);
	viewCountrie.getBtnDelete().addActionListener(this);
	viewCountrie.getBtnExit().addActionListener(this);
	viewCountrie.getCheckBoxIndependent().addActionListener(this);
	paisDAO.queriesI();
	country_TableView = new Country_TableView(paisDAO);
	viewCountrie.getJtableCountries().setModel(country_TableView);
	viewCountrie.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		viewCountrie.getJtableCountries().clearSelection();
		clearTextFields();
		initComponents();

	    }

	});
	/*Agregamos un evento de ratón a la tabla para seleccionar
        los valores de una fila y colocarlos en los cajones de texto*/
	viewCountrie.getJtableCountries().addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent me) {
		if (me.getClickCount() == 2) {
		    selected_row();
		    viewCountrie.getBtnUpdate().setEnabled(true);
		    viewCountrie.getBtnDelete().setEnabled(true);
		    viewCountrie.getBtnInsert().setEnabled(false);
		    if (viewCountrie.getTxtfDateBegin().getYear() != 0) {
			viewCountrie.getCheckBoxIndependent().doClick();
			setIndependent();

		    }

		}
	    }

	}
	);

	viewCountrie.getTxtfSearch().getDocument().addDocumentListener(new DocumentListener() {
	    @Override
	    public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == viewCountrie.getTxtfSearch().getDocument()) {
		    activoTimer();

		}
	    }

	    @Override
	    public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == viewCountrie.getTxtfSearch().getDocument()) {
		    activoTimer();
		}
	    }

	    @Override
	    public void changedUpdate(DocumentEvent e) {
		if (e.getDocument() == viewCountrie.getTxtfSearch().getDocument()) {
		    activoTimer();

		}
	    }
	});

    }//Fin initEvents

    @Override
    public void actionPerformed(ActionEvent ae) {
	//insert pais con independencia

	if (ae.getSource() == viewCountrie.getBtnInsert()) {
	   
		if (viewCountrie.getCheckBoxIndependent().isSelected() == true) {
		     if (viewCountrie.getTxtfCountryName().getText().trim().length() > 0 && viewCountrie.getTxtfCountryName().getText().trim().length() <= 50) {
		    try {
			pais = new Pais();
			pais.setNombre(viewCountrie.getTxtfCountryName().getText());
			PeriodoIndependecia periodo = new PeriodoIndependecia();
			periodo.setAnioInicio(viewCountrie.getTxtfDateBegin().getYear());
			periodo.setAnioFin(viewCountrie.getTxtfDateEnd().getYear());
			pais.getPeriodoIndependecias().add(periodo);
			System.out.println("" + pais.getPeriodoIndependecias());
			paisDAO.addObject(pais);

			pais = new Pais();
			pais.setNombre(viewCountrie.getTxtfCountryName().getText());
			periodo = new PeriodoIndependecia();
			periodo.setAnioInicio(viewCountrie.getTxtfDateBegin().getYear());
			periodo.setAnioFin(viewCountrie.getTxtfDateEnd().getYear());
			pais.getPeriodoIndependecias().add(periodo);
			periodoDAO.addIndependencePeriod(pais);
//		    System.out.println("" + pais + "" + periodo);

		    } catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("Algo no ha ido bien");
		    }
		} else {
		    JOptionPane.showMessageDialog(viewCountrie, "La longitud del nombre no es adecuada");
		}

		list();

		//insert de pais solo
	    } else {
		if (viewCountrie.getTxtfCountryName().getText().trim().length() > 0 && viewCountrie.getTxtfCountryName().getText().trim().length() <= 50) {

		    Pais pais = new Pais();
		    pais.setNombre(viewCountrie.getTxtfCountryName().getText());
		    paisDAO.addObject(pais);
		} else {
		    JOptionPane.showMessageDialog(viewCountrie, "La longitud del nombre no es adecuada");
		}
		list();

	    }

	    //update
	} else if (ae.getSource() == viewCountrie.getBtnUpdate()) {
	    if (viewCountrie.getTxtfCountryName().getText().trim().length() > 0 && viewCountrie.getTxtfCountryName().getText().trim().length() <= 50) {
		if (viewCountrie.getCheckBoxIndependent().isSelected() == true) {
		    Pais pais = paisDAO.getById(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
		    pais.setNombre(viewCountrie.getTxtfCountryName().getText());
		    paisDAO.updateObject(pais);

		    pais = paisDAO.getById(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
		    System.out.println("" + pais);
		    PeriodoIndependecia periodo = new PeriodoIndependecia();
		    periodo.setAnioInicio(viewCountrie.getTxtfDateBegin().getYear());
		    periodo.setAnioFin(viewCountrie.getTxtfDateEnd().getYear());
		    periodoDAO.UpdateOrSavePeriod(pais, periodo);
		} else {
		    JOptionPane.showMessageDialog(viewCountrie, "La longitud del nombre no es adecuada");
		}
		list();

	    } else {
		try {
		    if (viewCountrie.getTxtfCountryName().getText().trim().length() > 0 && viewCountrie.getTxtfCountryName().getText().trim().length() <= 50) {
			Pais pais = paisDAO.getById(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
			pais.setNombre(viewCountrie.getTxtfCountryName().getText());
			paisDAO.updateObject(pais);
			periodoDAO.deletePeriodoIndependencia(pais);
		    } else {
			JOptionPane.showMessageDialog(viewCountrie, "La longitud del nombre no es adecuada");
		    }
		} catch (Exception e) {
		}

		list();

	    }

	    //Delete
	} else if (ae.getSource() == viewCountrie.getBtnDelete()) {
	    try {
		Pais pais = paisDAO.getById(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
		paisDAO.remove(pais);
		list();
	    } catch (Exception ex) {
		Logger.getLogger(controllerCountry.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} else if (ae.getSource() == viewCountrie.getBtnExit()) {
	    viewCountrie.dispose();
	} else if (ae.getSource() == viewCountrie.getCheckBoxIndependent()) {
	    setIndependent();
	}//Fin del else-if

    }
    //Fin de action performed
    //Seteara las etiquetas acorde al CheckBox

    private void setIndependent() {
	boolean aux = viewCountrie.getCheckBoxIndependent().isSelected();
	viewCountrie.getLblDateBegin().setEnabled(aux);
	viewCountrie.getTxtfDateBegin().setEnabled(aux);
	viewCountrie.getLblDateEnd().setEnabled(aux);
	viewCountrie.getTxtfDateEnd().setEnabled(aux);
    }//Fin set independent

    private void clearTextFields() {
	viewCountrie.getTF_CountryId().setText("");
	viewCountrie.getTxtfCountryName().setText("");
	viewCountrie.getTxtfDateBegin().setYear(0);
	viewCountrie.getTxtfDateEnd().setYear(0);
	viewCountrie.getCheckBoxIndependent().setSelected(false);
    }

    private void selected_row() {
	int row = viewCountrie.getJtableCountries().getSelectedRow();
	if (row >= 0) {
	    viewCountrie.getTF_CountryId().setText(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 0)));
	    viewCountrie.getTxtfCountryName().setText(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 1)));
	    try {
		viewCountrie.getTxtfDateBegin().setYear(Integer.parseInt(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 3))));
		viewCountrie.getTxtfDateEnd().setYear(Integer.parseInt(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 4))));
	    } catch (NumberFormatException e) {
		viewCountrie.getTxtfDateBegin().setYear(0);
		viewCountrie.getTxtfDateEnd().setYear(0);
	    }

	}
    }

    private void list() {
	paisDAO.queriesI();
	country_TableView = new Country_TableView(paisDAO);
	viewCountrie.getJtableCountries().setModel(country_TableView);
	country_TableView.fireTableDataChanged();
	clearTextFields();
    }

    //Settear el objeto
//    private CountryDTO setCountryDTO() {
//	countryDTO = new CountryDTO();
//	countryDTO.setId_pais(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
//	countryDTO.setNombre(viewCountrie.getTxtfCountryName().getText());
//	countryDTO.setAnio_inicio(viewCountrie.getTxtfDateBegin().getText());
//	countryDTO.setAnio_fin(viewCountrie.getTxtfDateEnd().getText());
//	return countryDTO;
//    }
    private void activoTimer() {

	if ((timerbuscar != null) && timerbuscar.isRunning()) {
	    timerbuscar.restart();
	} else {
	    timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {

		    timerbuscar = null;
		    paisDAO.lightSearch(viewCountrie.getTxtfSearch().getText());
		    country_TableView.fireTableDataChanged();

		}

	    });
	    timerbuscar.setRepeats(false);
	    timerbuscar.start();
	}

    }
}//Fin de clase principal
