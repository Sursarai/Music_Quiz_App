import java.util.Scanner;



public class Main {
    public static void main(String [] args) {
        String playAgain = "y";
        Scanner scan = new Scanner(System.in);

        while (playAgain.equalsIgnoreCase("y")) {
            System.out.println("Welcome to Music Quiz!");
            System.out.println("Here are your instructions: ");
            SongCollection sc = new SongCollection();

            String answer = "";
            sc.addSongs();

            //    sc.displayCollection();
            while (sc.numberOfRoundsPlayed < 3 && !answer.equals("q")) {
                sc.randomlySelectLyrics();
                sc.displayRandomLyrics();

                System.out.println("What's your guess?");
                answer = scan.nextLine();

                sc.displayCorrectAnswer(answer);
                if (!answer.equals("q")) {
                    sc.displayUserScore();
                }

            }

            System.out.println("Would you like to play again? (y/n) ");
            String play = scan.nextLine();
            if(play.equalsIgnoreCase("n")){
                playAgain = "n";
            }


        }
    }

}
