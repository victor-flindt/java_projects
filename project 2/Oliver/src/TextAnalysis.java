import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class TextAnalysis {

    // Encapsulated fields of object
    private String FileName;
    // I have not yet found a use of maxWords
    private int maxWords;

    // constructor
    public TextAnalysis(String sourceFileName, int maxNoOfWords) {
        this.FileName = sourceFileName;
        this.maxWords = maxNoOfWords;
        
    }

    // Recieve data from file
    private String[] getStringFromFile(){
        String data = "";
        try {
            File text = new File(FileName);
            Scanner readText = new Scanner(text);
            while (readText.hasNextLine()) {
                data += readText.nextLine();
                data += " ";
            }
            readText.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured reading the file");
            e.printStackTrace();
        }
        if (data.isEmpty()){
            String[] emptyData = new String[0];
            return emptyData;
        } else{
            String[] arrayOfWords = new String[data.split("[^a-zA-Z]+").length];
            for (int i =0; i<data.split("[^a-zA-Z]+").length;i++ ){
               arrayOfWords[i] = data.split("[^a-zA-Z]+")[i].toUpperCase();
            }
            return arrayOfWords;
        }
    }

    
    public int wordCount() {
        return getStringFromFile().length;
    }


    public int getNoOfDifferentWords(){
        //We will solve this method by using set interfaces : https://www.javatpoint.com/set-in-java
        Set<String> differentWords = new LinkedHashSet<String>();
        String[] ArrayOfWords = getStringFromFile();
        // A different solution is using ArrayList (not sure which one is best)
        ArrayList<String> diffWords = new ArrayList<String>();
        for(int i=0; i<wordCount();i++){
            // For the set interface we just add to it, as a set doesn't allow duplicates and thus will not add a new one
            differentWords.add(ArrayOfWords[i]);

            // For the arraylist we need to compare before we add.
           if(!(diffWords.contains(ArrayOfWords[i]))){
                diffWords.add(ArrayOfWords[i]);
            }
        }
        return differentWords.size();
    }


    public int getNoOfRepetitions(){
        String lastWord = "";
        int count = 0;

        for (int i=0; i<wordCount();i++){
            if (lastWord.equals(getStringFromFile()[i])){
                count++;
            }
            lastWord = getStringFromFile()[i];
        }
        return count;
    }
}