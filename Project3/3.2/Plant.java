import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;

public abstract class Plant {
	protected Point position;
	protected Color color;
	
	public void setPosition(int x, int y) {
		position.x = x;
		position.y = y;
		
	}

	// Put abstract and non-abstract methods here.


	// method needed as named.
	// As said in "peberholmdSimulation.java": Draw and then move a Plants
	public Plant[] spreadSeeds() {

		//if Plant instanceOf Bush
			Plant[] newPlantsToAdd = new Plant[PeberholmConstantsAndUtilities.BUSH_SEED_NO];

			int bushRange = PeberholmConstantsAndUtilities.BUSH_RANGE; 

			// for loop for seeds seeds
			for(int i = 0; i< newPlantsToAdd.length; i++){
				Bush PlantToAdd = new Bush;
				
				
				// Find position for new plant
				PlantToAdd.setPosition(position.x + PeberholmConstantsAndUtilities.getRandomIntBetween(-bushRange, bushRange), 
										position.y+PeberholmConstantsAndUtilities.getRandomIntBetween(-bushRange, bushRange));
				
				// set false position
			
				newPlantsToAdd[i] = PlantToAdd;
			}
		
		return newPlantsToAdd;
	}

	

		
	}
	
	public String toString() {
		return "position ["+position.x+";"+position.y+"]";
	}
	

}
