import java.util.Scanner;

public class Human implements Player {
    protected String name;
    Scanner input =new Scanner(System.in);
    Human(String name){
        this.name=name;
    }

    //get the total number of the sticks
    //return the remaining number of the sticks
    //print and get a number from 1 to 3 from the user
    //if it is neither 1 nor 2 nor 3, get a new number from the user again
    //if the input is greater than the total number, get a new number
    public int move(int numSticks){
        System.out.println("There are " + numSticks + " stick(s) on the board.");
        System.out.print(name+" How many sticks do you take (1-3)? ");
        int stick =input.nextInt();
        while (stick<1||stick>3||stick>numSticks){
            if(stick<1||stick>3){
                System.out.print("Please enter a number between 1 and 3. ");
            }else {
                System.out.print("Please enter a number between 1 and "+numSticks+" .");
            }
             stick =input.nextInt();
        }
        System.out.println("");
        numSticks=numSticks-stick;

        return numSticks;
    }

    //say the name of that player
    public void startGame(){
        System.out.println(name + ": Good Luck!");
    }

    //check if that player is a person who moves the last stick(s)
    //print the winner and the loser
    public void endGame(boolean win){

       if (win==true)
       {System.out.println(name + " you win ");
       }
       else{
           System.out.println(name + " you lose");
       }
    }
}
