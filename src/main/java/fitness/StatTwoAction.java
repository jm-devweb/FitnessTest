/**
 * Classe StatTwoAction
 * Calcul for nb rep
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

import java.text.DecimalFormat;
import java.util.List;

public class StatTwoAction implements MenuItem{

    // **************************************************
    // Constants
    // **************************************************
    private static final String LABEL = "Stats de nombre de répétitions";

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
    public StatTwoAction(DataSet dataset,String key){
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
     * @Return boolean
     */    public boolean doIt(){
        String result = "";
        result =  dataset.statTwo(key) ;
        System.out.println(result);
        System.out.println ("\n" + Main.FOOTER );
        return true ;
    }
}