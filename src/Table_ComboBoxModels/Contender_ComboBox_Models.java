package Table_ComboBoxModels;

import Models.Dao.ContenderDAO;
import Models.Dao.GuerrasDAO;
import Models.Dao.PaisDAO;
import Models.Pojo.Contendiente;
import Models.Pojo.Guerra;
import Models.Pojo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.HibernateException;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class Contender_ComboBox_Models {

    String sql;
    ResultSet rs = null;
    Connection conexion;
    PreparedStatement sentencia;
    List<Guerra> guerras;
    GuerrasDAO guerrasDAO;
    List<Pais> paises;
    PaisDAO paisDAO;
    List<Contendiente> contendientes;
    ContenderDAO contenderDAO;

    public Contender_ComboBox_Models() {

	this.guerrasDAO = new GuerrasDAO();
	this.paisDAO = new PaisDAO();
	this.contenderDAO = new ContenderDAO();

    }


    //todas las guerras
    public DefaultComboBoxModel fillWarsComboBoxModel(String quote) throws HibernateException {
	DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
	comboBoxModel.addElement(quote);
	guerras = guerrasDAO.list();
	for (Guerra guerra : guerras) {
	    comboBoxModel.addElement(guerra.getNombre());

	}

	return comboBoxModel;
    }

    //todos los paises
    public DefaultComboBoxModel fillAllCountriesComboBoxModel(String quote) throws HibernateException {
	DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
	comboBoxModel.addElement(quote);
	paises = paisDAO.list();
	for (Pais pais : paises) {
	    comboBoxModel.addElement(pais.getNombre());

	}

	return comboBoxModel;
    }

    public DefaultComboBoxModel fillCountriesComboBoxModel(String quote, String nombre) throws HibernateException {
	DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
	comboBoxModel.addElement(quote);
	paises = paisDAO.listCountryOfContender(nombre);

	for (Pais pais : paises) {
	    System.out.println("" + pais);
	    comboBoxModel.addElement(pais.getNombre());

	}

	return comboBoxModel;
    }

    public DefaultComboBoxModel fillContendersComboBoxModel(String quote, String nombre) throws HibernateException {
	DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
	comboBoxModel.addElement(quote);
	contendientes = contenderDAO.listWarContenders(nombre);
	for (Contendiente contendiente : contendientes) {
	    comboBoxModel.addElement(contendiente.getNombre());

	}

	return comboBoxModel;
    }

    //Combo de Guerra
    public DefaultComboBoxModel fillComboBoxModelWar() throws HibernateException {
	DefaultComboBoxModel comboBoxModelWar = new DefaultComboBoxModel();
	comboBoxModelWar = fillWarsComboBoxModel("Seleccione una guerra...");
	return comboBoxModelWar;
    }

    //Combo de Contendiente
    public DefaultComboBoxModel fillComboBoxContender(String nombre) throws HibernateException {
	DefaultComboBoxModel comboBoxModelContender = new DefaultComboBoxModel();
	comboBoxModelContender = fillContendersComboBoxModel("Seleccione un contendiente...", nombre);
	return comboBoxModelContender;
    }

    //Combo de Pais aliado
    public DefaultComboBoxModel fillComboBoxCountry(String nombre) throws HibernateException {
	DefaultComboBoxModel comboBoxModelCountry = new DefaultComboBoxModel();
	comboBoxModelCountry = fillCountriesComboBoxModel("Seleccione un país contendiente...", nombre);
	return comboBoxModelCountry;
    }

    //Combo de todos los paises de la bbdd
    public DefaultComboBoxModel fillAllCountriesCombobox() throws HibernateException {
	DefaultComboBoxModel comboBoxModelCountries = new DefaultComboBoxModel();
	comboBoxModelCountries = fillAllCountriesComboBoxModel("Seleccione un país...");
	return comboBoxModelCountries;
    }

 
}
