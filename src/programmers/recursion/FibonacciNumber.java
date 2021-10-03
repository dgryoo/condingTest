package programmers.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    static int fibonacci(int num) {
        int answer = 0;

        if(num == 0) {
            answer = 0;
        } else if(num == 1) {
            answer = 1;
        } else {
            answer = fibonacci(num-1) + fibonacci(num -2);
            System.out.println(answer);
        }

        return answer;
    }

}


// LeetCode 509 Fibonacci Number
//    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
//    such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//        F(0) = 0, F(1) = 1
//        F(n) = F(n - 1) + F(n - 2), for n > 1.
//        Given n, calculate F(n).
