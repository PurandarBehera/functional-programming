package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP04Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6, 9, 97, 6, 2, 28, 54);
		
		Predicate<Integer> isEvenPredicate = x -> x%2 ==0;
		
		
		Function<Integer,Integer> squareFunction = x-> x*x;
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		numbers.stream()
			   .filter(isEvenPredicate)
			   .map(squareFunction)
			   .forEach(sysoutConsumer);
		
		System.out.println("-----------Below is a concrete impl of the above-----------");
		
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer x) {
				return x%2 ==0;
			}
		};
		
		Function<Integer,Integer> squareFunction2 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
		};
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		
		numbers.stream()
		   .filter(isEvenPredicate2)
		   .map(squareFunction2)
		   .forEach(sysoutConsumer2);

	}
}
