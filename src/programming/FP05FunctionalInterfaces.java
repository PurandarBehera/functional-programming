package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


/*
 * Brief summary of all types of Functional Interfaces
 */

public class FP05FunctionalInterfaces {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		Predicate<Integer> evenPredicate = x -> x%2==0;
		//System.out.println(evenPredicate.test(numbers.get(0)));
		
		Function<Integer,Integer> squareFunction = x -> x*x;
		//System.out.println(squareFunction.apply(numbers.get(0)));
		
		Function<Integer,String> stringFunction = x -> x +"abc"; //result can be of different types 
		//System.out.println(stringFunction.apply(numbers.get(3)));
		
		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
		//sysoutConsumer.accept(numbers.get(5));
		
		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
		//System.out.println(sumBinaryOperator.apply(10, 20));
		
		
		//No input , Return Something
		/*
		 * Supplier<Integer> randomIntegerSupplier = ()-> 2;
		 * System.out.println(randomIntegerSupplier.get());
		 */
		
		/*
		 * Supplier<Integer> randomIntegerSupplier = ( ) -> { return 2; };
		 * System.out.println(randomIntegerSupplier.get());
		 */
		
		/*
		 * Supplier<Integer> randomIntegerSupplier = ( ) -> {
		 * 
		 * Random random = new Random(); return random.nextInt(100); };
		 * System.out.println(randomIntegerSupplier.get());
		 */
		
		UnaryOperator<Integer> unaryOperator = x -> 10*x;
		System.out.println(unaryOperator.apply(4));
		
		Supplier<Integer> randomIntegerSupplier =( ) -> new Random().nextInt(100);
		System.out.println(randomIntegerSupplier.get());
		
		BiPredicate<Integer, String> biPredicate = (num , str ) -> {
			return num <=10 && str.length()>5;
		};
		System.out.println(biPredicate.test(90, "Hello"));
		
		BiFunction<Integer, String, String> biFunction = (num , str ) -> {
			return num + " "+ str +":"+ str.length();
		};
		System.out.println(biFunction.apply(78, "java"));
		
		BiFunction<Integer, Integer, Double> combineRatings = (rating1, rating2) -> (rating1 + rating2) / 2.0; 
		// Calculates the average rating
		double averageRating = combineRatings.apply(4, 5);
		System.out.println(averageRating);
		
		BiFunction<Double, Double, Double> applyDiscount = (price, discount) -> price - (price * discount); 
		// Calculates the price after a 10% discount
		System.out.println(applyDiscount.apply(200.0, 0.1)); 
		
		BiConsumer<Integer, String> biConsumer = (num , str ) -> {
			System.out.println(num);
			System.out.println(str);
		};
		biConsumer.accept(54, "AWS");
	}
}
