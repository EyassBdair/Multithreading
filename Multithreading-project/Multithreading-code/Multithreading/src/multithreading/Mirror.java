package multithreading;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Mirror implements Runnable {

    static long start = System.currentTimeMillis();
    static ArrayList<String> Words = new ArrayList<>();

    public Mirror(ArrayList<String> W) {
        Mirror.Words = W;
    }

    @Override
    public void run() {
        mirrorF(Words);
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void mirrorF(ArrayList<String> words) {
        System.out.println("start Mirror time : " + LocalDateTime.now());
        ArrayList<String> mirrors_word = new ArrayList<>();
        for (String word : words) {
            String r = reverseString(word);
            if (word.equals(r)) {
                mirrors_word.add(word);
            }
        }
        System.out.println("The mirror word is : ");
        for (String word : mirrors_word) {
            System.out.println(word);
        }
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.println("end Mirror time : " + LocalDateTime.now());
        System.out.println("Execution  for Mirror thread time is " + formatter.format((end - start) / 1000d) + " seconds");

    }
}
