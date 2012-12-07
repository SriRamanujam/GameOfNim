package gameOfNim;
/**
 * Created with IntelliJ IDEA.
 * User: Sri
 * Date: 10/25/12
 * Time: 2:03 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;

public class HumanPlayer {

    Scanner scan;

    public HumanPlayer() {

         scan = new Scanner(System.in);

    }
/**
 * Plays the human "turn". All it does is ask for input, and then return that input
 * to be handled by game.playGame(). 
 * 
 * If you try to cheat it, it punishes you by returning 1.
 * @return
 */
    public int playTurn() {

        System.out.println("Please enter the number of tiles you wish to " +
                "remove");
        int input = scan.nextInt();

        if (input <= 0) {
        	System.out.println("Nope, can't do that. You just forfeited your " +
        			"turn");
        	return 1;
        } else {
        	return input;
        }
    }
}
