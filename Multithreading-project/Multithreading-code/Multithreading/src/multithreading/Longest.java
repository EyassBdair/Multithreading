package multithreading;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Longest implements Runnable {

    static long start = System.currentTimeMillis();
    static ArrayList<String> Words = new ArrayList<>();

    public Longest(ArrayList<String> W) {
        Longest.Words = W;
    }

    public static void Counter(ArrayList<String> words) {

        System.out.println("The number of words in the file is : " + (Words.size()));

    }

    public static void longestf(ArrayList<String> words) {
        System.out.println("start Longest time : " + LocalDateTime.now());

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

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("end Longest time : " + LocalDateTime.now());
        System.out.println("Execution  for Longest thread time is " + formatter.format((end - start) / 1000d) + " seconds");

    }

    @Override
    public void run() {
        Counter(Words);
        longestf(Words);
    }

}
