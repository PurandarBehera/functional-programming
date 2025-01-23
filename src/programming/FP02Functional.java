package programming;

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6, 9, 97, 6, 2, 28, 54);
		
		/*
		 * int sum = addListOfNumbersFunctional(numbers); System.out.println(sum);
		 */
		
		//numbers.stream().distinct().forEach(System.out::println);
		//numbers.stream().sorted().forEach(System.out::println);
		numbers.stream().distinct().sorted().forEach(System.out::println);
	}
	
	private static int sum(int a , int b) {
		return a+b;
	}
	
	private static int addListOfNumbersFunctional(List<Integer> numbers) {
		
		//Stream of number -> One result value
		// Combine them into one Result ---> One Value
		//To reduce the sum into a single value , reduce operation is performed. Terminal Operation
		//reduce() ;  Under the hood , it takes the nums and performs an aggregate operation .
		return numbers.stream()
				//.reduce(0,FP02Functional::sum)
				//.reduce(0,(x,y) -> x+y)
				.reduce(0,Integer::sum);
	}			
}
