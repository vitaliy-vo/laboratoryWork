package lab1;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Book extends PublishingHouse{
    private String title;
    private PublishingHouse publishingHouse;
    private int yearOfPublishing;
    private String[] authors;



    /**
     * название, автор, год издания, издательство
     * @param title
     * @param authors
     * @param yearOfPublishing
     *
     */


    public Book(String title, String[] authors, int yearOfPublishing, PublishingHouse publishingHouse) {
        super(publishingHouse.namePublishingHouse, publishingHouse.city);
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;

    }



    /**
     * Конструтор: название, год издания, издательство (для случая, если авторов нет)
     *
     */
    public Book(String title, int yearOfPublishing, PublishingHouse publishingHouse) {
        super(publishingHouse.namePublishingHouse, publishingHouse.city);
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
    }




    @Override
    public String toString(){
        return String.format("Название книги: %17s | Автор(ы): %14s | Издательство: %14s | Год издательства: %5d |", getTitle(), Arrays.toString(authors), getNamePublishingHouse(), getYearOfPublishing());
    }

    public String toStringNullAutors(){
        return String.format("Название книги: %17s |Издательство: %14s | Год издательства: %5d |", getTitle(), getNamePublishingHouse(), getYearOfPublishing());
    }


    /**
     *
     * метод для вывода массива (с полем автор и без него)
     */
    public static void printAll(Book[] arraybooks){
        for ( int i =0;i< arraybooks.length; ++i){
            arraybooks[i].print();
        }
    }


    public void print(){
        if (this.authors != null){
            System.out.println(this);

        } else {
            System.out.println(this.toStringNullAutors());
        }
    }


    // set-metods

    public void setTitle(String title) throws NullPointerException {
        if (title== null) throw new NullPointerException ("Значение поля /Название книги/ не долно быть пустое");
        this.title = title;

    }

    public void setYear(int yearOfPublishing) throws IllegalArgumentException {
        if (yearOfPublishing >0) throw new IllegalArgumentException ("Значение поля /Год издания/ должно быть больше 0");
        this.yearOfPublishing = yearOfPublishing;
        };


    public void setAuthor(String[] author) {
        this.authors = author;

    }

    // get-metods

    public String[] getAuthor(String[] author) {
        return this.authors;
    }

    public int getCountAuthor(String[] author) {
        return this.authors.length;
    }


    public String getTitle() {
        return title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }


}
