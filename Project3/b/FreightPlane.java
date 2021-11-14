public class FreightPlane extends Plane{
    int payload;

    public FreightPlane(String manufacturer, String type, int payload) {
        this.payload = payload;
        this.manufacturer = manufacturer;
        this.type = type;
        
    }

    public String toString(){
        // din kode 
        return "Plane"+this.id+" "+this.manufacturer+" "+this.type+" payload:"+this.payload;    
}
}
