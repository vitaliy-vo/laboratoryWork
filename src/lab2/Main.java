package lab2;



public class Main {
    public static void main (String[] args) {
        Person[] person  = new Person[6];
        person[0]= new Student("Leo","Wilkinson",Sex.M,"Computer science",3,StageOfTrainig.BACHELOR);
        person[1]= new Student("Anna", "Cunningham",Sex.F,"World economy",1,StageOfTrainig.BACHELOR);
        person[2]= new Student("Jill", "Lundqvist",Sex.M,"Jurisprudence",1,StageOfTrainig.MASTER);
        person[3]= new Student("Ronald", "Correa",Sex.M,"Computer science","Design of a functional programming language.");
        person[4]= new Teacher("Ronald", "Turner",Sex.M,"Computer science",Degree.PhD,"Programming paradigms");
        person[5]= new Teacher("Ruth", "Hollings",Sex.F,"Jurisprudence",Degree.MSc,"Domestic arbitration");

        Person.printAll(person);
    }


}
