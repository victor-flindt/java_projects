package hjemmeopgave_3;

public class Plane {

	private static final int DEFAULT_ID = 0;

	protected String manufacturer, type;
	int id;

	public Plane(String manufacturer, String type) {
		this.manufacturer = manufacturer;
		this.type = type;
		this.id = DEFAULT_ID;
	}


	public void setId(int id){
		this.id = id;
	}

	public String toString(){
 

		return "Plane"+id+ " "+manufacturer+ " "+type;
		

	}


	public boolean equals(Object o){


		if(this.id == ((Plane)o).getId()) {

			return true;
			
		}else {
			return false;

		}

	}

	public int getId() {
		return id;

	}
}
