public class PassengerPlane extends Plane{
    int numSeats;

    public PassengerPlane(String manufacturer, String type, int numSeats) {
        this.numSeats = numSeats;
        this.manufacturer = manufacturer;
        this.type = type;
        
    }

    public String toString(){
        // din kode 
        return "Plane"+this.id+" "+this.manufacturer+" "+this.type+" seats:"+this.numSeats;    
}
}
