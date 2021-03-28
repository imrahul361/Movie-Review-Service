
import java.util.*;
import java.util.stream.Collectors.*;
import java.util.Map.Entry;  
class InvalidYearException extends Exception{
    public InvalidYearException(String s){
        super(s);
    }
}
public class Review{
    private static Map<String,HashMap<String,Integer>> score = new HashMap< String,HashMap< String,Integer >> ();

    public Review(){

    }
    public Review(String user,String movie,int rating){
        if(new User().searchUser(user,movie)){
           //do nothing
           System.out.println("Duplicate Review");
       }else{
        try{
            if(new Movie().getYear()>2020) throw new InvalidYearException("Can't review future movies");
            new User(user).addReview(user,movie);
            int wt = new User().Ratingweightage(user);
           // System.out.println(user+"---"+movie+"----"+rating+"---"+wt);
            Set<String> genre = null;
            
                genre = App.mov.get(movie).getGenre();
                if(wt > 1){
                    for(String s: genre){
                        if(score.containsKey(s)){
                            if(score.get(s).containsKey(movie))score.get(s).put(movie,score.get(s).get(movie)+rating);
                            else{
                             score.get(s).put(movie,rating);
                            }
                        }else{
                            HashMap<String, Integer> tmp = new HashMap<String,Integer>();
                            tmp.put(movie,rating);
                            score.put(s,tmp);
                        }
                    }
                }
                new Movie().addReview(App.mov.get(movie),rating*wt);
            }
            catch(InvalidYearException e1){
                System.out.println(e1.getMessage());
            }
            catch(Exception e){
              System.out.println("MisMatched Information");
            }
       }
    }
    public double avg_review_score_byYear(int year){
        int sum=0,cnt=0;
        for(Movie x: App.mov.values())
           if(x.getYear()==year)
            {
                sum+=x.getSumRating();
                cnt+=x.getReviewer();
            }
        if(cnt==0)cnt++;
        return (double)sum/cnt;
    }
    public double avg_review_score_ParticularMovie(String movie){
        return new Movie().getAvgRating(App.mov.get(movie));
    }
    public ArrayList<String> total_review_scoreByCritics(int n,String genre){
        ArrayList<String> rvw = new ArrayList<String>();
            try{
            Map<String,Integer> mp = score.get(genre);

            List< Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(mp.entrySet());   
            Collections.sort(list, new Comparator<Entry<String, Integer>>()   
            {  
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)   
                {   
                    return o2.getValue().compareTo(o1.getValue());  
                }  
            }  
            );
            
            Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();  
            for (Entry<String, Integer> entry : list)   
                sortedMap.put(entry.getKey(), entry.getValue());  
            for (Entry<String, Integer> entry : sortedMap.entrySet())   
            {  
                n--;
                rvw.add(entry.getKey());  
                if(n==0)break;
            }   
        } catch (Exception e) {
            System.out.println("Not Match found");
        }
        
        return rvw;
    
    }
    
   

}