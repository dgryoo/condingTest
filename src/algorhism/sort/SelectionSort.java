package algorhism.sort;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        int[] array = {1, 2, 7, 8, 3, 12, 6, 10, 5, 11, 9, 4};
        sort(array);
    }

    public static void sort(int[] array) {

        int lowIndex;

        for (int tempCount = 0; tempCount < array.length - 1; tempCount++) {
            lowIndex = tempCount;
            for (int searchIndex = tempCount + 1; searchIndex < array.length; searchIndex++) {
                if (array[lowIndex] > array[searchIndex]) {
                    lowIndex = searchIndex;
                }
            }
            int tempValue = array[tempCount];
            array[tempCount] = array[lowIndex];
            array[lowIndex] = tempValue;
            System.out.print("Time : " + tempCount + "  ");
            System.out.println(Arrays.toString(array));
        }


    }

}
