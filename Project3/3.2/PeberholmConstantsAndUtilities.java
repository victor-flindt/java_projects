import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class PeberholmConstantsAndUtilities {
	
	
	
	//CONSTANTS
    // set to true for viewing
	public static final boolean SHOW = false;
	
	
	public static final int W = 80;//Rows
	public static final int H = 40;//Columns
	public static final int ROUNDS = 12;//Iterations

	public static final int TREE_RANGE = 10;
	public static final int BUSH_RANGE = 3;
	public static final int FLOWER_RANGE = 3;
	public static final int MOSS_RANGE = 2;

	public static final int TREE_SEED_NO = 1;
	public static final int BUSH_SEED_NO = 2;
	public static final int FLOWER_SEED_NO = 4;
	public static final int MOSS_SEED_NO = 5;

	
	public static final Color TREE_COLOR = Color.black;
	public static final Color BUSH_COLOR = Color.green;
	public static final Color FLOWER_COLOR = Color.red;
	public static final Color MOSS_COLOR = Color.blue;

	//UTILITIES
	private static Random rand = new Random();

	/**
	 * Checks whether the position is on the island.
	 * @param p The point defining the position.
	 * @return true if the position is on the island.
	 */
	public static boolean positionOK(Point p) {
		return (positionOK(p.x, p.y));
	}


	/** 
	
	/**
	 * @return a Point on the island.
	 */
	public static Point getLegalRandomPosition() {
		int x, y;
		do {
			x = rand.nextInt(W);
			y = rand.nextInt(H);
		} while (!positionOK(x, y));
		return new Point(x, y);
	}

	public static int getRandomIntBetween(int low, int high) {
		return low + rand.nextInt(high - low + 1);
	}
	
	/** Checks whether the position is on the island.
     * @param x X-ccordinate of the position to be checked.
     * @param y Y-ccordinate of the position to be checked.
     * @return true if the position is on the d.
     * This method can be changed to only allow another set of positions.
     */
	public static boolean positionOK(double x, double y){
		return
		((0 <= x) && (x <= W) && (0 <= y) && (y <= H));
		
	}

}
