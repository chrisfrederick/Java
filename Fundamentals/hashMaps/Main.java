import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        HashMap<String, String> album = new HashMap<String, String>();

        album.put("Track1","Song lyrics for track 1");
        album.put("Track2","Song lyrics for track 2");
        album.put("Track3","Song lyrics for track 3");
        album.put("Track4","Song lyrics for track 4");

        String oneSong = album.get("Track1");
        System.out.println(oneSong);
        
        Set<String> keys = album.keySet();
        for(String key : keys){
            System.out.println(key);
            System.out.println(album.get(key));
        }
    }
}
