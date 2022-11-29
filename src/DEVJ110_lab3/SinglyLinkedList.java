package DEVJ110_lab3;


public class SinglyLinkedList {
    private Node head;
    private Node tail;

    public SinglyLinkedList() {
    }

    private SinglyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    //добавление значения в начало списка;
    public void addToHead(Object value) {
        if(head != null) {
            Node node = new Node(value);
            node.next = head;
            head = node;
        } else {
            head = tail = new Node(value);
        }
    }


    // извлечение значения из начала списка без его удаления из списка;
    public Object peekFromHead() {
        return head != null ? head.value : null;
    }

    //извлечение значения из начала списка с удалением из списка;
    public Object removeFromHead() {
        if(head == null)
            return null;

        Object rem = head.value;
        if(head != tail) {
            head = head.next;
        } else {
            head = tail = null;
        }
        return rem;
    }


    // добавление значения в конец списка;
    public void addToTail(Object value) {
        if(tail != null) {
            tail.next = new Node(value);
            tail = tail.next;
        } else {
            head = tail = new Node(value);
        }
    }
        // извлечение значения из конца списка без его удаления;
    public Object peekFromTail() {
        return tail != null ? tail.value : null;
    }

    //извлечение значения из конца списка с удалением;
    public Object removeFromTail() {
        if(tail == null)
            return null;

        Object rem = tail.value;
        if(head != tail) {
            Node nt = head;
            while(nt.next != tail)
                nt = nt.next;
            nt.next = null;
            tail = nt;
        } else {
            head = tail = null;
        }
        return rem;
    }

    //определение, является ли список пустым, или нет;
    public boolean isEmpty() {
        return head == null;
    }

    //определение, содержит ли список заданное значение, или нет;
    public boolean contains(Object val) {
        Node it = head;
        while(it != null) {
            if(it.keeps(val))
                return true;

            it = it.next;
        }
        return false;
    }




    public void printAll() {
        Node it = head;
        while(it != null) {
            System.out.print(it.value + ">>>");
            it = it.next;
        }
        System.out.println(it);
    }

    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }

        boolean keeps(Object val) {
            return value == null && val == null
                    || value != null && value.equals(val);
        }
    }
}
