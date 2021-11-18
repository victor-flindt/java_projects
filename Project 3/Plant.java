import java.awt.Color;
import java.awt.Point;

public abstract class Plant{

	// Put abstract and non-abstract methods here.

	// Class plant variables
	protected Point position;
	protected Color color;
	protected int range;
	protected int seed_no;

	// Default empty constructor.
	public Plant(){}
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

	// all sub classes will have this function avaliable. 
	public void setPosition(int x, int y) {
		position.x=x;
		position.y=y;
	}

	// abstract methods
	public abstract Color  getColor();
	public abstract Point getPosition();
	public abstract Plant[] spreadSeeds();
	
}