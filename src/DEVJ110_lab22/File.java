package DEVJ110_lab22;

public class File {

    protected String fileName;
    protected int size;



    public File(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    public static void printAll(File[] files){
        for ( int i =0;i< files.length; ++i){
            System.out.println(files[i]);
        }
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}






