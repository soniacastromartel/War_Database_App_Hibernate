/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

//import views.viewCountries;
import Models.Dao.GuerrasDAO;
import Models.Pojo.Guerra;
import Table_ComboBoxModels.War_TableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.hibernate.exception.ConstraintViolationException;
import views.viewPrincipal;
import views.viewWars;

/**
 *
 * @author grupo1
 */
public final class controllerWar implements ActionListener {

    viewWars viewWar;
    War_TableView warTableView;//= new War_TableView(bussiness);
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    GuerrasDAO guerrasDAO;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public controllerWar(viewPrincipal viewPpal) {
	viewWar = new viewWars(viewPpal, true);

	guerrasDAO = new GuerrasDAO();
	initComponents();
	initEvents();

	viewWar.setVisible(true);
    }

    private void initComponents() {
	viewWar.getId_text().setEnabled(false);
	viewWar.getEdit_button().setEnabled(false);
	viewWar.getDelete_button().setEnabled(false);
	viewWar.getAdd_button().setEnabled(true);

    }//Fin initComponents

    public void initEvents() {
	//INICIALIZAR EVENTOS
	viewWar.getName_text().addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char validar = e.getKeyChar();

		if (Character.isDigit(validar)) {
		    java.awt.Toolkit.getDefaultToolkit().beep();
		    e.consume();
		    JOptionPane.showMessageDialog(viewWar, "Ingrese solo Letras");
		}
	    }

	});
	viewWar.getAdd_button().addActionListener(this);
	viewWar.getDelete_button().addActionListener(this);
	viewWar.getEdit_button().addActionListener(this);
	viewWar.getExit_button().addActionListener(this);

	warTableView = new War_TableView(guerrasDAO);
	viewWar.getJtableWars().setModel(warTableView);
	guerrasDAO.queriesI();
	warTableView = new War_TableView(guerrasDAO);
	viewWar.getJtableWars().setModel(warTableView);

	viewWar.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		viewWar.getJtableWars().clearSelection();
		clearTextFields();
		initComponents();

	    }
	});
	/*Agregamos un evento de ratón a la tabla para seleccionar
        los valores de una fila y colocarlos en los cajones de texto*/
	viewWar.getJtableWars().addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent me) {
		if (me.getClickCount() == 2) {
		    try {
			selected_row();
		    } catch (ParseException ex) {
			Logger.getLogger(controllerWar.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    viewWar.getEdit_button().setEnabled(true);
		    viewWar.getDelete_button().setEnabled(true);
		    viewWar.getAdd_button().setEnabled(false);
		}
	    }
	}
	);

	viewWar.getTxtfFilterSearch().getDocument().addDocumentListener(new DocumentListener() {
	    @Override
	    public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == viewWar.getTxtfFilterSearch().getDocument()) {
		    activoTimer();

		}
	    }

	    @Override
	    public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == viewWar.getTxtfFilterSearch().getDocument()) {
		    activoTimer();
		}
	    }

	    @Override
	    public void changedUpdate(DocumentEvent e) {
		if (e.getDocument() == viewWar.getTxtfFilterSearch().getDocument()) {
		    activoTimer();

		}
	    }
	});

    }//Fin initEvents

    @Override
    public void actionPerformed(ActionEvent ae) {
	//Boton Añadir Guerras
	if (ae.getSource() == viewWar.getAdd_button()) {
	    Guerra guerra = new Guerra();

	    guerra.setNombre(viewWar.getName_text().getText());
	    if (guerra.getNombre().length() > 0 && guerra.getNombre().length() <= 50) {
		try {
		    guerra.setAnioInicio(df.format(viewWar.getStart_date_text().getDate()));

		} catch (Exception e) {
		    guerra.setAnioInicio("0001-01-01");
		}

		try {
		    guerra.setAnioFin(df.format(viewWar.getEnd_date_text().getDate()));

		} catch (Exception e) {
		    guerra.setAnioFin("0001-01-01");
		}
		try {
		    guerrasDAO.addObject(guerra);

		} catch (ConstraintViolationException e) {
		    JOptionPane.showMessageDialog(viewWar, "La guerra seleccionada ya existe");
		}
	    }else{
		 JOptionPane.showMessageDialog(viewWar, "El nombre no tiene la longitud adecuada");
		
	    }

	    list();

	    //Boton Editar Guerras
	} else if (ae.getSource() == viewWar.getEdit_button()) {
	    Guerra guerra = new Guerra();
	    guerra.setIdGuerra(Integer.parseInt(viewWar.getId_text().getText()));
	    guerra.setNombre(viewWar.getName_text().getText());
	    try {
		guerra.setAnioInicio(df.format(viewWar.getStart_date_text().getDate()));

	    } catch (Exception e) {
		guerra.setAnioInicio("");
	    }

	    try {
		guerra.setAnioFin(df.format(viewWar.getEnd_date_text().getDate()));

	    } catch (Exception e) {
		guerra.setAnioFin("");
	    }
	    guerrasDAO.updateObject(guerra);
	    list();

	    //Boton Eliminar Guerras
	} else if (ae.getSource() == viewWar.getDelete_button()) {
	    Guerra guerra = new Guerra();
	    guerra.setIdGuerra(Integer.parseInt(viewWar.getId_text().getText()));
	    guerra.setNombre(viewWar.getName_text().getText());
	    guerra.setAnioInicio(df.format(viewWar.getStart_date_text().getDate()));
	    guerra.setAnioFin(df.format(viewWar.getEnd_date_text().getDate()));
	    guerrasDAO.remove(guerra);
	    list();
	    //Botón Salir
	} else if (ae.getSource() == viewWar.getExit_button()) {
	    viewWar.dispose();
	}//Fin del else-if

    }//Fin de action performed

    private void selected_row() throws ParseException {
	int row = viewWar.getJtableWars().getSelectedRow();

	if (row >= 0) {
	    try {

		viewWar.getId_text().setText(String.valueOf(viewWar.getJtableWars().getValueAt(row, 0)));
		viewWar.getName_text().setText(String.valueOf(viewWar.getJtableWars().getValueAt(row, 3)));
		viewWar.getStart_date_text().setDate(df.parse(String.valueOf(viewWar.getJtableWars().getValueAt(row, 1))));
		viewWar.getEnd_date_text().setDate(df.parse(String.valueOf(viewWar.getJtableWars().getValueAt(row, 2))));
	    } catch (ParseException ex) {

		viewWar.getStart_date_text().setDate(null);
		viewWar.getEnd_date_text().setDate(null);

		System.out.println("No se pudo parsear la fecha");
	    }
	}
    }

    //Limpiar TextFields
    private void clearTextFields() {
	viewWar.getName_text().setText("");
	viewWar.getId_text().setText("");
	viewWar.getEnd_date_text().setDate(null);
	viewWar.getStart_date_text().setDate(null);

    }

    private void list() {

	guerrasDAO.queriesI();
	warTableView = new War_TableView(guerrasDAO);
	viewWar.getJtableWars().setModel(warTableView);
	warTableView.fireTableDataChanged();
	clearTextFields();
    }

    private void activoTimer() {

	if ((timerbuscar != null) && timerbuscar.isRunning()) {
	    timerbuscar.restart();
	} else {
	    timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
		    try {
			timerbuscar = null;
			guerrasDAO.lightSearch(viewWar.getTxtfFilterSearch().getText());
			warTableView.fireTableDataChanged();
		    } catch (Exception ex) {
			System.out.println("No funciona activo timer");
		    }
		}

	    });
	    timerbuscar.setRepeats(false);
	    timerbuscar.start();
	}

    }

}
