/**
 * Class Set
 *
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

public class Set {

    // **************************************************
    // Constants
    // **************************************************
    private final static String[] LIST_OF_TYPE_SET = {"SQUAT", "LEG_EXTENSION", "LEG_CURL", "LEG_PRESS", "CRUNCH", "PLANK", "BENCH_PRESS", "TRICEPS_EXTENSION", "BICEPS_CURL"} ;

    // **************************************************
    // Fields
    // **************************************************
    private String type;
    private float weight;
    private int repetition;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * constructor
     *
     */
    Set() {
        this.type = "";
        this.weight = 0 ;
        this.repetition =0 ;
    }

    /**
     * constructor with value
     *
     * @param type
     * @param repetition
     * @param weight
     */
    Set(String type, int repetition, float weight) {
        this.type = type;
        this.weight = weight ;
        this.repetition =repetition ;
    }

    public String getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }

    public int getRepetition() {
        return repetition;
    }

    static public String[] theListOfTypeSet() {
        return LIST_OF_TYPE_SET;
    }
}