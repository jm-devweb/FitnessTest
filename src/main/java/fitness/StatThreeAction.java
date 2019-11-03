/**
 * Classe StatThreeAction
 * Calcul for weight / set
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

import java.text.DecimalFormat;
import java.util.List;

public class StatThreeAction implements MenuItem{

    // **************************************************
    // Constants
    // **************************************************
    private static final String LABEL = "Stats de poids (/set)";

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
    public StatThreeAction(DataSet dataset,String key){
        this.dataset= dataset;
        this.key = key ;
    }

    /**
     * Return label of menuitem
     * @return label
     */
    public String getLabel(){
        return LABEL;
    }

    /**
     * Action of menuitem
     */
    public boolean doIt(){
        String result = "";
        result =  dataset.statThree(key) ;
        System.out.println(result);
        System.out.println ("\n" + Main.FOOTER );
        return true ;
    }
}