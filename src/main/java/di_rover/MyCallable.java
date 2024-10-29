package di_rover;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private final int iterations;
    private final String name;

    public MyCallable(int iterations, String name) {
        this.iterations = iterations;
        this.name = name;
    }

    @Override
    public Integer call() {
        int messageCount = 0;

        for (int i = 0; i < iterations; i++) {
            System.out.println("Hello! My name is " + name);
            messageCount++;
        }

        return messageCount;
    }
}
