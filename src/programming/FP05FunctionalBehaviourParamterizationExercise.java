package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * Do behavior parameterization for list of Square number or Cubes number
 */

public class FP05FunctionalBehaviourParamterizationExercise {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 9, 97, 6, 2, 28, 54);

		List<Integer> squaredList = mapAndCollect(numbers, x -> x * x);
		System.out.println(squaredList);

		List<Integer> cubedList = mapAndCollect(numbers, x -> x * x * x);
		System.out.println(cubedList);

	}

	private static List<Integer> mapAndCollect(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> mapper) {
		return numbers.stream()
					  .map(mapper)
					  .collect(Collectors.toList());
	}

}
