public class MovingPoint {
    
    // initialise fields
    private double direction, speed, x, y;

    // initial constructor:
    public MovingPoint(){
        this.direction = 90;
        this.speed = 0;
        this.x = 0;
        this.y = 0;
    }
    
    // Constructor for assigning values to all fields
    public MovingPoint(double x, double y, double direction, double speed){
        this.x = x;
        this.y=y;
        if (direction >= 0){
        this.direction = direction % 360;
        } else {
            this.direction = (360+direction) % 360;
        }
        if (speed > 0 && speed < 20.0) {
            this.speed = speed;
        }
    }

    public void move(double duration) {
        if(duration<0) {
            System.out.println("Err: Duration has to be a positive number");
            System.exit(200);
        }
        double totalYTranslation = 0;
        double totalXTranslation = 0;
        double leftover = duration % 1.0;
        double directionToRadian = Math.toRadians(this.direction);
        for(int i = 0;i<Math.floor(duration);i++){
            totalYTranslation += Math.sin(directionToRadian)*speed;
            totalXTranslation += Math.cos(directionToRadian)*speed;
        }
        double leftoverSpeed = leftover*speed;
        totalYTranslation += Math.sin(directionToRadian)*leftoverSpeed;
        totalXTranslation += Math.cos(directionToRadian)*leftoverSpeed;

        this.y += totalYTranslation;
        this.x += totalXTranslation;
    }

    public void turnBy(double angle){
        if(((angle+this.direction) % 360) < 0) {
            this.direction = 360+((angle+this.direction) % 360);
        } else{
            this.direction = (angle+this.direction) % 360;
        }
    }

    public void accelerateBy(double change){
        if ((change+this.speed)>20){
            this.speed = 20;
        } else if ((change+this.speed)<0){
            this.speed = 0;
        } else {
            this.speed += change;
        }
    }
    public String toString() {
        return "["+this.x+";"+this.y+"] "+this.direction+" "+this.speed;
    }

}
