import java.util.Random;
import java.util.Arrays;

public class SmartAI implements Player {
    protected String name;
    private int[][] hat= new int[101][3];
    private int[][] aiChoice =new int[100][2];
     private int j=0;


    SmartAI(String name){
        this.name=  name;
        for (int[] i: hat){
            i[0]=1;
            i[1]=1;
            i[2]=1;
        }
    }
    public SmartAI() {
    }

    //get the total number of the sticks
    //take 1 stick and returns the remaining number
    //show texts
    public int move(int numSticks) {

        int rand = new Random().nextInt(hat[numSticks][0] + hat[numSticks][1] + hat[numSticks][2]);

        aiChoice[j][0] = numSticks;

        System.out.println("There are " + numSticks + " stick(s) on the board.");

        if (numSticks > 3) {
            if (rand < hat[numSticks][0]) {
                aiChoice[j][1] = 1;
                j++;
                System.out.println("Player 2 selects 1 stick(s). \n");
                return numSticks - 1;
            } else if (rand < hat[numSticks][0] + hat[numSticks][1]) {

                aiChoice[j][1] = 2;
                j++;
                System.out.println("Player 2 selects 2 stick(s). \n");
                return numSticks - 2;
            } else {
                aiChoice[j][1] = 3;
                j++;
                System.out.println("Player 2 selects 3 stick(s). \n");
                return numSticks - 3;
            }
        }
        else if (numSticks>1){
            if (rand < hat[numSticks][0]) {
                aiChoice[j][1] = 1;
                j++;
                System.out.println("Player 2 selects 1 stick(s). \n");
                return numSticks - 1;
            } else if (rand < hat[numSticks][0] + hat[numSticks][1]) {
                aiChoice[j][1] = 2;
                j++;
                System.out.println("Player 2 selects 2 stick(s). \n");
                return numSticks - 2;
            }
        }
            aiChoice[j][1] = 1;
            j++;
        System.out.println("Player 2 selects 1 stick(s). \n");
            return numSticks - 1;
    }

    //this method is like move method, but it will not print anything.
    public int moveTrain(int numSticks) {

        int rand = new Random().nextInt(hat[numSticks][0] + hat[numSticks][1] + hat[numSticks][2]);
        aiChoice[j][0] = numSticks;
        if (numSticks > 3) {
            if (rand < hat[numSticks][0]) {
                aiChoice[j][1] = 1;
                j++;
                return numSticks - 1;
            } else if (rand < hat[numSticks][0] + hat[numSticks][1]) {
                aiChoice[j][1] = 2;
                j++;
                return numSticks - 2;
            } else {
                aiChoice[j][1] = 3;
                j++;
                return numSticks - 3;
            }
        }
        else if (numSticks>1){
            if (rand < hat[numSticks][0]) {
                aiChoice[j][1] = 1;
                j++;
                return numSticks - 1;
            } else if (rand < hat[numSticks][0] + hat[numSticks][1]) {
                aiChoice[j][1] = 2;
                j++;
                return numSticks - 2;
            }
        }
        aiChoice[j][1] = 1;
        j++;
        return numSticks - 1;

    }
    //say the name of that player
    public void startGame(){
        System.out.println(name + " : 'I, the AI, will hope to defeat you!'");
    }
    //check if that player is a person who moves the last stick(s)
    //print the winner and the loser
    public void endGame(boolean win){
        if (win==true) {
            System.out.println(name + " you win ");
            for (int i = 0 ; i < 50 && aiChoice[i][0] != 0; i++) {
                if (aiChoice[i][1] == 1) {
                    hat[aiChoice[i][0]][0]++;
                }
                if (aiChoice[i][1] == 2) {
                    hat[aiChoice[i][0]][1]++;
                }
                if (aiChoice[i][1] == 3) {
                    hat[aiChoice[i][0]][2]++;
                }
            }
        }
        else {
            System.out.println(name + " you lose");
            for (int i = 0; i < 50 && aiChoice[i][0] != 0; i++) {
                if (aiChoice[i][1] == 1 && hat[aiChoice[i][0]][0] != 1) {
                    hat[aiChoice[i][0]][0]--;
                }
                if (aiChoice[i][1] == 2 && hat[aiChoice[i][0]][1] != 1) {
                    hat[aiChoice[i][0]][1]--;
                }
                if (aiChoice[i][1] == 3 && hat[aiChoice[i][0]][2] != 1) {
                    hat[aiChoice[i][0]][2]--;
                }
            }
        }
        aiChoice =new int[50][2];
        j=0;
    }

    //check which AI is a loser and winner
    //check who is the winner. the winner will add the numbers of sticks it has just used to its hat. the loser will do the opposite thing.
    public void endGameforAI(boolean win){

        if (win==true) {
            for (int i = 0 ; i < 50 && aiChoice[i][0] != 0; i++) {
                if (aiChoice[i][1] == 1) {
                    hat[aiChoice[i][0]][0]++;
                }
                if (aiChoice[i][1] == 2) {
                    hat[aiChoice[i][0]][1]++;
                }
                if (aiChoice[i][1] == 3) {
                    hat[aiChoice[i][0]][2]++;
                }

            }
        }
        else {
            for (int i = 0; i < 50 && aiChoice[i][0] != 0; i++) {
                if (aiChoice[i][1] == 1 && hat[aiChoice[i][0]][0] != 1) {
                    hat[aiChoice[i][0]][0]--;
                }
                if (aiChoice[i][1] == 2 && hat[aiChoice[i][0]][1] != 1) {
                    hat[aiChoice[i][0]][1]--;
                }
                if (aiChoice[i][1] == 3 && hat[aiChoice[i][0]][2] != 1) {
                    hat[aiChoice[i][0]][2]--;
                }
            }
        }
        aiChoice =new int[50][2];
        j=0;
    }

    public int[][] getHat(){
        return hat;
    }
}
