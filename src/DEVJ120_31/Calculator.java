package DEVJ120_31;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator implements ActiveEvent, ActionListener {

    double number, answer;
    int calculation;

/*    Calculator calculator=  new Calculator();*/
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();

    ImageIcon img = new ImageIcon("src\\DEVJ120_31\\Calculator_37533.png");


    JLabel label = new JLabel();

    JPanel buttons= new JPanel();


    List<String> operations = Arrays.asList(".", "=","+","x","x\u00B2","\u221A","1/x","-","/","C","<=");

    ArrayList<JButton> buttonArrayList= new ArrayList<>();

    ArrayList<JButton> operArrayList= new ArrayList<>();



    Calculator()  {
        prepareGUI();
        addComponents();
        addActionEvent();
    }

    public void prepareGUI() {
        //Setting properties of JFrame(Window)
        frame.setTitle("Calculator");
        frame.setIconImage(img.getImage());
        frame.setSize(300, 440);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public void addComponents() {

        label.setBounds(200, 0, 50, 50);
        label.setForeground(Color.black);
        frame.add(label);



        textField.setBounds(15, 40, 260, 45);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);





        for (int i = 0; i < 10; i++){
            JButton jButtonNum = new JButton(Integer.toString(i));
            buttonArrayList.add(jButtonNum);
        }



        buttonArrayList.forEach(buttons::add);


        // //Setting property of button 0
        frame.add(buttonArrayList.get(0));
        buttonArrayList.get(0).setBounds(10, 350, 130, 40);
        buttonArrayList.get(0).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button 1
        frame.add(buttonArrayList.get(1));
        buttonArrayList.get(1).setBounds(10, 300, 60, 40);
        buttonArrayList.get(1).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button 2
        frame.add(buttonArrayList.get(2));
        buttonArrayList.get(2).setBounds(80, 300, 60, 40);
        buttonArrayList.get(2).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button 3
        frame.add(buttonArrayList.get(3));
        buttonArrayList.get(3).setBounds(150, 300, 60, 40);
        buttonArrayList.get(3).setFont(new Font("Arial", Font.BOLD, 20));


        //Setting property of button 4
        frame.add(buttonArrayList.get(4));
        buttonArrayList.get(4).setBounds(10, 250, 60, 40);
        buttonArrayList.get(4).setFont(new Font("Arial", Font.BOLD, 20));


        //Setting property of button 5
        frame.add(buttonArrayList.get(5));
        buttonArrayList.get(5).setBounds(80, 250, 60, 40);
        buttonArrayList.get(5).setFont(new Font("Arial", Font.BOLD, 20));


        //Setting property of button 6
        frame.add(buttonArrayList.get(6));
        buttonArrayList.get(6).setBounds(150, 250, 60, 40);
        buttonArrayList.get(6).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button 7
        frame.add(buttonArrayList.get(7));
        buttonArrayList.get(7).setBounds(10, 200, 60, 40);
        buttonArrayList.get(7).setFont(new Font("Arial", Font.BOLD, 20));


        // Setting property of button 8
        frame.add(buttonArrayList.get(8));
        buttonArrayList.get(8).setBounds(80, 200, 60, 40);
        buttonArrayList.get(8).setFont(new Font("Arial", Font.BOLD, 20));


        // Setting property of button 9
        frame.add(buttonArrayList.get(9));
        buttonArrayList.get(9).setBounds(150, 200, 60, 40);
        buttonArrayList.get(9).setFont(new Font("Arial", Font.BOLD, 20));





         operations.forEach(it -> {
            JButton jtmpbutton = new JButton(it);
             operArrayList.add((jtmpbutton));

        });


        //Setting property of button "."
        frame.add(operArrayList.get(0));
        operArrayList.get(0).setBounds(150, 350, 60, 40);
        operArrayList.get(0).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button "="
        frame.add(operArrayList.get(1));
        operArrayList.get(1).setBounds(220, 300, 60, 92);
        operArrayList.get(1).setFont(new Font("Arial", Font.BOLD, 20));
        operArrayList.get(1).setBackground(new Color(255,116,23));


        //Setting property of button "+"
        frame.add(operArrayList.get(2));
        operArrayList.get(2).setBounds(220, 250, 60, 40);
        operArrayList.get(2).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button "x"
        frame.add(operArrayList.get(3));
        operArrayList.get(3).setBounds(220, 200, 60, 40);
        operArrayList.get(3).setFont(new Font("Arial", Font.BOLD, 20));



        //Setting property of button "x^2"
        frame.add(operArrayList.get(4));
        operArrayList.get(4).setBounds(10, 150, 60, 40);
        operArrayList.get(4).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button "sqrt"
        frame.add(operArrayList.get(5));
        operArrayList.get(5).setBounds(80, 150, 60, 40);
        operArrayList.get(5).setFont(new Font("Arial", Font.BOLD, 20));

        //Setting property of button "1/x"
        frame.add(operArrayList.get(6));
        operArrayList.get(6).setBounds(150, 150, 60, 40);
        operArrayList.get(6).setFont(new Font("Arial", Font.BOLD, 15));


        //Setting property of button "-"
        frame.add(operArrayList.get(7));
        operArrayList.get(7).setBounds(220, 150, 60, 40);
        operArrayList.get(7).setFont(new Font("Arial", Font.BOLD, 15));

        //Setting property of button "/"
        frame.add(operArrayList.get(8));
        operArrayList.get(8).setBounds(150, 100, 60, 40);
        operArrayList.get(8).setFont(new Font("Arial", Font.BOLD, 15));


        //Setting property of button "C"
        frame.add(operArrayList.get(9));
        operArrayList.get(9).setBounds(80, 100, 60, 40);
        operArrayList.get(9).setFont(new Font("Arial", Font.BOLD, 15));
        operArrayList.get(9).setBackground(new Color(255,0,0));

        //Setting property of button "<="
        frame.add(operArrayList.get(10));
        operArrayList.get(10).setBounds(220, 100, 60, 40);
        operArrayList.get(10).setFont(new Font("Arial", Font.BOLD, 15));

    }


    public void addActionEvent() {
        // 1-9
        buttonArrayList.get(0).addActionListener(this);
        buttonArrayList.get(1).addActionListener(this);
        buttonArrayList.get(2).addActionListener(this);
        buttonArrayList.get(3).addActionListener(this);
        buttonArrayList.get(4).addActionListener(this);
        buttonArrayList.get(5).addActionListener(this);
        buttonArrayList.get(6).addActionListener(this);
        buttonArrayList.get(7).addActionListener(this);
        buttonArrayList.get(8).addActionListener(this);
        buttonArrayList.get(9).addActionListener(this);

        // ".", "=","+","x","x\u00B2","\u221A","1/x","-","/","C","<="
        operArrayList.get(0).addActionListener(this);
        operArrayList.get(1).addActionListener(this);
        operArrayList.get(2).addActionListener(this);
        operArrayList.get(3).addActionListener(this);
        operArrayList.get(4).addActionListener(this);
        operArrayList.get(5).addActionListener(this);
        operArrayList.get(6).addActionListener(this);
        operArrayList.get(7).addActionListener(this);
        operArrayList.get(8).addActionListener(this);
        operArrayList.get(9).addActionListener(this);
        operArrayList.get(10).addActionListener(this);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    Object source = e.getSource();
        if (source == operArrayList.get(9)) {
                //Clearing texts of label and text field
                label.setText("");
                textField.setText("");
            } else if (source == operArrayList.get(10)) {
                //Setting functionality for delete button(backspace)
                int length = textField.getText().length();
                int number = length - 1;


                if (length > 0) {
                    StringBuilder back = new StringBuilder(textField.getText());
                    back.deleteCharAt(number);
                    textField.setText(back.toString());

                }
                if (textField.getText().endsWith("")) {
                    label.setText("");
                }
            } else if (source == buttonArrayList.get(0)) {
                if (textField.getText().equals("0")) {
                    return;
                } else {
                    textField.setText(textField.getText() + "0");
                }
            } else if (source == buttonArrayList.get(1)) {
                textField.setText(textField.getText() + "1");
            } else if (source == buttonArrayList.get(2)) {
                textField.setText(textField.getText() + "2");
            } else if (source == buttonArrayList.get(3)) {
                textField.setText(textField.getText() + "3");
            } else if (source == buttonArrayList.get(4)) {
                textField.setText(textField.getText() + "4");
            } else if (source == buttonArrayList.get(5)) {
                textField.setText(textField.getText() + "5");
            } else if (source == buttonArrayList.get(6)) {
                textField.setText(textField.getText() + "6");
            } else if (source == buttonArrayList.get(7)) {
                textField.setText(textField.getText() + "7");
            } else if (source == buttonArrayList.get(8)) {
                textField.setText(textField.getText() + "8");
            } else if (source == buttonArrayList.get(9)) {
                textField.setText(textField.getText() + "9");
            } else if (source == operArrayList.get(0)) {
                if (textField.getText().contains(".")) {
                    return;
                } else {
                    textField.setText(textField.getText() + ".");
                }

            } else if (source == operArrayList.get(2)) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "+");
                calculation = 1;
            } else if (source == operArrayList.get(7)) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "-");
                calculation = 2;
            } else if (source == operArrayList.get(3)) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "X");
                calculation = 3;
            } else if (source == operArrayList.get(8)) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "/");
                calculation = 4;
            } else if (source == operArrayList.get(5)) {
                number = Double.parseDouble(textField.getText());
                Double sqrt = Math.sqrt(number);
                textField.setText(Double.toString(sqrt));

            } else if (source == operArrayList.get(4)) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                double square = Math.pow(number, 2);
                String string = Double.toString(square);
                if (string.endsWith(".0")) {
                    textField.setText(string.replace(".0", ""));
                } else {
                    textField.setText(string);
                }
                label.setText("(sqr)" + str);
            } else if (source == operArrayList.get(6)) {
                number = Double.parseDouble(textField.getText());
                double reciprocal = 1 / number;
                String string = Double.toString(reciprocal);
                if (string.endsWith(".0")) {
                    textField.setText(string.replace(".0", ""));
                } else {
                    textField.setText(string);
                }
            } else if (source == operArrayList.get(1)) {
                //Setting functionality for equal(=) button
                switch (calculation) {
                    case 1:
                        answer = number + Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        label.setText("");
                        break;
                    case 2:
                        answer = number - Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        label.setText("");
                        break;
                    case 3:
                        answer = number * Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        label.setText("");
                        break;
                    case 4:
                        answer = number / Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        label.setText("");
                        break;

                }
            }


        }


    @Override
    public void dispatch() {

    }

    }

