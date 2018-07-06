/**
 * @author liaohong
 * @date 2018/7/6 9:05
 */
class DuSqlList {
    int data;
    DuSqlList front;
    DuSqlList next;

    public DuSqlList(int data) {
        this.data = data;
    }
}

public class DuLinkList {
    public DuSqlList duSqlList;
    public DuSqlList temp;

    /**
     * 初始化双链表
     **/
    public void initList(int data[]) {
        DuSqlList temp1;
        for (int i = 0; i < data.length; i++) {
            if (duSqlList == null) {
                duSqlList = new DuSqlList(data[i]);
                duSqlList.front = null;
                duSqlList.next = null;
                temp = duSqlList;
            } else {
                temp.next = new DuSqlList(data[i]);
                temp.next.next = null;
                temp1 = temp.next;
                temp1.front = temp;
                temp = temp.next;
            }
        }
        print();
    }

    /**
     * 插入结点
     **/
    public void insertNode(int index, int data) {
        DuSqlList temp1;
        int sum = 1;
        if (index < 0 || index > lengthList()) {
            System.out.println("插入位置不对");
        } else {
            if (index == lengthList()) {
                temp = duSqlList;
                while (temp != null) {
                    if (sum == index) {
                        DuSqlList duSqlList1 = new DuSqlList(data);
                        temp.next = duSqlList1;
                        duSqlList1.front = temp;
                        duSqlList1.next = null;
                        print();
                        return;
                    } else {
                        sum++;
                        temp = temp.next;
                    }
                }
            } else if (index < lengthList()) {
                temp = duSqlList;
                while (temp.next != null) {
                    if (sum != index) {
                        sum++;
                        temp = temp.next;
                    } else {
                        DuSqlList duSqlList1 = new DuSqlList(data);
                        temp1 = temp.next;
                        temp.next = duSqlList1;
                        duSqlList1.front = temp;
                        duSqlList1.next = temp1;
                        temp1.front = duSqlList1;
                        print();
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除结点
     **/
    public void deleteNode(int index) {
        if (index < 0 || index > lengthList()) {
            System.out.println("删除位置不对");
        }
        if (index == lengthList()) {
            temp = duSqlList;
            int sum = 2;
            while (temp.next != null) {
                if (sum == index) {
                    temp.next = null;
                    print();
                    return;
                } else {
                    sum++;
                    temp = temp.next;
                }
            }
        } else if (index < lengthList()) {
            temp = duSqlList;
            int sum = 1;
            while (temp.next != null) {
                if (sum == index - 1) {
                    DuSqlList duSqlList1 = temp.next.next;
                    temp.next = duSqlList1;
                    duSqlList1.front = temp;
                    print();
                    return;
                } else {
                    sum++;
                    temp = temp.next;
                }
            }
        }
    }

    /**
     * 排序
     **/
    public void orderList() {
        if (lengthList() < 2) {
            System.out.println("无需排序");
        } else {
            temp = duSqlList;
            while (temp != null) {
                DuSqlList duSqlList1 = temp.next;
                while (duSqlList1 != null) {
                    if (temp.data > duSqlList1.data) {
                        int t = temp.data;
                        temp.data = duSqlList1.data;
                        duSqlList1.data = t;
                    }
                    duSqlList1 = duSqlList1.next;
                }
                temp = temp.next;
            }
        }
        print();
    }

    /**
     * 打印双链表的内容
     **/
    public void print() {
        temp = duSqlList;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 计算链表长度
     **/
    public int lengthList() {
        temp = duSqlList;
        int sum = 0;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        DuLinkList duLinkList = new DuLinkList();
        int[] data = {4, 5, 8, 9, 6, 2, 3};
        duLinkList.initList(data);
        //duLinkList.insertNode(7, 7);
        //duLinkList.print();
        //duLinkList.deleteNode(7);
        duLinkList.orderList();
    }


}
