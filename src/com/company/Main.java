package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //LOAD FILE, INITIALIZE BUFFEREDREADER
        File file = new File("E:\\Filer\\IntelliJ\\Projects\\WordCounter(MobyDick)\\src\\com\\company\\whale2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //SET CAN ONLY CONTAIN ONE INSTANCE OF A VALUE -> AUTO FORCES UNIQUENESS
        Set<String> uniqueWords = new HashSet<>();
        //MAP CONTAINS KEY-VALUE PAIRS -> CAN BE USED TO KEEP TALLY OF INDIVIDUAL WORDS
        Map<String, Integer> wordCounter = new HashMap<String, Integer>();

        //LOOP THROUGH EVERY LINE IN THE TXT
        String line = reader.readLine();
        while(line != null) {
            System.out.println("Reading line: " + line);

            //CHECKS IF THE LINE ISN'T EMPTY AND ADDS EVERY WORD TO STRING ARRAY
            if(!line.trim().equals("")) {
                String[] words = line.split(" ");

                /* GOES THROUGH THE STRING ARRAY
                REMOVING EVERY SPECIAL CHARACTER AND TRIES TO ADD IT TO THE SET,
                INCREASING THE CORRESPONDING VALUE IF THE KEY IF THE WORD HAS BEEN SEEN BEFORE
                OR OTHERWISE ADDS IT AS A NEW KEY
                 */
                for (String word : words) {
                    String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");
                    uniqueWords.add(cleanWord);

                    if(wordCounter.containsKey(cleanWord)) {
                        wordCounter.put(cleanWord, wordCounter.get(cleanWord) + 1);
                    } else {
                        wordCounter.put(cleanWord, 1);
                    }
                }
            }
            line = reader.readLine();
        }

        //PRINTS EVERY UNIQUE WORD
        uniqueWords.remove("");
        System.out.println();
        System.out.println("Set of unique words: " + uniqueWords + "\nNumber of unique words: " + uniqueWords.size());
        System.out.println();

        //SEARCH FOR SPECIFIC WORD
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Input word to search for");
            String word = scan.next().trim().toLowerCase();
            System.out.println(word + " appears " + wordCounter.get(word)+ " time(s). \n");
        }
    }
}
