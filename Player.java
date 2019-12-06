public interface Player
{
    //get the total number of the sticks
    //return the remaining number of the sticks
    //print and get a number from 1 to 3 from the user
    //if it is neither 1 nor 2 nor 3, get a new number from the user again
    public int move(int numSticks);

    //say the name of that player
    public void startGame();

    //check if that player is a person who moves the last stick(s)
    //print the winner and the loser
    public void endGame(boolean win);
}