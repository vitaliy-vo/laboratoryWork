package lab2;

public class Student extends Person {
    private int courseNumber;
    private String dissertation;
    private Sex sex;
    private StageOfTrainig stageOfTrainig;


    /**
     * Конструтор для Аспирантов : ФИО,пол,факультет,тема дисертации;
     *
     * @param name
     * @param surname
     * @param sex
     * @param faculty
     * @param dissertation
     */

    public Student(String name, String surname, Sex sex, String faculty, String dissertation) {
        super(name, surname, faculty);
        this.dissertation = dissertation;
        this.sex = sex;
    }

    /**
     * Конструтор для Бакалавров и Магистров: ФИО, пол, факультет,курс, ступень обучения
     *
     * @param name
     * @param surname
     * @param faculty
     * @param courseNumber
     * @param sex
     * @param stageOfTrainig
     */
    public Student(String name, String surname, Sex sex, String faculty, int courseNumber, StageOfTrainig stageOfTrainig) {
        super(name, surname, faculty);
        this.courseNumber = courseNumber;
        this.sex = sex;
        this.stageOfTrainig = stageOfTrainig;

    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) throws IllegalArgumentException {
        if (courseNumber <= 0) throw new IllegalArgumentException("Курс не может быть отрицательным или быть равным 0");
        this.courseNumber = courseNumber;
    }

    public String getDissertation() {
        return dissertation;
    }

    public void setDissertation(String dissertation) {
        this.dissertation = dissertation;
    }


    @Override
    public String toString() {
        if (stageOfTrainig == StageOfTrainig.BACHELOR) {
            return "This is " + getName() + " " + getSurname() + '.' + " "+"He/she studies at " + getFaculty() + "." + getName() + " " + getSurname() + " " + "is" + courseNumber + " ‘th year" + stageOfTrainig + "student";

        } else if (stageOfTrainig == StageOfTrainig.MASTER) {
            return "This is " + getName() + " " + getSurname() + '.' +" "+ "He/she studies at " + getFaculty() + "." + getName() + " " + getSurname() + " " + courseNumber + "  ‘th year" + stageOfTrainig + "student";
        } else {
            return "This is " + getName() + " " + getSurname() + '.' +" "+ "He/she studies at " + getFaculty() + "." + getName() + " " + getSurname() + " " + "thesis title is " + dissertation;
        }

    }


}




