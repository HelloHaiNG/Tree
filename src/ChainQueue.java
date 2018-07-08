/**
 * @author liaohong
 * @date 2018/7/6 17:16
 */
class QueueChain {
    int data;
    QueueChain next;

    public QueueChain() {
        this.next = null;
    }

    public QueueChain(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ChainQueue {
    QueueChain front;
    QueueChain rear;
    int maxSize;

    /**
     * 初始化队列
     */
    public void init() {
        front = new QueueChain();
        front.next = null;
        rear = new QueueChain();
        rear.next = null;
        maxSize = 0;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isNull() {
        if (front.next == null || rear.next == null)
            return true;
        else
            return false;
    }

    /**
     * 入队
     */
    public void push(int data) {
        QueueChain queueChain = new QueueChain(data);
        if (isNull()) {
            front.next = queueChain;
            rear.next = queueChain;
            maxSize++;
        } else {
            queueChain.next = front.next;
            front.next = queueChain;
            maxSize++;
        }
    }

    /**
     * 出队
     */
    public QueueChain pop() {
        if (isNull())
            return null;
        else if (maxSize == 1) {
            QueueChain node = front.next;
            init();
            return node;
        } else {
            QueueChain p = front;//使用p指针来遍历队列
            for (int i = 1; i < maxSize - 1; i++)
                p = p.next;
            QueueChain node = rear.next;
            rear.next = p.next;
            maxSize--;
            return node;
        }
    }

    public static void main(String[] args) {
        ChainQueue chainQueue = new ChainQueue();
        chainQueue.init();
        for (int i = 0; i < 9; i++) {
            chainQueue.push(i);
        }
        while (!chainQueue.isNull()) {
            System.out.print(chainQueue.pop().data + " ");
        }
    }

}
