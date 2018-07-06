/**
 * @author liaohong
 * @date 2018/7/6 15:14
 */
class QueueLinked {
    int[] data;
    int front;
    int rear;
    int maxSize;

    public QueueLinked(int initialSize) {
        this.data = new int[initialSize];
        this.front = 0;
        this.rear = 0;
        this.maxSize = initialSize;
    }
}

public class LinkedQueue {
    public QueueLinked queueLinked;

    /**
     * 初始化队列
     */
    public void init(int initialSize) {
        if (queueLinked == null) {
            queueLinked = new QueueLinked(initialSize);
        }
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        if ((queueLinked.rear + 1) % queueLinked.maxSize == queueLinked.front) {
            return true;
        }
        return false;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isNull() {
        if (queueLinked.front == queueLinked.rear) {
            return true;
        }
        return false;
    }

    /**
     * 入队
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("队列已满，无法入队");
        } else {
            queueLinked.data[queueLinked.rear] = data;
            //System.out.print(queueLinked.data[queueLinked.rear]+" ");
            queueLinked.rear = (queueLinked.rear + 1) % queueLinked.maxSize;
        }
    }

    /**
     * 出队
     */
    public void pop() {
        if (isNull()) {
            System.out.println("队列为空，无法出队");
        } else {
            System.out.println(queueLinked.data[queueLinked.front]);
            queueLinked.front = (queueLinked.front + 1) % queueLinked.maxSize;
        }
    }

    /**
     * 打印队列
     */
    public void print() {
        if (isNull()) {
            System.out.println("队列为空");
        } else {
            while (!isNull()) {
                System.out.print(queueLinked.data[queueLinked.front] + " ");
                queueLinked.front = (queueLinked.front + 1) % queueLinked.maxSize;
            }
        }
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.init(100);
        for (int i = 0; i < 10; i++) {
            linkedQueue.push(i);
        }
        //linkedQueue.pop();
        linkedQueue.print();
    }
}
