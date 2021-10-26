import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class TextAnalasys2 {

    // Encapsulated fields of object
    private String FileName;
    // I have not yet found a use of maxWords
    private int maxWords;
    public TextAnalasys2() {
        System.out.println("Test 2");
    }
    // constructor
    public TextAnalasys2(String sourceFileName, int maxNoOfWords) {
        System.out.println("test");
        this.FileName = sourceFileName;
        this.maxWords = maxNoOfWords;
        }
    
    // Recieve data from file
    private String[] getStringFromFile(){
        String[] arrayOfWords = new String[this.maxWords];
        try {
            System.out.println(this.FileName);
            File text = new File(this.FileName);
            Scanner readText = new Scanner(text);
            if(readText.nextLine().isEmpty()){
                readText.close();
                String[] emptyData = new String[0];
                return emptyData;
            }
            while (readText.hasNextLine()) {
                String tempLine = readText.nextLine().toUpperCase();
                int index = 0;
                for(int i =0;i<tempLine.split("[^a-zA-Z]+").length;i++){
                    arrayOfWords[index] = tempLine.split("[^a-zA-Z]+")[i];
                    index++;
                }
            }
            readText.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured reading the file");
            e.printStackTrace();
        }

        // We have now obtained an array of all the words - though we have an array that might be too big
        // We therefor create a new array with only words in it.
        int realSizeOfArray = 0;
        // Iterate through arrayOfWords to find size of "real" words.
        for(int i=0; i<arrayOfWords.length;i++){
            if(!(arrayOfWords[i] == null)){
                realSizeOfArray++;
            } else {
                break;
            }
        }
        // Create new array of words
        String[] realArrayOfWords = new String[realSizeOfArray];
        // Add elemts to new array
        for(int i =0;i<realArrayOfWords.length;i++){
            realArrayOfWords[i]=arrayOfWords[i];
        }

            return realArrayOfWords;
    }

    private String[] ArrayOfWords = getStringFromFile();

    
    public int wordCount() {
        return ArrayOfWords.length;
    }


    public int getNoOfDifferentWords(){
        //We will solve this method by using set interfaces : https://www.javatpoint.com/set-in-java
        Set<String> differentWords = new LinkedHashSet<String>();
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
            if (lastWord.equals(ArrayOfWords[i])){
                count++;
            }
            lastWord = ArrayOfWords[i];
        }
        return count;
    }
}


