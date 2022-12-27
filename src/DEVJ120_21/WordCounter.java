package DEVJ120_21;

import DEVJ110_lab22.File;

import java.io.*;
import java.util.*;

import static java.lang.Character.UnicodeBlock.of;
import static java.lang.Character.UnicodeBlock.CYRILLIC;

public class WordCounter {


        private static final String AL_REPORT = "report-by-alph.txt";
        private static final String AL_REVERS = "report-by-alph-rev.txt";
        private static final String FREQ_REPERS ="report-by-freq.txt";


        private final Map<String, Integer> words = new HashMap<>();

        public WordCounter(String fileName) throws IOException {
                File(fileName);
                saveReports();

        }



        public void File(String fileName) throws IOException {
                try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        String s;
                        while(( s = br.readLine() ) != null) {
                                s = s.toLowerCase();
                                int p = 0;
                                while(p < s.length()) {

                                        while(p < s.length() && of(s.charAt(p)) != CYRILLIC)
                                                p++;

                                        int st = p;
                                        while(p < s.length()
                                                && (of(s.charAt(p)) == CYRILLIC || s.charAt(p) == '-'))
                                                p++;

                                        if(st < p) {
                                                String w = s.substring(st, p);

                                                words.put(w, words.getOrDefault(w, 0) + 1);

                                        }
                                }
                        }
                }
        }


        public void saveReports() throws FileNotFoundException {
                Map.Entry<String, Integer>[] data = words.entrySet().toArray(new Map.Entry[0]);
                int wordsTotal = 0;
                for (Map.Entry<String, Integer> e : data) {
                        wordsTotal += e.getValue();
                }

                Arrays.sort(data,
                        (e1, e2) -> e1.getKey().compareTo(e2.getKey()));
                saveReport(AL_REPORT, data, wordsTotal);

                Arrays.sort(data,
                        (e1, e2) -> compareStringsByBackDict(e1.getKey(), e2.getKey()));
                saveReport(AL_REVERS, data, wordsTotal);

                Arrays.sort(data,
                        (e1, e2) -> {
                                int r = -e1.getValue().compareTo(e2.getValue());
                                if(r != 0)
                                        return r;
                                return e1.getKey().compareTo(e2.getKey());
                        });
                saveReport(FREQ_REPERS, data, wordsTotal);
        }


        private void saveReport(String fileName, Map.Entry<String, Integer>[] data,
                                int wordsTotal) throws FileNotFoundException {
                try(PrintWriter pw = new PrintWriter(fileName)) {
                        for (Map.Entry<String, Integer> e : data) {
                                pw.format("Слово : %-25s | Абсолютная чистота: %-3d | Относительная чистота : %-4f \n ",e.getKey(), e.getValue(),((float)e.getValue() / wordsTotal));
                                /*pw.println(e.getKey() + ", " + e.getValue() + ", "
                                        + ((float)e.getValue() / wordsTotal));*/
                        }
                }
        }


        private static int compareStringsByBackDict(String s1, String s2) {


                int p1 = s1.length() - 1,
                        p2 = s2.length() - 1;
                while(p1 >= 0 && p2 >= 0) {
                        int r = Character.compare(s1.charAt(p1), s2.charAt(p2));
                        if(r != 0)
                                return r;
                        p1--;
                        p2--;
                }

                return p1 - p2;
        }
}


