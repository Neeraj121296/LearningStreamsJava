/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.function.*;

public class ConsumerClass
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<Integer> al=Arrays.asList(1,2,3,4,5,6);
	/*	Consumer<Integer> c=new Consumer<Integer>(){
		  public void accept(Integer i){
		      System.out.println(i);
		  }  
		};*/
			Consumer<Integer> c=i -> System.out.println(i);
		
		al.forEach(c);
	/*	for each method internally calls consumer interface that accepts T
	as argument which is functional interface
		with only method accept accept the same type of argument defined in interface */
		//Lamda expression works only for functional interface
		al.forEach(i->  System.out.println(i));
	}
}
