package DEVJ120_32;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameOfPyatnashki extends JFrame {


    private JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));

    private JMenuBar menu = null;
    private final String fileItems[] = new String[]{"новая игра", "читы", "Выход"};
    private static Random generator = new Random(); // генератор случайных чисел
    private int[][] numbers = new int[4][4];

    JButton cheats = new JButton("Cheats");


    public GameOfPyatnashki() {
        setTitle("Пятнашки"); //Заголовок окна

        setSize(300, 300); // Задаем размеры окна приложения
        setLocationRelativeTo(null); // Окно приложения центрируется относительно экрана

        setResizable(true); // задаем возможность растягивать окно
        createMenu(); //инициализируем меню
        setJMenuBar(menu); // добавляем панель меню к окну
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрываем программу при закрытии окна

        Container container = getContentPane();
        init();
        panel.setDoubleBuffered(true);
        panel.setBackground(Color.white); // устанавливаем цвет фона
        container.add(panel); // добавление компонентов в контейнер
        repaintField();
        JLabel();

       // Cheats();
    }

    public void init() {
        int[] invariants = new int[16]; // инициализируем массив с именем invariants из 16 элементов - лт 0 до 15

        for (int i = 0; i < 4; i++) { // перебираем элементы i от 0 до 3
            for (int j = 0; j < 4; j++) { // перебираем элементы j от 0 до 3
                numbers[i][j] = 0; // указываем что перебор в цикле начинается с нулевого элемента
                invariants[i * 4 + j] = 0; // определяем какой из 16 элементов будет = 0
            }
        }

        for (int i = 1; i < 16; i++) { // перебираем елементы i от 1 до 15
            int k; //обьявляем переменную k типа int
            int l; //обьявляем переменную l типа int
            do { // цикл с послеусловием
                k = generator.nextInt(100) % 4; // переменной k присваиваем произвольное число от 0 до 100 деленное по модулю на 4
                l = generator.nextInt(100) % 4; // переменной l присваиваем произвольное число от 0 до 100 деленное по модулю на 4
            }
            while (numbers[k][l] != 0); // до тех пор пока двумерный массив numbers не равен 0
            numbers[k][l] = i; // присваиваем двумерному массиву numbers значение i в цикле от 1 до 15
            invariants[k * 4 + l] = i; // определяем позиции всех елементов кроме 0 на сетке
        }

        boolean change = true; // в булевую переменную change заносим значение true
        int counter = 1; // инициализируем переменную counter типа int и присваиваем ей 1
        while (change) {
            change = false;
            for (int i = 0; i < 16; i++) {
                if (invariants[i] != i) {
                    for (int j = 0; j < 16; j++) {
                        if (invariants[j] == i) {
                            int temp = invariants[i];
                            invariants[i] = invariants[j];
                            invariants[j] = temp;
                            change = true;
                            counter++;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        if (counter % 2 != 0) {
            int temp = numbers[0][0];
            numbers[0][0] = numbers[3][3];
            numbers[3][3] = temp;
        }
    }

    public void JLabel() {
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1); // создаем границу черного цвета
        Font font = new Font("Verdana", Font.PLAIN, 15); // задаем тип шрифта, и его размер
        JLabel topLabel = new JLabel(); // создаем обьект topLabel типа JLabel
        topLabel.setBorder(solidBorder); // устанавливаем границу
        topLabel.setFont(font); // устанавливаем тип текста
        topLabel.setForeground(Color.RED); // Устанавливаем цвет текста
        menu.add(topLabel); // добавляем JLabel на пенель menu
    }


    public void repaintField() {  //метод расстановки кнопок со значениями на сетке
        panel.removeAll();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(Integer.toString(numbers[i][j]));
                button.setFocusable(false);
                panel.add(button);
                button.setBackground(Color.red); // устанавливаем цвет кнопок
                if (numbers[i][j] == 0) {
                    button.setVisible(false); // сокрытие нулевого элемента массива
                } else
                    button.addActionListener(new ClickListener());
            }
        }

        panel.validate();
    }

    public boolean checkWin() { //метод проверки победы
        boolean status = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j > 2) //проверка на то, что последняя ячейка в сетке пустая
                    break;
                if (numbers[i][j] != i * 4 + j + 1) { //проверка на соотвествие элементам массива координатам в сетке
                    status = false;
                }
            }
        }
        return status;
    }


    private void createMenu() {
        menu = new JMenuBar();
        JMenu fileMenu = new JMenu("Меню");

        for (int i = 0; i < fileItems.length; i++) {
            JMenuItem item = new JMenuItem(fileItems[i]);
            JSeparator separator = new JSeparator();
            item.setActionCommand(fileItems[i].toLowerCase());
            item.addActionListener(new NewMenuListener());
            fileMenu.add(item);
            fileMenu.add(separator);
        }

        menu.add(fileMenu);
    }

    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("выход".equals(command)) {
                System.exit(0);
            }
            if ("новая игра".equals(command)) {
                init();
                repaintField();
            }
            if ("читы".equals(command)) {
                repaintField();
                сheats();
            }
            //
        }
    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setVisible(false);
            String name = button.getText();
            change(Integer.parseInt(name));
        }
    }


    public void change(int num) { // передаем в качестве входящих параметров метода change переменную num типа int
        int i = 0, j = 0; // присваиваем переменным i и j типа int значение равное 0
        for (int k = 0; k < 4; k++) { // перебираем элементы k от 0 до 3
            for (int l = 0; l < 4; l++) { // перебираем элементы l от 0 до 3
                if (numbers[k][l] == num) { // если массив numbers[k][l] равен переменной num то,
                    i = k; // переменную i приравниваем переменной k
                    j = l; // переменную j приравниваем переменной l
                }
            }
        }

        /*реализация логики сдвигов кнопок на сетке 4 Х 4*/
        //сдвиг вверх по строкам
        if (i > 0) { // условие отвечающее за то можно ли сдвинуть кнопку по строке
            if (numbers[i - 1][j] == 0) { //сравниваем значение координат элемента массива с кнопкой которая в текущем массиве равна нулю
                numbers[i - 1][j] = num; //присваиваем переменной num значение координат элемента массива
                numbers[i][j] = 0; //присваиваем нулевой элемент массива в ячейку которая перед этим смещалась в ноль
            }
        }
        //сдвиг вниз по строкам
        if (i < 3) {
            if (numbers[i + 1][j] == 0) {
                numbers[i + 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        //сдвиг влево по столбцам
        if (j > 0) {
            if (numbers[i][j - 1] == 0) {
                numbers[i][j - 1] = num;
                numbers[i][j] = 0;
            }
        }
        //сдвиг вправо по столбцам
        if (j < 3) {
            if (numbers[i][j + 1] == 0) {
                numbers[i][j + 1] = num;
                numbers[i][j] = 0;
            }
        }
        repaintField();
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "ВЫ ВЫИГРАЛИ!", "Поздравляем", 1);
            init();
            repaintField();
            setVisible(false);
            setVisible(true);
        }
    }

    public void сheats() {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[i].length; j++) {
                    System.out.print(numbers[i][j] + "\t");

                }
                System.out.println();
            }

        numbers[0][0]=1;
        numbers[0][1]=2;
        numbers[0][2]=3;
        numbers[0][3]=4;
        numbers[1][0]=5;
        numbers[1][1]=6;
        numbers[1][2]=7;
        numbers[1][3]=8;
        numbers[2][0]=9;
        numbers[2][1]=10;
        numbers[2][2]=11;
        numbers[2][3]=12;
        numbers[3][0]=13;
        numbers[3][1]=14;
        numbers[3][2]=15;
        numbers[3][3]=0;




        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + "\t");

            }
            System.out.println();
        }

    }

    @Override
    public String toString() {
        return "GameOfPyatnashki{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}



