import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/*
Control the song collection operations:
    - randomize lyrics method X
    - display lyrics to Main class X
    - check User guess X
    - displayUserScore X
 */
public class SongCollection {
    // Keys are song names & values are lyrics
    Hashtable <String,String> songCollection = new Hashtable<>();
    String[] songsNames = {"Sacrifice", "Take My Breath", "Out of Time", "Faith", "In Your Eyes", "Starry Eyes"};
    String [] lyrics = {"\"I was born in a city where the winter nights never sleep.\"", "\"It's like a dream what she feels with me. She loves to be on the edge.\"",
            "\"If he mess up just a little, baby, you know my line. If you don't trust him a little, then come right back, girl, come right back.\"",
            "\"I feel everything, I feel everything from my body to my soul\"", "\"You always try to hide the pain, You always know just what to say.\"",
            "\"And I wanna feel you close. But you're defeated, baby. Broken, hurtin', sufferin' from a shattered soul.\""};

    String randomLyrics;
    int userScore =0;
    ArrayList<String> alreadySelectedLyrics = new ArrayList<>();
    int numberOfRoundsPlayed=0;


    /*
    Use Random class:
        - pick any number that is between the range of lyrics array index (0-2)
        - dont display same lyrics twice
     */
    public String randomlySelectLyrics(){
        randomLyrics="";
        Random ran = new Random();
        int randNum = ran.nextInt(lyrics.length);

        //if the lyrics already exists in alreadySelectedLyrics, rerun the randomizer
        // implementation is kinda trash cuz the randomizer has to run multiple times then until
        // it selects a number that has not been selected before
        // maybe it would be more efficient if i turned the lyrics array to an array list and deleted the songs that have already been selected.
        // then at the end of the game, re-add the lyrics?
        boolean alreadyExists = false;
        while(!alreadyExists){
            if(alreadySelectedLyrics.contains(lyrics[randNum])){
                randNum = ran.nextInt(lyrics.length);
            }
            else{
                alreadyExists= true;
            }
        }


        randomLyrics = lyrics[randNum];
        alreadySelectedLyrics.add(lyrics[randNum]);

        return randomLyrics;
    }

    public void displayRandomLyrics(){
        System.out.println(numberOfRoundsPlayed+1 + "." + randomLyrics);
        numberOfRoundsPlayed++;
    }

    public boolean checkUserGuess(String guess){
        boolean check = false;
        for(int i=0; !check && i< songsNames.length; i++){
            if(guess.equalsIgnoreCase(songsNames[i])){
                check = true;
                userScore++;
            }
        }

        return check;
    }

    public void displayCorrectAnswer(String guess) {
        if (checkUserGuess(guess)) {
            System.out.println("Yup that's right!\n");
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
        System.out.println("Your score is: " + userScore + " out of 5");
        if(userScore==5){
            System.out.println("You got perfect! Good job!!");
        }
        System.out.print("\n");
    }


}
