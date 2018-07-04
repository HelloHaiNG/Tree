import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//二叉树的建树，前中后 递归非递归遍历 层序遍历
//Node节点
class Node {
    int element;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int element) {
        this.element = element;
    }
}

// BinaryTree
public class Tree {
    // creat tree from array
    public static Node creatTree(int[] data, int i) {
        if (i < data.length) {
            Node temp = new Node(data[i]);
            temp.left = creatTree(data, i + 3);
            temp.right = creatTree(data, i + 3);
            return temp;
        }
        return null;
    }

    // pre前序遍历递归
    public static void pre(Node temp) {
        if (temp == null)
            return;
        System.out.print(temp.element + " ");
        pre(temp.left);
        pre(temp.right);
    }

    // mid中序遍历递归
    public static void mid(Node temp) {
        if (temp == null)
            return;
        mid(temp.left);
        System.out.print(temp.element + " ");
        mid(temp.right);
    }

    // last后序遍历递归
    public static void last(Node temp) {
        if (temp == null)
            return;
        last(temp.left);
        last(temp.right);
        System.out.print(temp.element + " ");
    }

    // pre1前序遍历非递归
    public static void pre1(Node temp) {
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                System.out.print(temp.element + " ");
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop().right;
            }
        }
    }

    // mid1中序遍历非递归
    public static void mid1(Node temp) {
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                System.out.print(temp.element + " ");
                temp = temp.right;
            }
        }
    }

    // last1后序遍历非递归
    public static void last1(Node temp) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                stack2.push(temp);
                temp = temp.right;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop().left;
            }
        }
        while (!stack2.isEmpty())
            System.out.print(stack2.pop().element + " ");
    }

    // 层序遍历
    public static void ceng(Node temp) {
        if (temp == null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.element + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
    }

    // Demo
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 10, 13};
        Node tree = creatTree(array, 0);
        System.out.println("测试结果：");
        pre(tree);
        System.out.println();
        pre1(tree);
        System.out.println();
        mid(tree);
        System.out.println();
        mid1(tree);
        System.out.println();
        last(tree);
        System.out.println();
        last1(tree);
        System.out.println();
        ceng(tree);
    }
}