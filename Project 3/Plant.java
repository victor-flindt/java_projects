import java.awt.Color;
import java.awt.Point;

public abstract class Plant{

	// Put abstract and non-abstract methods here.

	// Class plant variables
	protected Point position;
	protected Color color;
	protected int range;
	protected int seed_no;
	
	// the Bicycle class has one constructor
    // constructor


    public Plant(Point position, Color color,int range, int seed_no)
    {
		this.position = position;
		this.color = color;
		this.range = range;
		this.seed_no = seed_no; 
    }

	// methods
	public String toString() {
		return "position ["+position.x+";"+position.y+"]";
	}

	public void setPosition(int x, int y) {
		position.x = x;
		position.y = y;
		
	}

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

	// abstract methods
	public abstract Color  getColor();
	public abstract Point getPosition();
//	public abstract Plant[] spreadSeeds();
	
}