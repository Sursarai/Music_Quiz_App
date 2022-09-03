import java.util.Scanner;



public class Main {
    public static void main(String [] args) {
        String playAgain = "y";
        Scanner scan = new Scanner(System.in);

        while (playAgain.equalsIgnoreCase("y")) {
            System.out.println("***** Welcome to Music Quiz! ******");
            System.out.println("Here are your instructions:");
            System.out.println("A randomly generated lyrics from a song will be displayed for you to guess which song it is from. There are 5 rounds to play through.\n" +
                    "If you do not want to keep playing, simply input \"q\" to leave the game. After 5 rounds or after you choose to quit, you can choose to play again.\n" +
                    "Let's Start!\n");

            // initializes the storage of the game
            SongCollection sc = new SongCollection();

            String answer = "";

            while (sc.numberOfRoundsPlayed < 5 && !answer.equals("q")) {
                sc.randomlySelectLyrics();
                sc.displayRandomLyrics();

                System.out.println("What's your guess?");
                answer = scan.nextLine();

                if(answer.equals("q")){
                    System.out.println("You have chosen to end the game!\n");

                }
                else{
                    sc.displayCorrectAnswer(answer);
                    sc.displayUserScore();
                }




            }

            System.out.println("Would you like to play again? (y/n) ");
            String play = scan.nextLine();
            if(!play.equalsIgnoreCase("y")){
                playAgain = "n";

            }


        }
    }

}
