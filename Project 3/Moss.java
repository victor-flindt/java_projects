import java.awt.Point;
import java.awt.Color;

public class Moss extends Plant 
{
	//this.color = "green";
    public Moss(Point position){
		// get the variables from the other files.
        super(position,PeberholmConstantsAndUtilities.MOSS_COLOR,PeberholmConstantsAndUtilities.MOSS_RANGE,PeberholmConstantsAndUtilities.MOSS_SEED_NO);
    }
	// default constructor
	public Moss(){}

	// Getter methods
	public Color getColor(){
		return this.color;
	}
	public Point getPosition(){
		return this.position;
	}

    public Plant[] spreadSeeds() {

		//if Plant instanceOf MOSS
			Plant[] newPlantsToAdd = new Plant[PeberholmConstantsAndUtilities.MOSS_SEED_NO]; // skal også laves om


            // skal laves om pr plant subclass
			int Range = PeberholmConstantsAndUtilities.MOSS_RANGE;


			// for loop for seeds seeds
			for(int i = 0; i< newPlantsToAdd.length; i++){

				Moss PlantToAdd = new Moss(PeberholmConstantsAndUtilities.getLegalRandomPosition()); // find lige ud af hvorfor man ikke kan init. en class inde i sigselv. 
				
				// Find position for new plant
				PlantToAdd.setPosition(position.x + PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range), 
										position.y+PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range));
				
				// set false position
			
				newPlantsToAdd[i] = PlantToAdd;
			}
		
		return newPlantsToAdd;
	}
}