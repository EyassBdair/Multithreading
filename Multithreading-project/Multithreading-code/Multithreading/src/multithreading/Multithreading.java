package multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Multithreading {

    static ArrayList<String> Words = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        long start = System.currentTimeMillis();
        File file = new File("C:\\Users\\DELL\\Desktop\\words.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            Words.add(st);
        }

        System.out.println("""
                           for Multithreading -> ( 1 ) 
                             for sequentially  - > ( 2 )    
                           input : """);
        int input = in.nextInt();

        if (input == 1) {

            Smallest small = new Smallest(Words);
            Mirror mirror = new Mirror(Words);
            Longest Long = new Longest(Words);
            AvgWord Avgword = new AvgWord(Words);
            DistinctNumberOfWordsThread distinctNumberOfWordsThread = new DistinctNumberOfWordsThread(Words);
            Thread t1 = new Thread(small);
            Thread t2 = new Thread(mirror);
            Thread t3 = new Thread(Long);
            Thread t4 = new Thread(Avgword);
            Thread t5 = new Thread(distinctNumberOfWordsThread);
            t2.start();
            t1.start();
            t3.start();
            t4.start();
            t5.start();

        } else {

            smallest(Words);
            mirror(Words);
            counter(Words);
            longest(Words);
            avg(Words);
            long end = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("start time : " + LocalDateTime.now());
            System.out.println("end time : " + LocalDateTime.now());
            System.out.println("Execution  for Mirror thread time is " + formatter.format((end - start) / 1000d) + " seconds");

        }

    }

    public static void avg(ArrayList<String> words) {
        double sum = 0;
        for (String word : Words) {
            sum += word.length();
        }
        System.out.println("The AVG word length is : " + sum / Words.size());
    }

    public static void longest(ArrayList<String> words) {
        if (words.isEmpty() || words.size() < 1) {
            System.out.println("null");

        }
        int max = -999;
        ArrayList<String> longest = new ArrayList<>();
        for (String word : Words) {
            if (word.length() > max) {
                max = word.length();
            }
        }

        for (String word : Words) {
            if (word.length() == max) {
                longest.add(word);
            }
        }
        System.out.println("The longest word is : ");
        for (String word : longest) {
            System.out.println(word);
        }

    }

    public static void counter(ArrayList<String> words) {
        System.out.println("The number of words in the file is : " + (Words.size()));
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void mirror(ArrayList<String> words) {
        ArrayList<String> mirrors_word = new ArrayList<>();
        for (String word : words) {
            String r = reverseString(word);
            if (word.equals(r)) {
                mirrors_word.add(word);
            }
        }
        System.out.println("The mirror word is : ");
        // System.out.println(mirrors_word);
        for (String word : mirrors_word) {
            System.out.println(word);
        }
    }

    public static void smallest(ArrayList<String> words) {

        if (words.isEmpty() || words.size() < 1) {
            System.out.println("null");

        }
        ArrayList<String> shortest = new ArrayList<>();
        for (String word : Words) {
            if (word.length() <= 1) {
                shortest.add(word);
            }
        }
        System.out.println("The shortest word is : ");
        for (String word : shortest) {
            System.out.println(word);
        }
    }

    public static void DistinctNumberOfWordsThre(ArrayList<String> words) {

        Map<String, Integer> map = new HashMap<>();
        for (String x : Words) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x + 1));
            }
        }
        System.out.println(map.size());

    }
    //     System.out.println(shortest);

}
