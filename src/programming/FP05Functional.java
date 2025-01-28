package programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP05Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(6, 9, 97, 6, 2, 28, 54);
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum; //(x,y) -> x+y
		int sum = numbers.stream()
				.reduce(0, sumBinaryOperator);
		System.out.println(sum);
		
		System.out.println("-----------Below is a concrete impl of the above-----------");
		
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer x, Integer y) {
				return x+y;
			}
		};
		
		int sum2 = numbers.stream()
				.reduce(0, sumBinaryOperator2);
		System.out.println(sum2);
	}
	

}
