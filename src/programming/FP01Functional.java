package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6, 9, 97, 6, 2, 28, 54);
		
		List<String> courses = List.of("Spring" , "SpringBoot", "Microservices", "AWS", "Kubernetes");
		
		//printAllNumbersInListFunctional(numbers);
		//printAllEvenNumbersInListFunctional(numbers);
		//printAllOddNumbersInListFunctional(numbers);
		
		//printSquaresOfAllEvenNumbersInListFunctional(numbers);
		printCubesOfOddEvenNumbersInListFunctional(numbers);
		
		
		//printAllCoursesInListFunctional(courses);
		//printCoursesContainingSpringInListFunctional(courses);
		//printNumberOfCharactersInCoursesInListFunctional(courses);
		
		/*
		 * courses.stream() .filter(course -> course.length()>=4)
		 * .forEach(System.out::println);
		 */
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// What to do?

		numbers.stream()
			   .forEach(System.out::println); // Method Reference
	}
	
	private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
		// What to do?

		numbers.stream()
				.filter(num -> num%2==0) // filter -> only allow even number , -> lambda expression
				.forEach(System.out::println); // Method Reference
	}
	
	private static void printAllOddNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream()
				.filter(num -> num%2!=0) // filter -> only allow odd number , -> lambda expression
				.forEach(System.out::println); // Method Reference
	}
	
	private static void printAllCoursesInListFunctional(List<String> courses) {

		courses.stream()
			   .forEach(System.out::println); 
	}
	
	private static void printCoursesContainingSpringInListFunctional(List<String> courses) {

		courses.stream()
				.filter(course -> course.contains("Spring"))
				.forEach(System.out::println); 
	}
	
	private static void printSquaresOfAllEvenNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream()
				.filter(num -> num%2==0) 
				.map(num-> num*num)
				.forEach((num) -> System.out.print(num + " "));
	}
	
	private static void printCubesOfOddEvenNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream()
				.filter(num -> num%2!=0) 
				.map(num-> num + ":"+  num*num*num)
				.forEach(System.out::println); 
	}
	
	private static void printNumberOfCharactersInCoursesInListFunctional(List<String> courses) {

		courses.stream()
				.map(course-> course + " " + course.length())
				.forEach(System.out::println); 
	}


}
