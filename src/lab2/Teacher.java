package lab2;

public class Teacher extends Person {
    private Sex sex;
    private Degree degree;
    private String specialization;



    /**
     * Конструктор для преподователей: ФИО,пол, факультет, ученая степень,специальность
     * @param name
     * @param surname
     * @param faculty
     * @param degree
     * @param specialization
     */
    public Teacher(String name, String surname, Sex sex, String faculty, Degree degree, String specialization) {
        super(name, surname, faculty);
        this.degree = degree;
        this.specialization = specialization;

        }


    @Override
    public String toString() {
        return  "This is " + getName() + ' '+ getSurname() + " "+ "."+ "He/she " + "teaches "+ ' ' + "at " + getFaculty()+ "." + getName() + " " + getSurname() +  "has " + degree + " "+ "degree in " + specialization;

    }

    public void print(){
        System.out.println(this);
    }
}






