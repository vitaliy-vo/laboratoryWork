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


        File[] files= new File[4];
        files[0] = new Audio.Docx("j110-lab2-hiers.docx",23212,"docx",2);
        files[1] = new Image("spb-map.png",1703527,"image",1024,3072);
        files[2] = new Audio("06-PrettyGirl.mp3",7893454,"audio",new String[]{"Eric Clapton", "Pretty Girl"},5,28,0);
        files[3] = new Video("BackToTheFuture1.avi",1470984192,"video", new String[]{"Back to the future I", "1985"}, 1,48,8,640,352);

        File.printAll(files);

    }


}
