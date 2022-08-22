import java.util.Hashtable;
import java.util.Map;

public class SongCollection {

    public Hashtable<String, String> songCollection = new Hashtable<>();

    public void addSongs(){
        String[] songsNames = {"Sacrifice", "Take My Breath", "Out of Time"};
        String [] lyrics = {"I was born in a city where the winter nights never sleep", "It's like a dream what she feels with me. She loves to be on the edge",
                "If he mess up just a little, baby, you know my line. If you don't trust him a little, then come right back, girl, come right back"};
        for(int i=0; i < songsNames.length; i++){
            songCollection.put(songsNames[i], lyrics[i]);
        }

    }

    public void displayCollection(){
       for(String song: songCollection.keySet()){
           System.out.println(song + ": " +  songCollection.get(song));
        }
    }



}
