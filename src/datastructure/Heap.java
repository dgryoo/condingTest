package datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    public static void main(String[] args) {
        // Collections.swap(List list, int a, int b)
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }

    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        heapArray = new ArrayList<Integer>();
        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean moveUp(Integer insertedIndex) {
        if (insertedIndex <= 1) return false;

        Integer parentIndex = insertedIndex / 2;
        if (heapArray.get(insertedIndex) > heapArray.get(parentIndex)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int data) {

        // 데이터가 없을떄
        if (heapArray == null) {
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        // 데이터가 있을때때
        Integer insertedIndex = null;
        Integer parentIndex = null;

        heapArray.add(data);
        insertedIndex = heapArray.size() - 1;

        while (moveUp(insertedIndex)) {
            parentIndex = insertedIndex / 2;
            Collections.swap(heapArray, insertedIndex, parentIndex);
            insertedIndex = parentIndex;
        }
        return true;
    }

    public boolean moveDown(Integer poppedIndex) {
        Integer leftChildPoppedIndex = poppedIndex * 2;
        Integer rightChildPoppedIndex = poppedIndex * 2 + 1;

        // Case1 왼쪽 자식 노드도 없을떄 (완전 이진 트리 자식 노드가 하나도 없음)
        if (leftChildPoppedIndex >= heapArray.size()) {
            return false;
            // Case2 오른쪽 자식 노드만 없을 때
        } else if (rightChildPoppedIndex >= heapArray.size()) {
            if (heapArray.get(poppedIndex) < heapArray.get(leftChildPoppedIndex)) {
                return true;
            } else {
                return false;
            }
            // Case3 왼쪽, 오른쪽 모두 자식 노드가 있을 때
        } else {
            if (heapArray.get(leftChildPoppedIndex) > heapArray.get(rightChildPoppedIndex)) {
                if (heapArray.get(leftChildPoppedIndex) > heapArray.get(poppedIndex)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (heapArray.get(rightChildPoppedIndex) > heapArray.get(poppedIndex)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returnedData;
        Integer poppedIndex;
        Integer leftChildPoppedIndex;
        Integer rightChildPoppedIndex;

        if (heapArray == null) {
            return null;
        } else {
            returnedData = heapArray.get(1);
            heapArray.set(1, heapArray.get(heapArray.size() - 1));
            heapArray.remove(heapArray.size() - 1);

            poppedIndex = 1;
            while (moveDown(poppedIndex)) {
                leftChildPoppedIndex = poppedIndex * 2;
                rightChildPoppedIndex = poppedIndex * 2 + 1;

                // Case2 오른쪽 자식 노드만 없을 때
                if (rightChildPoppedIndex >= heapArray.size()) {
                    if (heapArray.get(leftChildPoppedIndex) > heapArray.get(poppedIndex)) {
                        Collections.swap(heapArray, poppedIndex, leftChildPoppedIndex);
                        poppedIndex = leftChildPoppedIndex;
                    }

                    // Case3 왼쪽, 오른쪽 모두 자식 노드가 있을 때
                } else {
                    if (heapArray.get(leftChildPoppedIndex) > heapArray.get(rightChildPoppedIndex)) {
                        if (heapArray.get(leftChildPoppedIndex) > heapArray.get(poppedIndex)) {
                            Collections.swap(heapArray, poppedIndex, leftChildPoppedIndex);
                            poppedIndex = leftChildPoppedIndex;
                        }
                    } else {
                        if (heapArray.get(rightChildPoppedIndex) > heapArray.get(poppedIndex)) {
                            Collections.swap(heapArray, poppedIndex, rightChildPoppedIndex);
                            poppedIndex = rightChildPoppedIndex;
                        }
                    }
                }


            }

            return returnedData;
        }
    }
}
