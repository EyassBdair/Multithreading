package multithreading;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Smallest implements Runnable {

    static long start = System.currentTimeMillis();
    static ArrayList<String> Words = new ArrayList<>();

    public Smallest(ArrayList<String> W) {
        Smallest.Words = W;
    }

    @Override
    public void run() {
        smallestf(Words);
    }

    public static void smallestf(ArrayList<String> words) {
        System.out.println("start Smallest time : " + LocalDateTime.now());
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
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.println("end Smallest time : " + LocalDateTime.now());
        System.out.println("Execution  for Smallest thread time is " + formatter.format((end - start) / 1000d) + " seconds");

    }

}
