package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class FP05FunctionalBehaviourParamterization {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 9, 97, 6, 2, 28, 54);
		
		//filterAndPrint(numbers, x -> x % 2 == 0);
		
		//filterAndPrint(numbers, x -> x % 2 != 0);
		
		filterAndPrint(numbers, x -> x % 3 == 0);
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	

}
