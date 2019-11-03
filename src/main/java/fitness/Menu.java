/**
 * Classe Menu
 * Gère les libellés et l'affichage d'un menu
 *
 * @author Jean-Marc Noël
 * @version 1.0
 */

package fitness;

import java.util.Map;

public class Menu implements MenuItem {

    // **************************************************
    // Constants
    // **************************************************
    private final static String PROMPT = "Saisissez une lettre : ";

    // **************************************************
    // Fields
    // **************************************************
    private final String title;
    private final Map<String,MenuItem> entries;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Default constructor.
     * @param title Menu Title or label item
     * @param entries Map : Key + MenuItem
     */
    public Menu(String title, Map<String,MenuItem> entries) {
        this.title = title;
        this.entries = entries;
    }

    // **************************************************
    // Private methods
    // **************************************************

    // **************************************************
    // Public methods
    // **************************************************

    /**
     * Title of Menu / Item label
     *
     * @return MenuItem
     */
    public String getLabel() {
        return (title);
    }

    /**
     * Return a valid key in this menu
     *
     * @return key
     */
    public String getSelection() {
        String selection = "";
        do {
            System.out.print(PROMPT);
            selection = Main.keyboard.nextLine();
        } while (!entries.containsKey(selection.toUpperCase()));

        return (selection.toUpperCase());
    }

    /**
     * Action of menuitem
     * @Return boolean
     */
    public boolean doIt() {
        MenuItem item ;
        Boolean flag = true ;
        do {
            System.out.println(this.toString());
            item = entries.get(getSelection()) ;
            flag = item.doIt() ;
        } while(flag);
        return true ;
    }

    /**
     * toString
     * @Return String
     */
    public String toString() {
        StringBuilder result = new StringBuilder() ;

        result.append( title + "\n");
        entries.forEach((k, v) -> result.append( k + ". --> " + v.getLabel() + "\n" ));
        result.append( Main.FOOTER + "\n");
        return result.toString();
    }
}

