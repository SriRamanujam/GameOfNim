package gameOfNim;
/**
 * Created with IntelliJ IDEA.
 * User: Sri
 * Date: 10/24/12
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Random;

public class Game {

    Random randGen;
    int whoIsFirst;
    int intelligence;
    Pile pile = new Pile();
    //We are going to need to implement HumanPlayer and CompPlayer...
    HumanPlayer player = new HumanPlayer();
    CompPlayer comp;

    public Game() {
        randGen = new Random();

        whoIsFirst = randGen.nextInt(2);
        intelligence = randGen.nextInt(2);
        comp = new CompPlayer(intelligence);

    }
/**
 * This method plays the game entirely through, and takes no arguments.
 * Just run game.playGame().
 */
    public void playGame() {
    	
    	int newSize;

        System.out.println("Hello and welcome!");
        System.out.println("The number of marbles in the pile is: " + pile
                .getSizeOfPile());

        if (whoIsFirst == 1) {
            System.out.println("Human player goes first!");
            while(pile.getSizeOfPile() > 0) {
            	//Human
                newSize = player.playTurn();
                if (newSize <= 0) {
                	System.out.println("You lost!");
                	break;
                }
                pile.setSizeOfPile(pile.getSizeOfPile() - newSize);
                //Computer
                newSize = comp.playTurn(pile.getSizeOfPile());
                if (newSize <= 0) {
                	break;
                }
                pile.setSizeOfPile(newSize);
            }
        } else if (whoIsFirst == 0) {
            System.out.println("Computer player goes first!");
            while(pile.getSizeOfPile() > 0) {
            	//Computer
                newSize = comp.playTurn(pile.getSizeOfPile());
                if (newSize <= 0) {
                	break;
                }
                pile.setSizeOfPile(newSize);
                //Human
                newSize = player.playTurn();
                if (newSize <= 0) {
                	System.out.println("You lost!");
                	break;
                }
                pile.setSizeOfPile(pile.getSizeOfPile() - newSize);
            }
        }
        System.out.println("Game over!");
    }
}
