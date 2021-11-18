import java.awt.Point;
import java.awt.Color;

public class Flower extends Plant 
{
	//this.color = "green";
    public Flower(Point position){
		// get the variables from the other files.
        super(position,PeberholmConstantsAndUtilities.FLOWER_COLOR,PeberholmConstantsAndUtilities.FLOWER_RANGE,PeberholmConstantsAndUtilities.FLOWER_SEED_NO);
    }

	// Default constructor
	public Flower(){}

	// Getter methods
	public Color getColor(){
		return this.color;
	}
	public Point getPosition(){
		return this.position;
	}

    public Plant[] spreadSeeds() {

		//if Plant instanceOf Flower
			Plant[] newPlantsToAdd = new Plant[PeberholmConstantsAndUtilities.FLOWER_SEED_NO]; // skal også laves om


            // skal laves om pr plant subclass
			int Range = PeberholmConstantsAndUtilities.FLOWER_RANGE;


			// for loop for seeds seeds
			for(int i = 0; i< newPlantsToAdd.length; i++){

				Flower PlantToAdd = new Flower(PeberholmConstantsAndUtilities.getLegalRandomPosition()); // find lige ud af hvorfor man ikke kan init. en class inde i sigselv. 
				
				// Find position for new plant
				PlantToAdd.setPosition(position.x + PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range), 
										position.y+PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range));
				
				// set false position
			
				newPlantsToAdd[i] = PlantToAdd;
			}
		
		return newPlantsToAdd;
	}
}