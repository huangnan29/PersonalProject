package cn.hn.MyCollections;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-5 上午8:02
 * @desc : TODO
 **/
public class MyLinkedList {
    /**
     * 内部节点类
     */
    class Node {
        Node prev;
        Node next;
        Object obj;

        public Node() {

        }

        public Node(Node prev, Node next, Object obj) {
            this.prev = prev;
            this.next = next;
            this.obj = obj;
        }

        public Object getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Object getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Object obj) {
        if (head == null) {
            Node n = new Node();
            n.setPrev(null);
            n.setObj(obj);
            n.setNext(null);
            head = n;
            tail = n;
        } else {
            Node n = new Node();
            n.setPrev(tail);
            n.setObj(obj);
            n.setNext(null);

            tail.setNext(n);
            tail = n;

        }
        size++;
    }


    public int Size() {
        return size;
    }


    public Node node(int index) {
        Node temp = null;
        if (head != null) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

        }
        return temp;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception("OutOfRange");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        Node temp = node(index);
        return temp.obj;
    }

    public void set(int index ,Object obj){
        rangeCheck(index);
        Node temp = node(index);
        temp.obj = obj;
    }


    public void remove(int index) {
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null) {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            size--;
        }
    }

    public void insert(int index,Object obj){
        rangeCheck(index);
        Node temp = node(index);
        Node insertNode = new Node();
        insertNode.obj = obj;


        insertNode.prev = temp.prev;
        insertNode.next = temp;
        temp.prev.next = insertNode;
        temp.prev = insertNode;
    }


    public static void main(String[] args) {
        MyLinkedList Dlink = new MyLinkedList();
        Dlink.add("111");
        Dlink.add("222");
        Dlink.add("223");
        Dlink.add("444");
        Dlink.add("555");
//        Dlink.get(4);
        Dlink.remove(1);
        Dlink.get(1);
        Dlink.set(2,"set222");
        Dlink.get(2);
        Dlink.insert(1,"insert111");
        System.out.println(Dlink);
    }

}
