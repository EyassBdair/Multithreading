package multithreading;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberOfWordsThread extends Thread {

    static long start = System.currentTimeMillis();
    static ArrayList<String> Words = new ArrayList<>();

    public DistinctNumberOfWordsThread(ArrayList<String> W) {
        AvgWord.Words = W;
    }

    @Override
    public void run() {
        System.out.println("start DistinctNumberOfWordsThread time : " + LocalDateTime.now());
        Map<String, Integer> map = new HashMap<>();
        for (String x : Words) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x + 1));
            }
        }
        System.out.println(map.size());

        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.println("end DistinctNumberOfWordsThread time : " + LocalDateTime.now());
        System.out.println("Execution  for DistinctNumberOfWordsThread thread time is " + formatter.format((end - start) / 1000d) + " seconds");

    }
}
