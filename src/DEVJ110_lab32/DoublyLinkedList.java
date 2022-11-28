package DEVJ110_lab32;


import java.util.Arrays;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }





    //Внутренний класс, хранящий полезное значение и ссылки на следующий узел и предыдущий
    private static class Node {
        Integer data;
        Node next;
        Node previous;



        public Node(Integer data) {
            this.data = data;
        }




        boolean keeps(Integer val) {
            return data == null && val == null
                    || data != null && data.equals(val);
        }

    }

    // проверка на пустоту списка
    public boolean isEmpty() {
        return head == null;
    }

    public void printAll() {
        Node it = head;
        while (it != null) {
            System.out.print(it.data + ">>><<<");
            it = it.next;
        }
        System.out.println(it);
    }



    //добавление значения в начало списка;
    public void addToHead(Integer data) {
        Node node = new Node(data);

        if (isEmpty())
            tail = node;
        else
            head.previous = node;

        node.next = head;
        head = node;

    }

    //добавление значения в начало списка;
    public void addToHeadArray(Integer[] array) {
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i<array.length; i++){
            newArray[array.length - 1 - i] = array[i];
           addToHead(array[i]);
        }

    }

    // слияние списка в начало list1 в list c последующем обнулением list1
    public void addToHead(DoublyLinkedList list,DoublyLinkedList list1) {

        for (int i= 0; i<list1.size();i++){
            list.addToHead(list1.get(i));


        }
        while (!(list1.isEmpty() == true)){
            list1.removeTail();
        }

    }


    // слияние списка в конец list1 в list c последующем обнулением list1
    public void addToTail(DoublyLinkedList list,DoublyLinkedList list1){
        for (int i= 0; i<list1.size();i++){
            list.addToTail(list1.get(i));


        }
        while (!(list1.isEmpty() == true)){
            list1.removeTail();
        }



    }



    // извлечение значения из начала списка без его удаления из списка;
    public Integer peekFromHead() {
        return head != null ? head.data : null;
    }

    //добавление значения в конец списка;
    public void addToTail(Integer data) {
        Node node = new Node(data);

        if (isEmpty())
            head = node;
        else
            tail.next = node;

        node.previous = tail;
        tail = node;

    }

    // добавление значений при помощи массива в конец списка
    public void addToTailArray(Integer[] array) {

        for (int i = 0; i<array.length; i++){

            addToTail(array[i]);
        }

    }



    // извлечение значения из конца списка без его удаления;
    public Integer peekFromTail() {
        return tail != null ? tail.data : null;
    }

    // Добавление по индексу
    public void addByIndex(Integer data, int index) {
        Node current = head;
        int count = 0;
        while (current != null && count != index) {
            current = current.next;
            count++;
        }
        Node node = new Node(data);

        current.previous.next = node;
        node.previous = current.previous;
        current.previous = node;
        node.next = current;
    }

    // определение длины списка
    public int size() {
        int size = 0;
        if (head == null) return size;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    //извлечение значения из начала списка с удалением из списка;
    public void removeFromHead() {
        Node node = head;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
    }

    //извлечение значения из конца списка с удалением из списка;
    public void removeTail() {
        Node node = head;
        if (head.next == null) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
    }

    //определение, содержит ли список заданное значение, или нет;
    public boolean contains(Integer data) {
        Node it = head;
        while(it != null) {
            if(it.keeps(data))
                return true;

            it = it.next;
        }
        return false;
    }


    //Получение первого элемента
    public Integer getHead(){
        if(head==null) return null;
        return head.data;
    }

    //Получение последнего элемента
    public Integer getTail(){
        if(tail==null) return null;
        return tail.data;
    }

    //Получение значения элемента по его индексу
    public Integer get(int index){
        if(index<0) throw new IllegalArgumentException();
        int tempIndex = 0;
        Node tempNode = head;
        while(tempNode!=null){
            if(tempIndex==index) return tempNode.data;
            tempNode = tempNode.next;
            tempIndex++;
        }
        throw new IndexOutOfBoundsException();
    }

    // Печать списка в обраном порядке
    public void  revers(DoublyLinkedList list){


        for (int i= list.size()-1; i>=0; i--){
        System.out.print(list.get(i)+ ">><<");

        }

    }



}











