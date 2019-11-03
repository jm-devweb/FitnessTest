/**
 * Classe StatOneAction
 * Calcul for weight / rep
 * @author Jean-Marc Noël
 * @version 1.0
 */

package fitness;

public class StatOneAction implements MenuItem{

    // **************************************************
    // Constants
    // **************************************************
    private static final String LABEL = "Stats de poids (/répétitions)";

    // **************************************************
    // Fields
    // **************************************************
    private final DataSet dataset;
    private final String key;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Default constructor.
     * @param dataset  Data
     * @param key type of exercice
     */
    public StatOneAction(DataSet dataset,String key){
        this.dataset= dataset;
        this.key = key ;
    }

    /**
     * Return label of menuitem
     * @return label of menuitem
     */
    public String getLabel(){
        return LABEL;
    }

    /**
     * Action of menuitem
     * @Return boolean
     */
    public boolean doIt(){
        String result = "";
         result =  dataset.statOne (key);
        System.out.println(result);
        System.out.println ("\n" + Main.FOOTER );
        return true ;
    }
}