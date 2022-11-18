package DEVJ110_lab22;

import java.io.IOException;

import java.text.MessageFormat;



public class Docx extends File{
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





