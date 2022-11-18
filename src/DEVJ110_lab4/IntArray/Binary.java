package DEVJ110_lab4.IntArray;

import DEVJ110_lab4.Bool;


public class Binary implements Bool {

        int sizeIntArray = sizeBitFollow/32;
        int[] ints = new int[sizeIntArray];

        Binary [] binaries = new Binary[sizeBitFollow];


        @Override
        public boolean getByIndex(int index){
            int indexElement = index/32;
            int element = ints[indexElement];
            int indexBit = index%32;
            int mask = 1<<indexBit;
            return (element&mask) == mask;
        }


   // инвертирование элемента с заданным индексом;
        @Override
        public void inversion(int index){
            int indexElement = index/32;
            int indexBit = index%32;
            int mask = 1<<indexBit;
            ints[indexElement] = ints[indexElement] ^ mask;
        }

        //установка (в true) элемента с заданным индексом;
    @Override
    public void setTrue(int index) {
        if(index<0 || index>=sizeIntArray) return;
        int indexElement = index/32;
        int indexBit = index%32;
        int mask = 1<<indexBit;
        ints[indexElement] = ints[indexElement] | mask;
    }



    //сброс (в false) элемента с заданным индексом;
    @Override
    public void setFalse(int index) {
        if(index<0 || index>=sizeIntArray) return;
        int indexElement = index/32;
        int indexBit = index%32;
        int mask = 1<<indexBit;
        ints[indexElement] = ints[indexElement] & ~mask;
    }


    //установка элемента с заданным индексом заданным логическим значением;
    @Override
    public void setIndexValue(int index, boolean value) {

        int indexElement = index / 32;
        int indexBit = index % 32;
        int mask = 1 << indexBit;
        if (value == true) {
            ints[indexElement] = ints[indexElement] | mask;
        } else {
            ints[indexElement] = ints[indexElement] & ~mask;
        }
    }




    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= binaries.length) throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы массива");
    }




    public int countTrue() {
        int res = 0;
        for (int i = 0; i < sizeBitFollow; i++) {
            int x = getByIndex(i) ? 1 : 0;
            res += x;

        }
        return res;
    }

    @Override
        public String toString() {
            String temp = "";
            for(int i=0 ; i<sizeBitFollow ; i++){
                int x = getByIndex(i) ? 1 : 0;
                temp = temp + x + ", ";
            }
            return temp;
        }

        }



