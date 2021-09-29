package datastructure;

import java.util.ArrayList;

public class MyQueue<T> {

    private ArrayList<T> queue = new ArrayList<>();

    public void enQueue(T item) {
        queue.add(item);
    }

    public T deQueue() {
        if(queue.size() == 0) {
            return null;
        }

        return queue.remove(0);
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();

        myQueue.enQueue("A");
        myQueue.enQueue("B");
        myQueue.enQueue("C");

        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
    }
}
