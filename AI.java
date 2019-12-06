public class AI implements Player {
    protected String Ton;
    protected String name;
    AI(String name){

        this.name=  name;
    }
    //get the total number of the sticks
    //take 1 stick and returns the remaining number
    //show texts
    public int move(int numSticks){
        System.out.println("There are " + numSticks + " stick(s) on the board.");
        System.out.println("Player 2 selects 1 stick(s). \n");
        return numSticks-1;
    }

    //say the name of that player
    public void startGame(){
        System.out.println(name + " : 'I, the AI, will hope to defeat you!'");
    }

    //check if that player is a person who moves the last stick(s)
    //print the winner and the loser
    public void endGame(boolean win){

        if (win==true)
        {System.out.println(name + " you win ");
        }
        else{
            System.out.println(name + " you lose");
        };
    }
}
