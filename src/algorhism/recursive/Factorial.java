package algorhism.recursive;

import java.util.ArrayList;

public class Factorial {

    public static void main(String[] args) {

        ArrayList<Integer> testData = new ArrayList();
        for (int data = 0; data < 10; data++) {
            testData.add(data);
        }
        System.out.println(factorialFunc(testData));
    }

    public static int factorial(int num) {
        int value = 1;
        for (int i = num; i > 1; i--) {
            value = value * i;
        }
        return value;
    }

    public static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }

    public static int factorialFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + factorialFunc(new ArrayList<>(dataList.subList(1, dataList.size())));
    }

}
