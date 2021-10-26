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
        private String[] ArrayOfWords;

        
        // constructor
        public TextAnalysis(String sourceFileName, int maxNoOfWords) {
            this.FileName = sourceFileName;
            this.maxWords = maxNoOfWords;
            this.ArrayOfWords = getStringFromFile();
            }
        
        // Recieve data from file
        private String[] getStringFromFile(){
            String[] arrayOfWords = new String[this.maxWords];

            //check if file is empty
            try {
                String data = "";
                File testText = new File(this.FileName);
                Scanner readTestText = new Scanner(testText);
                if (readTestText.hasNextLine()) {
                    data += readTestText.nextLine();
                    readTestText.close();
                }
                if (data.isEmpty()){
                    String[] emptyData = new String[0];
                    readTestText.close();
                    return emptyData;
                }

            } catch (FileNotFoundException e) {
                System.out.println("An error occured reading the file");
                e.printStackTrace();
            }


            try {
                File text = new File(this.FileName);
                Scanner readText = new Scanner(text);
                int index = 0;
                while (readText.hasNextLine()) {
                    String tempLine = readText.nextLine().toUpperCase();
                    for(int i =0;i<tempLine.split("[^a-zA-Z]+").length;i++){
                        //if string is empty skip it
                        if(tempLine.split("[^a-zA-Z]+")[i].isEmpty()){
                            continue;
                        }
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
            for(int i = 0;i<realArrayOfWords.length;i++){
                realArrayOfWords[i]=arrayOfWords[i];
            }
                return realArrayOfWords;
        }

        
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


