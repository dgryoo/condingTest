package lab;

// ArrayList와 LinkedList의 조회, 삽입, 삭제 시간

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedList {
    static long beforeTime, afterTime, diffTime;

    public static void main(String[] args) {
//        long beforeTime = System.currentTimeMillis();
//
//        int sum = 0;
//        for (int i = 0; i < 1000000; i++) {
//            for (int j = 0; j < 50000; j++) {
//                sum += i*j;
//            }
//        }
//        System.out.println(sum);
//
//        long afterTime = System.currentTimeMillis();
//        long secDiffTime = (afterTime - beforeTime)/1000;
//        System.out.println("시간차이(m) : "+secDiffTime);

        ArrayList<Integer> arrayList = new ArrayList();
        LinkedList<Integer> linkedList = new LinkedList<>();

        beforeTime = System.currentTimeMillis();
        for (int i = 0; i <= 30000000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Test 1 : 마지막 데이터인 10000000번째 데이터 조회
        beforeTime = System.currentTimeMillis();
        arrayList.get(15000000);
        afterTime = System.currentTimeMillis();
        diffTime = (afterTime - beforeTime) % 1000;
        System.out.println("ArrayList 조회시간 : " + diffTime);

        beforeTime = System.currentTimeMillis();
        linkedList.get(15000000);
        afterTime = System.currentTimeMillis();
        diffTime = (afterTime - beforeTime)  % 1000;
        System.out.println("LinkedList 조회시간 : " + diffTime);

        // Test 2 : 첫번째 index에 데이터 삽입시
        beforeTime = System.currentTimeMillis();
        arrayList.add(15000000, 777);
        afterTime = System.currentTimeMillis();
        diffTime = (afterTime - beforeTime) % 1000;
        System.out.println("ArrayList 삽입시간 : " + diffTime);

        beforeTime = System.currentTimeMillis();
        linkedList.add(15000000, 777);
        afterTime = System.currentTimeMillis();
        diffTime = (afterTime - beforeTime) % 1000;
        System.out.println("LinkedList 삽입시간 : " + diffTime);


    }
}
