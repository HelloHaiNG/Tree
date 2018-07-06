class SqlList {
    int data;
    SqlList next;

    public SqlList(int data) {
        this.data = data;
    }
}

public class LinkedList {
    public SqlList sqlList;
    public SqlList temp;

    /**
     * 单链表赋值
     **/
    public void initList(int data[]) {
        for (int i = 0; i < data.length; i++) {
            if (sqlList == null) {
                sqlList = new SqlList(data[i]);
                temp = sqlList;
            } else {
                temp.next = new SqlList(data[i]);
                temp = temp.next;
            }
        }
    }

    /**
     * 插入结点
     **/
    public void insertList(int index, int data) {
        int length = lengthList();
        temp = sqlList;
        if (temp == null) {
            return;
        }
        if (index < 0 || index > length) {
            System.out.println("插入位置不对");
        }
        for (int i = 1; i <= length; i++) {
            if (i != index && temp.next != null) {
                temp = temp.next;
            } else {
                SqlList sqlList1 = new SqlList(data);
                sqlList1.next = temp.next;
                temp.next = sqlList1;
                return;
            }
        }
    }

    /**
     * 删除结点**
     */
    public void deleteList(int index) {
        int length = lengthList();
        temp = sqlList;
        if (temp == null) {
            return;
        }
        if (index < 0 || index > length) {
            System.out.println("删除位置不对");
        }
        if (index == length) {
            int i = 1;
            while (temp.next != null && i < length - 1) {
                temp = temp.next;
                i++;
            }
            temp.next = null;
            return;
        }
        for (int i = 2; i < length; i++) {
            if (i != index && temp.next != null) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
    }

    /**
     * 排序
     **/
    public void orderList() {
        if (lengthList() < 2) {
            System.out.println("无需排序");
            return;
        }
        temp = sqlList;
        while (temp.next != null) {
            SqlList sqlList1 = temp.next;
            while (sqlList1.next != null) {
                if (temp.next.data > sqlList1.next.data) {
                    int t = temp.next.data;
                    temp.next.data = sqlList1.next.data;
                    sqlList1.next.data = t;
                }
                sqlList1 = sqlList1.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 链表长度
     **/
    public int lengthList() {
        temp = sqlList;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        System.out.println("the length is:" + length);
        return length;
    }

    /**
     * 打印链表
     **/
    public void print() {
        temp = sqlList;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 6, 3, 7, 4};
        LinkedList linkedList = new LinkedList();
        linkedList.initList(array);
        linkedList.print();
        linkedList.insertList(7, 9);
        linkedList.print();
        linkedList.deleteList(7);
        linkedList.print();
        linkedList.orderList();
        linkedList.print();
    }
}
