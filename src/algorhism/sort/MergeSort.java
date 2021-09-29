package algorhism.sort;

import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        System.out.println(mSort.mergeSplitFunc(testData));

    }


    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {
            if (leftList.get(leftIndex) < rightList.get(rightIndex)) {
                mergedList.add(leftList.get(leftIndex));
                leftIndex++;
            } else {
                mergedList.add(rightList.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < leftList.size()) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < rightList.size()) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex++;
        }

        return mergedList;
    }


}
