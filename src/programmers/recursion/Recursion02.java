package programmers.recursion;

public class Recursion02 {

    public static void main(String[] args) {
        System.out.println(function(5));
    }

    // 1부터 n까지의 합을 구하라
    static int function(int num) {
        if(num == 1) return 1;

        return num + function(num -1);
    }

}
