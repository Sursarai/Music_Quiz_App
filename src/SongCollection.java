import java.util.Hashtable;
import java.util.Random;

/*
Control the song collection operations:
    - adding keys and values into hashtable  X
    - randomize lyrics method X
    - display lyrics to Main class X
    - check User guess X
    - displayUserScore X
 */
public class SongCollection {
    // Keys are song names & values are lyrics
    // Hashtable may not be needed for this problem
    public Hashtable<String, String> songCollection = new Hashtable<>();
    String[] songsNames = {"Sacrifice", "Take My Breath", "Out of Time"};
    String [] lyrics = {"I was born in a city where the winter nights never sleep.", "It's like a dream what she feels with me. She loves to be on the edge.",
            "If he mess up just a little, baby, you know my line. If you don't trust him a little, then come right back, girl, come right back."};
    String randomLyrics;
    int userscore =0;
    int numberOfRoundsPlayed=0;
    boolean endGame;

    // Add songs names and their corresponding lyrics into Hashtable
    public void addSongs(){
        for(int i=0; i < songsNames.length; i++){
            songCollection.put(songsNames[i], lyrics[i]);
        }

    }
    // For testing that values were inputted into hashtable correctly
    public void displayCollection(){
       for(String song: songCollection.keySet()){
           System.out.println("Song:" + song + "\nLyrics: " +  songCollection.get(song));
        }
    }

    /*
    Use Random class:
        - pick any number that is between the range of lyrics array index (0-2)
        - dont display same lyrics twice
     */
    public String randomlySelectLyrics(){
        randomLyrics="";
        Random ran = new Random();
        int randNum = ran.nextInt(lyrics.length);

        randomLyrics = lyrics[randNum];

        return randomLyrics;
    }

    public void displayRandomLyrics(){
        System.out.println(numberOfRoundsPlayed+1 + ". " + randomLyrics);
        numberOfRoundsPlayed++;
    }

    public boolean checkUserGuess(String guess){
        boolean check = false;
        for(int i=0; !check && i< songsNames.length; i++){
            if(guess.equalsIgnoreCase(songsNames[i])){
                check = true;
                userscore++;
            }
        }

        return check;
    }

    public void displayCorrectAnswer(String guess) {
        if (checkUserGuess(guess)) {
            System.out.println("Yup that's right!");
        } else if (guess.equalsIgnoreCase("q")) {
            endGame = true;
            System.out.println("You have chosen to end the game.");

        }
        else{
            System.out.println("Sorry this is actually: ");
            int index = 0;
            for (int i = 0; i < lyrics.length; i++) {
                if (lyrics[i].equals(randomLyrics)) {
                    index = i;
                }
            }
            System.out.println(songsNames[index]);

        }


    }

    public void displayUserScore(){
        System.out.println("Your current score is: " + userscore + " out of 5");
    }


}
