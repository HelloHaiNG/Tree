/**
 * @author liaohong
 * @date 2018/7/6 17:16
 */
class QueueChain {
    int data;
    QueueChain front;
    QueueChain rear;
    int maxSize;

    public QueueChain(int data) {
        this.data = data;
        this.front = null;
        this.rear = null;
        maxSize = 0;
    }
}

public class ChainQueue {
    QueueChain queueChain;

    /**
     * 判断队列是否为空
     */
    public boolean isNull() {
        if (queueChain.front == null || queueChain.rear == null)
            return true;
        else
            return false;
    }

}
