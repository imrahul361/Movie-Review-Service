
import java.util.*;
public class User {
    //m= name --> array(tag,no_of_review)
    //r= name--> set(movie_name)
    public static HashMap < String, ArrayList<String> > m = new HashMap<String, ArrayList<String> > ();
    private static HashMap< String, HashSet<String> > r = new HashMap<String,HashSet<String>>();

    public User(){

    }
    public User(String name) {
        if(m.containsKey(name))
        {
            int reviews = Integer.valueOf(m.get(name).get(1))+1;
           
            if (reviews > 10)
                m.get(name).set(0,"Admin");
            else if (reviews > 6)
                m.get(name).set(0,"Expert");
            else if (reviews > 3)
                m.get(name).set(0,"Critic");
            else
                m.get(name).set(0,"Viewer");
            m.get(name).set(1,String.valueOf(reviews));    
           
        }
        else
        {
            ArrayList<String> a = new ArrayList<String>();
            a.add("Viewer");
            a.add("0");
            m.put(name,a);
            HashSet<String> s = new HashSet<String>();
            r.put(name,s);
        }
        
    }
    public boolean searchUser(String user,String Movie){
        if(m.containsKey(user))
        {
           if(r.get(user).contains(Movie))
                return true;
           else
                return false;
           
        }
        return true;
    }
    public void addReview(String user,String Movie){
        r.get(user).add(Movie);
    }
    
    public int Ratingweightage(String user){
        ArrayList<String> a = m.get(user);
        int reviews = Integer.valueOf(a.get(1));
        if (reviews > 10)
            return 4;
        else if (reviews > 6)
            return 3;
        else if (reviews > 3)
            return 2;
        else
            return 1;
    }
   
}