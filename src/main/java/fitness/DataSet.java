/**
 * Class DataSet
 * Gère le stockage des exercices
 * @author Jean-Marc Noël
 * @version 1.0
 */
package fitness;

import java.io.*;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DataSet {

    // **************************************************
    // Constants
    // **************************************************
    private final static String LOADING_START = "Chargement de %s ...";
    private final static String LOADING_END = " effectué";
    private final static String SEPARATOR = ";";
    private final static String READ = "Une erreur est survenue lors de la lecture du fichier : ";
    private final static String WRITE = "Une erreur est survenue lors de l'écriture du fichier : ";

    private final static String MAX_WEIGHT = "poids max soulevé :  %s kg";
    private final static String AV_WEIGHT = "poids moyen soulevé :  %s kg ";
    private final static String MAX_REPS = "nombre max de répétition : %s reps";
    private final static String AV_REPS = "nombre moyen de répétitions : %s reps ";
    private final static String MAX_WEIGHT_SET = "poids max soulevé par set : %s kg";
    private final static String AV_WEIGHT_SET = "poids moyen soulevé par set : %s kg ";

    // **************************************************
    // Fields
    // **************************************************
    private final List<Set> dataset;
    private final Path filePath;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Default constructor.
     * @param filePath Path of the file to store data
     */
    DataSet(Path filePath) {
        this.filePath = filePath;
        dataset = new ArrayList<Set>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            String[] splitLine;
            System.out.print(String.format(LOADING_START, filePath.getFileName()));
            line = reader.readLine();
            while (line != null) {
                line = line.toUpperCase();
                splitLine = line.split(SEPARATOR);
                dataset.add(new Set(splitLine[0], Integer.parseInt(splitLine[1]), Float.parseFloat(splitLine[2])));
                line = reader.readLine();
            }
            System.out.println(LOADING_END);
        } catch (IOException ioEx) {
            System.err.println(READ + filePath);
        }
    }

    // **************************************************
    // Public methods
    // **************************************************

    /**
     * Add
     *
     * @param newSet
     */
    public void add(Set newSet) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(),true))) {
            writer.write( newSet.getType() + ";" +newSet.getRepetition() + ";" + newSet.getWeight() );
            writer.newLine();
            writer.flush();
            dataset.add(newSet);
        } catch (IOException ioEx) {
            System.err.println(WRITE + filePath);
        }
    }

    /**
     * Size of the dataset
     * @Return int
     */
    public int size() {
        return dataset.size();
    }

    /**
     * statOne
     * @param key
     * @Return string
     */
    public String statOne(String key){
        StringBuilder result = new StringBuilder() ;
        float maxWeight = 0f ;
        int nbRep = 0 ;
        float weight = 0f ;

        for(Set testSet : dataset) {
            if(testSet.getType().equals(key)) {
                if (testSet.getWeight() > maxWeight) maxWeight = testSet.getWeight();
                nbRep += testSet.getRepetition();
                weight += testSet.getRepetition() * testSet.getWeight();
            }
        }
        result.append(String.format(AV_WEIGHT,  new DecimalFormat("#.#").format(weight/nbRep)  ));
        result.append(String.format(MAX_WEIGHT, maxWeight));
        return result.toString() ;
    }

    /**
     * statTwo
     * @param key
     * @Return string
     */
    public String statTwo(String key){
        StringBuilder result = new StringBuilder() ;
        int maxRep = 0 ;
        int nbRep = 0 ;
        int sumRep = 0 ;

        for(Set testSet : dataset) {
            if(testSet.getType().equals(key)) {
                if(testSet.getRepetition()>maxRep ) maxRep = testSet.getRepetition() ;
                nbRep += 1  ;
                sumRep += testSet.getRepetition() ;
            }
        }

        result.append(String.format(AV_REPS,  new DecimalFormat("#").format(sumRep/nbRep)  ));
        result.append(String.format(MAX_REPS, maxRep));
        return result.toString() ;
    }

    /**
     * statThree
     * @param key
     * @Return string
     */
    public String statThree(String key){
        StringBuilder result = new StringBuilder() ;
        float maxWeight = 0f ;
        int nbRep = 0 ;
        float weight = 0f ;

        for(Set testSet : dataset) {
            if(testSet.getType().equals(key)) {
                if((testSet.getWeight()*testSet.getRepetition())> maxWeight ) maxWeight = testSet.getWeight()*testSet.getRepetition() ;
                nbRep += 1  ;
                weight += testSet.getRepetition() * testSet.getWeight() ;
            }
        }

        result.append(String.format(AV_WEIGHT_SET,  new DecimalFormat("#.#").format(weight/nbRep)  ));
        result.append(String.format(MAX_WEIGHT_SET,new DecimalFormat("#").format(maxWeight) ));
        return result.toString() ;
    }
}

