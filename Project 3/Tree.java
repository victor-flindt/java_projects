import java.awt.Point;
import java.awt.Color;

public class Tree extends Plant 
{
	//this.color = "green";
    public Tree(Point position){
		// get the variables from the other files.
        super(position,PeberholmConstantsAndUtilities.TREE_COLOR,PeberholmConstantsAndUtilities.TREE_RANGE,PeberholmConstantsAndUtilities.TREE_SEED_NO);
    }

	// Getter methods
	public Color getColor(){
		return this.color;
	}
	public Point getPosition(){
		return this.position;
	}

    public Plant[] spreadSeeds() {

		//if Plant instanceOf TREE
			Plant[] newPlantsToAdd = new Plant[PeberholmConstantsAndUtilities.TREE_SEED_NO]; // skal også laves om


            // skal laves om pr plant subclass
			int Range = PeberholmConstantsAndUtilities.TREE_RANGE;


			// for loop for seeds seeds
			for(int i = 0; i< newPlantsToAdd.length; i++){

				Tree PlantToAdd = new Tree(position); // find lige ud af hvorfor man ikke kan init. en class inde i sigselv. 
				
				// Find position for new plant
				PlantToAdd.setPosition(position.x + PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range), 
										position.y+PeberholmConstantsAndUtilities.getRandomIntBetween(-Range, Range));
				
				// set false position
			
				newPlantsToAdd[i] = PlantToAdd;
			}
		
		return newPlantsToAdd;
	}
}