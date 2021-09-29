package datastructure;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.deleteNode(15));
        System.out.println("1. HEAD: " + myTree.root.value);
        System.out.println("2. HEAD LEFT: " + myTree.root.left.value);
        System.out.println("3. HEAD LEFT LEFT: " + myTree.root.left.left.value);
        System.out.println("4. HEAD LEFT RIGHT: " + myTree.root.left.right.value);

        System.out.println("5. HEAD RIGHT: " + myTree.root.right.value);
        System.out.println("6. HEAD RIGHT LEFT: " + myTree.root.right.left.value);
        System.out.println("7. HEAD RIGHT RIGHT: " + myTree.root.right.right.value);

        System.out.println("8. HEAD RIGHT RIGHT LEFT: " + myTree.root.right.right.left.value);
        System.out.println("9. HEAD RIGHT RIGHT RIGHT: " + myTree.root.right.right.right.value);


    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node recentNode = root;
            while (true) {
                if (recentNode.value == value) {
                    System.out.println("이미 해당 value가 존재합니다.");
                    return false;
                }
                if (value < recentNode.value) {
                    if (recentNode.left != null) {
                        recentNode = recentNode.left;
                    } else {
                        recentNode.left = new Node(value);
                        break;
                    }
                } else {
                    if (recentNode.right != null) {
                        recentNode = recentNode.right;
                    } else {
                        recentNode.right = new Node(value);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node searchNode(int data) {

        if (root == null) {
            return null;
        } else {
            Node recentNode = root;
            while (recentNode != null) {
                if (recentNode.value == data) return recentNode;
                else if (data < recentNode.value) {
                    recentNode = recentNode.left;
                } else {
                    recentNode = recentNode.right;
                }
            }
        }
        return null;
    }

    public boolean deleteNode(int data) {
        // 코너 케이스1: Node 가 하나도 없을 때
        if (root == null) {
            System.out.println("트리가 비어있습니다.");
            return false;
        }

        // 코너 케이스2: Node 가 단지 하나만 있고, 해당 Node 가 삭제할 Node 일 때
        if (root.value == data && root.left == null && root.right == null) {
            root = null;
            System.out.println("checkPoint7");
            return true;
        }

        // 나머지
        Node recentParentNode = null;
        Node recentNode = root;
        boolean search = false;

        while (recentNode != null) {
            if (recentNode.value == data) {
                search = true;
                break;
            } else if (data < recentNode.value) {
                recentParentNode = recentNode;
                recentNode = recentNode.left;
            } else {
                recentParentNode = recentNode;
                recentNode = recentNode.right;
            }
        }

        // 삭제할 노드가 없는 경우
        if (!search) return false;

        // Case1 : 삭제할 노드가 Leaf Node 인 경우
        if (recentNode.left == null && recentNode.right == null) {
            if (data < recentParentNode.value) {
                recentParentNode.left = null;
                recentNode = null;
            } else {
                recentParentNode.right = null;
                recentNode = null;
            }
            System.out.println("checkPoint6");
            return true;
        }

        // Case2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽에 Child Node 가 있을 경우)
        if (recentNode.left != null && recentNode.right == null) {
            if (data < recentParentNode.value) {
                recentParentNode.left = recentNode.left;
                recentNode = null;
            } else {
                recentParentNode.right = recentNode.left;
                recentNode = null;
            }
            System.out.println("checkPoint5");
            return true;
        }

        // Case2-2: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우 (오른쪽에 Child Node 가 있을 경우)
        if (recentNode.left == null && recentNode.right != null) {
            if (data < recentParentNode.value) {
                recentParentNode.left = recentNode.right;
                recentNode = null;
            } else {
                recentParentNode.right = recentNode.right;
                recentNode = null;
            }
            System.out.println("checkPoint4");
            return true;
        }

        // Case3 : 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.

        // Case3-1 : 삭제할 Node가 Parent Node 왼쪽에 있을 때
        if (data < recentParentNode.value) {
            Node changeNode = recentNode.right;
            Node changeParentNode = recentNode.right;
            while(changeNode.left != null) {
                changeParentNode = changeNode;
                changeNode = changeNode.left;
            }

            if(changeNode.right != null) {
                changeParentNode.left = changeNode.right;
            } else {
                changeParentNode.left = null;
            }

            recentParentNode.left = changeNode;

            changeNode.right = recentNode.right;
            changeNode.left = recentNode.left;

            recentNode = null;
            System.out.println("checkPoint3");
            return true;

        }

        // Case3-1 : 삭제할 Node가 Parent Node 오른쪽에 있을 때
        if (data > recentParentNode.value) {
            Node changeNode = recentNode.right;
            Node changeParentNode = recentNode.right;
            while(changeNode.left != null) {
                changeParentNode = changeNode;
                changeNode = changeNode.left;
            }

            if(changeNode.right != null) {
                changeParentNode.left = changeNode.right;
            } else {
                changeParentNode.left = null;
            }

            recentParentNode.right = changeNode;

            changeNode.right = recentNode.right;
            changeNode.left = recentNode.left;

            recentNode = null;

            System.out.println("checkPoint2");
            return true;

        }
        System.out.println("checkPoint1");
        return true;


    }

}
