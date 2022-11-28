package DEVJ110_lab32;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        System.out.println("Создаем 2 списка и наполняем их");
        DoublyLinkedList list= new DoublyLinkedList();

        list.addToHead(1122);
        list.addToTail(2222);
        list.addToHeadArray(new Integer[]{111,112});
        list.addToTailArray(new Integer[]{256,6588});

        list.addByIndex( 2322,1);
        list.printAll();

        DoublyLinkedList list1= new DoublyLinkedList();
        list1.addToHead(4544);
        list1.addToTail(4125);
        list1.addToHeadArray(new Integer[]{222,113});
        list1.addToTailArray(new Integer[]{222,56565});
        list1.addByIndex( 2555,1);
        list1.printAll();

        System.out.println("Сливаем в первый список второй список ");
        list.addToTail(list,list1);
        list.printAll();
        System.out.println("Проверка удалился ли второй список после слияния" );

        System.out.println(list1.isEmpty());

        System.out.println("Вывод списка в обратном порядке");
        list.revers(list);



    }


}
