import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
moviename
release year
genre set

function- 

getRating
avgRating
*/
import java.util.*;
public class Movie {
    private int Id;
    private String MovieName;
    private int ReleaseYear;
    private Set<String> genres = new HashSet<String>();
    private int SumRating = 0;
    private int Reviewers = 0;
    public static int counter = 1;
    
    public Movie(){
        
    }
    public Movie(String Details) {
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(Details);
        if (m.find()) {
            MovieName = m.group();
            MovieName = MovieName.substring(1, MovieName.length() - 1);
        }
        this.Id = counter++;
        p = Pattern.compile("“([^”]*)”");
        m = p.matcher(Details);
        while (m.find()) {
            String g = m.group();
            this.genres.add(g.substring(1, g.length() - 1));
        }
        p = Pattern.compile("[0-9]{4}");
        m = p.matcher(Details);
        if (m.find()) {
            this.ReleaseYear = Integer.valueOf(m.group());
        }
        // System.out.println("cur--"+this.Id+ " "+this.MovieName +" "+this.ReleaseYear+" "+this.SumRating+" "+this.Reviewers);
        // System.out.println("-----genre-------");
        // for(String x: this.genres)System.out.println(x);
        // System.out.println("-------------------------------");

    }
    public String getMovieName(){
        
        return this.MovieName;
    }
    public Set<String> getGenre(){
        return this.genres;
    }
    public int getSumRating(){
        return this.SumRating;
    }
    public void setSumRating(int rating){
        this.SumRating = rating;
    }
    public void inc_Reviewers(){
        this.Reviewers++;
    }
    public int getReviewer(){
        return this.Reviewers;
    }
    public int getYear(){
        return this.ReleaseYear;
    }
    public void addReview(Movie m,int rating){
       rating+= m.getSumRating();
       m.setSumRating(rating);
       m.inc_Reviewers();
    }
    public double getAvgRating(Movie m){
        try {
            System.out.println(m.SumRating+" "+m.Reviewers);
            return (double)(m.SumRating)/(m.Reviewers);
        } catch (Exception e) {
            //TODO: handle exception
            return 0;
        }
        
    }

}