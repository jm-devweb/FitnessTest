/**
 * Classe QuitAction
 * Quit a menu
 *
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

public class QuitAction implements MenuItem{

    // **************************************************
    // Fields
    // **************************************************
    private final String label ;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Default constructor.
     * @param label label of menuitem
     */
    public QuitAction(String label){
        this.label = label ;
    }

    /**
     * Return label of menuitem
     * @return label
     */
    public String getLabel(){
        return label;
    }

    /**
     * Action of menuitem
     * @Return boolean
     */
    public boolean doIt(){
        return false ;
    }
}
