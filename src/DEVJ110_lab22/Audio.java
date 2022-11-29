package DEVJ110_lab22;

import java.text.MessageFormat;
import java.util.Arrays;

import java.io.IOException;


public class Audio extends File {

    private String fileFormat;
    public String[] info;
    private int timeInSecond; //время часы,минуты, секунды


    public Audio(String fileName, int size, String fileFormat, String[] info, int timeInSecond) {
        super(fileName, size);
        this.fileFormat = fileFormat;
        this.info = info;
        this.timeInSecond=timeInSecond;

    }

    @Override
    public String toString(){
        return String.format("Имя файла: %17s | Размер файла: %16d | Атрибуты файла: %20s",getFileName() , getSize(), MessageFormat.format("{0},{1},{2} сек",getFileFormat(), Arrays.toString(info) , getTimeInSecond()));

    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) throws IOException {
        if (fileFormat!="audio") throw new IOException("Выберите аудио файл");
        this.fileFormat = fileFormat;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public int getTimeInSecond() {
        return timeInSecond;
    }

    public void setTimeInSecond(int timeInSecond) throws IllegalArgumentException {
        if (timeInSecond < 0 ) throw new IllegalArgumentException("Продолжительность аудио файла не может быть меньше нуля");
        this.timeInSecond = timeInSecond;
    }
}
