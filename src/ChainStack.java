/**
 * @author liaohong
 * @date 2018/7/6 14:10
 */
class StackChain {
    int data;
    StackChain next;
    int size = 0;

    public StackChain(int data, StackChain next) {
        this.data = data;
        this.next = next;
    }
}

public class ChainStack {
    public StackChain stackChain;

    /**
     * 判断栈是否为空/
     */
    public boolean isEmpty() {
        return stackChain.size == 0 ? true : false;
    }

    /**
     * 入栈
     */
    public void push(int data) {
        stackChain = new StackChain(data, stackChain);
        stackChain.size++;
    }

    /**
     * 出栈
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("空栈，无法出栈");
        } else {
            StackChain temp = stackChain;
            stackChain = stackChain.next;
            temp.next = null;
            System.out.println(temp.data);
            stackChain.size--;
        }
    }

    /**
     * 返回栈顶元素
     */
    public void peek() {
        if (isEmpty()) {
            System.out.println("空栈,没有元素");
        } else {
            System.out.println(stackChain.data);
        }
    }

    /**
     * 打印
     */
    public void print() {
        while (stackChain != null) {
            System.out.print(stackChain.data + " ");
            stackChain = stackChain.next;
        }
    }

    public static void main(String[] args) {
        ChainStack chainStack = new ChainStack();
        for (int i = 0; i < 10; i++) {
            chainStack.push(i);
        }
        chainStack.print();
        //chainStack.pop();
        //chainStack.peek();
    }
}
