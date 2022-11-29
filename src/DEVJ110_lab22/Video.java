package DEVJ110_lab22;

import java.text.MessageFormat;

import java.util.Arrays;


public class Video extends Audio {
    private int width;
    public int heigth;

    public Video(String fileName, int size, String fileFormat, String[] info, int timeInSecond, int width, int heigth) {
        super(fileName, size, fileFormat, info, timeInSecond);
        this.width = width;
        this.heigth = heigth;
    }

    /**
     * Конструтор: имя файла, размер файла , тип файла, часы минуты,секунды , разрешение  экрана(высота х ширина)
     *
     */


    @Override
    public String toString(){
        return String.format("Имя файла: %17s | Размер файла: %15d | Атрибуты файла: %20s", getFileName(), getSize(), MessageFormat.format("{0},{1},  {2} сек, {3}x{4}",getFileFormat(), Arrays.toString(info) ,getTimeInSecond(),getWidth(),getHeigth()));

    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws IllegalArgumentException {
        if (width <= 0) throw new IllegalArgumentException("Высота не может быть меньше или равна 0");
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) throws IllegalArgumentException {
        if (heigth <= 0) throw new IllegalArgumentException("Ширина не может быть меньше или равна 0");
        this.heigth = heigth;
    }
}






