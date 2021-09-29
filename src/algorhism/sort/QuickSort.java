package algorhism.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] array = {4, 1, 2, 5, 7, 3, 6};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));

        System.out.println(splitFunc(list));
    }

    public static ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);
//        System.out.println("Pivot : " + pivot);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            if(dataList.get(index) < pivot) {
                leftArr.add(dataList.get(index));
            } else {
                rightArr.add(dataList.get(index));
            }
        }
//        if(pivot == 4) System.out.println(pivot);
        ArrayList<Integer> mergeArr = new ArrayList<>();
        mergeArr.addAll(splitFunc(leftArr));
        mergeArr.add(dataList.get(0));
        mergeArr.addAll(splitFunc(rightArr));
        System.out.println("Left : " + leftArr);
        System.out.println("Pivot : " + pivot);
        System.out.println("Right : " + rightArr);



        return mergeArr;
    }

}
