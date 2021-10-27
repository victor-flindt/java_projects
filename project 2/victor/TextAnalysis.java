import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalysis{
    //  BufferedInputStream bufferstream; the number should be a multiple of 1024, the bigger the faster
    //  but the bigger the number the more memeory hungry the program will get.   
    //  1024000 corrosponds to 1 mb     
    int buffer_size = 1024000; 
    String filename;
    int maxwords;
    Set<String> unique_words = new LinkedHashSet<String>();
    ArrayList<String> words = new ArrayList<String>();
    public static void main(String[] args){

        TextAnalysis ta = new TextAnalysis("hamlet.txt",1000);
        // System.out.println(ta.wordCount());
        // System.out.println(ta.getNoOfDifferentWords());
        System.out.println(ta.getNoOfRepetitions());
    }
    // constructor of the class
    public TextAnalysis(String sourceFileName, int maxNoOfWords) {
        this.filename = sourceFileName;
        this.maxwords = maxNoOfWords;
        }

                // Methods // 
    public int wordCount(){
        int counter=0;
        try {
            StringBuilder text_chunk = new StringBuilder();
            FileInputStream file = new FileInputStream(filename);
            // Creates a BufferedInputStream
            BufferedInputStream buffer = new BufferedInputStream(file);
            // Reads the first byte from input stream
            int i = buffer.read();
            while (i != -1) {
                text_chunk.append((char) i);
                // Reads next byte from the input stream
                i = buffer.read();
                if (i==-1){
                    Matcher m = Pattern.compile("(\\b[^\\s]+\\b)").matcher(text_chunk);
                    while(m.find()){
                        // a list of words and unique words are made here such that 
                        // the whole document wont have to searched again. 
                        words.add(m.group(0));
                        // using LinkedHashSet since you cant add the same entry twice
                        // making for a nice implementation of storing only unique words.
                        unique_words.add(m.group(0));
                        counter++;
                    }
                }
            }
            // Closes the input stream
            buffer.close();
         }
         catch (Exception e) {
            e.getStackTrace();
         }
         return counter;
      }

    public int getNoOfDifferentWords(){
        // if the list does not contains any entries it will run wordCount 
        if(unique_words.size() <= 0){
            wordCount();
        }
        return unique_words.size()+1;
    }

    public int getNoOfRepetitions(){
        // if the list does not contains any entries it will run wordCount 
        if(words.size()<=0){
            wordCount();
        }
        int counter=0;
            for (int i = 0; i < words.size()-1; i++) {
                if(words.get(i).equals(words.get(i+1))){
                    counter++;
                }
            }
        return counter;
    }
}