package DEVJ110_lab22;

public class Main {

    public static void main(String[] args) {
        File[] files = new File[4];
        files[0] = new Docx("j110-lab2-hiers.docx", 23212, "docx", 2);
        files[1] = new Image("spb-map.png", 1703527, "image", 1024, 3072);
        files[2] = new Audio("06-PrettyGirl.mp3", 7893454, "audio", new String[]{"Eric Clapton", "Pretty Girl"}, 328);
        files[3] = new Video("BackToTheFuture1.avi", 1470984192, "video", new String[]{"Back to the future I", "1985"}, 6488 ,640,352 );

        File.printAll(files);

    }
}
