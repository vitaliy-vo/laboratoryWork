package lab2;

import java.io.IOException;

import java.text.MessageFormat;
import java.util.Arrays;


public class Audio extends File{
    private String fileFormat;
    public String[] info;
    private int hh,mm,ss; //время часы,минуты, секунды


    public Audio(String fileName, int size, String fileFormat, String[] info, int hh,int mm,int ss) {
        super(fileName, size);
        this.fileFormat = fileFormat;
        this.info = info;
        this.hh=hh;
        this.mm=mm;
        this.ss=ss;

    }

    @Override
    public String toString(){
        return String.format("Имя файла: %17s | Размер файла: %15d | Атрибуты файла: %20s", getFileName(), getSize(), MessageFormat.format("{0},{1},{2},{3}",getFileFormat(), Arrays.toString(info) ,getHh(),getMm()));

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

    public int getHh()  {

        return hh;
    }

    public void setHh(int hh) throws IllegalArgumentException {
        if (hh < 0) throw new IllegalArgumentException("Значение должнобыть больше 0");
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) throws IllegalArgumentException {
        if (mm< 0) throw new IllegalArgumentException("Значение должнобыть больше 0");
        this.mm = mm;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) throws IllegalArgumentException {
        if (ss < 0) throw new IllegalArgumentException("Значение должнобыть больше 0");
        this.ss = ss;
    }

    public static class Docx extends File {
        private String fileFormat;
        private int pages;


        /**
         * Конструтор: имя файла, размер файла , тип файла, колличество страниц
         *
         */

        public Docx(String fileName, int size, String fileFormat, int pages) {
            super(fileName, size);
            this.fileFormat = fileFormat;
            this.pages = pages;

        }


        @Override
        public String toString(){
            return String.format("Имя файла: %17s | Размер файла: %15d | Атрибуты файла: %20s", getFileName(), getSize(), MessageFormat.format("{0},{1}",getFileFormat(),getPages()));

        }

        public String getFileFormat() {
            return fileFormat;
        }

        public void setFileFormat(String fileFormat) throws IOException {
            if (fileFormat!="docx") throw new IOException("Выберите текствый файл");
            this.fileFormat = fileFormat;
        };

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }


    }
}
