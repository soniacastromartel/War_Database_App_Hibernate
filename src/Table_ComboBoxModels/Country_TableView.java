package Table_ComboBoxModels;

import Models.Dao.PaisDAO;
import Models.Dao.PeriodoIndependeciaDAO;
import Models.Pojo.Pais;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author grupo1
 */
public class Country_TableView extends AbstractTableModel {

    String[] columnNames;
    PaisDAO paisDAO;
    private Object[] values;
    ArrayList<Pais> paises;
    PeriodoIndependeciaDAO periodoDAO;

    //Constructor
    public Country_TableView(PaisDAO paisDAO) {

	this.paisDAO = paisDAO;

    }

    @Override
    public int getRowCount() {
	return paisDAO.getSizeList();
    }

    @Override
    public int getColumnCount() {

	return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {

//        return values;
//	Pais p = paises.get(rowIndex);
//	List<PeriodoIndependecia> piList = new ArrayList<>(p.getPeriodoIndependecias());
//	PeriodoIndependecia pi = new PeriodoIndependecia();
//	for (PeriodoIndependecia periodoIndependecia : piList) {
//	    pi = periodoIndependecia;
//	}
//	List<PeriodoIndependecia> piList =periodoDAO.listIndependencePeriod(p) ;
//	PeriodoIndependecia pi = new PeriodoIndependecia();
//	for (PeriodoIndependecia periodoIndependecia : piList) {
//	    System.out.println(""+periodoIndependecia);
//	    pi = periodoIndependecia;
//	}
//	PeriodoIndependecia pi = (PeriodoIndependecia) (new ArrayList<>(p.getPeriodoIndependecias())).get(0);
//	System.out.println("" + pi);
//	values = new Object[]{p.getIdPais(), p.getNombre(), pi.getIdPeriodo(), pi.getAnioInicio(), pi.getAnioFin()};
	Object[] values = paisDAO.getCountryDTO(rowIndex);
	return values[columIndex];
    }

    @Override
    public String getColumnName(int column) {
	columnNames = new String[]{"ID", "Nombre", "ID_Periodo", "Año de Inicio", "Año de Fin"

	};
	return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
	return false;
    }

}
