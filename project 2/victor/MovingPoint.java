import java.lang.Math;

public class MovingPoint {
    
    double x,y,direction,speed;
    
    public static void main(String[] args){

		MovingPoint mp1 = new MovingPoint(7.0, 3.0, -10, 1.0);
		MovingPoint mp2 = new MovingPoint(7.0, 3.0, 475, 1.0);

		System.out.println(mp1);
		mp1.move(1);
		System.out.println(mp1);

		System.out.println(mp2);
		mp2.move(1);
		System.out.println(mp2);

    }
    public MovingPoint(){
        this.x=0;
        this.y=0;
        this.direction=90;
        this.speed=0;

    }
    public MovingPoint (double x , double y , double direction , double speed){

        this.x=x;
        this.y=y;
        // converts it to radians such that its easier to work with. 
        this.direction=direction;
        this.speed=speed;
        if(this.speed < 0){
            this.speed =0;
        }
        if(((this.direction) % 360) < 0) {
            this.direction = 360+((this.direction) % 360);
        } else{
            this.direction = (this.direction) % 360;
        }
    }
    public void move(double duration){
        double distance = speed*duration;
        x=x+(distance*(Math.cos(direction*(Math.PI/180))));
        y=y+(distance*(Math.sin(direction*(Math.PI/180))));
    }
    public void turnBy (double angle){
        if(((angle+this.direction) % 360) < 0) {
            this.direction = 360+((angle+this.direction) % 360);
        } else{
            this.direction = (angle+this.direction) % 360;
        }

    }
    public void accelerateBy (double change){
        if(change+this.speed>=20){
            this.speed=20;
        }else if(change+this.speed<=0){
            this.speed=0;
        }else{
            this.speed = speed+change;
        }

    }
    public String toString(){
        String temp="["+String.valueOf(x)+";"+String.valueOf(y)+"]"+" "+String.valueOf(direction)+" "+String.valueOf(speed);  
        return temp;
    }





}
