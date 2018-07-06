/**
 * @author liaohong
 * @date 2018/7/6 13:35
 */
class Stack {
    int data[];
    int top = -1;
    int maxSize;

    public Stack(int initialSize) {
        this.data = new int[initialSize];
        this.maxSize = initialSize;
        this.top = -1;
    }
}

public class LinkedStack {
    Stack stack;

    /**
     * 初始化栈
     **/
    public void init(int initialSize) {
        if (initialSize > 0) {
            stack = new Stack(initialSize);
        }
    }

    /**
     * 判断栈是否为空
     **/
    public boolean isEmpty() {
        return stack.top == -1 ? true : false;
    }

    /**
     * 判断栈是否已满
     **/
    public boolean isMax() {
        return stack.top >= stack.maxSize - 1 ? true : false;
    }

    /**
     * 入栈
     **/
    public void push(int data) {
        if (isMax()) {
            System.out.println("栈已满，不能入栈");
        } else {
            stack.top++;
            stack.data[stack.top] = data;
        }
    }

    /**
     * 出栈
     **/
    public void pop() {
        if (isEmpty()) {
            System.out.println("空栈，没有元素可以出栈");
        } else {
            stack.top--;
        }
    }

    /**
     * 返回当前栈顶元素
     **/
    public int peek() {
        if (isEmpty()) {
            System.out.println("当前空栈，无元素");
        } else {
            System.out.println(stack.data[stack.top]);
            return stack.data[stack.top];
        }
        return 0;
    }

    /**
     * 打印栈元素
     **/
    public void print() {
        if (isEmpty()) {
            System.out.println("空栈");
        } else {
            while (stack.top >= 0) {
                System.out.print(stack.data[stack.top] + " ");
                stack.top--;
            }
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.init(100);
        for (int i = 0; i < 10; i++) {
            linkedStack.push(i);
        }
        linkedStack.print();
        //linkedStack.pop();
        //linkedStack.print();
        //linkedStack.peek();
    }
}
