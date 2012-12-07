package gameOfNim;
/**
 * Created with IntelliJ IDEA.
 * User: Sri
 * Date: 10/25/12
 * Time: 2:03 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Random;

public class CompPlayer {

    private int intel;
    private Random randGen = new Random();
    
    public CompPlayer(int intelligence) {
        intel = intelligence;
    }
/**
 * takes pileSize in, and computes the logic for the stupid track of the computer.
 * Returns a random number between 1 and pileSize/2 for use in playTurn below.
 * 
 * Surrenders gracefully and returns -1 if there is no way for it to win.
 * @param pileSize
 * @return
 */
    private int tryPlay(int pileSize) {
    	//ok, this loop triggers whether the computer or the human won
    	if (pileSize <= 2) {
    		System.out.println("Human player has won!");
    		return -1;
    	}
    	double pileSizeDouble = (double)pileSize / (2.0) - 1 + 1; 
        return randGen.nextInt((int) pileSizeDouble);
    }
/**
 * Runs the computer's logic. If intel is 0, the computer plays stupid, and removes
 * a random number, decided by tryPlay above. 
 * 
 * If it's smart, it runs a bit more complicated logic, essentially trying to get
 * the pile size to be a 2^n - 1, whatever the closest value will be. If it realizes
 * that it's lost the turn already (ie, only one marble/tile/pebble left, it will 
 * surrender (bool autoDead). Returns -1 if there are any errors. 
 * @param pileSize
 * @return
 */
    public int playTurn(int pileSize) {
    	
    	System.out.println("Computer turn now!");

        if (intel == 0) {
            //this is the stupid track
            int play = tryPlay(pileSize);

            while (play > pileSize) {
                play = tryPlay(pileSize);
            }
            return play;

        } else if (intel == 1) {
            //this is the smart track

            Integer[] valids = {3, 7, 15, 31, 63};
            boolean autoDead = true;
            for (int valid : valids) {

                if (valid < pileSize) {
                    autoDead = false;
                    return pileSize - (pileSize - valid);
                }
            }
            if (autoDead == true) {
            	System.out.println("Game over, human won!");
                return -1;
            }
            return -1;
        } else {
            return -1;
        }
    }
}
