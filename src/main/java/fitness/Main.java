/**
 * Classe Main du projet Fitness
 *
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    // **************************************************
    // Constants
    // **************************************************
    private final static String TITLE_LEVEL_ONE = "--------------------- Fitness Coach ---------------------";
    private final static String TITLE_LEVEL_TWO = "Afficher les performances sur un excercice";

    private final static String ADD_SET =  "Ajouter un set";
    private final static String QUIT = "Quitter le programme" ;
    private final static String RETURN = "Retour au menu précédent";

    public final static String FOOTER = "--------------------- ############# ---------------------\n";

    // **************************************************
    // Fields
    // **************************************************
    public static Map<String,MenuItem> entriesLevelOne = new TreeMap<String, MenuItem>();
    public static Menu menuLevelOne = new Menu(TITLE_LEVEL_ONE, entriesLevelOne) ;

    public static Map<String,MenuItem> entriesLevelTwo = new TreeMap<String, MenuItem>();
    public static Menu menuLevelTwo = new Menu(TITLE_LEVEL_TWO, entriesLevelTwo) ;

    public static DataSet dataSet;

    public static final Scanner keyboard=new Scanner(System.in);

    // **************************************************
// Public methods
// **************************************************
    public static void main(String[] args) {
        int i ;
        String[] listOfSet ;
        Map<String,MenuItem> entriesLevelThree ;

        if (args[0] != null) {
            Path filePath = Path.of(args[0]);
            if (Files.exists(filePath)) {
                dataSet = new DataSet(filePath);
            }
        }

        entriesLevelOne.put("A",new AddSetAction(dataSet,ADD_SET));
        entriesLevelOne.put("B",menuLevelTwo);
        entriesLevelOne.put("C",new QuitAction(QUIT));
        listOfSet = Set.theListOfTypeSet() ;
        for( i=0; i< listOfSet.length; i++ ) {
            entriesLevelThree = new TreeMap<String, MenuItem>();
            entriesLevelThree.put("A",new StatOneAction(dataSet, listOfSet[i]));
            entriesLevelThree.put("B",new StatTwoAction(dataSet, listOfSet[i]));
            entriesLevelThree.put("C",new StatThreeAction(dataSet, listOfSet[i]));
            entriesLevelThree.put("D",new QuitAction(RETURN));
            entriesLevelTwo.put(""+(char)(64 +i+1), new Menu(listOfSet[i], entriesLevelThree));
        }
        entriesLevelTwo.put(""+(char)(64 +i+1), new QuitAction(RETURN));
        menuLevelOne.doIt() ;
    }
}

