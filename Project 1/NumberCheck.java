import java.util.ArrayList;
import java.math.*;

public class NumberCheck {
	public static void main(String[] args) {  
        try{System.out.println(NumberCheck.check("812738712837"));
	}
	catch (Exception e){
		// catches exepctions if the input to the functions is not a number
		System.out.println("input a valid number");
	}
}
public static boolean check(String input_string){
	// setting up local variables for the function
	String check_sum ="";
	String output_string ="";
	boolean output_bool = false;
	// handles exepction if input to function is "" 
	if(input_string == ""){
		System.out.println(output_string);
		return output_bool;
	}else{
		// itterates through the loop same amount of times as characters in input
		for(int i = 0; i < input_string.length(); i++) {
			// converts the input number at place i to a digit between 0..9
			int number = Character.digit(input_string.charAt(i), 10);
			if(((Math.abs((i-(input_string.length()-1)))))%2!=0)
			{
				if((number*2)>10){
					//System.out.print("inde 1: ");
			 		number = ((number*2)%10)+1;
					//System.out.println(number);
			 	}else if(number<10){
					//System.out.print("inde 2: ");
			 		number = number *2;
					//System.out.println(number);
			 	}
			}
		check_sum = check_sum+number;
		}
		int sum = 0;
		// sums all chars in the checksum string and returns the result as sum. 
		for (char c : check_sum.replaceAll("\\D", "").toCharArray()) {
			int digit = c - '0';
			sum += digit;
		}
		// does the final validation. 
		if(sum%10==0){
			output_string="accepted";
			output_bool = true;
		}else{
			output_string="false";
			output_bool = false;
		}
	 	return output_bool;
	 }
	}
}