import java.awt.Color;
import java.awt.Point;

public abstract class Plant {
	protected Point position;
	protected Color color;

	// Put abstract and non-abstract methods here.


	// method needed as named.
	// As said in "peberholmdSimulation.java": Draw and then move a Plants
	public static void spreadSeeds() {

	
	// get color needed - used in peberholmSimualtion l: 122 
	// this method might not be needed or used in this File perhaps in "PeberholmConstantsAndUtilities.java" instead, as it is defined here
	getColor() {
		
	}

	// same as getColor counts for getPosition:
	getPosition() {
		
	}
		
	}
	
	public String toString() {
		return "position ["+position.x+";"+position.y+"]";
	}
	

}
