package datastructure;

import java.util.ArrayList;

public class MyStack<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size()-1);
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();

        myStack.push("A");
        myStack.push("B");
        myStack.push("C");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
