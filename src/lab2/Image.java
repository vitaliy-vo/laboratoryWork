package lab2;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;

public class Image extends File{
    private String fileFormat;
    private int width, heigth;


    /**
     * Конструтор: имя файла, размер файла , тип файла, разрешение  ихображения(высота х ширина)
     *
     */

    public Image(String fileName, int size, String fileFormat, int width, int heigth) {
        super(fileName, size);
        this.fileFormat = fileFormat;
        this.width = width;
        this.heigth = heigth;
    }


    @Override
    public String toString(){
        return String.format("Имя файла: %17s | Размер файла: %15d | Атрибуты файла: %20s", getFileName(), getSize(),MessageFormat.format("{0},{1}x{2}",getFileFormat(), getWidth(), getHeigth()));

    }


    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) throws IOException{
        if (fileFormat!="image") throw new IOException("Выберите файл c изображением");
        this.fileFormat = fileFormat;
    };

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws IllegalArgumentException{
      if(width <=0) throw new IllegalArgumentException("Высота не может быть меньше или равна 0");

        this.width = width;
    };


    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) throws IllegalArgumentException {
        if (heigth <= 0) throw new IllegalArgumentException("Ширина не может быть меньше или равна 0");
        this.heigth = heigth;
    }




}
