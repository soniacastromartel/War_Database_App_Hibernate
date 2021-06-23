
package app_guerras;

import UpperEssential.UpperEssentialLookAndFeel;
import controllers.controllerPrincipal;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author soniacastromartel@gmail.com
 */
public class App_Guerras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
	UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("/Images/Chocolate.theme"));

    controllerPrincipal ctrlWar= new controllerPrincipal();    
        
        
    }// fien del bloque MAIN
    
    
    
    
}//Fin de la clase principal

