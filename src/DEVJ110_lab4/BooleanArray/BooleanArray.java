package DEVJ110_lab4.BooleanArray;

import DEVJ110_lab4.Bool;

public class BooleanArray implements Bool {

     boolean [] booleans = new boolean[sizeBitFollow];

   // проверка элемента с заданным индексом;

    @Override
    public boolean getByIndex(int index) {
        return booleans[index];
    }



    //инвертирование элемента с заданным индексом;
    @Override
    public void inversion(int index) {
        checkIndex(index);
        booleans[index] = !booleans[index];
    }

        //установка (в true) элемента с заданным индексом;
    @Override
    public void setTrue(int index) {
        booleans[index]=true;
    }

    //установка элемента с заданным индексом заданным логическим значением;
    @Override
    public void setIndexValue(int index, boolean value) {
        getByIndex(index);
        booleans[index] = value;
    }


    //сброс (в false) элемента с заданным индексом;
    public void setFalse(int index) {
        booleans[index]=false;
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= booleans.length) throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы массива");
    }

    // метод, возвращающий количество элементов, установленных в true;
    @Override
    public int countTrue() {
        int res = 0;
        for (boolean b : booleans) {
            if(b) res++;
        }
        return res;
    }

    @Override
    public String toString() {
        String temp = "";
        char[] ac = new char[sizeBitFollow];
        for (int i = 0; i < booleans.length; i++) {
            ac[i] = booleans[i] ? '1' : '0';
            temp = temp + ac[i] + ", ";
        }
        return temp;
    }

}
