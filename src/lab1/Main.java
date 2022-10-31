package lab1;


public class Main {


    public static void main (String[] args) {
        Сountry[] countries = new Сountry[5];
        countries[0] = new Сountry("Russia", 17.1, 146700000, "Moscow", 12600000);
        countries[1] = new Сountry("Finland", 338, 5500000, "Helsinki", 655000 );
        countries[2] = new Сountry("France", 643.8 , 67800000, "Paris", 2100000);
        countries[3] = new Сountry("Andorra", 467, 85400, "Andorra la Vella", 22600);
        countries[4] = new Сountry("Singapore", 725, 5700000);


        countries[0].print();
        countries[1].print();
        countries[2].print();
        countries[3].print();
        countries[4].print();
        Сountry.printAll(countries);

        System.out.println();



         Book[] arraybooks = new Book[]{
                new Book("Computer Science: основы программирования на Java,ООП, алгоритмы и структуры данных",new String[]{"Седжвик Роберт", "Уэйн Кевин"},2018,new PublishingHouse("Питер", "Санкт-Петербург")),
                new Book("Разработка требований к программному обеспечению. 3-е издание, дополненное",new String[] {"Вигерс Карл"},2019,new PublishingHouse("БХВ", "Санкт-Петебург")),
                new Book("Java. Полное руководство, 10-е издание",new String[]{"Шилдт Герберт"},2018,new PublishingHouse("Диалектика", "Киев")),
                new Book(" C/C++. Процедурное программирование", new String[] {"Полубенцева М.И"},2017,new PublishingHouse("БХВ", "Санкт-Петебург")),
                new Book("Конституция РФ",2020,new PublishingHouse("Проспект", "Москва"))};

         /**
         Вывод на экран массива Book[]
          */
        Book.printAll(arraybooks);

        /**
         * Установка корректного значения города
         */

        arraybooks[1].setCity("Санкт-Петербург");
        arraybooks[3].setCity("Санкт-Петербург");
        /**
         * Проверка утановленых значений поля city
         */
        System.out.println(arraybooks[1].getCity());
        System.out.println(arraybooks[3].getCity());

        /**
         * Повторный вывод массива Book[]
         */
        Book.printAll(arraybooks);




    }


}
