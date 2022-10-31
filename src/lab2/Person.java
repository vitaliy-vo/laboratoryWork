package lab2;

import lab1.Book;

public class Person {
    private String name;
    private String surname;
    private String faculty;

    public Person(String name, String surname, String faculty) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
    }


    public static void printAll(Person[] person){
        for ( int i =0;i< person.length; ++i){
            System.out.println(person[i]);
        }
    }




        public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if (name == null) throw new NullPointerException("Значение поля /Имя/ не долно быть пустое");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws NullPointerException {
        if (surname == null) throw new NullPointerException("Значение поля /Фамилия/ не долно быть пустое");
        this.surname=surname;

    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
