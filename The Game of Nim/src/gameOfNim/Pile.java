package gameOfNim;
/**
 * Created with IntelliJ IDEA.
 * User: Sri
 * Date: 10/24/12
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Random;
public class Pile {

    private int pileSize;
    private Random randGen;

    public Pile() {
        randGen = new Random();
        pileSize = createSizeOfPile();
    }

    private int createSizeOfPile() {
        return randGen.nextInt(100);
    }

    public int getSizeOfPile() {
        return pileSize;
    }

    public void setSizeOfPile(int newSize) {
        pileSize = newSize;
        System.out.println("The new pile size is: " + pileSize);
    }
}
