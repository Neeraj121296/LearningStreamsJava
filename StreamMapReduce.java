/******************************************************************************

//Streams in java 8 : Parallel stream : works in multithreading
Streams useful in process large amount of data
Stream is like flow of water stream we can use it only once 


*******************************************************************************/
import java.util.*;
public class StreamMapReduce
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<Integer> al=Arrays.asList(1,2,3,4,5,6);
		int result=0;
		for(int i: al){
		    result=result+i*2;
		}
	    	System.out.println(result);
	    	/*
	    	Printing result like above operatio is called mutation in above example
	    	we are mutating value of result 6 times which is less stable.
	    	We can not achieve concurrency with this code 
	    	TO achieve concurrency we have to use streams
	    	*/
		/*stream method is defined in collection interface and it is a default method
		This method has a return type of Stream which is a interface*/
	
			System.out.println(al.stream().map(i-> i*2).reduce(0,(c,e)->c+e));
			/*map method needs object of function interface and function interface takes
			two parameter one is type of value and second is return type 
			it takes a integer parameter and also return the integer
			function interface is a functional interface which has only one method apply
			map method returns object of Stream*/
			/*
			reduce method requires two parameter one is initial value and second is binary
			operator
			BinaryOperator is an functional interface which accept one value and returns one value
			it extends BiFunction<T,T,T>
			BiFunction has a method apply()
			*/
		
	}
}
