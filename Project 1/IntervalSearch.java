import java.lang.Math;
import java.math.BigInteger;
public class IntervalSearch {
	public static void main(String[] args) {

		System.out.println(IntervalSearch.intervalContains(93174,819374891, 3));

	}
    public static boolean intervalContains (int g1 , int g2 , int power){
        int higher = 0;
        int lower = 0;
        if(g1>=g2){
            higher = g1;
            lower = g2;
        }else{
            higher = g2;
            lower = g1;
        }
        Boolean result = false;
        for (int i = 0; i < higher; i++) {
            if(((lower<=Math.pow(power,i))&&(Math.pow(power,i)<=higher))==true){
                result=true;
                break;
            }
        }
        return result;
    }
}