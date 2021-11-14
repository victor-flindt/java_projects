package hjemmeopgave_3;

public class FreightPlane extends Plane {

	int payload;
	
	public FreightPlane(String manufacturer, String type, int payload) {
		super(manufacturer, type);
		this.payload = payload;
		
	}

	public String toString(){

		return "Plane"+id+ " "+manufacturer+ " "+type+ " payload:"+payload;
		
	}
}