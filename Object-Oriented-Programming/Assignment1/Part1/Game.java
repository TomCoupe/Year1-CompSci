import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Game {
    public static int rounds; //making the rounds variable static so it can be used through the entire program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //taking user input
        System.out.print("How many rounds would you like to play? "); //asking how many rounds are to be played
        rounds = scanner.nextInt(); //rounds = integer input by user
        while (true) {
            if (rounds < 0) {
                System.out.println("You cannot have a number of rounds less than zero"); //not allowing integers less than 0
                System.exit(0); // close the program if rounds < 0
            }
            if (rounds >= 1) {
                System.out.println("Rounds chosen: "+rounds+" Rounds"); // displaying the rounds chosen
                break; //break from loop
            }
            else if (rounds == 0) {
                System.out.println("Goodbye, you chose 0 rounds");  //saying goodbye to the user if rounds == 0.
                System.exit(0);//close the game because the user chose 0 rounds.
            }
        }
        dicerolls(); //calling dicerolls() outside of the while loop so when rounds >= 1 it breaks and calls dicerolls()

    }
    public static void dicerolls() { //dicerolls()
            int[] dice = new int[6]; //creating an array for the dice rolls
            int roundsComplete = 0; //setting the completed rounds to zero before the game starts
            int player1wins = 0; //setting the rounds won by player
            int player2wins = 0;
			ThreeDiceScorer[] player1r = new ThreeDiceScorer[rounds];
			ThreeDiceScorer[] player2r = new ThreeDiceScorer[rounds];
			int player1score; //Declaring the player1score as an integer value
			int player2score; //Declaring the player1score as an integer value
			int AVGscore1 = 0;
			int AVGscore2 = 0;
			double AVG1 = 0;
			double AVG2 = 0;
            int[] player1AVGscores = new int[rounds];
            int[] player2AVGscores = new int[rounds];
            while (roundsComplete < rounds) { //creating a while loop that only loops when rounds complete is less than rounds.
				//the loop will stop looping when the chosen amount of rounds has been reached
				dice = roll_dice(); // using the roll_dice method to roll each of the dice from the array randomly
				player1r[roundsComplete] = new ThreeDiceScorer(dice[0],dice[1],dice[2]); //creating the dice for player 1
				player2r[roundsComplete] = new ThreeDiceScorer(dice[3],dice[4],dice[5]); //creating the dice for player 2
						   
				 /*creating a new variable that uses the getpoints() method from 
                ThreeDiceScorer to get a score for each players dice rolls*/
                player1score = player1r[roundsComplete].getpoints();
				player2score = player2r[roundsComplete].getpoints();
                //this increases the rounds complete by 1 each time it loops, once roundsComplete = rounds the loop will stop.
                roundsComplete++; 
                //Displaying the current round and the dice outcomes for player 1 and player 2
				System.out.println("Round "+roundsComplete+".   Player 1: "+dice[0]+" "+dice[1]+" "+dice[2]+"  Player 2: "+dice[3]+" "+dice[4]+" "+dice[5]+"  ");
                //after the die rolls have been output it will display the score for each player 
				System.out.println("Player 1 Score: "+player1score+"    Player 2 Score: "+player2score);
				AVGscore1 = AVGscore1 + player1score;
				AVG1 = AVGscore1 / rounds;
				AVGscore2 = AVGscore2 + player2score;
				AVG2 = AVGscore2 / rounds;
               
				//these if statements output the player with the most amount of points at the end of each round and declare a winner
				if (player1score > player2score) {
                    player1wins++; // adds to the total of player1 wins
                    //if player1 score is higher than player 2, player 1 wins
					System.out.println("Player 1 Won the round \n");
                }
				else if (player1score < player2score) {
                    player2wins++; // adds to the total of player2 wins
                    //if player1 score is less than player 2, player 2 wins
					System.out.println("Player 2 Won the round \n");
                }
				else 
                    //if both scores are the same it is a draw.
					System.out.println("Draw");
			}
			System.out.println("Player 1 rounds won: "+player1wins+"   Player 2 rounds won: "+player2wins);
            if (player1wins > player2wins) {
                System.out.println("Player 1 Won The Game");
			}
        
            else if (player1wins < player2wins) {
                System.out.println("Player 2 Won The Game");
			}
            else 
                System.out.println("Both players tied, its a draw");
			
			System.out.println("Average for Player 1: "+AVG1);
			System.out.println("Average for Player 2: "+AVG2);
    
    }

    public static int[] roll_dice() {
        int[] dRoll = new int[6];
        for (int  i = 0; i<6;i++) //this method 
            dRoll[i] = 1 + (int)(6 * Math.random());    
        return dRoll;
    } 

}