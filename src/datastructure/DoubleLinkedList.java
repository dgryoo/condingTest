package datastructure;

public class DoubleLinkedList<T> {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addNode("A");
//        doubleLinkedList.addNode("B");
//        doubleLinkedList.addNode("C");
//        System.out.println(doubleLinkedList.insertToFront("B","AA"));
//
//        doubleLinkedList.printAll();
        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(3);
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(5);
        doubleLinkedList.printAll();
        System.out.println("----------------");

        doubleLinkedList.insertToFront(3, 2);
        doubleLinkedList.printAll();
        System.out.println("----------------");

        doubleLinkedList.insertToFront(6, 2);
        doubleLinkedList.insertToFront(1, 0);
        doubleLinkedList.printAll();
        System.out.println("----------------");

        doubleLinkedList.addNode(6);
        doubleLinkedList.printAll();




    }

    DoubleNode<T> head = null;
    DoubleNode<T> tail = null;

    public void addNode(T data) {
        if (this.head == null) {
            head = new DoubleNode<>(data);
            tail = head;
        } else {
            DoubleNode<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new DoubleNode<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public T searchFromHead(T data) {
        if (head == null) {
            System.out.println("리스트가 비어있습니다.");
            return null;
        } else {
            DoubleNode<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            System.out.println("해당 데이터가 없습니다.");
            return null;
        }
    }

    public T searchFromTail(T data) {
        if (tail == null) {
            System.out.println("리스트가 비어있습니다.");
            return null;
        } else {
            DoubleNode<T> node = this.tail;
            while (node.prev != null) {
                if (node.data == data) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            System.out.println("해당 데이터가 없습니다.");
            return null;
        }
    }
        public boolean insertToFront(T existData, T addData) {
        if (head == null) {
            head = new DoubleNode<>(addData);
            tail = head;
            return true;
        } else if (head.data == existData) {
            DoubleNode newHead = new DoubleNode<>(addData);
            newHead.next = head;
            newHead.next.prev = newHead;
            this.head = newHead;
            return true;
        } else {
            DoubleNode<T> node = head;
            while (node != null) {
                if (node.data == existData) {
                    DoubleNode<T> prevNode = node.prev;
                    prevNode.next = new DoubleNode<>(addData);
                    prevNode.next.next = node;
                    prevNode.next.prev = prevNode;
                    prevNode.next.next.prev = prevNode.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }
//    public boolean insertToFront(T existedData, T addData) {
//        if (this.head == null) {
//            this.head = new DoubleNode<>(addData);
//            this.tail = this.head;
//            return true;
//        } else if (this.head.data == existedData) {
//            DoubleNode<T> newHead = new DoubleNode<T>(addData);
//            newHead.next = this.head;
//            this.head = newHead;
//            return true;
//        } else {
//            DoubleNode<T> node = this.head;
//            while (node != null) {
//                if (node.data == existedData) {
//                    DoubleNode<T> nodePrev = node.prev;
//
//                    nodePrev.next = new DoubleNode<T>(addData);
//                    nodePrev.next.next = node;
//
//                    nodePrev.next.prev = nodePrev;
//                    node.prev = nodePrev.next;
//                    return true;
//                } else {
//                    node = node.next;
//                }
//            }
//            return false;
//        }
//    }
    public void printAll() {
        if (head != null) {
            DoubleNode<T> node = head;
            System.out.print(head.data);
            System.out.print(" ");
            while (node.next != null) {
                node = node.next;
                System.out.print(node.data);
                System.out.print(" ");
            }
        } else {
            System.out.println("리스트가 비어있습니다.");
        }
        System.out.println("");
    }

    public class DoubleNode<T> {
        T data;
        DoubleNode<T> prev;
        DoubleNode<T> next;

        public DoubleNode(T data) {
            this.data = data;
        }
    }


}
