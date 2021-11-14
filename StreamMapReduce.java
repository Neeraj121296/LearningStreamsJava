/******************************************************************************

//Streams in java 8 : Parallel stream : works in multithreading
Streams useful in process large amount of data
Stream is like flow of water stream we can use it only once 


*******************************************************************************/
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.function.Function;
import java.util.function.BinaryOperator;
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
			/*
			Above statement can also be written as
			*/
			System.out.println(al.stream().map(i-> i*2).reduce(0,(c,e)->Integer.sum(c,e)));	
			System.out.println(al.stream().map(i-> i*2).reduce(0,Integer::sum));	
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
			Stream s =al.stream();
			Stream s1=s.map(new Function<Integer,Integer>(){
			    public Integer apply(Integer i){
			        return i*2;
			    }
			});
			Integer result2=(Integer)s1.reduce(0,new BinaryOperator<Integer>(){
			    public Integer apply(Integer i,Integer j){
			        return i+j;
			    }
			});
			System.out.println(result2);
			/*
			Use case for filter method of stream 
			To sum all the values divisible by 6
			*/
			/*
			Filter method accepts the object of predicate interface
			In Predicate interface(1.8) we have test method which returns 
			boolean value
			If test method return false then filter will remove that 
			element from the list
			*/
			Predicate<Integer> p=new Predicate<Integer>(){
			    public boolean test(Integer i){
			        return i%2==0;
			    }
			};
				System.out.println(al.stream()
			                   .filter(p)
			                   .reduce(0,Integer :: sum));
			System.out.println(al.stream()
			                   .filter(i-> i%2==0)
			                   .reduce(0,Integer :: sum));
			System.out.println(al.stream()
			                   .filter(i-> i%2==0)
			                   .map(i->i*2)
			                   .reduce(0,Integer :: sum));
			/*
			Use case of findFirst method 
			it returns optional
			returns the first matched value
			                   
			                   */
			System.out.println(al.stream()
			                   .filter(i-> i%2==0)
			                   .map(i->i*2)
			                   .findFirst());   //Output : Optional[4]
			                   //outout if there no value divisible by 2 : Optional.empty
			  	System.out.println(al.stream()
			                   .filter(i-> i%2==0)
			                   .map(i->i*2)
			                   .findFirst()
			                   .orElse(0));   //Output : 4              
				System.out.println(al.stream()
			                   .filter(i-> i%7==0)
			                   .map(i->i*2)
			                   .findFirst()
			                   );     
			                   //Output : Optional.empty
			 	System.out.println(al.stream()
			                   .filter(i-> i%7==0)
			                   .map(i->i*2)
			                   .findFirst()
			                   .orElse(0)
			                   );  
			                    //Output : 0
			 /*
			 filter and map are lazy functions, they always go for lazy evalution 
			 findFirst is eager/terminal method
			 findFirst will ask map for the first value
			 map ask filter to check if only the first value is divisible by 
			 2 or not
			 */        
			 	System.out.println(al.stream()
			                   .filter(Main :: isDivisible)
			                   .map(Main :: isMapped)
			                   .findFirst()
			                   .orElse(0));  
	}
	
	public static boolean isDivisible(Integer i){
	    System.out.println("isDivisible "+i);
	    return i%2==0;
	}
	
	public static Integer isMapped(Integer i){
	    System.out.println("isMapped "+i);
	    return i*2;
	}
	/*
	Output :

isDivisible 1
isDivisible 2
isMapped 2
4
Filter is only applied to two value and map is only applied to one value
This prooves that Filter and map method have Lazy Evaluation and findFirst has
Early Evaluation.
	*/
	
}
