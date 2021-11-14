import java.awt.Color;
import java.awt.Point;

public abstract class Plant {
	protected Point position;
	protected Color color;

	// Put abstract and non-abstract methods here.
	
	public String toString() {
		return "position ["+position.x+";"+position.y+"]";
	}
	

}
