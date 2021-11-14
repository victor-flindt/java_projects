public class Plane {
	private static final int DEFAULT_ID = 0;
	
	protected String manufacturer, type;
	int id;
	/**
	 * @param manufacturer
	 * @param type
	 * @param id
	 */

    public Plane(){

    }

	public Plane(String manufacturer, String type) {
		this.manufacturer = manufacturer;
		this.type = type;
		this.id = DEFAULT_ID;
	}
	
	
	
	public void setId(int id){
		this.id = id;
	}
	
	public String toString(){
		// din kode 
        return "Plane"+this.id+" "+this.manufacturer+" "+this.type;
	}
	//denne metode skal sammenligne id nr på to objekter af flyver.
	
	public boolean equals(Object o){
		/* MY CODE*/
        boolean bool;

        if (o instanceof Plane){
            return bool = (this.id == ((Plane) o).getId()) ? true:false;
        } 
        
        return false;
	}
	
	public int getId() {
		return id;
	}

}



