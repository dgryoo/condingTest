package programmers.DynamicProgramming;

public class DynamicFibo {

    static int[] memo;

    public static void main(String[] args) {
        memo = new int[8];
        System.out.println(fibonacci(7));

        for (int m : memo) {
            System.out.println(m);
        }
    }

    static int fibonacci(int num) {
        if (num <= 1)
            return num;
        else if (memo[num] != 0)
            return memo[num];
        else
            return memo[num] = fibonacci(num - 1) + fibonacci(num - 2);
    }
}
