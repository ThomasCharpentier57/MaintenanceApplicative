package trivia;

import java.io.*;
import java.util.LinkedList;

public enum Category {
    POP("Pop", "pop.properties"), SCIENCE("Science", "science.properties"), SPORTS("Sports","sports.properties"), ROCK("Rock","rock.properties"), GEOGRAPHIE("Géographie","geographie.properties");

    private final String stringValue;
    private final String path;

    Category(final String s, final String p){
        this.stringValue = s;
        this.path = p;
    }

    public LinkedList<String> getQuestions() {
        LinkedList<String> questions = new LinkedList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("./questions/" + path));
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line);
            }
            br.close();
        }catch (IOException e){
            System.out.println("Erreur de lecture du fichier");
        }
        return questions;
    }

    public String toString(){
        return this.stringValue;
    }
}
