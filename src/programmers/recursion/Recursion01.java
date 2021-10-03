package programmers.recursion;

public class Recursion01 {



    public static void main(String[] args) {

        function(5);

    }


    // 재귀호출을 이용하여 n만큼 Hi 를 출력하라.
    static void function(int num) {


        if(num > 0) {
            System.out.println("Hi");
            function(num-1);
        }
    }

}
