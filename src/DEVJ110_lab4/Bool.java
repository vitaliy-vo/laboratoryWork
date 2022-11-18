package DEVJ110_lab4;

public interface Bool {
       final int sizeBitFollow = 1024;

        boolean getByIndex(int index);
        void inversion(int index);
        void setTrue(int index);
        void setFalse(int index);
        void setIndexValue(int index, boolean value);
        int countTrue();

}
