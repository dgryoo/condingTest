package algorhism.dpdc;

import java.util.Arrays;

public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(dynamicFibonacci(9 ));
    }

    public static int fibonacci(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;
        return fibonacci(num-1) + fibonacci(num-2);

    }

    public static int dynamicFibonacci(int num) {
        Integer[] cache = new Integer[num+1];
        cache[0] = 0;
        cache[1] = 1;
        // memoization
        for (int i = 2; i < num + 1; i++) {
            cache[i] = cache[i-1] + cache[i-2];
            System.out.println(Arrays.toString(cache));
        }
        return cache[num];
    }
}
