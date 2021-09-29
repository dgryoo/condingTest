package datastructure;

public class MyLinkedList<T> {

    Node<T> head = null;

    public void addNode(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(data);
        }

    }

    public void printAll() {
        if (head != null) {
            Node node = this.head;
            System.out.print(node.data);
            System.out.print(" ");
            while (node.next != null) {
                node = node.next;
                System.out.print(node.data);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public Node<T> search(T data) {
        if (head == null) return null;
        Node<T> node = head;
        while (node != null) {
            if (node.data == data) return node;
            node = node.next;
        }
        return null;
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchNode = search(isData);

        if (searchNode == null) {
            addNode(data);
        } else if (searchNode.next == null) {
            searchNode.next = new Node(data);
        } else {
            Node<T> newNode = new Node(data);
            Node<T> nextNode = searchNode.next;
            searchNode.next = newNode;
            newNode.next = nextNode;
        }
    }

    public boolean deleteNode(T data) {
        if (this.head == null) {
            System.out.println("리스트가 비어있습니다.");
            return false;
        } else {
            Node<T> node = head;
            if (node.data == data) {
                this.head = node.next;
                return true;
            } else {
                while (node.next != null) {
                    if (node.next.data == data) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                System.out.println("해당데이터가 없습니다.");
                return false;
            }
        }
    }

    static class Node<T> {
        T data;
        Node next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode("A");
        myLinkedList.addNode("B");
        myLinkedList.addNode("C");
        myLinkedList.addNode("E");
        myLinkedList.addNode("A");
        myLinkedList.addNodeInside("D", "C");
        myLinkedList.addNodeInside("F", "D");
        myLinkedList.addNodeInside("H", "HH");
        myLinkedList.printAll();
        myLinkedList.deleteNode("D");
        myLinkedList.printAll();
        myLinkedList.deleteNode("A");
        myLinkedList.printAll();
        myLinkedList.deleteNode("H");
        myLinkedList.printAll();
        myLinkedList.deleteNode("NOTEXIST");
        myLinkedList.printAll();







    }

}
