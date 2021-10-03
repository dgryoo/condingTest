package programmers.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    // num의 팩토리얼값을 구하라 ex) factorial(5) = 5 * 4 * 3 * 2 * 1
    static int factorial(int num) {
        if(num == 1) return 1;

        num = num * factorial(num-1);

        return num;
    }

}
