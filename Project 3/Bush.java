import java.awt.Point;
import java.awt.Color;

public class Bush extends Plant 
{
	//this.color = "green";
    public Bush(Point position){
		// get the variables from the other files.
        super(position,PeberholmConstantsAndUtilities.BUSH_COLOR,PeberholmConstantsAndUtilities.BUSH_RANGE,PeberholmConstantsAndUtilities.BUSH_SEED_NO);
    }

	// Getter methods
	public Color getColor(){
		return this.color;
	}
	public Point getPosition(){
		return this.position;
	}

    public Plant[] spreadSeeds() {

		//if Plant instanceOf Bush
			Plant[] newPlantsToAdd = new Plant[PeberholmConstantsAndUtilities.BUSH_SEED_NO]; // skal også laves om


            // skal laves om pr plant subclass
			int Range = PeberholmConstantsAndUtilities.BUSH_RANGE;


			// for loop for seeds seeds
			for(int i = 0; i< newPlantsToAdd.length; i++){

				Bush PlantToAdd = new Bush(position); // find lige ud af hvorfor man ikke kan init. en class inde i sigselv. 
				
				// Find position for new plant
				PlantToAdd.setPosition(position.x + PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range), 
										position.y+PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range));
				
				// set false position
			
				newPlantsToAdd[i] = PlantToAdd;
			}
		
		return newPlantsToAdd;
	}
}