package DEVJ110_lab3;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addToHead(155);
        list.addToTail(168);
        list.addToTail(125);
        list.addToTail(222);


        System.out.println("Исходный односвязанный список :");
        list.printAll();

        System.out.println("_____________________________");

        System.out.println("Является ли список пустым ? ");

        System.out.println(list.isEmpty());

        System.out.println("_____________________________");

        System.out.println("Удаление головного и последнего значения(155-голова,222-хвост)");
        list.removeFromHead();

        list.removeFromTail();

        list.printAll();
        System.out.println("_____________________________");

        System.out.println("Проверка на наличие элемента в односвязном списке (144524524;168)");
        System.out.println(list.contains(144524524));
        System.out.println(list.contains(168));
        System.out.println("_____________________________");






    }
}
