import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

// Game of sticks, main method
// Written by Dave Musicant
public class SticksGame
{
    static int numAI=7000;
    static int numAI2;
    static int count2=0;

    public static void playGameOnce1(Player player1, Player player2, int totalSticks)
{

    //check who is the last person who play
    int win=1;

    //welcome to players
    System.out.println("Here is where the game shall be played \n");
    player1.startGame();
    player2.startGame();
    System.out.println("");
    //run the game while the total number of sticks is not zero
    while(totalSticks!=0){
        totalSticks=player1.move(totalSticks);
        win++;
        if(totalSticks!=0) {
            totalSticks = player2.move(totalSticks);
            win++;
        }

    }

    //show who wins and loses
    player1.endGame(win%2==1);
    player2.endGame(win%2==0);


}

    public static void playGamewithAI(Player player1, Player player2, int totalSticks)
    {

        //check who is the last person who play
        int win=1;

        //welcome to players
        System.out.println("Here is where the game shall be played \n");
        player1.startGame();
        player2.startGame();
        System.out.println("");

        //run the game while the total number of sticks is not zero
        while(totalSticks!=0){
            totalSticks=player1.move(totalSticks);
            win++;
            if(totalSticks!=0) {
                totalSticks = player2.move(totalSticks);
                win++;
            }
        }
        //show who wins and loses
        player1.endGame(win%2==1);
        player2.endGame(win%2==0);


        //check if player want to play this again
        System.out.println("Do you want to play again? (Yes: 1, No: 2)");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextInt()==1){

            System.out.print("How many sticks are there on the table initally? (10-100)? ");
            totalSticks = scanner.nextInt();
            while (totalSticks < 10 || totalSticks > 100)
            {
                System.out.println("Please enter a number between 10 and 100.");
                System.out.print("How many sticks are there on the table initally? (10-100)? ");
                totalSticks = scanner.nextInt();
            }
            playGamewithAI( player1, player2, totalSticks);
        }

    }
        //this method is for training AI.
    public static void trainAI(SmartAI player1, SmartAI player2)
    {
        int totalSticks= 100;

        //check who is the last person who play
        int win=1;

        //run the game while the total number of sticks is not zero
        while(totalSticks!=0){
            totalSticks=player1.moveTrain(totalSticks);
            win++;
            if(totalSticks!=0) {
                totalSticks = player2.moveTrain(totalSticks);
                win++;
            }
        }
        //check who is the winner. the winner will add the numbers of sticks it has just used to its hat. the loser will do the opposite thing.
        player1.endGameforAI(win%2==1);
        player2.endGameforAI(win%2==0);


    }




    public static void main(String[] args)
    {
        // Initial setup
        System.out.println("Welcome to the game of sticks!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many sticks are there on the table initally? (10-100)? ");
        int totalSticks = scanner.nextInt();
        while (totalSticks < 10 || totalSticks > 100)
        {
            System.out.println("Please enter a number between 10 and 100.");
            System.out.print("How many sticks are there on the table initally? (10-100)? ");
            totalSticks = scanner.nextInt();
        }

        System.out.println("Options:");
        System.out.println("Play against a friend (1)");
        System.out.println("Play against the computer (2)");
        System.out.println("Play against the trained computer (3)");
        System.out.print("Which option do you take (1-3)? ");
        int option = scanner.nextInt();

        // Choose which game: 1 = human v human, 2 = human v AI,  3=human v trained AI
        if (option == 1)
        {
            Player player1 = new Human("Player 1");
            Player player2 = new Human("Player 2");
            playGameOnce1(player1, player2, totalSticks);

        }
        else if (option == 2)
        {
            Player player1 = new Human("Player 1");
            Player player2 = new SmartAI("Player 2");
            playGamewithAI(player1, player2, totalSticks);

        }
        else if (option ==3) {

            //create a player and two AI to train each other
            Player player1 = new Human("Player 1");
            SmartAI player2 = new SmartAI("Player 2");
            SmartAI trainer = new SmartAI("Trainer");

            System.out.println("\nWait for an AI to be trained\n");


            //train AI 1000000 times
            for(int i=0;i<1000000;i++) {
                trainAI(player2, trainer);
            }

            //print hat
            for(int i=1;i<101;i++){
                System.out.println(Arrays.toString(player2.getHat()[i]));
            }

            playGamewithAI(player1, player2, totalSticks);

        }
        else
        {
            System.out.println("Bad choice.");
        }

    }
}