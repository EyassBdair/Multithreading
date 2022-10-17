package multithreading;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AvgWord implements Runnable {

    static long start = System.currentTimeMillis();

    static ArrayList<String> Words = new ArrayList<>();

    public AvgWord(ArrayList<String> W) {
        AvgWord.Words = W;
    }

    @Override
    public void run() {
        avg(Words);
    }

    public static void avg(ArrayList<String> words) {
        System.out.println("start AvgWord time : " + LocalDateTime.now());
        double sum = 0;
        for (String word : Words) {
            sum += word.length();
        }
        System.out.println("The AVG word length is : " + sum / Words.size());
        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.println("end AvgWord time : " + LocalDateTime.now());
        System.out.println("Execution  for AvgWord thread time is " + formatter.format((end - start) / 1000d) + " seconds");

    }

}
