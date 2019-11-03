/**
 * Class AddSetAction
 * Add a set
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

public class AddSetAction implements MenuItem{

    // **************************************************
    // Constants
    // **************************************************
    private final static String PROMPT = "Ajouter un set : ";
    private final static String TYPE = "Le type : ";
    private final static String REPETITION = "Le nb répétition : ";
    private final static String WEIGHT = "Le poids : " ;

    // **************************************************
    // Fields
    // **************************************************
    private final DataSet dataset;
    private final String label;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Default constructor.
     * @param dataset
     * @param label label of menuitem
     */
    public AddSetAction(DataSet dataset,String label){
        this.dataset= dataset;
        this.label = label ;
    }

    /**
     * Return label for a menu
     * @return label of
     */
    public String getLabel(){
        return label;
    }

    /**
     * Action of menuitem
     * @Return boolean
     */
    public boolean doIt(){
        String type ;
        String rep ;
        String weight ;

        System.out.println(PROMPT);
        System.out.print(TYPE);
        type = Main.keyboard.nextLine();
        System.out.print(WEIGHT) ;
        rep = Main.keyboard.nextLine();
        System.out.print(REPETITION);
        weight = Main.keyboard.nextLine();
        dataset.add(new Set(type,Integer.parseInt(rep),Float.parseFloat(weight)));
        return true ;
    }
}