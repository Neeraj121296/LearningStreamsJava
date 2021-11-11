import java.util.*;
import java.util.function.*;

public class MethodRefernce
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<Integer> al=Arrays.asList(1,2,3,4,5,6);

		al.forEach(System.out::println); //This is called method reference or call by method 
		//we are passing println method as refernce for Standard output stream and thereby 
		//reducing the boiler plate code.
		al.forEach(i-> doubleIt(i));
		
		//using method refernce
		al.forEach(MethodRefernce :: doubleIt);
	}
	
		public static void doubleIt(Integer i){
	    System.out.print(i*2+" ");
	}
	
}
