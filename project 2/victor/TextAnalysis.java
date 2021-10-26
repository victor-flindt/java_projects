import java.io.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;  // Import this class to handle errors

public class TextAnalysis{

    BufferedInputStream bufferstream;

    public static void main(String[] args){
        
        String formula = get_text("hamlet.txt");
        
        Matcher m = Pattern.compile("(\\b[^\\s]+\\b)").matcher(formula);
        while (m.find()) {
            System.out.println(m.group(1));
        }

    }

    // constructor of the class
    public TextAnalysis(String sourceFileName, int maxNoOfWords) {
        // this.FileName = sourceFileName;
        // this.maxWords = maxNoOfWords;  
        // this.ArrayOfWords maybe use this array later ?
        }

    public static String get_text(String path){
            String text = "";
            try{    
            FileInputStream file_inputstream=new FileInputStream(path);    
            BufferedInputStream buffer_inputstream=new BufferedInputStream(file_inputstream);    
            int i;    
            while((i=buffer_inputstream.read())!=-1){    
                text=text+(char)i;
            }    
            buffer_inputstream.close();    
            file_inputstream.close();    
            }catch(Exception e){System.out.println(e);}    
            return text;
        }
                    // Methods // 
    public int wordCount(){

        return 1;
    }

    public int getNoOfDifferentWords(){

        return 1;
    }


    public int getNoOfRepetitions(){


        return 1;
    }



}