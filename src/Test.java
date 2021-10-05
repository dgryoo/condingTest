import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        int[][] test = {{1, 3, 5, 7, 9}, {10, 15, 17, 18, 19}, {21, 23, 25, 28, 29}, {31, 35, 36, 38, 39}};
//
//        System.out.println(func(test, 31));
        List<Integer> a = new LinkedList<>();
        a.add(1);

//        a.set(0, 2);

        System.out.println(a.get(0));
    }


    public static int func(int[][] array, int data) {
        for (int index = 0; index < array.length; index++) {
            if(array[index][array[index].length-1] == data) {
                return array[index][array[index].length-1];
            }

            if(array[index][array[index].length-1] < data) {
                for(int index2 = 0; index2 <array[index].length; index2 ++) {
                    if(array[index][index2] == data) {
                        return array[index][index2];
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
