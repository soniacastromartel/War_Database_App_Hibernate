
package Table_ComboBoxModels;

import Models.Dao.GuerrasDAO;
import Models.Pojo.Guerra;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soniacastromartel@gmail.com
 */
public class War_TableView extends AbstractTableModel {

    String[] columnNames;
    private Object [] values;
    GuerrasDAO guerrasDAO;
    ArrayList<Guerra> guerras;

    public War_TableView(GuerrasDAO guerrasDAO) {
	this.guerrasDAO = guerrasDAO;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

	Guerra guerra=guerrasDAO.getWarDTO(rowIndex);
	values= new Object[]{guerra.getIdGuerra(),guerra.getAnioInicio(),guerra.getAnioFin(), guerra.getNombre()};
        return values[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
      columnNames= new String[]{"ID","Año de Inicio","Año de Fin","Nombre"
	  
      };
        return columnNames[column];

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {        
        return guerrasDAO.getSizeList();
    }

}

