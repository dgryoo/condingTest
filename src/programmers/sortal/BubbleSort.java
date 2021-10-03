package programmers.sortal;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 9, 3, 1, 2, 8, 4, 7, 6};

        bubbleSort(a);

    }

    private static void bubbleSort(int[] a) {
        // 배열크기
        int size = a.length;

        // Round = 배열크기- 1 만큼 진행
        for (int i = 0; i < size - 1; i++) {

            // 정렬이 끝났을때 반복문 끝내기위한 변수
            boolean isSwap = false;

            // Round가 진행됨에따라 -1씩
            for (int j = size - 1; j > i; j--) {

                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSwap = true;
                }
            }
            for (int s = 0; s < a.length; s++) {
                System.out.print(a[s]);
            }
            System.out.println("  " +isSwap);
            if (isSwap == false) break;
        }
    }


}
