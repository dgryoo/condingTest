package algorhism.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[100];

        for (int index = 0; index < 100; index++) {
            array[index] = (int)(Math.random() * 100);
        }

        insertion_sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertion_sort(int[] array) {

        for (int count = 0; count < array.length -1; count++) {
            for(int temp = count + 1; temp > 0; temp--) {
                if(array[temp] < array[temp-1]) {
                    int tempValue = array[temp-1];
                    array[temp-1] = array[temp];
                    array[temp] = tempValue;
                }
            }
        }

    }

}
