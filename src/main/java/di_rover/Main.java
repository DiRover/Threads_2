package di_rover;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<MyCallable> tasks = new ArrayList<>();
        tasks.add(new MyCallable(5, "Harry"));
        tasks.add(new MyCallable(5, "John"));
        tasks.add(new MyCallable(5, "Sam"));
        tasks.add(new MyCallable(5, "Taylor"));



        try (final ExecutorService threadPools = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            List<Future<Integer>> results = threadPools.invokeAll(tasks);
            for (Future<Integer> result : results) {
                System.out.println("Task completed with message count: " + result.get());
            }

            Integer singleResult = threadPools.invokeAny(tasks);
            System.out.println("Result from invokeAny: " + singleResult);
        }
    }
}