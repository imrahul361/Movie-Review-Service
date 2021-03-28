import java.util.*;

public class App {
    //moviename -->movie
    public static HashMap<String, Movie> mov = new HashMap<String,Movie>();
    
    public static void main(String[] args) {
        Movie a = new Movie(" \"Don\" released in Year 2006 for Genres “Romance” & “Comedy”");
        mov.put(a.getMovieName(),a);
        Movie b = new Movie(" \"Tiger\" released in Year 2008 for Genre “Romance”");
        mov.put(b.getMovieName(),b);
        Movie c = new Movie("\"Padmaavat\" released in Year 2006 for Genre “Romance”");
        mov.put(c.getMovieName(),c);
        Movie d = new Movie("\"Lunchbox\" released in Year 2021 for Genre “Romance”");
        mov.put(d.getMovieName(),d);
        Movie e = new Movie("\"Guru\" released in Year 2006 for Genre “Romance”");
        mov.put(e.getMovieName(),e);
        Movie f = new Movie("\"Metro\" released in Year 2006 for Genre “Romance”");
        mov.put(f.getMovieName(),f);
        new User("SRK");
        new User("Salman");
        new User("Deepika");
        new Review("SRK", "Don", 2);
        new Review("SRK", "Padmavaat", 8);
        new Review("Salman", "Don", 5);
        new Review("Deepika", "Don", 9);
        new Review("Deepika", "Guru", 6);
        new Review("SRK","Don", 10);
        new Review("Deepika", "Metro", 5);
        new Review("SRK", "Tiger", 5);
        new Review("SRK", "Metro", 7);
        new Review("Deepika", "Padmaavat", 7);
        
        System.out.println("Particular Movie Average Score: "+ new Review().avg_review_score_ParticularMovie("Don"));
        System.out.println("Average Score Movie by Year: "+ new Review().avg_review_score_byYear(2006));
        System.out.println("Top 2 Movies Romance: ");
        ArrayList<String> arr = new Review().total_review_scoreByCritics(2,"Romance");
        for(String x:arr)System.out.println(x);

    }
}