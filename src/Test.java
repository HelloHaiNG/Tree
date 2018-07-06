class Nodee<T> {

    public T data;
    public Nodee next;

    public Nodee(T data) {
        this.data = data;
    }
}
public class Test {

    public Nodee head;
    public Nodee current;

    public void add(int data) {

        //如果头结点为空,为头结点
        if(head == null) {
            head = new Nodee(data);
            current = head;
        } else {
            current.next = new Nodee(data);
            current = current.next;
        }
    }

    //打印链表
    public void print(Nodee node) {
        if(node == null) {
            return;
        }

        current = node;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    //初始化链表,并且返回表头
    public Nodee init() {
        for(int i=0; i<10; i++) {
            this.add(i);
        }
        return head;
    }

    //求链表长度
    public int get_length(Nodee head) {
        if (head == null) {
            return -1;
        }

        int length = 0;
        current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public static void main(String[] args) {
        Test list = new Test();
        Nodee head = list.init();
        list.print(head);

        int length = list.get_length(head);
        System.out.println();
        System.out.println("The length of list is: " + length);
    }


}
